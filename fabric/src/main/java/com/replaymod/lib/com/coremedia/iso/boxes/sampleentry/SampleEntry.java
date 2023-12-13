package com.replaymod.lib.com.coremedia.iso.boxes.sampleentry;

import com.replaymod.lib.com.coremedia.iso.boxes.Box;
import com.replaymod.lib.com.coremedia.iso.boxes.Container;

public interface SampleEntry extends Box, Container {
   int getDataReferenceIndex();

   void setDataReferenceIndex(int var1);
}
