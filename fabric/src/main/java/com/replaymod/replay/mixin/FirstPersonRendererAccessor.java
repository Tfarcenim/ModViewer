package com.replaymod.replay.mixin;

import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin({ItemInHandRenderer.class})
public interface FirstPersonRendererAccessor {
   @Accessor("mainHand")
   void setItemStackMainHand(ItemStack var1);

   @Accessor("offHand")
   void setItemStackOffHand(ItemStack var1);

   @Accessor("equipProgressMainHand")
   void setEquippedProgressMainHand(float var1);

   @Accessor("prevEquipProgressMainHand")
   void setPrevEquippedProgressMainHand(float var1);

   @Accessor("equipProgressOffHand")
   void setEquippedProgressOffHand(float var1);

   @Accessor("prevEquipProgressOffHand")
   void setPrevEquippedProgressOffHand(float var1);
}
