package com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.DataItem;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.Item;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import io.netty.buffer.ByteBuf;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ItemType extends BaseItemType {
   public ItemType() {
      super("Item");
   }

   @Nullable
   public Item read(ByteBuf buffer) throws Exception {
      short id = buffer.readShort();
      if (id < 0) {
         return null;
      } else {
         Item item = new DataItem();
         item.setIdentifier(id);
         item.setAmount(buffer.readByte());
         item.setData(buffer.readShort());
         item.setTag((CompoundTag)NBT.read(buffer));
         return item;
      }
   }

   public void write(ByteBuf buffer, @Nullable Item object) throws Exception {
      if (object == null) {
         buffer.writeShort(-1);
      } else {
         buffer.writeShort(object.identifier());
         buffer.writeByte(object.amount());
         buffer.writeShort(object.data());
         NBT.write(buffer, object.tag());
      }

   }
}
