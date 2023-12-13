package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2;

import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonElement;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonObject;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonParser;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.Component;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.TextComponent;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.format.TextDecoration;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.serializer.gson.GsonComponentSerializer;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.serializer.gson.legacyimpl.NBTLegacyHoverEventSerializer;
import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;

public final class ChatRewriter {
   public static final GsonComponentSerializer HOVER_GSON_SERIALIZER = GsonComponentSerializer.builder().emitLegacyHoverEvent().legacyHoverEventSerializer(NBTLegacyHoverEventSerializer.get()).build();

   public static JsonObject emptyComponent() {
      JsonObject object = new JsonObject();
      object.addProperty("text", "");
      return object;
   }

   public static String emptyComponentString() {
      return "{\"text\":\"\"}";
   }

   public static String legacyTextToJsonString(String message, boolean itemData) {
      Component component = LegacyComponentSerializer.legacySection().deserialize(message);
      if (itemData) {
         component = ((TextComponent.Builder)((TextComponent.Builder)Component.text().decoration(TextDecoration.ITALIC, false)).append((Component)component)).build();
      }

      return (String)GsonComponentSerializer.gson().serialize((Component)component);
   }

   public static String legacyTextToJsonString(String legacyText) {
      return legacyTextToJsonString(legacyText, false);
   }

   public static JsonElement legacyTextToJson(String legacyText) {
      return JsonParser.parseString(legacyTextToJsonString(legacyText, false));
   }

   public static String jsonToLegacyText(String value) {
      try {
         Component component = HOVER_GSON_SERIALIZER.deserialize(value);
         return LegacyComponentSerializer.legacySection().serialize(component);
      } catch (Exception var2) {
         Via.getPlatform().getLogger().warning("Error converting json text to legacy: " + value);
         var2.printStackTrace();
         return "";
      }
   }

   /** @deprecated */
   @Deprecated
   public static void processTranslate(JsonElement value) {
      ((Protocol1_13To1_12_2)Via.getManager().getProtocolManager().getProtocol(Protocol1_13To1_12_2.class)).getComponentRewriter().processText(value);
   }
}
