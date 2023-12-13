package com.replaymod.replaystudio.lib.viaversion.api.data;

import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.objects.Object2IntMap;
import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.objects.Object2IntOpenHashMap;
import com.replaymod.replaystudio.lib.viaversion.util.Key;
import java.util.List;
import org.checkerframework.checker.nullness.qual.Nullable;

public class FullMappingsBase implements FullMappings {
   private static final String[] EMPTY_ARRAY = new String[0];
   private final Object2IntMap<String> stringToId;
   private final Object2IntMap<String> mappedStringToId;
   private final String[] idToString;
   private final String[] mappedIdToString;
   private final Mappings mappings;

   public FullMappingsBase(List<String> unmappedIdentifiers, List<String> mappedIdentifiers, Mappings mappings) {
      this.mappings = mappings;
      this.stringToId = toInverseMap(unmappedIdentifiers);
      this.mappedStringToId = toInverseMap(mappedIdentifiers);
      this.idToString = (String[])unmappedIdentifiers.toArray(EMPTY_ARRAY);
      this.mappedIdToString = (String[])mappedIdentifiers.toArray(EMPTY_ARRAY);
   }

   private FullMappingsBase(Object2IntMap<String> stringToId, Object2IntMap<String> mappedStringToId, String[] idToString, String[] mappedIdToString, Mappings mappings) {
      this.stringToId = stringToId;
      this.mappedStringToId = mappedStringToId;
      this.idToString = idToString;
      this.mappedIdToString = mappedIdToString;
      this.mappings = mappings;
   }

   public Mappings mappings() {
      return this.mappings;
   }

   public int id(String identifier) {
      return this.stringToId.getInt(Key.stripMinecraftNamespace(identifier));
   }

   public int mappedId(String mappedIdentifier) {
      return this.mappedStringToId.getInt(Key.stripMinecraftNamespace(mappedIdentifier));
   }

   public String identifier(int id) {
      String identifier = this.idToString[id];
      return Key.namespaced(identifier);
   }

   public String mappedIdentifier(int mappedId) {
      String identifier = this.mappedIdToString[mappedId];
      return Key.namespaced(identifier);
   }

   @Nullable
   public String mappedIdentifier(String identifier) {
      int id = this.id(identifier);
      if (id == -1) {
         return null;
      } else {
         int mappedId = this.mappings.getNewId(id);
         return mappedId != -1 ? this.mappedIdentifier(mappedId) : null;
      }
   }

   public int getNewId(int id) {
      return this.mappings.getNewId(id);
   }

   public void setNewId(int id, int mappedId) {
      this.mappings.setNewId(id, mappedId);
   }

   public int size() {
      return this.mappings.size();
   }

   public int mappedSize() {
      return this.mappings.mappedSize();
   }

   public FullMappings inverse() {
      return new FullMappingsBase(this.mappedStringToId, this.stringToId, this.mappedIdToString, this.idToString, this.mappings.inverse());
   }

   private static Object2IntMap<String> toInverseMap(List<String> list) {
      Object2IntMap<String> map = new Object2IntOpenHashMap(list.size());
      map.defaultReturnValue(-1);

      for(int i = 0; i < list.size(); ++i) {
         map.put(list.get(i), i);
      }

      return map;
   }
}
