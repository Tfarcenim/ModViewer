package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.serializer.gson;

import com.replaymod.replaystudio.lib.viaversion.libs.gson.Gson;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonParseException;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.TypeAdapter;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.stream.JsonReader;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.stream.JsonToken;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.stream.JsonWriter;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.key.Key;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.nbt.api.BinaryTagHolder;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.event.HoverEvent;
import java.io.IOException;
import java.lang.reflect.Type;

final class ShowItemSerializer extends TypeAdapter<HoverEvent.ShowItem> {
   static final String ID = "id";
   static final String COUNT = "count";
   static final String TAG = "tag";
   private final Gson gson;

   static TypeAdapter<HoverEvent.ShowItem> create(final Gson gson) {
      return (new ShowItemSerializer(gson)).nullSafe();
   }

   private ShowItemSerializer(final Gson gson) {
      this.gson = gson;
   }

   public HoverEvent.ShowItem read(final JsonReader in) throws IOException {
      in.beginObject();
      Key key = null;
      int count = 1;
      BinaryTagHolder nbt = null;

      while(true) {
         while(in.hasNext()) {
            String fieldName = in.nextName();
            if (fieldName.equals("id")) {
               key = (Key)this.gson.fromJson((JsonReader)in, (Type)SerializerFactory.KEY_TYPE);
            } else if (fieldName.equals("count")) {
               count = in.nextInt();
            } else if (fieldName.equals("tag")) {
               JsonToken token = in.peek();
               if (token != JsonToken.STRING && token != JsonToken.NUMBER) {
                  if (token == JsonToken.BOOLEAN) {
                     nbt = BinaryTagHolder.binaryTagHolder(String.valueOf(in.nextBoolean()));
                  } else {
                     if (token != JsonToken.NULL) {
                        throw new JsonParseException("Expected tag to be a string");
                     }

                     in.nextNull();
                  }
               } else {
                  nbt = BinaryTagHolder.binaryTagHolder(in.nextString());
               }
            } else {
               in.skipValue();
            }
         }

         if (key == null) {
            throw new JsonParseException("Not sure how to deserialize show_item hover event");
         }

         in.endObject();
         return HoverEvent.ShowItem.of(key, count, nbt);
      }
   }

   public void write(final JsonWriter out, final HoverEvent.ShowItem value) throws IOException {
      out.beginObject();
      out.name("id");
      this.gson.toJson(value.item(), SerializerFactory.KEY_TYPE, (JsonWriter)out);
      int count = value.count();
      if (count != 1) {
         out.name("count");
         out.value((long)count);
      }

      BinaryTagHolder nbt = value.nbt();
      if (nbt != null) {
         out.name("tag");
         out.value(nbt.string());
      }

      out.endObject();
   }
}
