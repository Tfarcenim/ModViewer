package com.replaymod.lib.de.johni0702.minecraft.gui.container;

import com.google.common.base.Preconditions;
import com.replaymod.lib.de.johni0702.minecraft.gui.GuiRenderer;
import com.replaymod.lib.de.johni0702.minecraft.gui.OffsetGuiRenderer;
import com.replaymod.lib.de.johni0702.minecraft.gui.RenderInfo;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.AbstractComposedGuiElement;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.ComposedGuiElement;
import com.replaymod.lib.de.johni0702.minecraft.gui.element.GuiElement;
import com.replaymod.lib.de.johni0702.minecraft.gui.layout.HorizontalLayout;
import com.replaymod.lib.de.johni0702.minecraft.gui.layout.Layout;
import com.replaymod.lib.de.johni0702.minecraft.gui.layout.LayoutData;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.Point;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.ReadableColor;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.ReadableDimension;
import com.replaymod.lib.de.johni0702.minecraft.gui.utils.lwjgl.ReadablePoint;
import com.replaymod.lib.de.johni0702.minecraft.gui.versions.MCVer;
import com.replaymod.lib.org.apache.commons.lang3.tuple.Pair;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import net.minecraft.CrashReport;
import net.minecraft.CrashReportCategory;
import net.minecraft.ReportedException;

public abstract class AbstractGuiContainer<T extends AbstractGuiContainer<T>> extends AbstractComposedGuiElement<T> implements GuiContainer<T> {
   private static final Layout DEFAULT_LAYOUT = new HorizontalLayout();
   private Map<GuiElement, LayoutData> elements = new LinkedHashMap();
   private Map<GuiElement, Pair<ReadablePoint, ReadableDimension>> layedOutElements;
   private Layout layout;
   private ReadableColor backgroundColor;

   public AbstractGuiContainer() {
      this.layout = DEFAULT_LAYOUT;
   }

   public AbstractGuiContainer(GuiContainer container) {
      super(container);
      this.layout = DEFAULT_LAYOUT;
   }

   public T setLayout(Layout layout) {
      this.layout = layout;
      return (AbstractGuiContainer)this.getThis();
   }

   public Layout getLayout() {
      return this.layout;
   }

   public void convertFor(GuiElement element, Point point) {
      this.convertFor(element, point, element.getLayer());
   }

   public void convertFor(GuiElement element, Point point, int relativeLayer) {
      if (this.layedOutElements == null || !this.layedOutElements.containsKey(element)) {
         this.layout((ReadableDimension)null, new RenderInfo(0.0F, 0, 0, relativeLayer));
      }

      Preconditions.checkState(this.layedOutElements != null, "Cannot convert position unless rendered at least once.");
      Pair<ReadablePoint, ReadableDimension> pair = (Pair)this.layedOutElements.get(element);
      Preconditions.checkState(pair != null, "Element " + element + " not part of " + this);
      ReadablePoint pos = (ReadablePoint)pair.getKey();
      if (this.getContainer() != null) {
         this.getContainer().convertFor(this, point, relativeLayer + this.getLayer());
      }

      point.translate(-pos.getX(), -pos.getY());
   }

   public Collection<GuiElement> getChildren() {
      return Collections.unmodifiableCollection(this.elements.keySet());
   }

   public Map<GuiElement, LayoutData> getElements() {
      return Collections.unmodifiableMap(this.elements);
   }

   public T addElements(LayoutData layoutData, GuiElement... elements) {
      if (layoutData == null) {
         layoutData = LayoutData.NONE;
      }

      GuiElement[] var3 = elements;
      int var4 = elements.length;

      for(int var5 = 0; var5 < var4; ++var5) {
         GuiElement element = var3[var5];
         this.elements.put(element, layoutData);
         element.setContainer(this);
      }

      return (AbstractGuiContainer)this.getThis();
   }

   public T removeElement(GuiElement element) {
      if (this.elements.remove(element) != null) {
         element.setContainer((GuiContainer)null);
         if (this.layedOutElements != null) {
            this.layedOutElements.remove(element);
         }
      }

      return (AbstractGuiContainer)this.getThis();
   }

   public void layout(ReadableDimension size, RenderInfo renderInfo) {
      super.layout(size, renderInfo);
      if (size != null) {
         try {
            this.layedOutElements = this.layout.layOut(this, size);
         } catch (Exception var8) {
            CrashReport crashReport = CrashReport.forThrowable(var8, "Gui Layout");
            renderInfo.addTo(crashReport);
            CrashReportCategory category = crashReport.addCategory("Gui container details");
            MCVer.addDetail(category, "Container", this::toString);
            Layout var10002 = this.layout;
            Objects.requireNonNull(var10002);
            MCVer.addDetail(category, "Layout", var10002::toString);
            throw new ReportedException(crashReport);
         }

         Iterator var3 = this.layedOutElements.entrySet().iterator();

         while(true) {
            Entry e;
            GuiElement element;
            while(true) {
               if (!var3.hasNext()) {
                  return;
               }

               e = (Entry)var3.next();
               element = (GuiElement)e.getKey();
               if (element instanceof ComposedGuiElement) {
                  if (((ComposedGuiElement)element).getMaxLayer() < renderInfo.layer) {
                     continue;
                  }
               } else if (element.getLayer() != renderInfo.layer) {
                  continue;
               }
               break;
            }

            ReadablePoint ePosition = (ReadablePoint)((Pair)e.getValue()).getLeft();
            ReadableDimension eSize = (ReadableDimension)((Pair)e.getValue()).getRight();
            element.layout(eSize, renderInfo.offsetMouse(ePosition.getX(), ePosition.getY()).layer(renderInfo.getLayer() - element.getLayer()));
         }
      }
   }

   public void draw(GuiRenderer renderer, ReadableDimension size, RenderInfo renderInfo) {
      super.draw(renderer, size, renderInfo);
      if (this.backgroundColor != null && renderInfo.getLayer() == 0) {
         renderer.drawRect(0, 0, size.getWidth(), size.getHeight(), this.backgroundColor);
      }

      Iterator var4 = this.layedOutElements.entrySet().iterator();

      while(true) {
         Entry e;
         boolean strict;
         while(true) {
            if (!var4.hasNext()) {
               return;
            }

            e = (Entry)var4.next();
            GuiElement element = (GuiElement)e.getKey();
            if (element instanceof ComposedGuiElement) {
               if (((ComposedGuiElement)element).getMaxLayer() >= renderInfo.layer) {
                  strict = renderInfo.layer == 0;
                  break;
               }
            } else if (element.getLayer() == renderInfo.layer) {
               strict = true;
               break;
            }
         }

         ReadablePoint ePosition = (ReadablePoint)((Pair)e.getValue()).getLeft();
         ReadableDimension eSize = (ReadableDimension)((Pair)e.getValue()).getRight();

         try {
            OffsetGuiRenderer eRenderer = new OffsetGuiRenderer(renderer, ePosition, eSize, strict);
            eRenderer.startUsing();
            ((GuiElement)e.getKey()).draw(eRenderer, eSize, renderInfo.offsetMouse(ePosition.getX(), ePosition.getY()).layer(renderInfo.getLayer() - ((GuiElement)e.getKey()).getLayer()));
            eRenderer.stopUsing();
         } catch (Exception var13) {
            CrashReport crashReport = CrashReport.forThrowable(var13, "Rendering Gui");
            renderInfo.addTo(crashReport);
            CrashReportCategory category = crashReport.addCategory("Gui container details");
            MCVer.addDetail(category, "Container", this::toString);
            MCVer.addDetail(category, "Width", () -> {
               return size.getWidth().makeConcatWithConstants<invokedynamic>(size.getWidth());
            });
            MCVer.addDetail(category, "Height", () -> {
               return size.getHeight().makeConcatWithConstants<invokedynamic>(size.getHeight());
            });
            Layout var10002 = this.layout;
            Objects.requireNonNull(var10002);
            MCVer.addDetail(category, "Layout", var10002::toString);
            category = crashReport.addCategory("Gui element details");
            MCVer.addDetail(category, "Element", () -> {
               return ((GuiElement)e.getKey()).toString();
            });
            Objects.requireNonNull(ePosition);
            MCVer.addDetail(category, "Position", ePosition::toString);
            Objects.requireNonNull(eSize);
            MCVer.addDetail(category, "Size", eSize::toString);
            if (e.getKey() instanceof GuiContainer) {
               MCVer.addDetail(category, "Layout", () -> {
                  return ((GuiContainer)e.getKey()).getLayout().toString();
               });
            }

            throw new ReportedException(crashReport);
         }
      }
   }

   public ReadableDimension calcMinSize() {
      return this.layout.calcMinSize(this);
   }

   public T sortElements() {
      this.sortElements(new Comparator<GuiElement>() {
         public int compare(GuiElement o1, GuiElement o2) {
            return o1 instanceof Comparable && o2 instanceof Comparable ? ((Comparable)o1).compareTo(o2) : o1.hashCode() - o2.hashCode();
         }
      });
      return (AbstractGuiContainer)this.getThis();
   }

   public T sortElements(Comparator<GuiElement> comparator) {
      this.elements = (Map)this.elements.entrySet().stream().sorted(Entry.comparingByKey(comparator)).collect(Collectors.toMap(Entry::getKey, Entry::getValue, (x, y) -> {
         return y;
      }, LinkedHashMap::new));
      return (AbstractGuiContainer)this.getThis();
   }

   public ReadableColor getBackgroundColor() {
      return this.backgroundColor;
   }

   public T setBackgroundColor(ReadableColor backgroundColor) {
      this.backgroundColor = backgroundColor;
      return (AbstractGuiContainer)this.getThis();
   }
}
