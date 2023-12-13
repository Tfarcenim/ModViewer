package com.replaymod.replaystudio.studio;

import com.replaymod.replaystudio.Studio;
import com.replaymod.replaystudio.filter.StreamFilter;
import com.replaymod.replaystudio.viaversion.ViaVersionPacketConverter;
import java.util.Iterator;
import java.util.ServiceLoader;

public class ReplayStudio implements Studio {
   private final ServiceLoader<StreamFilter> streamFilterServiceLoader = ServiceLoader.load(StreamFilter.class);

   public String getName() {
      return "ReplayStudio";
   }

   public int getVersion() {
      return 1;
   }

   public StreamFilter loadStreamFilter(String name) {
      Iterator var2 = this.streamFilterServiceLoader.iterator();

      StreamFilter filter;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         filter = (StreamFilter)var2.next();
      } while(!filter.getName().equalsIgnoreCase(name));

      try {
         return (StreamFilter)filter.getClass().newInstance();
      } catch (IllegalAccessException | InstantiationException var5) {
         throw new RuntimeException(var5);
      }
   }

   public boolean isCompatible(int fileVersion, int protocolVersion, int currentVersion) {
      return ViaVersionPacketConverter.isFileVersionSupported(fileVersion, protocolVersion, currentVersion);
   }

   public int getCurrentFileFormatVersion() {
      return 14;
   }
}
