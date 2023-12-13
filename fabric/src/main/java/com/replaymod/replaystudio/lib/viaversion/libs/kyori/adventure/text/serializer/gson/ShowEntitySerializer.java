package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.serializer.gson;

import com.replaymod.replaystudio.lib.viaversion.libs.gson.Gson;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonParseException;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.TypeAdapter;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.stream.JsonReader;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.stream.JsonWriter;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.key.Key;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.Component;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.event.HoverEvent;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.UUID;

final class ShowEntitySerializer extends TypeAdapter<HoverEvent.ShowEntity> {
   static final String TYPE = "type";
   static final String ID = "id";
   static final String NAME = "name";
   private final Gson gson;

   static TypeAdapter<HoverEvent.ShowEntity> create(final Gson gson) {
      return (new ShowEntitySerializer(gson)).nullSafe();
   }

   private ShowEntitySerializer(final Gson gson) {
      this.gson = gson;
   }

   public HoverEvent.ShowEntity read(final JsonReader in) throws IOException {
      in.beginObject();
      Key type = null;
      UUID id = null;
      Component name = null;

      while(in.hasNext()) {
         String fieldName = in.nextName();
         if (fieldName.equals("type")) {
            type = (Key)this.gson.fromJson((JsonReader)in, (Type)SerializerFactory.KEY_TYPE);
         } else if (fieldName.equals("id")) {
            id = UUID.fromString(in.nextString());
         } else if (fieldName.equals("name")) {
            name = (Component)this.gson.fromJson((JsonReader)in, (Type)SerializerFactory.COMPONENT_TYPE);
         } else {
            in.skipValue();
         }
      }

      if (type != null && id != null) {
         in.endObject();
         return HoverEvent.ShowEntity.of(type, id, name);
      } else {
         throw new JsonParseException("A show entity hover event needs type and id fields to be deserialized");
      }
   }

   public void write(final JsonWriter out, final HoverEvent.ShowEntity value) throws IOException {
      out.beginObject();
      out.name("type");
      this.gson.toJson(value.type(), SerializerFactory.KEY_TYPE, (JsonWriter)out);
      out.name("id");
      out.value(value.id().toString());
      Component name = value.name();
      if (name != null) {
         out.name("name");
         this.gson.toJson(name, SerializerFactory.COMPONENT_TYPE, (JsonWriter)out);
      }

      out.endObject();
   }
}
