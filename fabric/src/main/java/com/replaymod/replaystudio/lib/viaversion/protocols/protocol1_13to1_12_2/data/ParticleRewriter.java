package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.data;

import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.DataItem;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.api.type.types.Particle;
import com.replaymod.replaystudio.lib.viaversion.libs.opennbt.tag.builtin.CompoundTag;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.Protocol1_13To1_12_2;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.packets.WorldPackets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class ParticleRewriter {
   private static final List<ParticleRewriter.NewParticle> particles = new ArrayList();

   public static Particle rewriteParticle(int particleId, Integer[] data) {
      if (particleId >= particles.size()) {
         Via.getPlatform().getLogger().severe("Failed to transform particles with id " + particleId + " and data " + Arrays.toString(data));
         return null;
      } else {
         ParticleRewriter.NewParticle rewrite = (ParticleRewriter.NewParticle)particles.get(particleId);
         return rewrite.handle(new Particle(rewrite.getId()), data);
      }
   }

   private static void add(int newId) {
      particles.add(new ParticleRewriter.NewParticle(newId, (ParticleRewriter.ParticleDataHandler)null));
   }

   private static void add(int newId, ParticleRewriter.ParticleDataHandler dataHandler) {
      particles.add(new ParticleRewriter.NewParticle(newId, dataHandler));
   }

   private static ParticleRewriter.ParticleDataHandler reddustHandler() {
      return new ParticleRewriter.ParticleDataHandler() {
         public Particle handler(Particle particle, Integer[] data) {
            particle.getArguments().add(new Particle.ParticleData(Type.FLOAT, ParticleRewriter.randomBool() ? 1.0F : 0.0F));
            particle.getArguments().add(new Particle.ParticleData(Type.FLOAT, 0.0F));
            particle.getArguments().add(new Particle.ParticleData(Type.FLOAT, ParticleRewriter.randomBool() ? 1.0F : 0.0F));
            particle.getArguments().add(new Particle.ParticleData(Type.FLOAT, 1.0F));
            return particle;
         }
      };
   }

   private static boolean randomBool() {
      return ThreadLocalRandom.current().nextBoolean();
   }

   private static ParticleRewriter.ParticleDataHandler iconcrackHandler() {
      return new ParticleRewriter.ParticleDataHandler() {
         public Particle handler(Particle particle, Integer[] data) {
            DataItem item;
            if (data.length == 1) {
               item = new DataItem(data[0], (byte)1, (short)0, (CompoundTag)null);
            } else {
               if (data.length != 2) {
                  return particle;
               }

               item = new DataItem(data[0], (byte)1, data[1].shortValue(), (CompoundTag)null);
            }

            ((Protocol1_13To1_12_2)Via.getManager().getProtocolManager().getProtocol(Protocol1_13To1_12_2.class)).getItemRewriter().handleItemToClient(item);
            particle.getArguments().add(new Particle.ParticleData(Type.FLAT_ITEM, item));
            return particle;
         }
      };
   }

   private static ParticleRewriter.ParticleDataHandler blockHandler() {
      return new ParticleRewriter.ParticleDataHandler() {
         public Particle handler(Particle particle, Integer[] data) {
            int value = data[0];
            int combined = (value & 4095) << 4 | value >> 12 & 15;
            int newId = WorldPackets.toNewId(combined);
            particle.getArguments().add(new Particle.ParticleData(Type.VAR_INT, newId));
            return particle;
         }
      };
   }

   static {
      add(34);
      add(19);
      add(18);
      add(21);
      add(4);
      add(43);
      add(22);
      add(42);
      add(42);
      add(6);
      add(14);
      add(37);
      add(30);
      add(12);
      add(26);
      add(17);
      add(0);
      add(44);
      add(10);
      add(9);
      add(1);
      add(24);
      add(32);
      add(33);
      add(35);
      add(15);
      add(23);
      add(31);
      add(-1);
      add(5);
      add(11, reddustHandler());
      add(29);
      add(34);
      add(28);
      add(25);
      add(2);
      add(27, iconcrackHandler());
      add(3, blockHandler());
      add(3, blockHandler());
      add(36);
      add(-1);
      add(13);
      add(8);
      add(16);
      add(7);
      add(40);
      add(20, blockHandler());
      add(41);
      add(38);
   }

   private static class NewParticle {
      private final int id;
      private final ParticleRewriter.ParticleDataHandler handler;

      public NewParticle(int id, ParticleRewriter.ParticleDataHandler handler) {
         this.id = id;
         this.handler = handler;
      }

      public Particle handle(Particle particle, Integer[] data) {
         return this.handler != null ? this.handler.handler(particle, data) : particle;
      }

      public int getId() {
         return this.id;
      }

      public ParticleRewriter.ParticleDataHandler getHandler() {
         return this.handler;
      }
   }

   interface ParticleDataHandler {
      Particle handler(Particle var1, Integer[] var2);
   }
}
