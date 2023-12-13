package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.title;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.Component;
import org.jetbrains.annotations.ApiStatus.NonExtendable;

@NonExtendable
public interface TitlePart<T> {
   TitlePart<Component> TITLE = new TitlePart<Component>() {
      public String toString() {
         return "TitlePart.TITLE";
      }
   };
   TitlePart<Component> SUBTITLE = new TitlePart<Component>() {
      public String toString() {
         return "TitlePart.SUBTITLE";
      }
   };
   TitlePart<Title.Times> TIMES = new TitlePart<Title.Times>() {
      public String toString() {
         return "TitlePart.TIMES";
      }
   };
}
