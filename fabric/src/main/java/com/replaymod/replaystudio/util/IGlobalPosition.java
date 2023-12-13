package com.replaymod.replaystudio.util;

import java.util.Objects;

public class IGlobalPosition {
   private final String dimension;
   private final IPosition position;

   public IGlobalPosition(String dimension, IPosition position) {
      this.dimension = dimension;
      this.position = position;
   }

   public String getDimension() {
      return this.dimension;
   }

   public IPosition getPosition() {
      return this.position;
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         IGlobalPosition that = (IGlobalPosition)o;
         return this.dimension.equals(that.dimension) && this.position.equals(that.position);
      } else {
         return false;
      }
   }

   public int hashCode() {
      return Objects.hash(new Object[]{this.dimension, this.position});
   }

   public String toString() {
      return "IGlobalPosition{dimension='" + this.dimension + '\'' + ", position=" + this.position + '}';
   }
}
