package com.replaymod.core.gui;

import com.replaymod.core.versions.MCVer;
import com.replaymod.lib.de.johni0702.minecraft.gui.GuiRenderer;
import com.replaymod.lib.de.johni0702.minecraft.gui.RenderInfo;
import com.replaymod.lib.de.johni0702.minecraft.gui.container.AbstractGuiContainer;
import com.replaymod.lib.de.johni0702.minecraft.gui.container.GuiPanel;
import com.replaymod.lib.de.johni0702.minecraft.gui.container.GuiScreen;
import com.replaymod.lib.de.johni0702.minecraft.gui.container.VanillaGuiScreen;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.GuiElement;
import com.replaymod.lib.de.johni0702.minecraft.gui.layout.CustomLayout;
import com.replaymod.lib.de.johni0702.minecraft.gui.layout.VerticalLayout;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.EventRegistrations;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.Dimension;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.ReadableDimension;
import com.replaymod.lib.de.johni0702.minecraft.gui.versions.callbacks.InitScreenCallback;
import java.util.Iterator;
import net.minecraft.client.gui.screens.Screen;

public class GuiBackgroundProcesses extends EventRegistrations {
   private final GuiPanel panel = new GuiPanel().setLayout(new VerticalLayout().setSpacing(10));
   private boolean reentrant;

   public GuiBackgroundProcesses() {
      this.on(InitScreenCallback.EVENT, (screen, buttons) -> this.onGuiInit(screen));
   }

   private void onGuiInit(Screen guiScreen) {
      if (guiScreen == MCVer.getMinecraft().screen) {
         if (!this.reentrant) {
            VanillaGuiScreen vanillaGui;
            try {
               this.reentrant = true;
               vanillaGui = VanillaGuiScreen.wrap(guiScreen);
            } finally {
               this.reentrant = false;
            }

            vanillaGui.setLayout(new CustomLayout<GuiScreen>(vanillaGui.getLayout()) {
               protected void layout(GuiScreen container, int width, int height) {
                  this.pos(GuiBackgroundProcesses.this.panel, width - 5 - this.width(GuiBackgroundProcesses.this.panel), 5);
               }
            }).addElements(null, this.panel);
         }
      }
   }

   public void addProcess(GuiElement<?> element) {
      this.panel.addElements(new VerticalLayout.Data(1.0D), new Element(element));
   }

   public void removeProcess(GuiElement<?> element) {
      Iterator<GuiElement> var2 = this.panel.getChildren().iterator();

      GuiElement child;
      do {
         if (!var2.hasNext()) {
            return;
         }

         child = var2.next();
      } while(((GuiBackgroundProcesses.Element)child).inner != element);

      this.panel.removeElement(child);
   }

   private static class Element extends AbstractGuiContainer<GuiBackgroundProcesses.Element> {
      private final GuiElement inner;

      Element(GuiElement inner) {
         this.inner = inner;
         this.addElements(null, inner);
         this.setLayout(new CustomLayout<GuiBackgroundProcesses.Element>(inner) {
            // $FF: synthetic field
            final GuiElement val$inner;
            // $FF: synthetic field
            final GuiBackgroundProcesses.Element this$0;

            {
               this.this$0 = this$0;
               this.val$inner = var2;
            }

            protected void layout(GuiBackgroundProcesses.Element container, int width, int height) {
               this.pos(this.val$inner, 10, 10);
               this.size(this.val$inner, width - 20, height - 20);
            }
         });
      }

      public int getLayer() {
         return 1;
      }

      public ReadableDimension getMinSize() {
         ReadableDimension minSize = this.inner.getMinSize();
         return new Dimension(minSize.getWidth() + 20, minSize.getHeight() + 20);
      }

      public void draw(GuiRenderer renderer, ReadableDimension size, RenderInfo renderInfo) {
         int u0 = false;
         int v0 = true;
         renderer.bindTexture(TEXTURE);
         int w = size.getWidth();
         int h = size.getHeight();
         renderer.drawTexturedRect(0, 0, 0, 39, 5, 5);
         renderer.drawTexturedRect(w - 5, 0, 12, 39, 5, 5);
         renderer.drawTexturedRect(0, h - 5, 0, 51, 5, 5);
         renderer.drawTexturedRect(w - 5, h - 5, 12, 51, 5, 5);

         int x;
         int y;
         for(x = 5; x < w - 5; x += 5) {
            y = Math.min(5, w - 5 - x);
            renderer.drawTexturedRect(x, 0, 6, 39, y, 5);
            renderer.drawTexturedRect(x, h - 5, 6, 51, y, 5);
         }

         for(x = 5; x < h - 5; x += 5) {
            y = Math.min(5, h - 5 - x);
            renderer.drawTexturedRect(0, x, 0, 45, 5, y);
            renderer.drawTexturedRect(w - 5, x, 12, 45, 5, y);
         }

         for(x = 5; x < w - 5; x += 5) {
            for(y = 5; y < h - 5; y += 5) {
               int rx = Math.min(5, w - 5 - x);
               int ry = Math.min(5, h - 5 - y);
               renderer.drawTexturedRect(x, y, 6, 45, rx, ry);
            }
         }

         super.draw(renderer, size, renderInfo);
      }

      protected GuiBackgroundProcesses.Element getThis() {
         return this;
      }
   }
}
