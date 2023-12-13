package com.replaymod.lib.com.coremedia.iso.boxes;

import com.replaymod.lib.com.googlecode.mp4parser.AbstractContainerBox;
import java.util.Iterator;

public class MediaInformationBox extends AbstractContainerBox {
   public static final String TYPE = "minf";

   public MediaInformationBox() {
      super("minf");
   }

   public SampleTableBox getSampleTableBox() {
      Iterator var2 = this.getBoxes().iterator();

      while(var2.hasNext()) {
         Box box = (Box)var2.next();
         if (box instanceof SampleTableBox) {
            return (SampleTableBox)box;
         }
      }

      return null;
   }

   public AbstractMediaHeaderBox getMediaHeaderBox() {
      Iterator var2 = this.getBoxes().iterator();

      while(var2.hasNext()) {
         Box box = (Box)var2.next();
         if (box instanceof AbstractMediaHeaderBox) {
            return (AbstractMediaHeaderBox)box;
         }
      }

      return null;
   }
}
