package com.replaymod.core.gui;

import com.replaymod.core.SettingsRegistry;
import com.replaymod.lib.de.johni0702.minecraft.gui.container.AbstractGuiScreen;
import com.replaymod.lib.de.johni0702.minecraft.gui.container.GuiPanel;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.GuiButton;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.GuiElement;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.GuiLabel;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.GuiToggleButton;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.advanced.GuiDropdownMenu;
import com.replaymod.lib.de.johni0702.minecraft.gui.layout.CustomLayout;
import com.replaymod.lib.de.johni0702.minecraft.gui.layout.HorizontalLayout;
import com.replaymod.lib.de.johni0702.minecraft.gui.layout.VerticalLayout;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.Consumer;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.Dimension;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.ReadableDimension;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;

public class GuiReplaySettings extends AbstractGuiScreen<GuiReplaySettings> {
   public GuiReplaySettings(Screen parent, SettingsRegistry settingsRegistry) {
      final GuiButton doneButton = (GuiButton)((GuiButton)((GuiButton)(new GuiButton(this)).setI18nLabel("gui.done", new Object[0])).setSize(200, 20)).onClick(new Runnable() {
         public void run() {
            GuiReplaySettings.this.getMinecraft().setScreen(parent);
         }
      });
      final GuiPanel allElements = (GuiPanel)(new GuiPanel(this)).setLayout((new HorizontalLayout()).setSpacing(10));
      GuiPanel leftColumn = (GuiPanel)(new GuiPanel()).setLayout((new VerticalLayout()).setSpacing(4));
      GuiPanel rightColumn = (GuiPanel)(new GuiPanel()).setLayout((new VerticalLayout()).setSpacing(4));
      allElements.addElements(new VerticalLayout.Data(0.0D), new GuiElement[]{leftColumn, rightColumn});
      HorizontalLayout.Data leftHorizontalData = new HorizontalLayout.Data(1.0D);
      HorizontalLayout.Data rightHorizontalData = new HorizontalLayout.Data(0.0D);
      int i = 0;
      Iterator var10 = settingsRegistry.getSettings().iterator();

      while(true) {
         final SettingsRegistry.SettingKey key;
         do {
            if (!var10.hasNext()) {
               this.setLayout(new CustomLayout<GuiReplaySettings>() {
                  protected void layout(GuiReplaySettings container, int width, int height) {
                     this.pos(allElements, width / 2 - 155, height / 6);
                     this.pos(doneButton, width / 2 - 100, height - 27);
                  }
               });
               this.setTitle((GuiLabel)(new GuiLabel()).setI18nText("replaymod.gui.settings.title", new Object[0]));
               return;
            }

            key = (SettingsRegistry.SettingKey)var10.next();
         } while(key.getDisplayString() == null);

         Object element;
         if (key.getDefault() instanceof Boolean) {
            final GuiToggleButton button = (GuiToggleButton)((GuiToggleButton)((GuiToggleButton)((GuiToggleButton)(new GuiToggleButton()).setSize(150, 20)).setI18nLabel(key.getDisplayString(), new Object[0])).setSelected((Boolean)settingsRegistry.get(key) ? 0 : 1)).setValues(new Object[]{I18n.get("options.on", new Object[0]), I18n.get("options.off", new Object[0])});
            element = button.onClick(new Runnable() {
               public void run() {
                  settingsRegistry.set(key, button.getSelected() == 0);
                  settingsRegistry.save();
               }
            });
         } else {
            if (!(key instanceof SettingsRegistry.MultipleChoiceSettingKey)) {
               throw new IllegalArgumentException("Type " + key.getDefault().getClass() + " not supported.");
            }

            final SettingsRegistry.MultipleChoiceSettingKey<?> multipleChoiceKey = (SettingsRegistry.MultipleChoiceSettingKey)key;
            List<?> values = multipleChoiceKey.getChoices();
            GuiReplaySettings.MultipleChoiceDropdownEntry[] entries = new GuiReplaySettings.MultipleChoiceDropdownEntry[values.size()];
            int selected = 0;
            Object currentValue = settingsRegistry.get(multipleChoiceKey);

            for(int j = 0; j < entries.length; ++j) {
               Object value = values.get(j);
               String var10005 = I18n.get(multipleChoiceKey.getDisplayString(), new Object[0]);
               entries[j] = new GuiReplaySettings.MultipleChoiceDropdownEntry(value, var10005 + ": " + I18n.get(value.toString(), new Object[0]));
               if (currentValue.equals(value)) {
                  selected = j;
               }
            }

            final GuiDropdownMenu<GuiReplaySettings.MultipleChoiceDropdownEntry> menu = (GuiDropdownMenu)((GuiDropdownMenu)(new GuiDropdownMenu<GuiReplaySettings.MultipleChoiceDropdownEntry>() {
               protected ReadableDimension calcMinSize() {
                  ReadableDimension size = super.calcMinSize();
                  return (ReadableDimension)(size.getWidth() > 150 ? new Dimension(150, size.getHeight()) : size);
               }
            }).setSize(150, 20)).setValues(entries);
            ((GuiDropdownMenu)menu.setSelected(selected)).onSelection(new Consumer<Integer>() {
               public void consume(Integer obj) {
                  settingsRegistry.set(multipleChoiceKey, ((GuiReplaySettings.MultipleChoiceDropdownEntry)menu.getSelectedValue()).value);
                  settingsRegistry.save();
               }
            });
            element = menu;
         }

         if (i++ % 2 == 0) {
            leftColumn.addElements(leftHorizontalData, new GuiElement[]{(GuiElement)element});
         } else {
            rightColumn.addElements(rightHorizontalData, new GuiElement[]{(GuiElement)element});
         }
      }
   }

   protected GuiReplaySettings getThis() {
      return this;
   }

   private static class MultipleChoiceDropdownEntry {
      private final Object value;
      private final String text;

      public MultipleChoiceDropdownEntry(Object value, String text) {
         this.value = value;
         this.text = text;
      }

      public String toString() {
         return this.text;
      }
   }
}
