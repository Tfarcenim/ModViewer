package com.replaymod.replaystudio.lib.viaversion.api.type.types;

import com.replaymod.replaystudio.lib.guava.base.Preconditions;
import com.replaymod.replaystudio.lib.viaversion.api.type.OptionalType;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import io.netty.buffer.ByteBuf;
import java.nio.charset.StandardCharsets;

public class StringType extends Type<String> {
   private static final int maxJavaCharUtf8Length;
   private final int maxLength;

   public StringType() {
      this(32767);
   }

   public StringType(int maxLength) {
      super(String.class);
      this.maxLength = maxLength;
   }

   public String read(ByteBuf buffer) throws Exception {
      int len = Type.VAR_INT.readPrimitive(buffer);
      Preconditions.checkArgument(len <= this.maxLength * maxJavaCharUtf8Length, "Cannot receive string longer than Short.MAX_VALUE * " + maxJavaCharUtf8Length + " bytes (got %s bytes)", len);
      String string = buffer.toString(buffer.readerIndex(), len, StandardCharsets.UTF_8);
      buffer.skipBytes(len);
      Preconditions.checkArgument(string.length() <= this.maxLength, "Cannot receive string longer than Short.MAX_VALUE characters (got %s bytes)", string.length());
      return string;
   }

   public void write(ByteBuf buffer, String object) throws Exception {
      Preconditions.checkArgument(object.length() <= this.maxLength, "Cannot send string longer than Short.MAX_VALUE (got %s characters)", object.length());
      byte[] b = object.getBytes(StandardCharsets.UTF_8);
      Type.VAR_INT.writePrimitive(buffer, b.length);
      buffer.writeBytes(b);
   }

   static {
      maxJavaCharUtf8Length = Character.toString('\uffff').getBytes(StandardCharsets.UTF_8).length;
   }

   public static final class OptionalStringType extends OptionalType<String> {
      public OptionalStringType() {
         super(Type.STRING);
      }
   }
}
