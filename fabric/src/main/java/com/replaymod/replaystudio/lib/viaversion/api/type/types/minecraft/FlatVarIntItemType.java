package com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.DataItem;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.Item;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public class FlatVarIntItemType extends BaseItemType {
   public FlatVarIntItemType() {
      super("FlatVarIntItem");
   }

   @Nullable
   public Item read(ByteBuf buffer) throws Exception {
      boolean present = buffer.readBoolean();
      if (!present) {
         return null;
      } else {
         Item item = new DataItem();
         item.setIdentifier(VAR_INT.readPrimitive(buffer));
         item.setAmount(buffer.readByte());
         item.setTag((CompoundTag)NBT.read(buffer));
         return item;
      }
   }

   public void write(ByteBuf buffer, @Nullable Item object) throws Exception {
      if (object == null) {
         buffer.writeBoolean(false);
      } else {
         buffer.writeBoolean(true);
         VAR_INT.writePrimitive(buffer, object.identifier());
         buffer.writeByte(object.amount());
         NBT.write(buffer, object.tag());
      }

   }
}
