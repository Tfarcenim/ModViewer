package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.serializer.gson;

import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonParseException;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.TypeAdapter;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.stream.JsonReader;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.stream.JsonWriter;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.BlockNBTComponent;
import java.io.IOException;

final class BlockNBTComponentPosSerializer extends TypeAdapter<BlockNBTComponent.Pos> {
   static final TypeAdapter<BlockNBTComponent.Pos> INSTANCE = (new BlockNBTComponentPosSerializer()).nullSafe();

   private BlockNBTComponentPosSerializer() {
   }

   public BlockNBTComponent.Pos read(final JsonReader in) throws IOException {
      String string = in.nextString();

      try {
         return BlockNBTComponent.Pos.fromString(string);
      } catch (IllegalArgumentException var4) {
         throw new JsonParseException("Don't know how to turn " + string + " into a Position");
      }
   }

   public void write(final JsonWriter out, final BlockNBTComponent.Pos value) throws IOException {
      out.value(value.asString());
   }
}
