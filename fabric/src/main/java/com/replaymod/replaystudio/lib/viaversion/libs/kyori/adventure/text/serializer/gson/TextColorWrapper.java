package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.serializer.gson;

import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonParseException;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonSyntaxException;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.TypeAdapter;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.stream.JsonReader;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.stream.JsonWriter;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.format.TextColor;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.format.TextDecoration;
import java.io.IOException;
import org.jetbrains.annotations.Nullable;

final class TextColorWrapper {
   @Nullable
   final TextColor color;
   @Nullable
   final TextDecoration decoration;
   final boolean reset;

   TextColorWrapper(@Nullable final TextColor color, @Nullable final TextDecoration decoration, final boolean reset) {
      this.color = color;
      this.decoration = decoration;
      this.reset = reset;
   }

   static final class Serializer extends TypeAdapter<TextColorWrapper> {
      static final TextColorWrapper.Serializer INSTANCE = new TextColorWrapper.Serializer();

      private Serializer() {
      }

      public void write(final JsonWriter out, final TextColorWrapper value) {
         throw new JsonSyntaxException("Cannot write TextColorWrapper instances");
      }

      public TextColorWrapper read(final JsonReader in) throws IOException {
         String input = in.nextString();
         TextColor color = TextColorSerializer.fromString(input);
         TextDecoration decoration = (TextDecoration)TextDecoration.NAMES.value(input);
         boolean reset = decoration == null && input.equals("reset");
         if (color == null && decoration == null && !reset) {
            throw new JsonParseException("Don't know how to parse " + input + " at " + in.getPath());
         } else {
            return new TextColorWrapper(color, decoration, reset);
         }
      }
   }
}
