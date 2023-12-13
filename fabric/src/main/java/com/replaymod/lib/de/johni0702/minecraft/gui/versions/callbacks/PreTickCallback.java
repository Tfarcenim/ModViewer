package com.replaymod.lib.de.johni0702.minecraft.gui.versions.callbacks;

import com.replaymod.lib.de.johni0702.minecraft.gui.utils.Event;
import java.util.Iterator;

public interface PreTickCallback {
   Event<PreTickCallback> EVENT = Event.create((listeners) -> {
      return () -> {
         Iterator var1 = listeners.iterator();

         while(var1.hasNext()) {
            PreTickCallback listener = (PreTickCallback)var1.next();
            listener.preTick();
         }

      };
   });

   void preTick();
}
