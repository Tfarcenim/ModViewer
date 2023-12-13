package com.replaymod.lib.com.coremedia.iso.boxes;

import com.replaymod.lib.com.googlecode.mp4parser.AbstractContainerBox;
import java.util.Iterator;
import java.util.List;

public class MovieBox extends AbstractContainerBox {
   public static final String TYPE = "moov";

   public MovieBox() {
      super("moov");
   }

   public int getTrackCount() {
      return this.getBoxes(TrackBox.class).size();
   }

   public long[] getTrackNumbers() {
      List<TrackBox> trackBoxes = this.getBoxes(TrackBox.class);
      long[] trackNumbers = new long[trackBoxes.size()];

      for(int trackCounter = 0; trackCounter < trackBoxes.size(); ++trackCounter) {
         trackNumbers[trackCounter] = ((TrackBox)trackBoxes.get(trackCounter)).getTrackHeaderBox().getTrackId();
      }

      return trackNumbers;
   }

   public MovieHeaderBox getMovieHeaderBox() {
      Iterator var2 = this.getBoxes().iterator();

      while(var2.hasNext()) {
         Box box = (Box)var2.next();
         if (box instanceof MovieHeaderBox) {
            return (MovieHeaderBox)box;
         }
      }

      return null;
   }
}
