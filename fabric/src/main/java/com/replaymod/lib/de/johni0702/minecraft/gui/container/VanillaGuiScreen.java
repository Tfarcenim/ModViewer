package com.replaymod.lib.de.johni0702.minecraft.gui.container;

import com.replaymod.lib.de.johni0702.minecraft.gui.function.Draggable;
import com.replaymod.lib.de.johni0702.minecraft.gui.function.Scrollable;
import com.replaymod.lib.de.johni0702.minecraft.gui.function.Tickable;
import com.replaymod.lib.de.johni0702.minecraft.gui.function.Typeable;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.EventRegistrations;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.MouseUtils;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.Point;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.ReadablePoint;
import com.replaymod.lib.de.johni0702.minecraft.gui.versions.MCVer;
import com.replaymod.lib.de.johni0702.minecraft.gui.versions.callbacks.InitScreenCallback;
import com.replaymod.lib.de.johni0702.minecraft.gui.versions.callbacks.KeyboardCallback;
import com.replaymod.lib.de.johni0702.minecraft.gui.versions.callbacks.MouseCallback;
import com.replaymod.lib.de.johni0702.minecraft.gui.versions.callbacks.OpenGuiScreenCallback;
import com.replaymod.lib.de.johni0702.minecraft.gui.versions.callbacks.PostRenderScreenCallback;
import com.replaymod.lib.de.johni0702.minecraft.gui.versions.callbacks.PreTickCallback;
import java.util.Collections;
import java.util.Map;
import java.util.WeakHashMap;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;

public class VanillaGuiScreen extends GuiScreen implements Draggable, Typeable, Scrollable, Tickable {
   private static final Map<Screen, VanillaGuiScreen> WRAPPERS = Collections.synchronizedMap(new WeakHashMap());
   private final Screen mcScreen;
   private final VanillaGuiScreen.EventHandler eventHandler = new VanillaGuiScreen.EventHandler();

   public static VanillaGuiScreen wrap(Screen originalGuiScreen) {
      VanillaGuiScreen gui = (VanillaGuiScreen)WRAPPERS.get(originalGuiScreen);
      if (gui == null) {
         WRAPPERS.put(originalGuiScreen, gui = new VanillaGuiScreen(originalGuiScreen));
         gui.register();
      }

      return gui;
   }

   /** @deprecated */
   @Deprecated
   public static VanillaGuiScreen setup(Screen originalGuiScreen) {
      VanillaGuiScreen gui = new VanillaGuiScreen(originalGuiScreen);
      gui.register();
      return gui;
   }

   public VanillaGuiScreen(Screen mcScreen) {
      this.mcScreen = mcScreen;
      this.suppressVanillaKeys = true;
      super.setBackground(AbstractGuiScreen.Background.NONE);
   }

   public void register() {
      if (!this.eventHandler.active) {
         this.eventHandler.active = true;
         this.eventHandler.register();
         this.getSuperMcGui().init(MCVer.getMinecraft(), this.mcScreen.width, this.mcScreen.height);
      }

   }

   public void display() {
      this.getMinecraft().setScreen(this.mcScreen);
      this.register();
   }

   public Screen toMinecraft() {
      return this.mcScreen;
   }

   public void setBackground(AbstractGuiScreen.Background background) {
      throw new UnsupportedOperationException("Cannot set background of vanilla gui screen.");
   }

   private Screen getSuperMcGui() {
      return super.toMinecraft();
   }

   public boolean mouseClick(ReadablePoint position, int button) {
      return false;
   }

   public boolean mouseDrag(ReadablePoint position, int button, long timeSinceLastCall) {
      return false;
   }

   public boolean mouseRelease(ReadablePoint position, int button) {
      return false;
   }

   public boolean scroll(ReadablePoint mousePosition, int dWheel) {
      return false;
   }

   public boolean typeKey(ReadablePoint mousePosition, int keyCode, char keyChar, boolean ctrlDown, boolean shiftDown) {
      return false;
   }

   public void tick() {
      if (this.getSuperMcGui() == this.getMinecraft().screen) {
         this.getMinecraft().setScreen((Screen)null);
      }

   }

   private class EventHandler extends EventRegistrations implements KeyboardCallback, MouseCallback {
      private boolean active;

      private EventHandler() {
         this.on(OpenGuiScreenCallback.EVENT, (screen) -> {
            this.onGuiClosed();
         });
         this.on(InitScreenCallback.Pre.EVENT, this::preGuiInit);
         this.on(PostRenderScreenCallback.EVENT, this::onGuiRender);
         this.on(PreTickCallback.EVENT, this::tickOverlay);
         this.on(MouseCallback.EVENT, this);
         this.on(KeyboardCallback.EVENT, this);
      }

      private void onGuiClosed() {
         this.unregister();
         if (this.active) {
            this.active = false;
            VanillaGuiScreen.this.getSuperMcGui().removed();
            VanillaGuiScreen.WRAPPERS.remove(VanillaGuiScreen.this.mcScreen, VanillaGuiScreen.this);
         }

      }

      private void preGuiInit(Screen screen) {
         if (screen == VanillaGuiScreen.this.mcScreen && this.active) {
            this.active = false;
            this.unregister();
            VanillaGuiScreen.this.getSuperMcGui().removed();
            VanillaGuiScreen.WRAPPERS.remove(VanillaGuiScreen.this.mcScreen, VanillaGuiScreen.this);
         }

      }

      private void onGuiRender(GuiGraphics stack, float partialTicks) {
         stack.flush();
         Point mousePos = MouseUtils.getMousePos();
         VanillaGuiScreen.this.getSuperMcGui().render(stack, mousePos.getX(), mousePos.getY(), partialTicks);
      }

      private void tickOverlay() {
         VanillaGuiScreen.this.getSuperMcGui().tick();
      }

      public boolean mouseDown(double x, double y, int button) {
         return VanillaGuiScreen.this.getSuperMcGui().mouseClicked(x, y, button);
      }

      public boolean mouseDrag(double x, double y, int button, double dx, double dy) {
         return VanillaGuiScreen.this.getSuperMcGui().mouseDragged(x, y, button, dx, dy);
      }

      public boolean mouseUp(double x, double y, int button) {
         return VanillaGuiScreen.this.getSuperMcGui().mouseReleased(x, y, button);
      }

      public boolean mouseScroll(double x, double y, double scroll) {
         return VanillaGuiScreen.this.getSuperMcGui().mouseScrolled(x, y, scroll);
      }

      public boolean keyPressed(int keyCode, int scanCode, int modifiers) {
         return VanillaGuiScreen.this.getSuperMcGui().keyPressed(keyCode, scanCode, modifiers);
      }

      public boolean keyReleased(int keyCode, int scanCode, int modifiers) {
         return VanillaGuiScreen.this.getSuperMcGui().keyReleased(keyCode, scanCode, modifiers);
      }

      public boolean charTyped(char keyChar, int scanCode) {
         return VanillaGuiScreen.this.getSuperMcGui().charTyped(keyChar, scanCode);
      }
   }
}
