package com.replaymod.replaystudio.viaversion;

import com.replaymod.replaystudio.lib.viaversion.api.configuration.ViaVersionConfig;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.WorldIdentifiers;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.BlockedProtocolVersions;
import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.ints.IntSet;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonElement;
import com.replaymod.replaystudio.lib.viaversion.protocol.BlockedProtocolVersionsImpl;

public class CustomViaConfig implements ViaVersionConfig {
   public boolean isCheckForUpdates() {
      return false;
   }

   public void setCheckForUpdates(boolean b) {
   }

   public boolean isPreventCollision() {
      return false;
   }

   public boolean isNewEffectIndicator() {
      return false;
   }

   public boolean isShowNewDeathMessages() {
      return false;
   }

   public boolean isSuppressMetadataErrors() {
      return true;
   }

   public boolean isShieldBlocking() {
      return false;
   }

   public boolean isNoDelayShieldBlocking() {
      return false;
   }

   public boolean isShowShieldWhenSwordInHand() {
      return false;
   }

   public boolean isHologramPatch() {
      return true;
   }

   public boolean isPistonAnimationPatch() {
      return false;
   }

   public boolean isBossbarPatch() {
      return true;
   }

   public boolean isBossbarAntiflicker() {
      return false;
   }

   public double getHologramYOffset() {
      return -0.96D;
   }

   public boolean isAutoTeam() {
      return false;
   }

   public int getMaxPPS() {
      return -1;
   }

   public String getMaxPPSKickMessage() {
      return null;
   }

   public int getTrackingPeriod() {
      return -1;
   }

   public int getWarningPPS() {
      return -1;
   }

   public int getMaxWarnings() {
      return -1;
   }

   public String getMaxWarningsKickMessage() {
      return null;
   }

   public boolean isSendSupportedVersions() {
      return false;
   }

   public boolean isSimulatePlayerTick() {
      return false;
   }

   public boolean isItemCache() {
      return false;
   }

   public boolean isNMSPlayerTicking() {
      return false;
   }

   public boolean isReplacePistons() {
      return false;
   }

   public int getPistonReplacementId() {
      return -1;
   }

   public boolean isChunkBorderFix() {
      return true;
   }

   public boolean isForceJsonTransform() {
      return false;
   }

   public boolean is1_12NBTArrayFix() {
      return true;
   }

   public boolean is1_13TeamColourFix() {
      return true;
   }

   public boolean shouldRegisterUserConnectionOnJoin() {
      return false;
   }

   public boolean is1_12QuickMoveActionFix() {
      return false;
   }

   public BlockedProtocolVersions blockedProtocolVersions() {
      return new BlockedProtocolVersionsImpl(IntSet.of(), 0, 0);
   }

   public String getBlockedDisconnectMsg() {
      return null;
   }

   public String getReloadDisconnectMsg() {
      return null;
   }

   public boolean isSuppressConversionWarnings() {
      return false;
   }

   public boolean isDisable1_13AutoComplete() {
      return false;
   }

   public boolean isMinimizeCooldown() {
      return true;
   }

   public boolean isServersideBlockConnections() {
      return true;
   }

   public String getBlockConnectionMethod() {
      return "packet";
   }

   public boolean isReduceBlockStorageMemory() {
      return false;
   }

   public boolean isStemWhenBlockAbove() {
      return true;
   }

   public boolean isVineClimbFix() {
      return false;
   }

   public boolean isSnowCollisionFix() {
      return false;
   }

   public boolean isInfestedBlocksFix() {
      return false;
   }

   public int get1_13TabCompleteDelay() {
      return 0;
   }

   public boolean isTruncate1_14Books() {
      return false;
   }

   public boolean isLeftHandedHandling() {
      return true;
   }

   public boolean is1_9HitboxFix() {
      return true;
   }

   public boolean is1_14HitboxFix() {
      return true;
   }

   public boolean isNonFullBlockLightFix() {
      return false;
   }

   public boolean is1_14HealthNaNFix() {
      return true;
   }

   public boolean is1_15InstantRespawn() {
      return false;
   }

   public boolean isIgnoreLong1_16ChannelNames() {
      return false;
   }

   public boolean isForcedUse1_17ResourcePack() {
      return false;
   }

   public JsonElement get1_17ResourcePackPrompt() {
      return null;
   }

   public WorldIdentifiers get1_16WorldNamesMap() {
      return new WorldIdentifiers("minecraft:overworld");
   }

   public boolean cache1_17Light() {
      return true;
   }

   public String chatTypeFormat(String key) {
      byte var3 = -1;
      switch(key.hashCode()) {
      case -1972720102:
         if (key.equals("chat.type.emote")) {
            var3 = 4;
         }
         break;
      case -1587217333:
         if (key.equals("chat.type.text")) {
            var3 = 0;
         }
         break;
      case -854273153:
         if (key.equals("commands.message.display.incoming")) {
            var3 = 2;
         }
         break;
      case -404421019:
         if (key.equals("chat.type.announcement")) {
            var3 = 1;
         }
         break;
      case 1483815360:
         if (key.equals("chat.type.team.text")) {
            var3 = 3;
         }
      }

      switch(var3) {
      case 0:
         return "<%s> %s";
      case 1:
         return "[%s] %s";
      case 2:
         return "%s whispers to you: %s";
      case 3:
         return "%s <%s> %s";
      case 4:
         return "* %s %s";
      default:
         return null;
      }
   }

   public boolean isArmorToggleFix() {
      return false;
   }
}
