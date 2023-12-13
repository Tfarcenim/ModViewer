package com.replaymod.lib.com.coremedia.iso.boxes;

import com.replaymod.lib.com.googlecode.mp4parser.AbstractFullBox;

public abstract class AbstractMediaHeaderBox extends AbstractFullBox {
   protected AbstractMediaHeaderBox(String type) {
      super(type);
   }
}
