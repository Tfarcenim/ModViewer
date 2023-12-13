package com.replaymod.lib.de.johni0702.minecraft.gui.element.advanced;

import com.replaymod.lib.de.johni0702.minecraft.gui.GuiRenderer;
import com.replaymod.lib.de.johni0702.minecraft.gui.RenderInfo;
import com.replaymod.lib.de.johni0702.minecraft.gui.container.GuiContainer;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.AbstractGuiElement;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.GuiTooltip;
import com.replaymod.lib.de.johni0702.minecraft.gui.function.Clickable;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.Colors;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.Utils;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.Dimension;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.Point;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.ReadableColor;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.ReadableDimension;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.ReadablePoint;

public abstract class AbstractGuiTimeline<T extends AbstractGuiTimeline<T>> extends AbstractGuiElement<T> implements IGuiTimeline<T>, Clickable {
   protected static final int TEXTURE_WIDTH = 64;
   protected static final int TEXTURE_HEIGHT = 22;
   protected static final int TEXTURE_X = 0;
   protected static final int TEXTURE_Y = 16;
   protected static final int BORDER_LEFT = 4;
   protected static final int BORDER_RIGHT = 4;
   protected static final int BORDER_TOP = 4;
   protected static final int BORDER_BOTTOM = 3;
   protected static final int MARKER_MIN_DISTANCE = 40;
   private IGuiTimeline.OnClick onClick;
   private int length;
   private int cursorPosition;
   private double zoom = 1.0D;
   private int offset;
   private boolean drawCursor = true;
   private boolean drawMarkers;
   /** @deprecated */
   @Deprecated
   protected ReadableDimension size;

   public AbstractGuiTimeline() {
      this.setTooltip((new GuiTooltip() {
         public void draw(GuiRenderer renderer, ReadableDimension size, RenderInfo renderInfo) {
            this.setText(AbstractGuiTimeline.this.getTooltipText(renderInfo));
            super.draw(renderer, size, renderInfo);
         }
      }).setText("00:00"));
   }

   public AbstractGuiTimeline(GuiContainer container) {
      super(container);
      this.setTooltip((new GuiTooltip() {
         public void draw(GuiRenderer renderer, ReadableDimension size, RenderInfo renderInfo) {
            this.setText(AbstractGuiTimeline.this.getTooltipText(renderInfo));
            super.draw(renderer, size, renderInfo);
         }
      }).setText("00:00"));
   }

   protected String getTooltipText(RenderInfo renderInfo) {
      int ms = this.getTimeAt(renderInfo.mouseX, renderInfo.mouseY);
      int s = ms / 1000 % 60;
      int m = ms / 1000 / 60;
      return String.format("%02d:%02d", m, s);
   }

   public void draw(GuiRenderer renderer, ReadableDimension size, RenderInfo renderInfo) {
      this.size = size;
      super.draw(renderer, size, renderInfo);
      int width = size.getWidth();
      int height = size.getHeight();
      renderer.bindTexture(TEXTURE);
      Utils.drawDynamicRect(renderer, width, height, 0, 16, 64, 22, 5, 3, 5, 4);
      if (this.drawMarkers) {
         this.drawMarkers(renderer, size);
      }

      this.drawTimelineCursor(renderer, size);
   }

   protected void drawTimelineCursor(GuiRenderer renderer, ReadableDimension size) {
      if (this.drawCursor) {
         int height = size.getHeight();
         renderer.bindTexture(TEXTURE);
         int visibleLength = (int)((double)this.length * this.zoom);
         int cursor = Utils.clamp(this.cursorPosition, this.offset, this.offset + visibleLength);
         double positionInVisible = (double)(cursor - this.offset);
         double fractionOfVisible = positionInVisible / (double)visibleLength;
         int cursorX = (int)(4.0D + fractionOfVisible * (double)(size.getWidth() - 4 - 4));
         renderer.drawTexturedRect(cursorX - 2, 3, 64, 0, 5, 4);

         for(int y = 3; y < height - 3; y += 11) {
            int segmentHeight = Math.min(11, height - 3 - y);
            renderer.drawTexturedRect(cursorX - 2, y, 64, 4, 5, segmentHeight);
         }

      }
   }

   protected void drawMarkers(GuiRenderer renderer, ReadableDimension size) {
      int visibleLength = (int)((double)this.length * this.zoom);
      int markerInterval = this.getMarkerInterval();
      int smallInterval = Math.max(markerInterval / 5, 1);

      for(int time = this.offset / markerInterval * markerInterval; time <= this.offset + visibleLength; time += smallInterval) {
         if (time >= this.offset) {
            this.drawMarker(renderer, size, time, time % markerInterval == 0);
         }
      }

   }

   protected void drawMarker(GuiRenderer renderer, ReadableDimension size, int time, boolean big) {
      int visibleLength = (int)((double)this.length * this.zoom);
      double positionInVisible = (double)(time - this.offset);
      double fractionOfVisible = positionInVisible / (double)visibleLength;
      int positionX = (int)(4.0D + fractionOfVisible * (double)(size.getWidth() - 4 - 4));
      int height = size.getHeight() / (big ? 3 : 6);
      ReadableColor color = big ? Colors.LIGHT_GRAY : Colors.WHITE;
      renderer.drawRect(positionX, size.getHeight() - 3 - height, 1, height, color);
   }

   protected int getTimeAt(int mouseX, int mouseY) {
      if (this.getLastSize() == null) {
         return -1;
      } else {
         Point mouse = new Point(mouseX, mouseY);
         this.getContainer().convertFor(this, mouse);
         mouseX = mouse.getX();
         mouseY = mouse.getY();
         if (mouseX >= 0 && mouseY >= 0 && mouseX <= this.size.getWidth() && mouseY <= this.size.getHeight()) {
            int width = this.size.getWidth();
            int bodyWidth = width - 4 - 4;
            double segmentLength = (double)this.length * this.zoom;
            double segmentTime = segmentLength * (double)(mouseX - 4) / (double)bodyWidth;
            return Math.min(Math.max((int)Math.round((double)this.offset + segmentTime), 0), this.length);
         } else {
            return -1;
         }
      }
   }

   public void onClick(int time) {
      if (this.onClick != null) {
         this.onClick.run(time);
      }

   }

   public ReadableDimension calcMinSize() {
      return new Dimension(0, 0);
   }

   public T setLength(int length) {
      this.length = length;
      return (AbstractGuiTimeline)this.getThis();
   }

   public int getLength() {
      return this.length;
   }

   public T setCursorPosition(int position) {
      this.cursorPosition = Math.min(Math.max(position, 0), this.length);
      return (AbstractGuiTimeline)this.getThis();
   }

   public int getCursorPosition() {
      return this.cursorPosition;
   }

   public T ensureCursorVisible() {
      return this.ensureCursorVisible(0);
   }

   public T ensureCursorVisibleWithPadding() {
      return this.ensureCursorVisible(Math.max((int)((double)this.length * this.zoom) / 10, 10));
   }

   public T ensureCursorVisible(int padding) {
      int visibleLength = (int)((double)this.length * this.zoom);
      if (this.cursorPosition - padding < this.offset) {
         this.setOffset(this.cursorPosition - padding);
      } else if (this.cursorPosition + padding > this.offset + visibleLength) {
         this.setOffset(this.cursorPosition + padding - visibleLength);
      }

      return (AbstractGuiTimeline)this.getThis();
   }

   public T setZoom(double zoom) {
      this.zoom = Math.min(zoom, 1.0D);
      this.checkOffset();
      return (AbstractGuiTimeline)this.getThis();
   }

   public double getZoom() {
      return this.zoom;
   }

   public T setOffset(int offset) {
      this.offset = Math.max(offset, 0);
      this.checkOffset();
      return (AbstractGuiTimeline)this.getThis();
   }

   public int getOffset() {
      return this.offset;
   }

   public T onClick(IGuiTimeline.OnClick onClick) {
      this.onClick = onClick;
      return (AbstractGuiTimeline)this.getThis();
   }

   public boolean mouseClick(ReadablePoint position, int button) {
      int time = this.getTimeAt(position.getX(), position.getY());
      if (time != -1) {
         this.onClick(time);
         return true;
      } else {
         return false;
      }
   }

   public boolean getMarkers() {
      return this.drawMarkers;
   }

   public T setMarkers(boolean active) {
      this.drawMarkers = active;
      return (AbstractGuiTimeline)this.getThis();
   }

   public T setMarkers() {
      return this.setMarkers(true);
   }

   public int getMarkerInterval() {
      if (this.size == null) {
         return this.length;
      } else {
         int width = this.size.getWidth() - 4 - 4;
         double segmentLength = (double)this.length * this.zoom;
         int markerMinDistance = (int)(40.0D * (this.length > 3600000 ? 1.2D : 1.0D));
         int maxMarkers = width / markerMinDistance;
         int minInterval = (int)(segmentLength / (double)maxMarkers);
         int S = true;
         int M = '\uea60';
         int H = 3600000;
         int[] snapTo = new int[]{1000, 2000, 5000, 10000, 15000, 20000, 30000, 60000, 120000, 300000, 600000, 900000, 1800000, 3600000, 7200000, 18000000, 36000000};
         int[] var11 = snapTo;
         int var12 = snapTo.length;

         for(int var13 = 0; var13 < var12; ++var13) {
            int snap = var11[var13];
            if (snap > minInterval) {
               return snap;
            }
         }

         return snapTo[snapTo.length - 1];
      }
   }

   public T setCursor(boolean active) {
      this.drawCursor = active;
      return (AbstractGuiTimeline)this.getThis();
   }

   public boolean getCursor() {
      return this.drawCursor;
   }

   private void checkOffset() {
      int visibleLength = (int)((double)this.length * this.zoom);
      if (visibleLength + this.offset > this.length) {
         this.offset = this.length - visibleLength;
      }

   }

   protected ReadableDimension getLastSize() {
      return super.getLastSize();
   }
}
