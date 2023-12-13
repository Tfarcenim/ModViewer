package com.replaymod.lib.de.johni0702.minecraft.gui.versions.callbacks;

import com.replaymod.lib.de.johni0702.minecraft.gui.utils.Event;
import java.util.Collection;
import java.util.Iterator;
import net.minecraft.client.gui.components.AbstractWidget;
import net.minecraft.client.gui.screens.Screen;

public interface InitScreenCallback {
   Event<InitScreenCallback> EVENT = Event.create((listeners) -> {
      return (screen, buttons) -> {
         Iterator var3 = listeners.iterator();

         while(var3.hasNext()) {
            InitScreenCallback listener = (InitScreenCallback)var3.next();
            listener.initScreen(screen, buttons);
         }

      };
   });

   void initScreen(Screen var1, Collection<AbstractWidget> var2);

   public interface Pre {
      Event<InitScreenCallback.Pre> EVENT = Event.create((listeners) -> {
         return (screen) -> {
            Iterator var2 = listeners.iterator();

            while(var2.hasNext()) {
               InitScreenCallback.Pre listener = (InitScreenCallback.Pre)var2.next();
               listener.preInitScreen(screen);
            }

         };
      });

      void preInitScreen(Screen var1);
   }
}
