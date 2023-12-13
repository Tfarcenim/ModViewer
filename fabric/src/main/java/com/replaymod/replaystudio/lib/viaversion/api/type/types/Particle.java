package com.replaymod.replaystudio.lib.viaversion.api.type.types;

import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import java.util.ArrayList;
import java.util.List;

public class Particle {
   private List<Particle.ParticleData> arguments = new ArrayList(4);
   private int id;

   public Particle(int id) {
      this.id = id;
   }

   public int getId() {
      return this.id;
   }

   public void setId(int id) {
      this.id = id;
   }

   public List<Particle.ParticleData> getArguments() {
      return this.arguments;
   }

   /** @deprecated */
   @Deprecated
   public void setArguments(List<Particle.ParticleData> arguments) {
      this.arguments = arguments;
   }

   public <T> void add(Type<T> type, T value) {
      this.arguments.add(new Particle.ParticleData(type, value));
   }

   public static class ParticleData {
      private Type type;
      private Object value;

      public ParticleData(Type type, Object value) {
         this.type = type;
         this.value = value;
      }

      public Type getType() {
         return this.type;
      }

      public void setType(Type type) {
         this.type = type;
      }

      public Object getValue() {
         return this.value;
      }

      public <T> T get() {
         return this.value;
      }

      public void setValue(Object value) {
         this.value = value;
      }

      public String toString() {
         return "ParticleData{type=" + this.type + ", value=" + this.value + '}';
      }
   }
}
