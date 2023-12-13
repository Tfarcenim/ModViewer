package com.replaymod.replaystudio.util;

import com.replaymod.replaystudio.protocol.Packet;
import java.io.IOException;

public class Property {
   private final String name;
   private final String value;
   private final String signature;

   public Property(String name, String value, String signature) {
      this.name = name;
      this.value = value;
      this.signature = signature;
   }

   public static Property read(Packet.Reader in) throws IOException {
      String name = in.readString();
      String value = in.readString();
      String signature = null;
      if (in.readBoolean()) {
         signature = in.readString();
      }

      return new Property(name, value, signature);
   }

   public void write(Packet.Writer out) throws IOException {
      out.writeString(this.name);
      out.writeString(this.value);
      if (this.signature != null) {
         out.writeBoolean(true);
         out.writeString(this.signature);
      } else {
         out.writeBoolean(false);
      }

   }
}
