package com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.MetaType;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.Metadata;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;

public abstract class ModernMetaType extends MetaTypeTemplate {
   private static final int END = 255;

   public Metadata read(ByteBuf buffer) throws Exception {
      short index = buffer.readUnsignedByte();
      if (index == 255) {
         return null;
      } else {
         MetaType type = this.getType(Type.VAR_INT.readPrimitive(buffer));
         return new Metadata(index, type, type.type().read(buffer));
      }
   }

   protected abstract MetaType getType(int var1);

   public void write(ByteBuf buffer, Metadata object) throws Exception {
      if (object == null) {
         buffer.writeByte(255);
      } else {
         buffer.writeByte(object.id());
         MetaType type = object.metaType();
         Type.VAR_INT.writePrimitive(buffer, type.typeId());
         type.type().write(buffer, object.getValue());
      }

   }
}
