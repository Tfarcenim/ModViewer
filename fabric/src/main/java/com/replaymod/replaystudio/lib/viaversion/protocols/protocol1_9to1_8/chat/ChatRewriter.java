package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.chat;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonArray;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonElement;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonObject;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.Protocol1_9To1_8;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.storage.EntityTracker1_9;

public class ChatRewriter {
   public static void toClient(JsonObject obj, UserConnection user) {
      if (obj.get("translate") != null && obj.get("translate").getAsString().equals("gameMode.changed")) {
         EntityTracker1_9 tracker = (EntityTracker1_9)user.getEntityTracker(Protocol1_9To1_8.class);
         String gameMode = tracker.getGameMode().getText();
         JsonObject gameModeObject = new JsonObject();
         gameModeObject.addProperty("text", gameMode);
         gameModeObject.addProperty("color", "gray");
         gameModeObject.addProperty("italic", true);
         JsonArray array = new JsonArray();
         array.add((JsonElement)gameModeObject);
         obj.add("with", array);
      }

   }
}
