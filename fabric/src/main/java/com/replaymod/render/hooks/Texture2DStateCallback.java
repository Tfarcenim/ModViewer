package com.replaymod.render.hooks;

import com.replaymod.lib.de.johni0702.minecraft.gui.utils.Event;
import java.util.Iterator;

public interface Texture2DStateCallback {
   Event<Texture2DStateCallback> EVENT = Event.create((listeners) -> {
      return (slot, enabled) -> {
         Iterator var3 = listeners.iterator();

         while(var3.hasNext()) {
            Texture2DStateCallback listener = (Texture2DStateCallback)var3.next();
            listener.texture2DStateChanged(slot, enabled);
         }

      };
   });

   void texture2DStateChanged(int var1, boolean var2);
}
