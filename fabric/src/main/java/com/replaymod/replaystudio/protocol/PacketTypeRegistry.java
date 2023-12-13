package com.replaymod.replaystudio.protocol;

import com.replaymod.lib.org.apache.commons.lang3.tuple.Pair;
import com.replaymod.replaystudio.lib.guava.collect.Lists;
import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.AbstractProtocol;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.Protocol;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.ProtocolPathEntry;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.ClientboundPacketType;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.State;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.mapping.PacketMapping;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.mapping.PacketMappings;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.provider.PacketTypeMap;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ProtocolVersion;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_14to1_13_2.Protocol1_14To1_13_2;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_16to1_15_2.Protocol1_16To1_15_2;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_17_1to1_17.Protocol1_17_1To1_17;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_17to1_16_4.Protocol1_17To1_16_4;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19to1_18_2.Protocol1_19To1_18_2;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_9to1_8.Protocol1_9To1_8;
import com.replaymod.replaystudio.viaversion.CustomViaManager;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class PacketTypeRegistry {
   private static Map<ProtocolVersion, EnumMap<State, PacketTypeRegistry>> forVersionAndState = new HashMap();
   private static Field clientbound;
   private final ProtocolVersion version;
   private final State state;
   private final PacketType unknown;
   private final Map<Integer, PacketType> typeForId = new HashMap();
   private final Map<PacketType, Integer> idForType = new HashMap();

   public static PacketTypeRegistry get(ProtocolVersion version, State state) {
      EnumMap<State, PacketTypeRegistry> forState = (EnumMap)forVersionAndState.get(version);
      return forState != null ? (PacketTypeRegistry)forState.get(state) : new PacketTypeRegistry(version, state);
   }

   private PacketTypeRegistry(ProtocolVersion version, State state) {
      this.version = version;
      this.state = state;
      PacketType unknown = null;
      int versionIndex = ProtocolVersion.getIndex(version);
      PacketType[] var5 = PacketType.values();
      int var6 = var5.length;

      label102:
      for(int var7 = 0; var7 < var6; ++var7) {
         PacketType packetType = var5[var7];
         if (packetType.getState() == state) {
            if (packetType.isUnknown()) {
               unknown = packetType;
            } else if (ProtocolVersion.getIndex(packetType.getInitialVersion()) <= versionIndex) {
               List<ProtocolPathEntry> protocolPath = getProtocolPath(version.getVersion(), packetType.getInitialVersion().getVersion());
               if (protocolPath != null) {
                  int id = packetType.getInitialId();
                  Iterator var11 = Lists.reverse(protocolPath).iterator();

                  boolean wasReplaced;
                  do {
                     if (!var11.hasNext()) {
                        this.typeForId.put(id, packetType);
                        this.idForType.put(packetType, id);
                        break;
                     }

                     ProtocolPathEntry entry = (ProtocolPathEntry)var11.next();
                     Protocol<?, ?, ?, ?> protocol = entry.getProtocol();
                     wasReplaced = false;
                     Iterator var15 = getIdMappings(protocol, state).iterator();

                     while(var15.hasNext()) {
                        Pair<Integer, Integer> idMapping = (Pair)var15.next();
                        int oldId = (Integer)idMapping.getKey();
                        int newId = (Integer)idMapping.getValue();
                        if (oldId == id) {
                           if (newId == -1) {
                              if (!(protocol instanceof Protocol1_17To1_16_4) || packetType != PacketType.DestroyEntities || version == ProtocolVersion.v1_17) {
                                 continue label102;
                              }

                              id = PacketType.DestroyEntity.getInitialId();
                              wasReplaced = false;
                           } else {
                              id = newId;
                              wasReplaced = false;
                           }
                           break;
                        }

                        if (newId == id) {
                           wasReplaced = true;
                        }
                     }

                     if (protocol instanceof Protocol1_19To1_18_2) {
                        switch(packetType) {
                        case SpawnPainting:
                        case SpawnMob:
                           continue label102;
                        case SpawnObject:
                           wasReplaced = false;
                           id = 0;
                        }
                     }

                     if (protocol instanceof Protocol1_16To1_15_2 && packetType == PacketType.SpawnGlobalEntity) {
                        wasReplaced = true;
                     }

                     if (protocol instanceof Protocol1_14To1_13_2 && packetType == PacketType.PlayerUseBed) {
                        wasReplaced = true;
                     }

                     if (protocol instanceof Protocol1_9To1_8 && packetType == PacketType.EntityNBTUpdate) {
                        wasReplaced = true;
                     }

                     if (protocol instanceof Protocol1_17_1To1_17 && packetType == PacketType.DestroyEntity) {
                        wasReplaced = true;
                     }
                  } while(!wasReplaced);
               }
            }
         }
      }

      this.unknown = unknown;
   }

   private static List<ProtocolPathEntry> getProtocolPath(int clientVersion, int serverVersion) {
      if (serverVersion == ProtocolVersion.v1_7_6.getVersion()) {
         return getProtocolPath(clientVersion, ProtocolVersion.v1_8.getVersion());
      } else if (clientVersion == ProtocolVersion.v1_7_6.getVersion()) {
         return getProtocolPath(ProtocolVersion.v1_8.getVersion(), serverVersion);
      } else {
         return clientVersion == serverVersion ? Collections.emptyList() : Via.getManager().getProtocolManager().getProtocolPath(clientVersion, serverVersion);
      }
   }

   public ProtocolVersion getVersion() {
      return this.version;
   }

   public State getState() {
      return this.state;
   }

   public Integer getId(PacketType type) {
      return (Integer)this.idForType.get(type);
   }

   public PacketType getType(int id) {
      return (PacketType)this.typeForId.getOrDefault(id, this.unknown);
   }

   public boolean atLeast(ProtocolVersion protocolVersion) {
      return this.version.getVersion() >= protocolVersion.getVersion();
   }

   public boolean atMost(ProtocolVersion protocolVersion) {
      return this.version.getVersion() <= protocolVersion.getVersion();
   }

   public boolean olderThan(ProtocolVersion protocolVersion) {
      return this.version.getVersion() < protocolVersion.getVersion();
   }

   private static List<Pair<Integer, Integer>> getIdMappings(Protocol<?, ?, ?, ?> protocol, State state) {
      ArrayList result = new ArrayList();

      try {
         if (clientbound == null) {
            clientbound = AbstractProtocol.class.getDeclaredField("clientboundMappings");
            clientbound.setAccessible(true);
         }

         PacketMappings mappings = (PacketMappings)clientbound.get(protocol);
         PacketTypeMap<? extends ClientboundPacketType> packetTypeMap = (PacketTypeMap)protocol.getPacketTypesProvider().unmappedClientboundPacketTypes().get(state);
         if (packetTypeMap == null) {
            return result;
         } else {
            PacketWrapper dummyPacketWrapper = PacketWrapper.create((com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketType)null, (UserConnection)((UserConnection)null));
            Iterator var6 = packetTypeMap.types().iterator();

            while(var6.hasNext()) {
               ClientboundPacketType unmappedPacketType = (ClientboundPacketType)var6.next();
               PacketMapping packetMapping = mappings.mappedPacket(state, unmappedPacketType.getId());
               if (packetMapping != null) {
                  dummyPacketWrapper.setPacketType((com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketType)null);
                  packetMapping.applyType(dummyPacketWrapper);
                  int oldId = unmappedPacketType.getId();
                  int newId = dummyPacketWrapper.getId();
                  result.add(Pair.of(oldId, newId));
               }
            }

            return result;
         }
      } catch (IllegalAccessException | NoSuchFieldException var11) {
         throw new RuntimeException(var11);
      }
   }

   static {
      CustomViaManager.initialize();
      Iterator var0 = ProtocolVersion.getProtocols().iterator();

      while(true) {
         ProtocolVersion version;
         do {
            if (!var0.hasNext()) {
               return;
            }

            version = (ProtocolVersion)var0.next();
         } while(ProtocolVersion.getIndex(version) < ProtocolVersion.getIndex(ProtocolVersion.v1_7_1));

         EnumMap<State, PacketTypeRegistry> forState = new EnumMap(State.class);
         State[] var3 = State.values();
         int var4 = var3.length;

         for(int var5 = 0; var5 < var4; ++var5) {
            State state = var3[var5];
            forState.put(state, new PacketTypeRegistry(version, state));
         }

         forVersionAndState.put(version, forState);
      }
   }
}
