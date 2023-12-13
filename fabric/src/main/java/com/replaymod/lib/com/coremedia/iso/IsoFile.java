package com.replaymod.lib.com.coremedia.iso;

import com.replaymod.lib.com.coremedia.iso.boxes.Box;
import com.replaymod.lib.com.coremedia.iso.boxes.MovieBox;
import com.replaymod.lib.com.googlecode.mp4parser.BasicContainer;
import com.replaymod.lib.com.googlecode.mp4parser.DataSource;
import com.replaymod.lib.com.googlecode.mp4parser.FileDataSourceImpl;
import com.replaymod.lib.com.googlecode.mp4parser.annotations.DoNotParseDetail;
import com.replaymod.lib.com.googlecode.mp4parser.util.Logger;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.channels.WritableByteChannel;
import java.util.Iterator;

@DoNotParseDetail
public class IsoFile extends BasicContainer implements Closeable {
   private static Logger LOG = Logger.getLogger(IsoFile.class);

   public IsoFile(String filename) throws IOException {
      this((DataSource)(new FileDataSourceImpl(new File(filename))));
   }

   public IsoFile(DataSource dataSource) throws IOException {
      this(dataSource, new PropertyBoxParserImpl(new String[0]));
   }

   public IsoFile(DataSource dataSource, BoxParser boxParser) throws IOException {
      this.initContainer(dataSource, dataSource.size(), boxParser);
   }

   public static byte[] fourCCtoBytes(String fourCC) {
      byte[] result = new byte[4];
      if (fourCC != null) {
         for(int i = 0; i < Math.min(4, fourCC.length()); ++i) {
            result[i] = (byte)fourCC.charAt(i);
         }
      }

      return result;
   }

   public static String bytesToFourCC(byte[] type) {
      byte[] result = new byte[4];
      if (type != null) {
         System.arraycopy(type, 0, result, 0, Math.min(type.length, 4));
      }

      try {
         return new String(result, "ISO-8859-1");
      } catch (UnsupportedEncodingException var3) {
         throw new Error("Required character encoding is missing", var3);
      }
   }

   public long getSize() {
      return this.getContainerSize();
   }

   public MovieBox getMovieBox() {
      Iterator var2 = this.getBoxes().iterator();

      while(var2.hasNext()) {
         Box box = (Box)var2.next();
         if (box instanceof MovieBox) {
            return (MovieBox)box;
         }
      }

      return null;
   }

   public void getBox(WritableByteChannel os) throws IOException {
      this.writeContainer(os);
   }

   public void close() throws IOException {
      this.dataSource.close();
   }

   public String toString() {
      return "model(" + this.dataSource.toString() + ")";
   }
}
