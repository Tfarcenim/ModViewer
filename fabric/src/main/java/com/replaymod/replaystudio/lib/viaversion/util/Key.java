package com.replaymod.replaystudio.lib.viaversion.util;

public final class Key {
   public static String stripNamespace(String identifier) {
      int index = identifier.indexOf(58);
      return index == -1 ? identifier : identifier.substring(index + 1);
   }

   public static String stripMinecraftNamespace(String identifier) {
      return identifier.startsWith("minecraft:") ? identifier.substring(10) : identifier;
   }

   public static String namespaced(String identifier) {
      return identifier.indexOf(58) == -1 ? "minecraft:" + identifier : identifier;
   }
}
