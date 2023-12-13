package com.replaymod.extras;

import com.replaymod.core.KeyBindingRegistry;
import com.replaymod.core.ReplayMod;
import com.replaymod.lib.de.johni0702.minecraft.gui.GuiRenderer;
import com.replaymod.lib.de.johni0702.minecraft.gui.RenderInfo;
import com.replaymod.lib.de.johni0702.minecraft.gui.container.GuiPanel;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.GuiButton;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.GuiElement;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.GuiLabel;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.GuiTooltip;
import com.replaymod.lib.de.johni0702.minecraft.gui.layout.CustomLayout;
import com.replaymod.lib.de.johni0702.minecraft.gui.layout.GridLayout;
import com.replaymod.lib.de.johni0702.minecraft.gui.layout.LayoutData;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.EventRegistrations;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.ReadableDimension;
import com.replaymod.replay.events.ReplayOpenedCallback;
import com.replaymod.replay.gui.overlay.GuiReplayOverlay;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.resources.language.I18n;

public class HotkeyButtons extends EventRegistrations implements Extra {
   private ReplayMod mod;

   public HotkeyButtons() {
      this.on(ReplayOpenedCallback.EVENT, (replayHandler) -> {
         new HotkeyButtons.Gui(this.mod, replayHandler.getOverlay());
      });
   }

   public void register(ReplayMod mod) {
      this.mod = mod;
      this.register();
   }

   public static final class Gui {
      private final GuiButton toggleButton;
      private final GridLayout panelLayout;
      private final GuiPanel panel;
      private boolean open;

      public Gui(ReplayMod mod, GuiReplayOverlay overlay) {
         this.toggleButton = (GuiButton)((GuiButton)((GuiButton)((GuiButton)(new GuiButton(overlay)).setSize(20, 20)).setTexture(ReplayMod.TEXTURE, 256)).setSpriteUV(0, 120)).onClick(new Runnable() {
            // $FF: synthetic field
            final HotkeyButtons.Gui this$0;

            {
               this.this$0 = this$0;
            }

            public void run() {
               this.this$0.open = !this.this$0.open;
            }
         });
         this.panel = (GuiPanel)(new GuiPanel(overlay) {
            // $FF: synthetic field
            final HotkeyButtons.Gui this$0;

            {
               super(container);
               this.this$0 = this$0;
            }

            public Collection<GuiElement> getChildren() {
               return (Collection)(this.this$0.open ? super.getChildren() : Collections.emptyList());
            }

            public Map<GuiElement, LayoutData> getElements() {
               return this.this$0.open ? super.getElements() : Collections.emptyMap();
            }
         }).setLayout(this.panelLayout = (new GridLayout()).setSpacingX(5).setSpacingY(5).setColumns(1));
         KeyBindingRegistry keyBindingRegistry = mod.getKeyBindingRegistry();
         keyBindingRegistry.getBindings().values().stream().sorted(Comparator.comparing((it) -> {
            return I18n.get(it.name, new Object[0]);
         })).forEachOrdered((keyBinding) -> {
            GuiButton button = (GuiButton)(new GuiButton(keyBinding) {
               // $FF: synthetic field
               final KeyBindingRegistry.Binding val$keyBinding;
               // $FF: synthetic field
               final HotkeyButtons.Gui this$0;

               {
                  this.this$0 = this$0;
                  this.val$keyBinding = var2;
               }

               public void draw(GuiRenderer renderer, ReadableDimension size, RenderInfo renderInfo) {
                  this.setLabel(this.val$keyBinding.isBound() ? this.val$keyBinding.getBoundKey() : "");
                  if (this.val$keyBinding.supportsAutoActivation()) {
                     GuiTooltip var10001 = new GuiTooltip();
                     String[] var10002 = new String[]{I18n.get("replaymod.gui.ingame.autoactivating", new Object[0]), null};
                     String var10005 = this.val$keyBinding.isAutoActivating() ? "disable" : "enable";
                     var10002[1] = I18n.get("replaymod.gui.ingame.autoactivating." + var10005, new Object[0]);
                     this.setTooltip(var10001.setText(var10002));
                     this.setLabelColor(this.val$keyBinding.isAutoActivating() ? '\uff00' : 14737632);
                  }

                  super.draw(renderer, size, renderInfo);
               }
            }).onClick(() -> {
               if (keyBinding.supportsAutoActivation() && Screen.hasControlDown()) {
                  keyBinding.setAutoActivating(!keyBinding.isAutoActivating());
               } else {
                  keyBinding.trigger();
               }

            });
            GuiLabel label = (GuiLabel)(new GuiLabel()).setI18nText(keyBinding.name, new Object[0]);
            this.panel.addElements((LayoutData)null, new GuiElement[]{((GuiPanel)((GuiPanel)(new GuiPanel()).setLayout(new CustomLayout<GuiPanel>(button, label) {
               // $FF: synthetic field
               final GuiButton val$button;
               // $FF: synthetic field
               final GuiLabel val$label;
               // $FF: synthetic field
               final HotkeyButtons.Gui this$0;

               {
                  this.this$0 = this$0;
                  this.val$button = var2;
                  this.val$label = var3;
               }

               protected void layout(GuiPanel container, int width, int height) {
                  this.width(this.val$button, Math.max(10, this.width(this.val$button)) + 10);
                  this.height(this.val$button, 20);
                  int textWidth = this.width(this.val$label);
                  this.x(this.val$label, this.width(this.val$button) + 4);
                  this.width(this.val$label, width - this.x(this.val$label));
                  if (textWidth > width - this.x(this.val$label)) {
                     this.height(this.val$label, this.height(this.val$label) * 2);
                  }

                  this.y(this.val$label, (height - this.height(this.val$label)) / 2);
               }
            })).addElements((LayoutData)null, new GuiElement[]{button, label})).setSize(150, 20)});
         });
         overlay.setLayout(new CustomLayout<GuiReplayOverlay>(overlay.getLayout()) {
            // $FF: synthetic field
            final HotkeyButtons.Gui this$0;

            {
               super(parent);
               this.this$0 = this$0;
            }

            protected void layout(GuiReplayOverlay container, int width, int height) {
               this.this$0.panelLayout.setColumns(Math.max(1, (width - 10) / 155));
               this.size(this.this$0.panel, this.this$0.panel.getMinSize());
               this.pos(this.this$0.toggleButton, 5, height - 25);
               this.pos(this.this$0.panel, 5, this.y(this.this$0.toggleButton) - 5 - this.height(this.this$0.panel));
            }
         });
      }
   }
}
