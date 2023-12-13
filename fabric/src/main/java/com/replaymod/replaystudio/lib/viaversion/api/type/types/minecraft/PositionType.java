package com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.Position;
import com.replaymod.replaystudio.lib.viaversion.api.type.OptionalType;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;

public class PositionType extends Type<Position> {
   public PositionType() {
      super(Position.class);
   }

   public Position read(ByteBuf buffer) {
      long val = buffer.readLong();
      long x = val >> 38;
      long y = val >> 26 & 4095L;
      long z = val << 38 >> 38;
      return new Position((int)x, (short)((int)y), (int)z);
   }

   public void write(ByteBuf buffer, Position object) {
      buffer.writeLong(((long)object.x() & 67108863L) << 38 | ((long)object.y() & 4095L) << 26 | (long)(object.z() & 67108863));
   }

   public static final class OptionalPositionType extends OptionalType<Position> {
      public OptionalPositionType() {
         super(Type.POSITION);
      }
   }
}
