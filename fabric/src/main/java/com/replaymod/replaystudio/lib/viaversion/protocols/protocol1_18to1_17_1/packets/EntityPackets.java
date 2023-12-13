package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_18to1_17_1.packets;

import com.replaymod.replaystudio.lib.viaversion.api.data.entity.EntityTracker;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_17Types;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.EntityType;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.metadata.MetaType;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.remapper.PacketHandlers;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.Particle;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_17;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.version.Types1_18;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_17_1to1_17.ClientboundPackets1_17_1;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_18to1_17_1.Protocol1_18To1_17_1;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_18to1_17_1.storage.ChunkLightStorage;
import com.replaymod.replaystudio.lib.viaversion.rewriter.EntityRewriter;

public final class EntityPackets extends EntityRewriter<ClientboundPackets1_17_1, Protocol1_18To1_17_1> {
   public EntityPackets(Protocol1_18To1_17_1 protocol) {
      super(protocol);
   }

   public void registerPackets() {
      this.registerMetadataRewriter(ClientboundPackets1_17_1.ENTITY_METADATA, Types1_17.METADATA_LIST, Types1_18.METADATA_LIST);
      ((Protocol1_18To1_17_1)this.protocol).registerClientbound(ClientboundPackets1_17_1.JOIN_GAME, new PacketHandlers() {
         public void register() {
            this.map(Type.INT);
            this.map(Type.BOOLEAN);
            this.map(Type.UNSIGNED_BYTE);
            this.map(Type.BYTE);
            this.map(Type.STRING_ARRAY);
            this.map(Type.NBT);
            this.map(Type.NBT);
            this.map(Type.STRING);
            this.map(Type.LONG);
            this.map(Type.VAR_INT);
            this.handler((wrapper) -> {
               int chunkRadius = (Integer)wrapper.passthrough(Type.VAR_INT);
               wrapper.write(Type.VAR_INT, chunkRadius);
            });
            this.handler(EntityPackets.this.worldDataTrackerHandler(1));
            this.handler(EntityPackets.this.biomeSizeTracker());
         }
      });
      ((Protocol1_18To1_17_1)this.protocol).registerClientbound(ClientboundPackets1_17_1.RESPAWN, new PacketHandlers() {
         public void register() {
            this.map(Type.NBT);
            this.map(Type.STRING);
            this.handler((wrapper) -> {
               String world = (String)wrapper.get(Type.STRING, 0);
               EntityTracker tracker = EntityPackets.this.tracker(wrapper.user());
               if (!world.equals(tracker.currentWorld())) {
                  ((ChunkLightStorage)wrapper.user().get(ChunkLightStorage.class)).clear();
               }

            });
            this.handler(EntityPackets.this.worldDataTrackerHandler(0));
         }
      });
   }

   protected void registerRewrites() {
      this.filter().handler((event, meta) -> {
         meta.setMetaType(Types1_18.META_TYPES.byId(meta.metaType().typeId()));
         if (meta.metaType() == Types1_18.META_TYPES.particleType) {
            Particle particle = (Particle)meta.getValue();
            if (particle.getId() == 2) {
               particle.setId(3);
               particle.getArguments().add(new Particle.ParticleData(Type.VAR_INT, 7754));
            } else if (particle.getId() == 3) {
               particle.getArguments().add(new Particle.ParticleData(Type.VAR_INT, 7786));
            } else {
               this.rewriteParticle(particle);
            }
         }

      });
      this.registerMetaTypeHandler(Types1_18.META_TYPES.itemType, (MetaType)null, (MetaType)null, (MetaType)null);
   }

   public EntityType typeFromId(int type) {
      return Entity1_17Types.getTypeFromId(type);
   }
}
