package com.replaymod.lib.com.fasterxml.jackson.databind.deser;

import com.replaymod.lib.com.fasterxml.jackson.databind.BeanDescription;
import com.replaymod.lib.com.fasterxml.jackson.databind.DeserializationConfig;
import com.replaymod.lib.com.fasterxml.jackson.databind.JavaType;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonDeserializer;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonMappingException;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonNode;
import com.replaymod.lib.com.fasterxml.jackson.databind.KeyDeserializer;
import com.replaymod.lib.com.fasterxml.jackson.databind.jsontype.TypeDeserializer;
import com.replaymod.lib.com.fasterxml.jackson.databind.type.ArrayType;
import com.replaymod.lib.com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.replaymod.lib.com.fasterxml.jackson.databind.type.CollectionType;
import com.replaymod.lib.com.fasterxml.jackson.databind.type.MapLikeType;
import com.replaymod.lib.com.fasterxml.jackson.databind.type.MapType;
import com.replaymod.lib.com.fasterxml.jackson.databind.type.ReferenceType;

public interface Deserializers {
   JsonDeserializer<?> findEnumDeserializer(Class<?> var1, DeserializationConfig var2, BeanDescription var3) throws JsonMappingException;

   JsonDeserializer<?> findTreeNodeDeserializer(Class<? extends JsonNode> var1, DeserializationConfig var2, BeanDescription var3) throws JsonMappingException;

   JsonDeserializer<?> findBeanDeserializer(JavaType var1, DeserializationConfig var2, BeanDescription var3) throws JsonMappingException;

   JsonDeserializer<?> findReferenceDeserializer(ReferenceType var1, DeserializationConfig var2, BeanDescription var3, TypeDeserializer var4, JsonDeserializer<?> var5) throws JsonMappingException;

   JsonDeserializer<?> findArrayDeserializer(ArrayType var1, DeserializationConfig var2, BeanDescription var3, TypeDeserializer var4, JsonDeserializer<?> var5) throws JsonMappingException;

   JsonDeserializer<?> findCollectionDeserializer(CollectionType var1, DeserializationConfig var2, BeanDescription var3, TypeDeserializer var4, JsonDeserializer<?> var5) throws JsonMappingException;

   JsonDeserializer<?> findCollectionLikeDeserializer(CollectionLikeType var1, DeserializationConfig var2, BeanDescription var3, TypeDeserializer var4, JsonDeserializer<?> var5) throws JsonMappingException;

   JsonDeserializer<?> findMapDeserializer(MapType var1, DeserializationConfig var2, BeanDescription var3, KeyDeserializer var4, TypeDeserializer var5, JsonDeserializer<?> var6) throws JsonMappingException;

   JsonDeserializer<?> findMapLikeDeserializer(MapLikeType var1, DeserializationConfig var2, BeanDescription var3, KeyDeserializer var4, TypeDeserializer var5, JsonDeserializer<?> var6) throws JsonMappingException;

   public static class Base implements Deserializers {
      public JsonDeserializer<?> findEnumDeserializer(Class<?> type, DeserializationConfig config, BeanDescription beanDesc) throws JsonMappingException {
         return null;
      }

      public JsonDeserializer<?> findTreeNodeDeserializer(Class<? extends JsonNode> nodeType, DeserializationConfig config, BeanDescription beanDesc) throws JsonMappingException {
         return null;
      }

      public JsonDeserializer<?> findReferenceDeserializer(ReferenceType refType, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer contentTypeDeserializer, JsonDeserializer<?> contentDeserializer) throws JsonMappingException {
         return this.findBeanDeserializer(refType, config, beanDesc);
      }

      public JsonDeserializer<?> findBeanDeserializer(JavaType type, DeserializationConfig config, BeanDescription beanDesc) throws JsonMappingException {
         return null;
      }

      public JsonDeserializer<?> findArrayDeserializer(ArrayType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
         return null;
      }

      public JsonDeserializer<?> findCollectionDeserializer(CollectionType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
         return null;
      }

      public JsonDeserializer<?> findCollectionLikeDeserializer(CollectionLikeType type, DeserializationConfig config, BeanDescription beanDesc, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
         return null;
      }

      public JsonDeserializer<?> findMapDeserializer(MapType type, DeserializationConfig config, BeanDescription beanDesc, KeyDeserializer keyDeserializer, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
         return null;
      }

      public JsonDeserializer<?> findMapLikeDeserializer(MapLikeType type, DeserializationConfig config, BeanDescription beanDesc, KeyDeserializer keyDeserializer, TypeDeserializer elementTypeDeserializer, JsonDeserializer<?> elementDeserializer) throws JsonMappingException {
         return null;
      }
   }
}
