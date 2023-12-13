package com.replaymod.lib.com.coremedia.iso.boxes;

import com.replaymod.lib.com.googlecode.mp4parser.AbstractContainerBox;
import java.util.Iterator;

public class MediaBox extends AbstractContainerBox {
   public static final String TYPE = "mdia";

   public MediaBox() {
      super("mdia");
   }

   public MediaInformationBox getMediaInformationBox() {
      Iterator var2 = this.getBoxes().iterator();

      while(var2.hasNext()) {
         Box box = (Box)var2.next();
         if (box instanceof MediaInformationBox) {
            return (MediaInformationBox)box;
         }
      }

      return null;
   }

   public MediaHeaderBox getMediaHeaderBox() {
      Iterator var2 = this.getBoxes().iterator();

      while(var2.hasNext()) {
         Box box = (Box)var2.next();
         if (box instanceof MediaHeaderBox) {
            return (MediaHeaderBox)box;
         }
      }

      return null;
   }

   public HandlerBox getHandlerBox() {
      Iterator var2 = this.getBoxes().iterator();

      while(var2.hasNext()) {
         Box box = (Box)var2.next();
         if (box instanceof HandlerBox) {
            return (HandlerBox)box;
         }
      }

      return null;
   }
}
