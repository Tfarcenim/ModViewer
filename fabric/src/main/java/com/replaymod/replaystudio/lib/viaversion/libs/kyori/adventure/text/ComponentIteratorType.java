package com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text;

import com.replaymod.replaystudio.lib.viaversion.libs.kyori.adventure.text.event.HoverEvent;
import java.util.Deque;
import java.util.List;
import java.util.Set;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.ApiStatus.NonExtendable;

@FunctionalInterface
@NonExtendable
public interface ComponentIteratorType {
   ComponentIteratorType DEPTH_FIRST = (component, deque, flags) -> {
      List children;
      int i;
      if (flags.contains(ComponentIteratorFlag.INCLUDE_TRANSLATABLE_COMPONENT_ARGUMENTS) && component instanceof TranslatableComponent) {
         TranslatableComponent translatable = (TranslatableComponent)component;
         children = translatable.args();

         for(i = children.size() - 1; i >= 0; --i) {
            deque.addFirst((Component)children.get(i));
         }
      }

      HoverEvent<?> hoverEvent = component.hoverEvent();
      if (hoverEvent != null) {
         HoverEvent.Action<?> action = hoverEvent.action();
         if (flags.contains(ComponentIteratorFlag.INCLUDE_HOVER_SHOW_ENTITY_NAME) && action == HoverEvent.Action.SHOW_ENTITY) {
            deque.addFirst(((HoverEvent.ShowEntity)hoverEvent.value()).name());
         } else if (flags.contains(ComponentIteratorFlag.INCLUDE_HOVER_SHOW_TEXT_COMPONENT) && action == HoverEvent.Action.SHOW_TEXT) {
            deque.addFirst((Component)hoverEvent.value());
         }
      }

      children = component.children();

      for(i = children.size() - 1; i >= 0; --i) {
         deque.addFirst((Component)children.get(i));
      }

   };
   ComponentIteratorType BREADTH_FIRST = (component, deque, flags) -> {
      if (flags.contains(ComponentIteratorFlag.INCLUDE_TRANSLATABLE_COMPONENT_ARGUMENTS) && component instanceof TranslatableComponent) {
         deque.addAll(((TranslatableComponent)component).args());
      }

      HoverEvent<?> hoverEvent = component.hoverEvent();
      if (hoverEvent != null) {
         HoverEvent.Action<?> action = hoverEvent.action();
         if (flags.contains(ComponentIteratorFlag.INCLUDE_HOVER_SHOW_ENTITY_NAME) && action == HoverEvent.Action.SHOW_ENTITY) {
            deque.addLast(((HoverEvent.ShowEntity)hoverEvent.value()).name());
         } else if (flags.contains(ComponentIteratorFlag.INCLUDE_HOVER_SHOW_TEXT_COMPONENT) && action == HoverEvent.Action.SHOW_TEXT) {
            deque.addLast((Component)hoverEvent.value());
         }
      }

      deque.addAll(component.children());
   };

   void populate(@NotNull final Component component, @NotNull final Deque<Component> deque, @NotNull final Set<ComponentIteratorFlag> flags);
}
