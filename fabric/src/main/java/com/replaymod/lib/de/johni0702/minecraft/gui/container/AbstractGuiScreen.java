package com.replaymod.lib.de.johni0702.minecraft.gui.container;

import com.replaymod.lib.de.johni0702.minecraft.gui.GuiRenderer;
import com.replaymod.lib.de.johni0702.minecraft.gui.MinecraftGuiRenderer;
import com.replaymod.lib.de.johni0702.minecraft.gui.OffsetGuiRenderer;
import com.replaymod.lib.de.johni0702.minecraft.gui.RenderInfo;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.GuiElement;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.GuiLabel;
import com.replaymod.lib.de.johni0702.minecraft.gui.function.Clickable;
import com.replaymod.lib.de.johni0702.minecraft.gui.function.Closeable;
import com.replaymod.lib.de.johni0702.minecraft.gui.function.Draggable;
import com.replaymod.lib.de.johni0702.minecraft.gui.function.Loadable;
import com.replaymod.lib.de.johni0702.minecraft.gui.function.Scrollable;
import com.replaymod.lib.de.johni0702.minecraft.gui.function.Tickable;
import com.replaymod.lib.de.johni0702.minecraft.gui.function.Typeable;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.MouseUtils;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.Dimension;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.Point;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.ReadableDimension;
import com.replaymod.lib.de.johni0702.minecraft.gui.versions.MCVer;
import java.util.Objects;
import net.minecraft.CrashReport;
import net.minecraft.CrashReportCategory;
import net.minecraft.ReportedException;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;

public abstract class AbstractGuiScreen<T extends AbstractGuiScreen<T>> extends AbstractGuiContainer<T> {
   private final AbstractGuiScreen<T>.MinecraftGuiScreen wrapped = new AbstractGuiScreen.MinecraftGuiScreen();
   private Dimension screenSize;
   private AbstractGuiScreen.Background background;
   private boolean enabledRepeatedKeyEvents;
   private GuiLabel title;
   protected boolean suppressVanillaKeys;

   public AbstractGuiScreen() {
      this.background = AbstractGuiScreen.Background.DEFAULT;
      this.enabledRepeatedKeyEvents = true;
   }

   public Screen toMinecraft() {
      return this.wrapped;
   }

   public void layout(ReadableDimension size, RenderInfo renderInfo) {
      if (size == null) {
         size = this.screenSize;
      }

      if (renderInfo.layer == 0 && this.title != null) {
         this.title.layout(this.title.getMinSize(), renderInfo);
      }

      super.layout((ReadableDimension)size, renderInfo);
      if (renderInfo.layer == this.getMaxLayer()) {
         GuiElement tooltip = (GuiElement)this.forEach(GuiElement.class, (e) -> {
            return e.getTooltip(renderInfo);
         });
         if (tooltip != null) {
            tooltip.layout(tooltip.getMinSize(), renderInfo);
         }
      }

   }

   public void draw(GuiRenderer renderer, ReadableDimension size, RenderInfo renderInfo) {
      if (renderInfo.layer == 0) {
         int x;
         switch(this.background) {
         case NONE:
         default:
            break;
         case DEFAULT:
            this.wrapped.renderBackground(renderer.getContext());
            break;
         case TRANSPARENT:
            int top = -1072689136;
            x = -804253680;
            renderer.drawRect(0, 0, size.getWidth(), size.getHeight(), top, top, x, x);
            break;
         case DIRT:
            this.wrapped.renderDirtBackground(renderer.getContext());
         }

         if (this.title != null) {
            ReadableDimension titleSize = this.title.getMinSize();
            x = this.screenSize.getWidth() / 2 - titleSize.getWidth() / 2;
            OffsetGuiRenderer eRenderer = new OffsetGuiRenderer(renderer, new Point(x, 10), new Dimension(0, 0));
            this.title.draw(eRenderer, titleSize, renderInfo);
         }
      }

      super.draw(renderer, size, renderInfo);
      if (renderInfo.layer == this.getMaxLayer()) {
         GuiElement tooltip = (GuiElement)this.forEach(GuiElement.class, (e) -> {
            return e.getTooltip(renderInfo);
         });
         if (tooltip != null) {
            ReadableDimension tooltipSize = tooltip.getMinSize();
            int x;
            if (renderInfo.mouseX + 8 + tooltipSize.getWidth() < this.screenSize.getWidth()) {
               x = renderInfo.mouseX + 8;
            } else {
               x = this.screenSize.getWidth() - tooltipSize.getWidth() - 1;
            }

            int y;
            if (renderInfo.mouseY + 8 + tooltipSize.getHeight() < this.screenSize.getHeight()) {
               y = renderInfo.mouseY + 8;
            } else {
               y = this.screenSize.getHeight() - tooltipSize.getHeight() - 1;
            }

            Point position = new Point(x, y);

            try {
               OffsetGuiRenderer eRenderer = new OffsetGuiRenderer(renderer, position, tooltipSize);
               tooltip.draw(eRenderer, tooltipSize, renderInfo);
            } catch (Exception var12) {
               CrashReport crashReport = CrashReport.forThrowable(var12, "Rendering Gui Tooltip");
               renderInfo.addTo(crashReport);
               CrashReportCategory category = crashReport.addCategory("Gui container details");
               MCVer.addDetail(category, "Container", this::toString);
               MCVer.addDetail(category, "Width", () -> {
                  return size.getWidth().makeConcatWithConstants<invokedynamic>(size.getWidth());
               });
               MCVer.addDetail(category, "Height", () -> {
                  return size.getHeight().makeConcatWithConstants<invokedynamic>(size.getHeight());
               });
               category = crashReport.addCategory("Tooltip details");
               Objects.requireNonNull(tooltip);
               MCVer.addDetail(category, "Element", tooltip::toString);
               Objects.requireNonNull(position);
               MCVer.addDetail(category, "Position", position::toString);
               Objects.requireNonNull(tooltipSize);
               MCVer.addDetail(category, "Size", tooltipSize::toString);
               throw new ReportedException(crashReport);
            }
         }
      }

   }

   public ReadableDimension getMinSize() {
      return this.screenSize;
   }

   public ReadableDimension getMaxSize() {
      return this.screenSize;
   }

   public void setEnabledRepeatedKeyEvents(boolean enableRepeatKeyEvents) {
      this.enabledRepeatedKeyEvents = enableRepeatKeyEvents;
      if (this.wrapped.active) {
         MCVer.Keyboard.enableRepeatEvents(enableRepeatKeyEvents);
      }

   }

   public void display() {
      this.getMinecraft().setScreen(this.toMinecraft());
   }

   public AbstractGuiScreen.Background getBackground() {
      return this.background;
   }

   public boolean isEnabledRepeatedKeyEvents() {
      return this.enabledRepeatedKeyEvents;
   }

   public GuiLabel getTitle() {
      return this.title;
   }

   public void setBackground(AbstractGuiScreen.Background background) {
      this.background = background;
   }

   public void setTitle(GuiLabel title) {
      this.title = title;
   }

   protected class MinecraftGuiScreen extends Screen {
      private boolean active;

      protected MinecraftGuiScreen() {
         super((Component)null);
      }

      public Component getTitle() {
         GuiLabel title = AbstractGuiScreen.this.title;
         return MCVer.literalText(title == null ? "" : title.getText());
      }

      public void render(GuiGraphics stack, int mouseX, int mouseY, float partialTicks) {
         int layers = AbstractGuiScreen.this.getMaxLayer();
         RenderInfo renderInfo = new RenderInfo(partialTicks, mouseX, mouseY, 0);

         for(int layer = 0; layer <= layers; ++layer) {
            AbstractGuiScreen.this.layout(AbstractGuiScreen.this.screenSize, renderInfo.layer(layer));
         }

         MinecraftGuiRenderer renderer = new MinecraftGuiRenderer(stack);

         for(int layerx = 0; layerx <= layers; ++layerx) {
            AbstractGuiScreen.this.draw(renderer, AbstractGuiScreen.this.screenSize, renderInfo.layer(layerx));
         }

      }

      public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
         Point mouse = MouseUtils.getMousePos();
         boolean ctrlDown = hasControlDown();
         boolean shiftDown = hasShiftDown();
         if (!AbstractGuiScreen.this.invokeHandlers(Typeable.class, (e) -> {
            return e.typeKey(mouse, keyCode, '\u0000', ctrlDown, shiftDown);
         })) {
            return AbstractGuiScreen.this.suppressVanillaKeys ? false : super.keyPressed(keyCode, scanCode, modifiers);
         } else {
            return true;
         }
      }

      public boolean charTyped(char keyChar, int scanCode) {
         Point mouse = MouseUtils.getMousePos();
         boolean ctrlDown = hasControlDown();
         boolean shiftDown = hasShiftDown();
         if (!AbstractGuiScreen.this.invokeHandlers(Typeable.class, (e) -> {
            return e.typeKey(mouse, 0, keyChar, ctrlDown, shiftDown);
         })) {
            return AbstractGuiScreen.this.suppressVanillaKeys ? false : super.charTyped(keyChar, scanCode);
         } else {
            return true;
         }
      }

      public boolean mouseClicked(double mouseXD, double mouseYD, int mouseButton) {
         int mouseX = (int)Math.round(mouseXD);
         int mouseY = (int)Math.round(mouseYD);
         return AbstractGuiScreen.this.invokeHandlers(Clickable.class, (e) -> {
            return e.mouseClick(new Point(mouseX, mouseY), mouseButton);
         });
      }

      public boolean mouseReleased(double mouseXD, double mouseYD, int mouseButton) {
         int mouseX = (int)Math.round(mouseXD);
         int mouseY = (int)Math.round(mouseYD);
         return AbstractGuiScreen.this.invokeHandlers(Draggable.class, (e) -> {
            return e.mouseRelease(new Point(mouseX, mouseY), mouseButton);
         });
      }

      public boolean mouseDragged(double mouseXD, double mouseYD, int mouseButton, double deltaX, double deltaY) {
         int mouseX = (int)Math.round(mouseXD);
         int mouseY = (int)Math.round(mouseYD);
         long timeSinceLastClick = 0L;
         return AbstractGuiScreen.this.invokeHandlers(Draggable.class, (e) -> {
            return e.mouseDrag(new Point(mouseX, mouseY), mouseButton, timeSinceLastClick);
         });
      }

      public void tick() {
         AbstractGuiScreen.this.invokeAll(Tickable.class, Tickable::tick);
      }

      public boolean mouseScrolled(double mouseX, double mouseY, double dWheel) {
         Point mouse = new Point((int)mouseX, (int)mouseY);
         int wheel = (int)(dWheel * 120.0D);
         return AbstractGuiScreen.this.invokeHandlers(Scrollable.class, (e) -> {
            return e.scroll(mouse, wheel);
         });
      }

      public void removed() {
         AbstractGuiScreen.this.invokeAll(Closeable.class, Closeable::close);
         this.active = false;
         if (AbstractGuiScreen.this.enabledRepeatedKeyEvents) {
            MCVer.Keyboard.enableRepeatEvents(false);
         }

      }

      public void init() {
         this.active = false;
         if (AbstractGuiScreen.this.enabledRepeatedKeyEvents) {
            MCVer.Keyboard.enableRepeatEvents(true);
         }

         AbstractGuiScreen.this.screenSize = new Dimension(this.width, this.height);
         AbstractGuiScreen.this.invokeAll(Loadable.class, Loadable::load);
      }

      public T getWrapper() {
         return (AbstractGuiScreen)AbstractGuiScreen.this.getThis();
      }
   }

   public static enum Background {
      NONE,
      DEFAULT,
      TRANSPARENT,
      DIRT;

      // $FF: synthetic method
      private static AbstractGuiScreen.Background[] $values() {
         return new AbstractGuiScreen.Background[]{NONE, DEFAULT, TRANSPARENT, DIRT};
      }
   }
}
