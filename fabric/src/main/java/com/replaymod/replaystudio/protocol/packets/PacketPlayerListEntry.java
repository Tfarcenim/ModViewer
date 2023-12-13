package com.replaymod.replaystudio.protocol.packets;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ProtocolVersion;
import com.replaymod.replaystudio.protocol.Packet;
import com.replaymod.replaystudio.protocol.PacketType;
import com.replaymod.replaystudio.protocol.PacketTypeRegistry;
import com.replaymod.replaystudio.util.Property;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

public class PacketPlayerListEntry {
   private UUID uuid;
   private String name;
   private List<Property> properties;
   private String displayName;
   private int gamemode;
   private boolean listed;
   private int latency;
   private PacketPlayerListEntry.SigData sigData;

   public static PacketPlayerListEntry updateChatKey(PacketPlayerListEntry entry, PacketPlayerListEntry.SigData sigData) {
      entry = new PacketPlayerListEntry(entry);
      entry.sigData = sigData;
      return entry;
   }

   public static PacketPlayerListEntry updateGamemode(PacketPlayerListEntry entry, int gamemode) {
      entry = new PacketPlayerListEntry(entry);
      entry.gamemode = gamemode;
      return entry;
   }

   public static PacketPlayerListEntry updateListed(PacketPlayerListEntry entry, boolean listed) {
      entry = new PacketPlayerListEntry(entry);
      entry.listed = listed;
      return entry;
   }

   public static PacketPlayerListEntry updateLatency(PacketPlayerListEntry entry, int latency) {
      entry = new PacketPlayerListEntry(entry);
      entry.latency = latency;
      return entry;
   }

   public static PacketPlayerListEntry updateDisplayName(PacketPlayerListEntry entry, String displayName) {
      entry = new PacketPlayerListEntry(entry);
      entry.displayName = displayName;
      return entry;
   }

   public static Set<PacketPlayerListEntry.Action> getActions(Packet packet) throws IOException {
      Packet.Reader in = packet.reader();
      Throwable var2 = null;

      Set var3;
      try {
         if (packet.atLeast(ProtocolVersion.v1_19_3)) {
            if (packet.getType() == PacketType.PlayerListEntryRemove) {
               var3 = Collections.singleton(PacketPlayerListEntry.Action.REMOVE);
               return var3;
            }

            EnumSet var18 = PacketPlayerListEntry.Action.readSet(in, PacketPlayerListEntry.Action.VALUES_1_19_3);
            return var18;
         }

         if (!packet.atLeast(ProtocolVersion.v1_8)) {
            in.readString();
            if (in.readBoolean()) {
               var3 = Collections.singleton(PacketPlayerListEntry.Action.ADD);
               return var3;
            }

            var3 = Collections.singleton(PacketPlayerListEntry.Action.REMOVE);
            return var3;
         }

         var3 = Collections.singleton(PacketPlayerListEntry.Action.VALUES_1_8.get(in.readVarInt()));
      } catch (Throwable var16) {
         var2 = var16;
         throw var16;
      } finally {
         if (in != null) {
            if (var2 != null) {
               try {
                  in.close();
               } catch (Throwable var15) {
                  var2.addSuppressed(var15);
               }
            } else {
               in.close();
            }
         }

      }

      return var3;
   }

   public static List<PacketPlayerListEntry> read(Packet packet) throws IOException {
      Packet.Reader in = packet.reader();
      Throwable var2 = null;

      try {
         if (!packet.atLeast(ProtocolVersion.v1_8)) {
            PacketPlayerListEntry entry = new PacketPlayerListEntry();
            entry.name = in.readString();
            in.readBoolean();
            entry.latency = in.readShort();
            List var21 = Collections.singletonList(entry);
            return var21;
         } else {
            Object actions;
            if (packet.getType() == PacketType.PlayerListEntryRemove) {
               actions = Collections.singleton(PacketPlayerListEntry.Action.REMOVE);
            } else if (packet.atLeast(ProtocolVersion.v1_19_3)) {
               actions = PacketPlayerListEntry.Action.readSet(in, PacketPlayerListEntry.Action.VALUES_1_19_3);
            } else {
               actions = Collections.singleton(PacketPlayerListEntry.Action.VALUES_1_8.get(in.readVarInt()));
            }

            int count = in.readVarInt();
            List<PacketPlayerListEntry> result = new ArrayList(count);

            for(int i = 0; i < count; ++i) {
               PacketPlayerListEntry entry = new PacketPlayerListEntry();
               entry.uuid = in.readUUID();
               Iterator var8 = ((Set)actions).iterator();

               while(var8.hasNext()) {
                  PacketPlayerListEntry.Action action = (PacketPlayerListEntry.Action)var8.next();
                  switch(action) {
                  case ADD:
                     entry.name = in.readString();
                     entry.properties = in.readList(() -> {
                        return Property.read(in);
                     });
                     if (packet.olderThan(ProtocolVersion.v1_19_3)) {
                        entry.gamemode = in.readVarInt();
                        entry.latency = in.readVarInt();
                        if (in.readBoolean()) {
                           entry.displayName = in.readString();
                        }

                        if (packet.atLeast(ProtocolVersion.v1_19) && in.readBoolean()) {
                           entry.sigData = PacketPlayerListEntry.SigData.read(packet, in);
                        }
                     }
                     break;
                  case CHAT_KEY:
                     if (in.readBoolean()) {
                        entry.sigData = PacketPlayerListEntry.SigData.read(packet, in);
                     }
                     break;
                  case GAMEMODE:
                     entry.gamemode = in.readVarInt();
                     break;
                  case LISTED:
                     entry.listed = in.readBoolean();
                     break;
                  case LATENCY:
                     entry.latency = in.readVarInt();
                     break;
                  case DISPLAY_NAME:
                     if (in.readBoolean()) {
                        entry.displayName = in.readString();
                     }
                  }
               }

               result.add(entry);
            }

            ArrayList var22 = result;
            return var22;
         }
      } catch (Throwable var18) {
         var2 = var18;
         throw var18;
      } finally {
         if (in != null) {
            if (var2 != null) {
               try {
                  in.close();
               } catch (Throwable var17) {
                  var2.addSuppressed(var17);
               }
            } else {
               in.close();
            }
         }

      }
   }

   public static Packet write(PacketTypeRegistry registry, Set<PacketPlayerListEntry.Action> actions, PacketPlayerListEntry entry) throws IOException {
      return (Packet)write(registry, actions, Collections.singletonList(entry)).get(0);
   }

   public static List<Packet> write(PacketTypeRegistry registry, Set<PacketPlayerListEntry.Action> actions, List<PacketPlayerListEntry> entries) throws IOException {
      if (registry.atLeast(ProtocolVersion.v1_8)) {
         return Collections.singletonList(write_1_8(registry, actions, entries));
      } else {
         List<Packet> packets = new ArrayList(entries.size());
         Iterator var4 = entries.iterator();

         while(var4.hasNext()) {
            PacketPlayerListEntry it = (PacketPlayerListEntry)var4.next();
            packets.add(write_1_7(registry, (PacketPlayerListEntry.Action)actions.iterator().next(), it));
         }

         return packets;
      }
   }

   private static Packet write_1_8(PacketTypeRegistry registry, Set<PacketPlayerListEntry.Action> actions, List<PacketPlayerListEntry> entries) throws IOException {
      Packet packet;
      Packet.Writer out;
      Throwable var5;
      if (registry.atLeast(ProtocolVersion.v1_19_3) && actions.contains(PacketPlayerListEntry.Action.REMOVE)) {
         packet = new Packet(registry, PacketType.PlayerListEntry);
         out = packet.overwrite();
         var5 = null;

         try {
            out.writeList(entries, (entryx) -> {
               out.writeUUID(entryx.uuid);
            });
         } catch (Throwable var29) {
            var5 = var29;
            throw var29;
         } finally {
            if (out != null) {
               if (var5 != null) {
                  try {
                     out.close();
                  } catch (Throwable var27) {
                     var5.addSuppressed(var27);
                  }
               } else {
                  out.close();
               }
            }

         }

         return packet;
      } else {
         packet = new Packet(registry, PacketType.PlayerListEntry);
         out = packet.overwrite();
         var5 = null;

         try {
            if (packet.atLeast(ProtocolVersion.v1_19_3)) {
               PacketPlayerListEntry.Action.writeSet(out, actions, PacketPlayerListEntry.Action.VALUES_1_19_3);
            } else {
               out.writeVarInt(PacketPlayerListEntry.Action.VALUES_1_8.indexOf(actions.iterator().next()));
            }

            out.writeVarInt(entries.size());
            Iterator var6 = entries.iterator();

            while(var6.hasNext()) {
               PacketPlayerListEntry entry = (PacketPlayerListEntry)var6.next();
               out.writeUUID(entry.uuid);
               Iterator var8 = actions.iterator();

               while(var8.hasNext()) {
                  PacketPlayerListEntry.Action action = (PacketPlayerListEntry.Action)var8.next();
                  switch(action) {
                  case ADD:
                     out.writeString(entry.name);
                     out.writeList(entry.properties, (it) -> {
                        it.write(out);
                     });
                     if (packet.olderThan(ProtocolVersion.v1_19_3)) {
                        out.writeVarInt(entry.gamemode);
                        out.writeVarInt(entry.latency);
                        if (entry.displayName != null) {
                           out.writeBoolean(true);
                           out.writeString(entry.displayName);
                        } else {
                           out.writeBoolean(false);
                        }

                        if (packet.atLeast(ProtocolVersion.v1_19)) {
                           if (entry.sigData != null) {
                              out.writeBoolean(true);
                              entry.sigData.write(packet, out);
                           } else {
                              out.writeBoolean(false);
                           }
                        }
                     }
                     break;
                  case CHAT_KEY:
                     if (entry.sigData != null) {
                        out.writeBoolean(true);
                        entry.sigData.write(packet, out);
                     } else {
                        out.writeBoolean(false);
                     }
                     break;
                  case GAMEMODE:
                     out.writeVarInt(entry.gamemode);
                     break;
                  case LISTED:
                     out.writeBoolean(entry.listed);
                     break;
                  case LATENCY:
                     out.writeVarInt(entry.latency);
                     break;
                  case DISPLAY_NAME:
                     if (entry.displayName != null) {
                        out.writeBoolean(true);
                        out.writeString(entry.displayName);
                     } else {
                        out.writeBoolean(false);
                     }
                  }
               }
            }
         } catch (Throwable var31) {
            var5 = var31;
            throw var31;
         } finally {
            if (out != null) {
               if (var5 != null) {
                  try {
                     out.close();
                  } catch (Throwable var28) {
                     var5.addSuppressed(var28);
                  }
               } else {
                  out.close();
               }
            }

         }

         return packet;
      }
   }

   private static Packet write_1_7(PacketTypeRegistry registry, PacketPlayerListEntry.Action action, PacketPlayerListEntry entry) throws IOException {
      Packet packet = new Packet(registry, PacketType.PlayerListEntry);
      Packet.Writer out = packet.overwrite();
      Throwable var5 = null;

      try {
         out.writeString(entry.name);
         if (action == PacketPlayerListEntry.Action.ADD) {
            out.writeBoolean(true);
         } else {
            if (action != PacketPlayerListEntry.Action.REMOVE) {
               throw new IllegalStateException("1.7 only supports ADD or REMOVE");
            }

            out.writeBoolean(false);
         }

         out.writeShort(entry.latency);
      } catch (Throwable var14) {
         var5 = var14;
         throw var14;
      } finally {
         if (out != null) {
            if (var5 != null) {
               try {
                  out.close();
               } catch (Throwable var13) {
                  var5.addSuppressed(var13);
               }
            } else {
               out.close();
            }
         }

      }

      return packet;
   }

   private PacketPlayerListEntry() {
   }

   private PacketPlayerListEntry(PacketPlayerListEntry from) {
      this.uuid = from.uuid;
      this.name = from.name;
      this.properties = from.properties;
      this.displayName = from.displayName;
      this.gamemode = from.gamemode;
      this.listed = from.listed;
      this.latency = from.latency;
      this.sigData = from.sigData;
   }

   public UUID getUuid() {
      return this.uuid;
   }

   public String getName() {
      return this.name;
   }

   public List<Property> getProperties() {
      return this.properties;
   }

   public String getDisplayName() {
      return this.displayName;
   }

   public int getGamemode() {
      return this.gamemode;
   }

   public boolean isListed() {
      return this.listed;
   }

   public int getLatency() {
      return this.latency;
   }

   public PacketPlayerListEntry.SigData getSigData() {
      return this.sigData;
   }

   public String getId() {
      return this.uuid != null ? this.uuid.toString() : this.name;
   }

   public static class SigData {
      private final UUID sessionUuid;
      private final long expireTimestamp;
      private final byte[] publicKey;
      private final byte[] signature;

      public SigData(UUID sessionUuid, long expireTimestamp, byte[] publicKey, byte[] signature) {
         this.sessionUuid = sessionUuid;
         this.expireTimestamp = expireTimestamp;
         this.publicKey = publicKey;
         this.signature = signature;
      }

      public static PacketPlayerListEntry.SigData read(Packet packet, Packet.Reader in) throws IOException {
         UUID sessionUuid;
         if (packet.atLeast(ProtocolVersion.v1_19_3)) {
            sessionUuid = in.readUUID();
         } else {
            sessionUuid = null;
         }

         long expireTimestamp = in.readLong();
         byte[] publicKey = in.readBytes(in.readVarInt());
         byte[] signature = in.readBytes(in.readVarInt());
         return new PacketPlayerListEntry.SigData(sessionUuid, expireTimestamp, publicKey, signature);
      }

      public void write(Packet packet, Packet.Writer out) throws IOException {
         if (packet.atLeast(ProtocolVersion.v1_19_3)) {
            out.writeUUID(this.sessionUuid);
         }

         out.writeLong(this.expireTimestamp);
         out.writeVarInt(this.publicKey.length);
         out.writeBytes(this.publicKey);
         out.writeVarInt(this.signature.length);
         out.writeBytes(this.signature);
      }
   }

   public static enum Action {
      ADD,
      CHAT_KEY,
      GAMEMODE,
      LISTED,
      LATENCY,
      DISPLAY_NAME,
      REMOVE;

      private static final List<PacketPlayerListEntry.Action> VALUES_1_19_3 = Arrays.asList(ADD, CHAT_KEY, GAMEMODE, LISTED, LATENCY, DISPLAY_NAME);
      private static final List<PacketPlayerListEntry.Action> VALUES_1_8 = Arrays.asList(ADD, GAMEMODE, LATENCY, DISPLAY_NAME, REMOVE);
      private static final List<PacketPlayerListEntry.Action> VALUES_1_7 = Arrays.asList(ADD, REMOVE);

      public static Set<PacketPlayerListEntry.Action> init(PacketTypeRegistry registry) {
         return registry.atLeast(ProtocolVersion.v1_19_3) ? EnumSet.copyOf(VALUES_1_19_3) : EnumSet.of(ADD);
      }

      public static List<PacketPlayerListEntry.Action> values(PacketTypeRegistry registry) {
         if (registry.atLeast(ProtocolVersion.v1_19_3)) {
            return VALUES_1_19_3;
         } else {
            return registry.atLeast(ProtocolVersion.v1_8) ? VALUES_1_8 : VALUES_1_7;
         }
      }

      public static EnumSet<PacketPlayerListEntry.Action> readSet(Packet.Reader in, List<PacketPlayerListEntry.Action> values) throws IOException {
         BitSet bitSet = BitSet.valueOf(in.readBytes((values.size() + 7) / 8));
         EnumSet<PacketPlayerListEntry.Action> set = EnumSet.noneOf(PacketPlayerListEntry.Action.class);

         for(int i = 0; i < values.size(); ++i) {
            if (bitSet.get(i)) {
               set.add(values.get(i));
            }
         }

         return set;
      }

      public static void writeSet(Packet.Writer out, Set<PacketPlayerListEntry.Action> actions, List<PacketPlayerListEntry.Action> values) throws IOException {
         BitSet bitSet = new BitSet();

         for(int i = 0; i < values.size(); ++i) {
            if (actions.contains(values.get(i))) {
               bitSet.set(i);
            }
         }

         out.writeBytes(Arrays.copyOf(bitSet.toByteArray(), (values.size() + 7) / 8));
      }
   }
}
