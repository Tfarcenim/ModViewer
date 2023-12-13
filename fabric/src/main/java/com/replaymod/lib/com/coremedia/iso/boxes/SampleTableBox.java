package com.replaymod.lib.com.coremedia.iso.boxes;

import com.replaymod.lib.com.googlecode.mp4parser.AbstractContainerBox;
import java.util.Iterator;

public class SampleTableBox extends AbstractContainerBox {
   public static final String TYPE = "stbl";
   private SampleToChunkBox sampleToChunkBox;

   public SampleTableBox() {
      super("stbl");
   }

   public SampleDescriptionBox getSampleDescriptionBox() {
      Iterator var2 = this.getBoxes().iterator();

      while(var2.hasNext()) {
         Box box = (Box)var2.next();
         if (box instanceof SampleDescriptionBox) {
            return (SampleDescriptionBox)box;
         }
      }

      return null;
   }

   public SampleSizeBox getSampleSizeBox() {
      Iterator var2 = this.getBoxes().iterator();

      while(var2.hasNext()) {
         Box box = (Box)var2.next();
         if (box instanceof SampleSizeBox) {
            return (SampleSizeBox)box;
         }
      }

      return null;
   }

   public SampleToChunkBox getSampleToChunkBox() {
      if (this.sampleToChunkBox != null) {
         return this.sampleToChunkBox;
      } else {
         Iterator var2 = this.getBoxes().iterator();

         while(var2.hasNext()) {
            Box box = (Box)var2.next();
            if (box instanceof SampleToChunkBox) {
               this.sampleToChunkBox = (SampleToChunkBox)box;
               return this.sampleToChunkBox;
            }
         }

         return null;
      }
   }

   public ChunkOffsetBox getChunkOffsetBox() {
      Iterator var2 = this.getBoxes().iterator();

      while(var2.hasNext()) {
         Box box = (Box)var2.next();
         if (box instanceof ChunkOffsetBox) {
            return (ChunkOffsetBox)box;
         }
      }

      return null;
   }

   public TimeToSampleBox getTimeToSampleBox() {
      Iterator var2 = this.getBoxes().iterator();

      while(var2.hasNext()) {
         Box box = (Box)var2.next();
         if (box instanceof TimeToSampleBox) {
            return (TimeToSampleBox)box;
         }
      }

      return null;
   }

   public SyncSampleBox getSyncSampleBox() {
      Iterator var2 = this.getBoxes().iterator();

      while(var2.hasNext()) {
         Box box = (Box)var2.next();
         if (box instanceof SyncSampleBox) {
            return (SyncSampleBox)box;
         }
      }

      return null;
   }

   public CompositionTimeToSample getCompositionTimeToSample() {
      Iterator var2 = this.getBoxes().iterator();

      while(var2.hasNext()) {
         Box box = (Box)var2.next();
         if (box instanceof CompositionTimeToSample) {
            return (CompositionTimeToSample)box;
         }
      }

      return null;
   }

   public SampleDependencyTypeBox getSampleDependencyTypeBox() {
      Iterator var2 = this.getBoxes().iterator();

      while(var2.hasNext()) {
         Box box = (Box)var2.next();
         if (box instanceof SampleDependencyTypeBox) {
            return (SampleDependencyTypeBox)box;
         }
      }

      return null;
   }
}
