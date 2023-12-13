package com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;

public class TypeRemapper<T> implements ValueReader<T>, ValueWriter<T> {
   private final Type<T> type;

   public TypeRemapper(Type<T> type) {
      this.type = type;
   }

   public T read(PacketWrapper wrapper) throws Exception {
      return wrapper.read(this.type);
   }

   public void write(PacketWrapper output, T inputValue) {
      output.write(this.type, inputValue);
   }
}
