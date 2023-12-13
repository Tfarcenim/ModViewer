package com.replaymod.replaystudio.lib.viaversion.api.minecraft;

import com.replaymod.replaystudio.lib.viaversion.api.connection.StorableObject;

public class WorldIdentifiers implements StorableObject {
   public static final String OVERWORLD_DEFAULT = "minecraft:overworld";
   public static final String NETHER_DEFAULT = "minecraft:the_nether";
   public static final String END_DEFAULT = "minecraft:the_end";
   private final String overworld;
   private final String nether;
   private final String end;

   public WorldIdentifiers(String overworld) {
      this(overworld, "minecraft:the_nether", "minecraft:the_end");
   }

   public WorldIdentifiers(String overworld, String nether, String end) {
      this.overworld = overworld;
      this.nether = nether;
      this.end = end;
   }

   public String overworld() {
      return this.overworld;
   }

   public String nether() {
      return this.nether;
   }

   public String end() {
      return this.end;
   }
}
