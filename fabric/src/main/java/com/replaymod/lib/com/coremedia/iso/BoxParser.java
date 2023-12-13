package com.replaymod.lib.com.coremedia.iso;

import com.replaymod.lib.com.coremedia.iso.boxes.Box;
import com.replaymod.lib.com.coremedia.iso.boxes.Container;
import com.replaymod.lib.com.googlecode.mp4parser.DataSource;
import java.io.IOException;

public interface BoxParser {
   Box parseBox(DataSource var1, Container var2) throws IOException;
}
