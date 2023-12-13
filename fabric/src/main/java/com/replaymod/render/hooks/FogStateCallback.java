package com.replaymod.render.hooks;

import com.replaymod.lib.de.johni0702.minecraft.gui.utils.Event;
import java.util.Iterator;

public interface FogStateCallback {
   Event<FogStateCallback> EVENT = Event.create((listeners) -> {
      return (enabled) -> {
         Iterator var2 = listeners.iterator();

         while(var2.hasNext()) {
            FogStateCallback listener = (FogStateCallback)var2.next();
            listener.fogStateChanged(enabled);
         }

      };
   });

   void fogStateChanged(boolean var1);
}
