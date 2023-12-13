package com.replaymod.render.events;

import com.replaymod.lib.de.johni0702.minecraft.gui.utils.Event;
import com.replaymod.render.rendering.VideoRenderer;
import java.util.Iterator;

public interface ReplayRenderCallback {
   public interface Post {
      Event<ReplayRenderCallback.Post> EVENT = Event.create((listeners) -> {
         return (renderer) -> {
            Iterator var2 = listeners.iterator();

            while(var2.hasNext()) {
               ReplayRenderCallback.Post listener = (ReplayRenderCallback.Post)var2.next();
               listener.afterRendering(renderer);
            }

         };
      });

      void afterRendering(VideoRenderer var1);
   }

   public interface Pre {
      Event<ReplayRenderCallback.Pre> EVENT = Event.create((listeners) -> {
         return (renderer) -> {
            Iterator var2 = listeners.iterator();

            while(var2.hasNext()) {
               ReplayRenderCallback.Pre listener = (ReplayRenderCallback.Pre)var2.next();
               listener.beforeRendering(renderer);
            }

         };
      });

      void beforeRendering(VideoRenderer var1);
   }
}
