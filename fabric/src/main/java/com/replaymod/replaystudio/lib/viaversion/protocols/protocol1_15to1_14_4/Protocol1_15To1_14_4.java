package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_15to1_14_4;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.data.MappingData;
import com.replaymod.replaystudio.lib.viaversion.api.data.MappingDataBase;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.RegistryType;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.entities.Entity1_15Types;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.Item;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.AbstractProtocol;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.data.entity.EntityTrackerBase;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14_4to1_14_3.ClientboundPackets1_14_4;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14to1_13_2.ServerboundPackets1_14;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_15to1_14_4.metadata.MetadataRewriter1_15To1_14_4;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_15to1_14_4.packets.EntityPackets;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_15to1_14_4.packets.InventoryPackets;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_15to1_14_4.packets.WorldPackets;
import com.replaymod.replaystudio.lib.viaversion.rewriter.SoundRewriter;
import com.replaymod.replaystudio.lib.viaversion.rewriter.StatisticsRewriter;
import com.replaymod.replaystudio.lib.viaversion.rewriter.TagRewriter;

public class Protocol1_15To1_14_4 extends AbstractProtocol<ClientboundPackets1_14_4, ClientboundPackets1_15, ServerboundPackets1_14, ServerboundPackets1_14> {
   public static final MappingData MAPPINGS = new MappingDataBase("1.14", "1.15");
   private final MetadataRewriter1_15To1_14_4 metadataRewriter = new MetadataRewriter1_15To1_14_4(this);
   private final InventoryPackets itemRewriter = new InventoryPackets(this);
   private TagRewriter<ClientboundPackets1_14_4> tagRewriter;

   public Protocol1_15To1_14_4() {
      super(ClientboundPackets1_14_4.class, ClientboundPackets1_15.class, ServerboundPackets1_14.class, ServerboundPackets1_14.class);
   }

   protected void registerPackets() {
      this.metadataRewriter.register();
      this.itemRewriter.register();
      EntityPackets.register(this);
      WorldPackets.register(this);
      SoundRewriter<ClientboundPackets1_14_4> soundRewriter = new SoundRewriter(this);
      soundRewriter.registerSound(ClientboundPackets1_14_4.ENTITY_SOUND);
      soundRewriter.registerSound(ClientboundPackets1_14_4.SOUND);
      (new StatisticsRewriter(this)).register(ClientboundPackets1_14_4.STATISTICS);
      this.registerServerbound(ServerboundPackets1_14.EDIT_BOOK, (wrapper) -> {
         this.itemRewriter.handleItemToServer((Item)wrapper.passthrough(Type.FLAT_VAR_INT_ITEM));
      });
      this.tagRewriter = new TagRewriter(this);
      this.tagRewriter.register(ClientboundPackets1_14_4.TAGS, RegistryType.ENTITY);
   }

   protected void onMappingDataLoaded() {
      int[] shulkerBoxes = new int[17];
      int shulkerBoxOffset = 501;

      for(int i = 0; i < 17; ++i) {
         shulkerBoxes[i] = shulkerBoxOffset + i;
      }

      this.tagRewriter.addTag(RegistryType.BLOCK, "minecraft:shulker_boxes", shulkerBoxes);
   }

   public void init(UserConnection connection) {
      this.addEntityTracker(connection, new EntityTrackerBase(connection, Entity1_15Types.PLAYER));
   }

   public MappingData getMappingData() {
      return MAPPINGS;
   }

   public MetadataRewriter1_15To1_14_4 getEntityRewriter() {
      return this.metadataRewriter;
   }

   public InventoryPackets getItemRewriter() {
      return this.itemRewriter;
   }
}
