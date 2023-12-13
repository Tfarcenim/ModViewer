package com.replaymod.replaystudio.pathing.interpolation;

import java.beans.ConstructorProperties;

public class InterpolationParameters {
   private final double value;
   private final double velocity;
   private final double acceleration;

   @ConstructorProperties({"value", "velocity", "acceleration"})
   public InterpolationParameters(double value, double velocity, double acceleration) {
      this.value = value;
      this.velocity = velocity;
      this.acceleration = acceleration;
   }

   public double getValue() {
      return this.value;
   }

   public double getVelocity() {
      return this.velocity;
   }

   public double getAcceleration() {
      return this.acceleration;
   }

   public boolean equals(Object o) {
      if (o == this) {
         return true;
      } else if (!(o instanceof InterpolationParameters)) {
         return false;
      } else {
         InterpolationParameters other = (InterpolationParameters)o;
         if (!other.canEqual(this)) {
            return false;
         } else if (Double.compare(this.getValue(), other.getValue()) != 0) {
            return false;
         } else if (Double.compare(this.getVelocity(), other.getVelocity()) != 0) {
            return false;
         } else {
            return Double.compare(this.getAcceleration(), other.getAcceleration()) == 0;
         }
      }
   }

   protected boolean canEqual(Object other) {
      return other instanceof InterpolationParameters;
   }

   public int hashCode() {
      int PRIME = true;
      int result = 1;
      long $value = Double.doubleToLongBits(this.getValue());
      int result = result * 59 + (int)($value >>> 32 ^ $value);
      long $velocity = Double.doubleToLongBits(this.getVelocity());
      result = result * 59 + (int)($velocity >>> 32 ^ $velocity);
      long $acceleration = Double.doubleToLongBits(this.getAcceleration());
      result = result * 59 + (int)($acceleration >>> 32 ^ $acceleration);
      return result;
   }

   public String toString() {
      return "InterpolationParameters(value=" + this.getValue() + ", velocity=" + this.getVelocity() + ", acceleration=" + this.getAcceleration() + ")";
   }
}
