package com.replaymod.core.events;

import com.replaymod.lib.de.johni0702.minecraft.gui.utils.Event;
import java.util.Iterator;

public interface PostRenderCallback {
   Event<PostRenderCallback> EVENT = Event.create((listeners) -> {
      return () -> {
         Iterator var1 = listeners.iterator();

         while(var1.hasNext()) {
            PostRenderCallback listener = (PostRenderCallback)var1.next();
            listener.postRender();
         }

      };
   });

   void postRender();
}
