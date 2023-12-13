package com.replaymod.replaystudio.lib.viaversion.api.configuration;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.WorldIdentifiers;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.BlockedProtocolVersions;
import com.replaymod.replaystudio.lib.viaversion.libs.fastutil.ints.IntSet;
import com.replaymod.replaystudio.lib.viaversion.libs.gson.JsonElement;
import org.checkerframework.checker.nullness.qual.Nullable;

public interface ViaVersionConfig {
   boolean isCheckForUpdates();

   void setCheckForUpdates(boolean var1);

   boolean isPreventCollision();

   boolean isNewEffectIndicator();

   boolean isShowNewDeathMessages();

   boolean isSuppressMetadataErrors();

   boolean isShieldBlocking();

   boolean isNoDelayShieldBlocking();

   boolean isShowShieldWhenSwordInHand();

   boolean isHologramPatch();

   boolean isPistonAnimationPatch();

   boolean isBossbarPatch();

   boolean isBossbarAntiflicker();

   double getHologramYOffset();

   boolean isAutoTeam();

   int getMaxPPS();

   String getMaxPPSKickMessage();

   int getTrackingPeriod();

   int getWarningPPS();

   int getMaxWarnings();

   String getMaxWarningsKickMessage();

   boolean isSendSupportedVersions();

   boolean isSimulatePlayerTick();

   boolean isItemCache();

   boolean isNMSPlayerTicking();

   boolean isReplacePistons();

   int getPistonReplacementId();

   boolean isChunkBorderFix();

   boolean isForceJsonTransform();

   boolean is1_12NBTArrayFix();

   boolean is1_13TeamColourFix();

   boolean shouldRegisterUserConnectionOnJoin();

   boolean is1_12QuickMoveActionFix();

   BlockedProtocolVersions blockedProtocolVersions();

   /** @deprecated */
   @Deprecated
   default IntSet getBlockedProtocols() {
      return this.blockedProtocolVersions().singleBlockedVersions();
   }

   String getBlockedDisconnectMsg();

   String getReloadDisconnectMsg();

   boolean isSuppressConversionWarnings();

   boolean isDisable1_13AutoComplete();

   boolean isMinimizeCooldown();

   boolean isServersideBlockConnections();

   String getBlockConnectionMethod();

   boolean isReduceBlockStorageMemory();

   boolean isStemWhenBlockAbove();

   boolean isVineClimbFix();

   boolean isSnowCollisionFix();

   boolean isInfestedBlocksFix();

   int get1_13TabCompleteDelay();

   boolean isTruncate1_14Books();

   boolean isLeftHandedHandling();

   boolean is1_9HitboxFix();

   boolean is1_14HitboxFix();

   boolean isNonFullBlockLightFix();

   boolean is1_14HealthNaNFix();

   boolean is1_15InstantRespawn();

   boolean isIgnoreLong1_16ChannelNames();

   boolean isForcedUse1_17ResourcePack();

   JsonElement get1_17ResourcePackPrompt();

   WorldIdentifiers get1_16WorldNamesMap();

   boolean cache1_17Light();

   @Nullable
   String chatTypeFormat(String var1);

   boolean isArmorToggleFix();
}
