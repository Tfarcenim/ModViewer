package com.replaymod.replaystudio.lib.viaversion.rewriter;

import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.Protocol;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.ClientboundPacketType;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandler;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonElement;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonObject;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonParser;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonPrimitive;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonSyntaxException;
import java.util.Iterator;

public class ComponentRewriter<C extends ClientboundPacketType> {
   protected final Protocol<C, ?, ?, ?> protocol;

   public ComponentRewriter(Protocol<C, ?, ?, ?> protocol) {
      this.protocol = protocol;
   }

   public ComponentRewriter() {
      this.protocol = null;
   }

   public void registerComponentPacket(C packetType) {
      this.protocol.registerClientbound(packetType, (wrapper) -> {
         this.processText((JsonElement)wrapper.passthrough(Type.COMPONENT));
      });
   }

   /** @deprecated */
   @Deprecated
   public void registerChatMessage(C packetType) {
      this.registerComponentPacket(packetType);
   }

   public void registerBossBar(C packetType) {
      this.protocol.registerClientbound(packetType, (PacketHandler)(new PacketHandlers() {
         public void register() {
            this.map(Type.UUID);
            this.map(Type.VAR_INT);
            this.handler((wrapper) -> {
               int action = (Integer)wrapper.get(Type.VAR_INT, 0);
               if (action == 0 || action == 3) {
                  ComponentRewriter.this.processText((JsonElement)wrapper.passthrough(Type.COMPONENT));
               }

            });
         }
      }));
   }

   public void registerCombatEvent(C packetType) {
      this.protocol.registerClientbound(packetType, (wrapper) -> {
         if ((Integer)wrapper.passthrough(Type.VAR_INT) == 2) {
            wrapper.passthrough(Type.VAR_INT);
            wrapper.passthrough(Type.INT);
            this.processText((JsonElement)wrapper.passthrough(Type.COMPONENT));
         }

      });
   }

   public void registerTitle(C packetType) {
      this.protocol.registerClientbound(packetType, (wrapper) -> {
         int action = (Integer)wrapper.passthrough(Type.VAR_INT);
         if (action >= 0 && action <= 2) {
            this.processText((JsonElement)wrapper.passthrough(Type.COMPONENT));
         }

      });
   }

   public JsonElement processText(String value) {
      try {
         JsonElement root = JsonParser.parseString(value);
         this.processText(root);
         return root;
      } catch (JsonSyntaxException var3) {
         if (Via.getManager().isDebug()) {
            Via.getPlatform().getLogger().severe("Error when trying to parse json: " + value);
            throw var3;
         } else {
            return new JsonPrimitive(value);
         }
      }
   }

   public void processText(JsonElement element) {
      if (element != null && !element.isJsonNull()) {
         if (element.isJsonArray()) {
            this.processAsArray(element);
         } else if (element.isJsonPrimitive()) {
            this.handleText(element.getAsJsonPrimitive());
         } else {
            JsonObject object = element.getAsJsonObject();
            JsonPrimitive text = object.getAsJsonPrimitive("text");
            if (text != null) {
               this.handleText(text);
            }

            JsonElement translate = object.get("translate");
            JsonElement extra;
            if (translate != null) {
               this.handleTranslate(object, translate.getAsString());
               extra = object.get("with");
               if (extra != null) {
                  this.processAsArray(extra);
               }
            }

            extra = object.get("extra");
            if (extra != null) {
               this.processAsArray(extra);
            }

            JsonObject hoverEvent = object.getAsJsonObject("hoverEvent");
            if (hoverEvent != null) {
               this.handleHoverEvent(hoverEvent);
            }

         }
      }
   }

   protected void handleText(JsonPrimitive text) {
   }

   protected void handleTranslate(JsonObject object, String translate) {
   }

   protected void handleHoverEvent(JsonObject hoverEvent) {
      String action = hoverEvent.getAsJsonPrimitive("action").getAsString();
      if (action.equals("show_text")) {
         JsonElement value = hoverEvent.get("value");
         this.processText(value != null ? value : hoverEvent.get("contents"));
      } else if (action.equals("show_entity")) {
         JsonObject contents = hoverEvent.getAsJsonObject("contents");
         if (contents != null) {
            this.processText(contents.get("name"));
         }
      }

   }

   private void processAsArray(JsonElement element) {
      Iterator var2 = element.getAsJsonArray().iterator();

      while(var2.hasNext()) {
         JsonElement jsonElement = (JsonElement)var2.next();
         this.processText(jsonElement);
      }

   }

   public <T extends Protocol<C, ?, ?, ?>> T getProtocol() {
      return this.protocol;
   }
}
