package com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.Item;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;

public abstract class BaseItemType extends Type<Item> {
   protected BaseItemType() {
      super(Item.class);
   }

   protected BaseItemType(String typeName) {
      super(typeName, Item.class);
   }

   public Class<? extends Type> getBaseClass() {
      return BaseItemType.class;
   }
}
