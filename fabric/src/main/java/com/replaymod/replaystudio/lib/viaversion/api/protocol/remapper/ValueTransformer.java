package com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.exception.InformativeException;
import org.checkerframework.checker.nullness.qual.Nullable;

public abstract class ValueTransformer<T1, T2> implements ValueWriter<T1> {
   private final Type<T1> inputType;
   private final Type<T2> outputType;

   protected ValueTransformer(@Nullable Type<T1> inputType, Type<T2> outputType) {
      this.inputType = inputType;
      this.outputType = outputType;
   }

   protected ValueTransformer(Type<T2> outputType) {
      this((Type)null, outputType);
   }

   public abstract T2 transform(PacketWrapper var1, T1 var2) throws Exception;

   public void write(PacketWrapper writer, T1 inputValue) throws Exception {
      try {
         writer.write(this.outputType, this.transform(writer, inputValue));
      } catch (InformativeException var4) {
         var4.addSource(this.getClass());
         throw var4;
      }
   }

   @Nullable
   public Type<T1> getInputType() {
      return this.inputType;
   }

   public Type<T2> getOutputType() {
      return this.outputType;
   }
}
