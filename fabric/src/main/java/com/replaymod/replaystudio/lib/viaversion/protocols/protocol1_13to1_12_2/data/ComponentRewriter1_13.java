package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.data;

import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.DataItem;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.Item;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.nbt.BinaryTagIO;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.Protocol;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.ClientboundPacketType;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonArray;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonElement;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonObject;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonPrimitive;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.NumberTag;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.ShortTag;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.Protocol1_13To1_12_2;
import com.replaymod.replaystudio.lib.viaversion.rewriter.ComponentRewriter;
import java.io.IOException;
import java.util.Iterator;

public class ComponentRewriter1_13<C extends ClientboundPacketType> extends ComponentRewriter<C> {
   public ComponentRewriter1_13(Protocol<C, ?, ?, ?> protocol) {
      super(protocol);
   }

   protected void handleHoverEvent(JsonObject hoverEvent) {
      super.handleHoverEvent(hoverEvent);
      String action = hoverEvent.getAsJsonPrimitive("action").getAsString();
      if (action.equals("show_item")) {
         JsonElement value = hoverEvent.get("value");
         if (value != null) {
            String text = this.findItemNBT(value);
            if (text != null) {
               CompoundTag tag;
               try {
                  tag = BinaryTagIO.readString(text);
               } catch (Exception var15) {
                  if (!Via.getConfig().isSuppressConversionWarnings() || Via.getManager().isDebug()) {
                     Via.getPlatform().getLogger().warning("Error reading NBT in show_item:" + text);
                     var15.printStackTrace();
                  }

                  return;
               }

               CompoundTag itemTag = (CompoundTag)tag.get("tag");
               NumberTag damageTag = (NumberTag)tag.get("Damage");
               short damage = damageTag != null ? damageTag.asShort() : 0;
               Item item = new DataItem();
               item.setData(damage);
               item.setTag(itemTag);
               this.protocol.getItemRewriter().handleItemToClient(item);
               if (damage != item.data()) {
                  tag.put("Damage", new ShortTag(item.data()));
               }

               if (itemTag != null) {
                  tag.put("tag", itemTag);
               }

               JsonArray array = new JsonArray();
               JsonObject object = new JsonObject();
               array.add((JsonElement)object);

               try {
                  String serializedNBT = BinaryTagIO.writeString(tag);
                  object.addProperty("text", serializedNBT);
                  hoverEvent.add("value", array);
               } catch (IOException var14) {
                  Via.getPlatform().getLogger().warning("Error writing NBT in show_item:" + text);
                  var14.printStackTrace();
               }

            }
         }
      }
   }

   protected String findItemNBT(JsonElement element) {
      if (element.isJsonArray()) {
         Iterator var2 = element.getAsJsonArray().iterator();

         while(var2.hasNext()) {
            JsonElement jsonElement = (JsonElement)var2.next();
            String value = this.findItemNBT(jsonElement);
            if (value != null) {
               return value;
            }
         }
      } else if (element.isJsonObject()) {
         JsonPrimitive text = element.getAsJsonObject().getAsJsonPrimitive("text");
         if (text != null) {
            return text.getAsString();
         }
      } else if (element.isJsonPrimitive()) {
         return element.getAsJsonPrimitive().getAsString();
      }

      return null;
   }

   protected void handleTranslate(JsonObject object, String translate) {
      super.handleTranslate(object, translate);
      String newTranslate = (String)Protocol1_13To1_12_2.MAPPINGS.getTranslateMapping().get(translate);
      if (newTranslate == null) {
         newTranslate = (String)Protocol1_13To1_12_2.MAPPINGS.getMojangTranslation().get(translate);
      }

      if (newTranslate != null) {
         object.addProperty("translate", newTranslate);
      }

   }
}
