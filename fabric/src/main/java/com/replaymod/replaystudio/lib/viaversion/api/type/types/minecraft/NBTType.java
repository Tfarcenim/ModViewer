package com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft;

import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.NBTIO;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.limiter.TagLimiter;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.ByteBufInputStream;
import io.netty.buffer.ByteBufOutputStream;
import java.io.DataInput;
import java.io.DataOutput;

public class NBTType extends Type<CompoundTag> {
   private static final int MAX_NBT_BYTES = 2097152;
   private static final int MAX_NESTING_LEVEL = 512;

   public NBTType() {
      super(CompoundTag.class);
   }

   public CompoundTag read(ByteBuf buffer) throws Exception {
      int readerIndex = buffer.readerIndex();
      byte b = buffer.readByte();
      if (b == 0) {
         return null;
      } else {
         buffer.readerIndex(readerIndex);
         return NBTIO.readTag((DataInput)(new ByteBufInputStream(buffer)), TagLimiter.create(2097152, 512));
      }
   }

   public void write(ByteBuf buffer, CompoundTag object) throws Exception {
      if (object == null) {
         buffer.writeByte(0);
      } else {
         ByteBufOutputStream bytebufStream = new ByteBufOutputStream(buffer);
         NBTIO.writeTag((DataOutput)bytebufStream, object);
      }

   }
}
