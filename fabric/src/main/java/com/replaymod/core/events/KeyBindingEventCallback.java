package com.replaymod.core.events;

import com.replaymod.lib.de.johni0702.minecraft.gui.utils.Event;
import java.util.Iterator;

public interface KeyBindingEventCallback {
   Event<KeyBindingEventCallback> EVENT = Event.create((listeners) -> {
      return () -> {
         Iterator var1 = listeners.iterator();

         while(var1.hasNext()) {
            KeyBindingEventCallback listener = (KeyBindingEventCallback)var1.next();
            listener.onKeybindingEvent();
         }

      };
   });

   void onKeybindingEvent();
}
