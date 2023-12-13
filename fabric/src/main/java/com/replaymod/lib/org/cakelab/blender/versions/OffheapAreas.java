package com.replaymod.lib.org.cakelab.blender.versions;

import com.replaymod.lib.org.cakelab.blender.io.FileHeader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class OffheapAreas {
   private static final List<OffheapAreas.Entry> map = new ArrayList();
   private static final Comparator<OffheapAreas.Entry> COMPARATOR;

   public static String[] get(int versionCode) {
      OffheapAreas.Entry key = new OffheapAreas.Entry(versionCode);
      int index = Collections.binarySearch(map, key, COMPARATOR);
      if (index < 0) {
         index = -index - 2;
      }

      return ((OffheapAreas.Entry)map.get(index)).value;
   }

   static {
      map.add(new OffheapAreas.Entry(0, new String[]{"FileGlobal"}));
      map.add(new OffheapAreas.Entry(276, new String[]{"FileGlobal", "TreeStoreElem"}));
      COMPARATOR = new Comparator<OffheapAreas.Entry>() {
         public int compare(OffheapAreas.Entry o1, OffheapAreas.Entry o2) {
            return o1.key.getCode() - o2.key.getCode();
         }
      };
   }

   static class Entry {
      FileHeader.Version key;
      String[] value;

      public Entry(int versionCode, String[] value) {
         this.key = new FileHeader.Version(versionCode);
         this.value = value;
      }

      public Entry(int versionCode) {
         this(versionCode, (String[])null);
      }
   }
}
