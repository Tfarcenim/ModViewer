package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9_3to1_9_1_2.chunks;

import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.ints.Int2ObjectMap;
import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.ints.Int2ObjectOpenHashMap;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.IntTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.StringTag;

public class FakeTileEntity {
   private static final Int2ObjectMap<CompoundTag> tileEntities = new Int2ObjectOpenHashMap();

   private static void register(String name, int... ids) {
      int[] var2 = ids;
      int var3 = ids.length;

      for(int var4 = 0; var4 < var3; ++var4) {
         int id = var2[var4];
         CompoundTag comp = new CompoundTag();
         comp.put("id", new StringTag(name));
         tileEntities.put(id, comp);
      }

   }

   public static boolean isTileEntity(int block) {
      return tileEntities.containsKey(block);
   }

   public static CompoundTag createTileEntity(int x, int y, int z, int block) {
      CompoundTag originalTag = (CompoundTag)tileEntities.get(block);
      if (originalTag != null) {
         CompoundTag tag = originalTag.clone();
         tag.put("x", new IntTag(x));
         tag.put("y", new IntTag(y));
         tag.put("z", new IntTag(z));
         return tag;
      } else {
         return null;
      }
   }

   static {
      register("Furnace", 61, 62);
      register("Chest", 54, 146);
      register("EnderChest", 130);
      register("RecordPlayer", 84);
      register("Trap", 23);
      register("Dropper", 158);
      register("Sign", 63, 68);
      register("MobSpawner", 52);
      register("Music", 25);
      register("Piston", 33, 34, 29, 36);
      register("Cauldron", 117);
      register("EnchantTable", 116);
      register("Airportal", 119, 120);
      register("Beacon", 138);
      register("Skull", 144);
      register("DLDetector", 178, 151);
      register("Hopper", 154);
      register("Comparator", 149, 150);
      register("FlowerPot", 140);
      register("Banner", 176, 177);
      register("EndGateway", 209);
      register("Control", 137);
   }
}
