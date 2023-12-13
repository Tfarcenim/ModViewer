package com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.Item;
import io.netty.buffer.ByteBuf;

public class FlatVarIntItemArrayType extends BaseItemArrayType {
   public FlatVarIntItemArrayType() {
      super("Flat Item Array");
   }

   public Item[] read(ByteBuf buffer) throws Exception {
      int amount = SHORT.readPrimitive(buffer);
      Item[] array = new Item[amount];

      for(int i = 0; i < amount; ++i) {
         array[i] = (Item)FLAT_VAR_INT_ITEM.read(buffer);
      }

      return array;
   }

   public void write(ByteBuf buffer, Item[] object) throws Exception {
      SHORT.writePrimitive(buffer, (short)object.length);
      Item[] var3 = object;
      int var4 = object.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         Item o = var3[var5];
         FLAT_VAR_INT_ITEM.write(buffer, o);
      }

   }
}
