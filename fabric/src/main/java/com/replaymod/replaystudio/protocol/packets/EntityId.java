package com.replaymod.replaystudio.protocol.packets;

import com.replaymod.replaystudio.lib.viaversion.api.protocol.version.ProtocolVersion;
import com.replaymod.replaystudio.protocol.Packet;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class EntityId {
   public static List<Integer> getEntityIds(Packet packet) throws IOException {
      Packet.Reader in;
      Throwable var2;
      List var3;
      int event;
      switch(packet.getType()) {
      case EntityCollectItem:
         in = packet.reader();
         var2 = null;

         try {
            if (!packet.atLeast(ProtocolVersion.v1_8)) {
               var3 = Arrays.asList(in.readInt(), in.readInt());
               return var3;
            }

            var3 = Arrays.asList(in.readVarInt(), in.readVarInt());
         } catch (Throwable var131) {
            var2 = var131;
            throw var131;
         } finally {
            if (in != null) {
               if (var2 != null) {
                  try {
                     in.close();
                  } catch (Throwable var118) {
                     var2.addSuppressed(var118);
                  }
               } else {
                  in.close();
               }
            }

         }

         return var3;
      case DestroyEntities:
         return PacketDestroyEntities.getEntityIds(packet);
      case SetPassengers:
         in = packet.reader();
         var2 = null;

         try {
            event = in.readVarInt();
            int len = in.readVarInt();
            List<Integer> result = new ArrayList(len + 1);
            result.add(event);

            for(int i = 0; i < len; ++i) {
               result.add(in.readVarInt());
            }

            ArrayList var136 = result;
            return var136;
         } catch (Throwable var129) {
            var2 = var129;
            throw var129;
         } finally {
            if (in != null) {
               if (var2 != null) {
                  try {
                     in.close();
                  } catch (Throwable var120) {
                     var2.addSuppressed(var120);
                  }
               } else {
                  in.close();
               }
            }

         }
      case EntityAttach:
         in = packet.reader();
         var2 = null;

         try {
            var3 = Arrays.asList(in.readInt(), in.readInt());
         } catch (Throwable var123) {
            var2 = var123;
            throw var123;
         } finally {
            if (in != null) {
               if (var2 != null) {
                  try {
                     in.close();
                  } catch (Throwable var119) {
                     var2.addSuppressed(var119);
                  }
               } else {
                  in.close();
               }
            }

         }

         return var3;
      case Combat:
         in = packet.reader();
         var2 = null;

         List var4;
         try {
            event = in.readVarInt();
            if (event == 1) {
               in.readVarInt();
               var4 = Collections.singletonList(in.readInt());
               return var4;
            }

            if (event == 2) {
               var4 = Arrays.asList(in.readVarInt(), in.readInt());
               return var4;
            }

            var4 = Collections.emptyList();
         } catch (Throwable var127) {
            var2 = var127;
            throw var127;
         } finally {
            if (in != null) {
               if (var2 != null) {
                  try {
                     in.close();
                  } catch (Throwable var121) {
                     var2.addSuppressed(var121);
                  }
               } else {
                  in.close();
               }
            }

         }

         return var4;
      case CombatEntityDead:
         in = packet.reader();
         var2 = null;

         try {
            if (!packet.atLeast(ProtocolVersion.v1_20)) {
               var3 = Arrays.asList(in.readVarInt(), in.readInt());
               return var3;
            }

            var3 = Collections.singletonList(in.readVarInt());
         } catch (Throwable var125) {
            var2 = var125;
            throw var125;
         } finally {
            if (in != null) {
               if (var2 != null) {
                  try {
                     in.close();
                  } catch (Throwable var122) {
                     var2.addSuppressed(var122);
                  }
               } else {
                  in.close();
               }
            }

         }

         return var3;
      default:
         Integer entityId = getEntityId(packet);
         return entityId != null ? Collections.singletonList(entityId) : Collections.emptyList();
      }
   }

   public static Integer getEntityId(Packet packet) throws IOException {
      Packet.Reader in;
      Throwable var2;
      Integer var3;
      switch(packet.getType()) {
      case OpenHorseWindow:
         in = packet.reader();
         var2 = null;

         try {
            in.readByte();
            in.readVarInt();
            var3 = in.readInt();
         } catch (Throwable var160) {
            var2 = var160;
            throw var160;
         } finally {
            if (in != null) {
               if (var2 != null) {
                  try {
                     in.close();
                  } catch (Throwable var156) {
                     var2.addSuppressed(var156);
                  }
               } else {
                  in.close();
               }
            }

         }

         return var3;
      case EntitySoundEffect:
         in = packet.reader();
         var2 = null;

         try {
            in.readVarInt();
            in.readVarInt();
            var3 = in.readVarInt();
         } catch (Throwable var159) {
            var2 = var159;
            throw var159;
         } finally {
            if (in != null) {
               if (var2 != null) {
                  try {
                     in.close();
                  } catch (Throwable var151) {
                     var2.addSuppressed(var151);
                  }
               } else {
                  in.close();
               }
            }

         }

         return var3;
      case EntityEffect:
      case EntityRemoveEffect:
      case EntityEquipment:
      case EntityHeadLook:
      case EntityMetadata:
      case EntityMovement:
      case EntityPosition:
      case EntityRotation:
      case EntityPositionRotation:
      case EntityAnimation:
      case EntityNBTUpdate:
      case EntityProperties:
      case EntityTeleport:
      case EntityVelocity:
      case SwitchCamera:
      case PlayerUseBed:
         in = packet.reader();
         var2 = null;

         try {
            if (!packet.atLeast(ProtocolVersion.v1_8)) {
               var3 = in.readInt();
               return var3;
            }

            var3 = in.readVarInt();
         } catch (Throwable var167) {
            var2 = var167;
            throw var167;
         } finally {
            if (in != null) {
               if (var2 != null) {
                  try {
                     in.close();
                  } catch (Throwable var155) {
                     var2.addSuppressed(var155);
                  }
               } else {
                  in.close();
               }
            }

         }

         return var3;
      case BlockBreakAnim:
      case DestroyEntity:
      case SpawnPlayer:
      case SpawnObject:
      case SpawnPainting:
      case SpawnMob:
      case SpawnGlobalEntity:
      case SpawnExpOrb:
         in = packet.reader();
         var2 = null;

         try {
            var3 = in.readVarInt();
         } catch (Throwable var158) {
            var2 = var158;
            throw var158;
         } finally {
            if (in != null) {
               if (var2 != null) {
                  try {
                     in.close();
                  } catch (Throwable var152) {
                     var2.addSuppressed(var152);
                  }
               } else {
                  in.close();
               }
            }

         }

         return var3;
      case EntityStatus:
         in = packet.reader();
         var2 = null;

         try {
            var3 = in.readInt();
         } catch (Throwable var157) {
            var2 = var157;
            throw var157;
         } finally {
            if (in != null) {
               if (var2 != null) {
                  try {
                     in.close();
                  } catch (Throwable var154) {
                     var2.addSuppressed(var154);
                  }
               } else {
                  in.close();
               }
            }

         }

         return var3;
      case CombatEnd:
         in = packet.reader();
         var2 = null;

         try {
            in.readVarInt();
            if (!packet.atLeast(ProtocolVersion.v1_20)) {
               var3 = in.readInt();
               return var3;
            }

            var3 = null;
         } catch (Throwable var165) {
            var2 = var165;
            throw var165;
         } finally {
            if (in != null) {
               if (var2 != null) {
                  try {
                     in.close();
                  } catch (Throwable var153) {
                     var2.addSuppressed(var153);
                  }
               } else {
                  in.close();
               }
            }

         }

         return var3;
      default:
         return null;
      }
   }
}
