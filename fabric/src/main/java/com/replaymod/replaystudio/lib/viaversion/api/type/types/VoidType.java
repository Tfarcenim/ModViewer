package com.replaymod.replaystudio.lib.viaversion.api.type.types;

import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.TypeConverter;
import io.netty.buffer.ByteBuf;

public class VoidType extends Type<Void> implements TypeConverter<Void> {
   public VoidType() {
      super(Void.class);
   }

   public Void read(ByteBuf buffer) {
      return null;
   }

   public void write(ByteBuf buffer, Void object) {
   }

   public Void from(Object o) {
      return null;
   }
}
