package com.replaymod.lib.com.coremedia.iso.boxes;

import com.replaymod.lib.com.googlecode.mp4parser.AbstractContainerBox;
import java.util.Iterator;
import java.util.List;

public class TrackBox extends AbstractContainerBox {
   public static final String TYPE = "trak";
   private SampleTableBox sampleTableBox;

   public TrackBox() {
      super("trak");
   }

   public TrackHeaderBox getTrackHeaderBox() {
      Iterator var2 = this.getBoxes().iterator();

      while(var2.hasNext()) {
         Box box = (Box)var2.next();
         if (box instanceof TrackHeaderBox) {
            return (TrackHeaderBox)box;
         }
      }

      return null;
   }

   public SampleTableBox getSampleTableBox() {
      if (this.sampleTableBox != null) {
         return this.sampleTableBox;
      } else {
         MediaBox mdia = this.getMediaBox();
         if (mdia != null) {
            MediaInformationBox minf = mdia.getMediaInformationBox();
            if (minf != null) {
               this.sampleTableBox = minf.getSampleTableBox();
               return this.sampleTableBox;
            }
         }

         return null;
      }
   }

   public MediaBox getMediaBox() {
      Iterator var2 = this.getBoxes().iterator();

      while(var2.hasNext()) {
         Box box = (Box)var2.next();
         if (box instanceof MediaBox) {
            return (MediaBox)box;
         }
      }

      return null;
   }

   public void setBoxes(List<Box> boxes) {
      super.setBoxes(boxes);
      this.sampleTableBox = null;
   }
}
