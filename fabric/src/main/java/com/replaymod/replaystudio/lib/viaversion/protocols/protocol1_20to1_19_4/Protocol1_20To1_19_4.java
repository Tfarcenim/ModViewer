package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_20to1_19_4;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.data.MappingData;
import com.replaymod.replaystudio.lib.viaversion.api.data.MappingDataBase;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_19_4Types;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.AbstractProtocol;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.minecraft.ParticleType;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_20;
import com.replaymod.replaystudio.lib.viaversion.data.entity.EntityTrackerBase;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_4to1_19_3.ClientboundPackets1_19_4;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_4to1_19_3.ServerboundPackets1_19_4;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_20to1_19_4.packets.EntityPackets;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_20to1_19_4.packets.InventoryPackets;
import com.replaymod.replaystudio.lib.viaversion.rewriter.SoundRewriter;
import com.replaymod.replaystudio.lib.viaversion.rewriter.StatisticsRewriter;
import com.replaymod.replaystudio.lib.viaversion.rewriter.TagRewriter;

public final class Protocol1_20To1_19_4 extends AbstractProtocol<ClientboundPackets1_19_4, ClientboundPackets1_19_4, ServerboundPackets1_19_4, ServerboundPackets1_19_4> {
   public static final MappingData MAPPINGS = new MappingDataBase("1.19.4", "1.20");
   private final EntityPackets entityRewriter = new EntityPackets(this);
   private final InventoryPackets itemRewriter = new InventoryPackets(this);

   public Protocol1_20To1_19_4() {
      super(ClientboundPackets1_19_4.class, ClientboundPackets1_19_4.class, ServerboundPackets1_19_4.class, ServerboundPackets1_19_4.class);
   }

   protected void registerPackets() {
      super.registerPackets();
      TagRewriter<ClientboundPackets1_19_4> tagRewriter = new TagRewriter(this);
      tagRewriter.registerGeneric(ClientboundPackets1_19_4.TAGS);
      SoundRewriter<ClientboundPackets1_19_4> soundRewriter = new SoundRewriter(this);
      soundRewriter.register1_19_3Sound(ClientboundPackets1_19_4.SOUND);
      soundRewriter.registerSound(ClientboundPackets1_19_4.ENTITY_SOUND);
      (new StatisticsRewriter(this)).register(ClientboundPackets1_19_4.STATISTICS);
      this.registerClientbound(ClientboundPackets1_19_4.COMBAT_END, (wrapper) -> {
         wrapper.passthrough(Type.VAR_INT);
         wrapper.read(Type.INT);
      });
      this.registerClientbound(ClientboundPackets1_19_4.COMBAT_KILL, (wrapper) -> {
         wrapper.passthrough(Type.VAR_INT);
         wrapper.read(Type.INT);
      });
   }

   protected void onMappingDataLoaded() {
      super.onMappingDataLoaded();
      Types1_20.PARTICLE.filler(this).reader("block", ParticleType.Readers.BLOCK).reader("block_marker", ParticleType.Readers.BLOCK).reader("dust", ParticleType.Readers.DUST).reader("falling_dust", ParticleType.Readers.BLOCK).reader("dust_color_transition", ParticleType.Readers.DUST_TRANSITION).reader("item", ParticleType.Readers.VAR_INT_ITEM).reader("vibration", ParticleType.Readers.VIBRATION1_19).reader("sculk_charge", ParticleType.Readers.SCULK_CHARGE).reader("shriek", ParticleType.Readers.SHRIEK);
   }

   public void init(UserConnection user) {
      this.addEntityTracker(user, new EntityTrackerBase(user, Entity1_19_4Types.PLAYER));
   }

   public MappingData getMappingData() {
      return MAPPINGS;
   }

   public EntityPackets getEntityRewriter() {
      return this.entityRewriter;
   }

   public InventoryPackets getItemRewriter() {
      return this.itemRewriter;
   }
}
