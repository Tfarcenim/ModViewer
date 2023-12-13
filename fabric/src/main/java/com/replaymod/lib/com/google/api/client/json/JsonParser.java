package com.replaymod.lib.com.google.api.client.json;

import com.replaymod.lib.com.google.api.client.util.Beta;
import com.replaymod.lib.com.google.api.client.util.ClassInfo;
import com.replaymod.lib.com.google.api.client.util.Data;
import com.replaymod.lib.com.google.api.client.util.FieldInfo;
import com.replaymod.lib.com.google.api.client.util.GenericData;
import com.replaymod.lib.com.google.api.client.util.Preconditions;
import com.replaymod.lib.com.google.api.client.util.Sets;
import com.replaymod.lib.com.google.api.client.util.Types;
import java.io.IOException;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class JsonParser {
   private static WeakHashMap<Class<?>, Field> cachedTypemapFields = new WeakHashMap();
   private static final Lock lock = new ReentrantLock();

   public abstract JsonFactory getFactory();

   public abstract void close() throws IOException;

   public abstract JsonToken nextToken() throws IOException;

   public abstract JsonToken getCurrentToken();

   public abstract String getCurrentName() throws IOException;

   public abstract JsonParser skipChildren() throws IOException;

   public abstract String getText() throws IOException;

   public abstract byte getByteValue() throws IOException;

   public abstract short getShortValue() throws IOException;

   public abstract int getIntValue() throws IOException;

   public abstract float getFloatValue() throws IOException;

   public abstract long getLongValue() throws IOException;

   public abstract double getDoubleValue() throws IOException;

   public abstract BigInteger getBigIntegerValue() throws IOException;

   public abstract BigDecimal getDecimalValue() throws IOException;

   public final <T> T parseAndClose(Class<T> destinationClass) throws IOException {
      return this.parseAndClose((Class)destinationClass, (CustomizeJsonParser)null);
   }

   @Beta
   public final <T> T parseAndClose(Class<T> destinationClass, CustomizeJsonParser customizeParser) throws IOException {
      Object var3;
      try {
         var3 = this.parse(destinationClass, customizeParser);
      } finally {
         this.close();
      }

      return var3;
   }

   public final void skipToKey(String keyToFind) throws IOException {
      this.skipToKey(Collections.singleton(keyToFind));
   }

   public final String skipToKey(Set<String> keysToFind) throws IOException {
      for(JsonToken curToken = this.startParsingObjectOrArray(); curToken == JsonToken.FIELD_NAME; curToken = this.nextToken()) {
         String key = this.getText();
         this.nextToken();
         if (keysToFind.contains(key)) {
            return key;
         }

         this.skipChildren();
      }

      return null;
   }

   private JsonToken startParsing() throws IOException {
      JsonToken currentToken = this.getCurrentToken();
      if (currentToken == null) {
         currentToken = this.nextToken();
      }

      Preconditions.checkArgument(currentToken != null, "no JSON input found");
      return currentToken;
   }

   private JsonToken startParsingObjectOrArray() throws IOException {
      JsonToken currentToken = this.startParsing();
      switch(currentToken) {
      case START_OBJECT:
         currentToken = this.nextToken();
         Preconditions.checkArgument(currentToken == JsonToken.FIELD_NAME || currentToken == JsonToken.END_OBJECT, currentToken);
         break;
      case START_ARRAY:
         currentToken = this.nextToken();
      }

      return currentToken;
   }

   public final void parseAndClose(Object destination) throws IOException {
      this.parseAndClose((Object)destination, (CustomizeJsonParser)null);
   }

   @Beta
   public final void parseAndClose(Object destination, CustomizeJsonParser customizeParser) throws IOException {
      try {
         this.parse(destination, customizeParser);
      } finally {
         this.close();
      }

   }

   public final <T> T parse(Class<T> destinationClass) throws IOException {
      return this.parse((Class)destinationClass, (CustomizeJsonParser)null);
   }

   @Beta
   public final <T> T parse(Class<T> destinationClass, CustomizeJsonParser customizeParser) throws IOException {
      T result = this.parse(destinationClass, false, customizeParser);
      return result;
   }

   public Object parse(Type dataType, boolean close) throws IOException {
      return this.parse(dataType, close, (CustomizeJsonParser)null);
   }

   @Beta
   public Object parse(Type dataType, boolean close, CustomizeJsonParser customizeParser) throws IOException {
      Object var4;
      try {
         if (!Void.class.equals(dataType)) {
            this.startParsing();
         }

         var4 = this.parseValue((Field)null, dataType, new ArrayList(), (Object)null, customizeParser, true);
      } finally {
         if (close) {
            this.close();
         }

      }

      return var4;
   }

   public final void parse(Object destination) throws IOException {
      this.parse((Object)destination, (CustomizeJsonParser)null);
   }

   @Beta
   public final void parse(Object destination, CustomizeJsonParser customizeParser) throws IOException {
      ArrayList<Type> context = new ArrayList();
      context.add(destination.getClass());
      this.parse(context, destination, customizeParser);
   }

   private void parse(ArrayList<Type> context, Object destination, CustomizeJsonParser customizeParser) throws IOException {
      if (destination instanceof GenericJson) {
         ((GenericJson)destination).setFactory(this.getFactory());
      }

      JsonToken curToken = this.startParsingObjectOrArray();
      Class<?> destinationClass = destination.getClass();
      ClassInfo classInfo = ClassInfo.of(destinationClass);
      boolean isGenericData = GenericData.class.isAssignableFrom(destinationClass);
      if (!isGenericData && Map.class.isAssignableFrom(destinationClass)) {
         Map<String, Object> destinationMap = (Map)destination;
         this.parseMap((Field)null, destinationMap, Types.getMapValueParameter(destinationClass), context, customizeParser);
      } else {
         for(; curToken == JsonToken.FIELD_NAME; curToken = this.nextToken()) {
            String key = this.getText();
            this.nextToken();
            if (customizeParser != null && customizeParser.stopAt(destination, key)) {
               return;
            }

            FieldInfo fieldInfo = classInfo.getFieldInfo(key);
            if (fieldInfo != null) {
               if (fieldInfo.isFinal() && !fieldInfo.isPrimitive()) {
                  throw new IllegalArgumentException("final array/object fields are not supported");
               }

               Field field = fieldInfo.getField();
               int contextSize = context.size();
               context.add(field.getGenericType());
               Object fieldValue = this.parseValue(field, fieldInfo.getGenericType(), context, destination, customizeParser, true);
               context.remove(contextSize);
               fieldInfo.setValue(destination, fieldValue);
            } else if (isGenericData) {
               GenericData object = (GenericData)destination;
               object.set(key, this.parseValue((Field)null, (Type)null, context, destination, customizeParser, true));
            } else {
               if (customizeParser != null) {
                  customizeParser.handleUnrecognizedKey(destination, key);
               }

               this.skipChildren();
            }
         }

      }
   }

   public final <T> Collection<T> parseArrayAndClose(Class<?> destinationCollectionClass, Class<T> destinationItemClass) throws IOException {
      return this.parseArrayAndClose((Class)destinationCollectionClass, destinationItemClass, (CustomizeJsonParser)null);
   }

   @Beta
   public final <T> Collection<T> parseArrayAndClose(Class<?> destinationCollectionClass, Class<T> destinationItemClass, CustomizeJsonParser customizeParser) throws IOException {
      Collection var4;
      try {
         var4 = this.parseArray(destinationCollectionClass, destinationItemClass, customizeParser);
      } finally {
         this.close();
      }

      return var4;
   }

   public final <T> void parseArrayAndClose(Collection<? super T> destinationCollection, Class<T> destinationItemClass) throws IOException {
      this.parseArrayAndClose((Collection)destinationCollection, destinationItemClass, (CustomizeJsonParser)null);
   }

   @Beta
   public final <T> void parseArrayAndClose(Collection<? super T> destinationCollection, Class<T> destinationItemClass, CustomizeJsonParser customizeParser) throws IOException {
      try {
         this.parseArray(destinationCollection, destinationItemClass, customizeParser);
      } finally {
         this.close();
      }

   }

   public final <T> Collection<T> parseArray(Class<?> destinationCollectionClass, Class<T> destinationItemClass) throws IOException {
      return this.parseArray((Class)destinationCollectionClass, destinationItemClass, (CustomizeJsonParser)null);
   }

   @Beta
   public final <T> Collection<T> parseArray(Class<?> destinationCollectionClass, Class<T> destinationItemClass, CustomizeJsonParser customizeParser) throws IOException {
      Collection<T> destinationCollection = Data.newCollectionInstance(destinationCollectionClass);
      this.parseArray(destinationCollection, destinationItemClass, customizeParser);
      return destinationCollection;
   }

   public final <T> void parseArray(Collection<? super T> destinationCollection, Class<T> destinationItemClass) throws IOException {
      this.parseArray((Collection)destinationCollection, destinationItemClass, (CustomizeJsonParser)null);
   }

   @Beta
   public final <T> void parseArray(Collection<? super T> destinationCollection, Class<T> destinationItemClass, CustomizeJsonParser customizeParser) throws IOException {
      this.parseArray((Field)null, destinationCollection, destinationItemClass, new ArrayList(), customizeParser);
   }

   private <T> void parseArray(Field fieldContext, Collection<T> destinationCollection, Type destinationItemType, ArrayList<Type> context, CustomizeJsonParser customizeParser) throws IOException {
      for(JsonToken curToken = this.startParsingObjectOrArray(); curToken != JsonToken.END_ARRAY; curToken = this.nextToken()) {
         T parsedValue = this.parseValue(fieldContext, destinationItemType, context, destinationCollection, customizeParser, true);
         destinationCollection.add(parsedValue);
      }

   }

   private void parseMap(Field fieldContext, Map<String, Object> destinationMap, Type valueType, ArrayList<Type> context, CustomizeJsonParser customizeParser) throws IOException {
      for(JsonToken curToken = this.startParsingObjectOrArray(); curToken == JsonToken.FIELD_NAME; curToken = this.nextToken()) {
         String key = this.getText();
         this.nextToken();
         if (customizeParser != null && customizeParser.stopAt(destinationMap, key)) {
            return;
         }

         Object value = this.parseValue(fieldContext, valueType, context, destinationMap, customizeParser, true);
         destinationMap.put(key, value);
      }

   }

   private final Object parseValue(Field fieldContext, Type valueType, ArrayList<Type> context, Object destination, CustomizeJsonParser customizeParser, boolean handlePolymorphic) throws IOException {
      valueType = Data.resolveWildcardTypeOrTypeVariable(context, valueType);
      Class<?> valueClass = valueType instanceof Class ? (Class)valueType : null;
      if (valueType instanceof ParameterizedType) {
         valueClass = Types.getRawClass((ParameterizedType)valueType);
      }

      if (valueClass == Void.class) {
         this.skipChildren();
         return null;
      } else {
         JsonToken token = this.getCurrentToken();

         try {
            switch(this.getCurrentToken()) {
            case START_OBJECT:
            case FIELD_NAME:
            case END_OBJECT:
               Preconditions.checkArgument(!Types.isArray(valueType), "expected object or map type but got %s", valueType);
               Field typemapField = handlePolymorphic ? getCachedTypemapFieldFor(valueClass) : null;
               Object newInstance = null;
               if (valueClass != null && customizeParser != null) {
                  newInstance = customizeParser.newInstanceForObject(destination, valueClass);
               }

               boolean isMap = valueClass != null && Types.isAssignableToOrFrom(valueClass, Map.class);
               if (typemapField != null) {
                  newInstance = new GenericJson();
               } else if (newInstance == null) {
                  if (!isMap && valueClass != null) {
                     newInstance = Types.newInstance(valueClass);
                  } else {
                     newInstance = Data.newMapInstance(valueClass);
                  }
               }

               int contextSize = context.size();
               if (valueType != null) {
                  context.add(valueType);
               }

               if (isMap && !GenericData.class.isAssignableFrom(valueClass)) {
                  Type subValueType = Map.class.isAssignableFrom(valueClass) ? Types.getMapValueParameter(valueType) : null;
                  if (subValueType != null) {
                     Map<String, Object> destinationMap = (Map)newInstance;
                     this.parseMap(fieldContext, destinationMap, subValueType, context, customizeParser);
                     return newInstance;
                  }
               }

               this.parse(context, newInstance, customizeParser);
               if (valueType != null) {
                  context.remove(contextSize);
               }

               if (typemapField == null) {
                  return newInstance;
               }

               Object typeValueObject = ((GenericJson)newInstance).get(typemapField.getName());
               Preconditions.checkArgument(typeValueObject != null, "No value specified for @JsonPolymorphicTypeMap field");
               String typeValue = typeValueObject.toString();
               JsonPolymorphicTypeMap typeMap = (JsonPolymorphicTypeMap)typemapField.getAnnotation(JsonPolymorphicTypeMap.class);
               Class<?> typeClass = null;
               JsonPolymorphicTypeMap.TypeDef[] arr$ = typeMap.typeDefinitions();
               int len$ = arr$.length;

               for(int i$ = 0; i$ < len$; ++i$) {
                  JsonPolymorphicTypeMap.TypeDef typeDefinition = arr$[i$];
                  if (typeDefinition.key().equals(typeValue)) {
                     typeClass = typeDefinition.ref();
                     break;
                  }
               }

               Preconditions.checkArgument(typeClass != null, "No TypeDef annotation found with key: " + typeValue);
               JsonFactory factory = this.getFactory();
               JsonParser parser = factory.createJsonParser(factory.toString(newInstance));
               parser.startParsing();
               return parser.parseValue(fieldContext, typeClass, context, (Object)null, (CustomizeJsonParser)null, false);
            case START_ARRAY:
            case END_ARRAY:
               boolean isArray = Types.isArray(valueType);
               Preconditions.checkArgument(valueType == null || isArray || valueClass != null && Types.isAssignableToOrFrom(valueClass, Collection.class), "expected collection or array type but got %s", valueType);
               Collection<Object> collectionValue = null;
               if (customizeParser != null && fieldContext != null) {
                  collectionValue = customizeParser.newInstanceForArray(destination, fieldContext);
               }

               if (collectionValue == null) {
                  collectionValue = Data.newCollectionInstance(valueType);
               }

               Type subType = null;
               if (isArray) {
                  subType = Types.getArrayComponentType(valueType);
               } else if (valueClass != null && Iterable.class.isAssignableFrom(valueClass)) {
                  subType = Types.getIterableParameter(valueType);
               }

               subType = Data.resolveWildcardTypeOrTypeVariable(context, subType);
               this.parseArray(fieldContext, collectionValue, subType, context, customizeParser);
               if (isArray) {
                  return Types.toArray(collectionValue, Types.getRawArrayComponentType(context, subType));
               }

               return collectionValue;
            case VALUE_TRUE:
            case VALUE_FALSE:
               Preconditions.checkArgument(valueType == null || valueClass == Boolean.TYPE || valueClass != null && valueClass.isAssignableFrom(Boolean.class), "expected type Boolean or boolean but got %s", valueType);
               return token == JsonToken.VALUE_TRUE ? Boolean.TRUE : Boolean.FALSE;
            case VALUE_NUMBER_FLOAT:
            case VALUE_NUMBER_INT:
               Preconditions.checkArgument(fieldContext == null || fieldContext.getAnnotation(JsonString.class) == null, "number type formatted as a JSON number cannot use @JsonString annotation");
               if (valueClass != null && !valueClass.isAssignableFrom(BigDecimal.class)) {
                  if (valueClass == BigInteger.class) {
                     return this.getBigIntegerValue();
                  }

                  if (valueClass != Double.class && valueClass != Double.TYPE) {
                     if (valueClass != Long.class && valueClass != Long.TYPE) {
                        if (valueClass != Float.class && valueClass != Float.TYPE) {
                           if (valueClass != Integer.class && valueClass != Integer.TYPE) {
                              if (valueClass != Short.class && valueClass != Short.TYPE) {
                                 if (valueClass != Byte.class && valueClass != Byte.TYPE) {
                                    throw new IllegalArgumentException("expected numeric type but got " + valueType);
                                 }

                                 return this.getByteValue();
                              }

                              return this.getShortValue();
                           }

                           return this.getIntValue();
                        }

                        return this.getFloatValue();
                     }

                     return this.getLongValue();
                  }

                  return this.getDoubleValue();
               }

               return this.getDecimalValue();
            case VALUE_STRING:
               String text = this.getText().trim().toLowerCase(Locale.US);
               if (valueClass != Float.TYPE && valueClass != Float.class && valueClass != Double.TYPE && valueClass != Double.class || !text.equals("nan") && !text.equals("infinity") && !text.equals("-infinity")) {
                  Preconditions.checkArgument(valueClass == null || !Number.class.isAssignableFrom(valueClass) || fieldContext != null && fieldContext.getAnnotation(JsonString.class) != null, "number field formatted as a JSON string must use the @JsonString annotation");
               }

               return Data.parsePrimitiveValue(valueType, this.getText());
            case VALUE_NULL:
               Preconditions.checkArgument(valueClass == null || !valueClass.isPrimitive(), "primitive number field but found a JSON null");
               if (valueClass != null && 0 != (valueClass.getModifiers() & 1536)) {
                  if (Types.isAssignableToOrFrom(valueClass, Collection.class)) {
                     return Data.nullOf(Data.newCollectionInstance(valueType).getClass());
                  }

                  if (Types.isAssignableToOrFrom(valueClass, Map.class)) {
                     return Data.nullOf(Data.newMapInstance(valueClass).getClass());
                  }
               }

               return Data.nullOf(Types.getRawArrayComponentType(context, valueType));
            default:
               throw new IllegalArgumentException("unexpected JSON node type: " + token);
            }
         } catch (IllegalArgumentException var24) {
            StringBuilder contextStringBuilder = new StringBuilder();
            String currentName = this.getCurrentName();
            if (currentName != null) {
               contextStringBuilder.append("key ").append(currentName);
            }

            if (fieldContext != null) {
               if (currentName != null) {
                  contextStringBuilder.append(", ");
               }

               contextStringBuilder.append("field ").append(fieldContext);
            }

            throw new IllegalArgumentException(contextStringBuilder.toString(), var24);
         }
      }
   }

   private static Field getCachedTypemapFieldFor(Class<?> key) {
      if (key == null) {
         return null;
      } else {
         lock.lock();

         Field value;
         try {
            if (!cachedTypemapFields.containsKey(key)) {
               value = null;
               Collection<FieldInfo> fieldInfos = ClassInfo.of(key).getFieldInfos();
               Iterator i$ = fieldInfos.iterator();

               while(i$.hasNext()) {
                  FieldInfo fieldInfo = (FieldInfo)i$.next();
                  Field field = fieldInfo.getField();
                  JsonPolymorphicTypeMap typemapAnnotation = (JsonPolymorphicTypeMap)field.getAnnotation(JsonPolymorphicTypeMap.class);
                  if (typemapAnnotation != null) {
                     Preconditions.checkArgument(value == null, "Class contains more than one field with @JsonPolymorphicTypeMap annotation: %s", key);
                     Preconditions.checkArgument(Data.isPrimitive(field.getType()), "Field which has the @JsonPolymorphicTypeMap, %s, is not a supported type: %s", key, field.getType());
                     value = field;
                     JsonPolymorphicTypeMap.TypeDef[] typeDefs = typemapAnnotation.typeDefinitions();
                     HashSet<String> typeDefKeys = Sets.newHashSet();
                     Preconditions.checkArgument(typeDefs.length > 0, "@JsonPolymorphicTypeMap must have at least one @TypeDef");
                     JsonPolymorphicTypeMap.TypeDef[] arr$ = typeDefs;
                     int len$ = typeDefs.length;

                     for(int i$ = 0; i$ < len$; ++i$) {
                        JsonPolymorphicTypeMap.TypeDef typeDef = arr$[i$];
                        Preconditions.checkArgument(typeDefKeys.add(typeDef.key()), "Class contains two @TypeDef annotations with identical key: %s", typeDef.key());
                     }
                  }
               }

               cachedTypemapFields.put(key, value);
               Field var16 = value;
               return var16;
            }

            value = (Field)cachedTypemapFields.get(key);
         } finally {
            lock.unlock();
         }

         return value;
      }
   }
}
