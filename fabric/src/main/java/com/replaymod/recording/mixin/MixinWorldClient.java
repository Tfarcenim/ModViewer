package com.replaymod.recording.mixin;

import com.replaymod.recording.handler.RecordingEventHandler;
import java.util.function.Supplier;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.WritableLevelData;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin({ClientLevel.class})
public abstract class MixinWorldClient extends Level implements RecordingEventHandler.RecordingEventSender {
   @Shadow
   private Minecraft field_3729;

   protected MixinWorldClient() {
      super((WritableLevelData)null, (ResourceKey)null, (RegistryAccess)null, (Holder)null, (Supplier)null, false, false, 0L, 0);
   }

   private RecordingEventHandler replayModRecording_getRecordingEventHandler() {
      return ((RecordingEventHandler.RecordingEventSender)this.field_3729.levelRenderer).getRecordingEventHandler();
   }

   @Inject(
      method = {"playSound(Lnet/minecraft/entity/player/PlayerEntity;DDDLnet/minecraft/registry/entry/RegistryEntry;Lnet/minecraft/sound/SoundCategory;FFJ)V"},
      at = {@At("HEAD")}
   )
   public void replayModRecording_recordClientSound(Player player, double x, double y, double z, Holder<SoundEvent> sound, SoundSource category, float volume, float pitch, long seed, CallbackInfo ci) {
      if (player == this.field_3729.player) {
         RecordingEventHandler handler = this.replayModRecording_getRecordingEventHandler();
         if (handler != null) {
            handler.onPacket(new ClientboundSoundPacket(sound, category, x, y, z, volume, pitch, seed));
         }
      }

   }

   @Inject(
      method = {"syncWorldEvent"},
      at = {@At("HEAD")}
   )
   private void playLevelEvent(Player player, int type, BlockPos pos, int data, CallbackInfo ci) {
      if (player == this.field_3729.player) {
         RecordingEventHandler handler = this.replayModRecording_getRecordingEventHandler();
         if (handler != null) {
            handler.onClientEffect(type, pos, data);
         }
      }

   }
}
