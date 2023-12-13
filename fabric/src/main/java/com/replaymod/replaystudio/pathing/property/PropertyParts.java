package com.replaymod.replaystudio.pathing.property;

import com.replaymod.lib.org.apache.commons.lang3.tuple.Triple;

public class PropertyParts {
   private PropertyParts() {
   }

   public static enum TripleElement {
      LEFT,
      MIDDLE,
      RIGHT;
   }

   public static class ForFloatTriple extends AbstractPropertyPart<Triple<Float, Float, Float>> {
      private final PropertyParts.TripleElement element;

      public ForFloatTriple(Property<Triple<Float, Float, Float>> property, boolean interpolatable, PropertyParts.TripleElement element) {
         super(property, interpolatable);
         this.element = element;
      }

      public ForFloatTriple(Property<Triple<Float, Float, Float>> property, boolean interpolatable, float upperBound, PropertyParts.TripleElement element) {
         super(property, interpolatable, (double)upperBound);
         this.element = element;
      }

      public double toDouble(Triple<Float, Float, Float> value) {
         switch(this.element) {
         case LEFT:
            return (double)(Float)value.getLeft();
         case MIDDLE:
            return (double)(Float)value.getMiddle();
         case RIGHT:
            return (double)(Float)value.getRight();
         default:
            throw new AssertionError(this.element);
         }
      }

      public Triple<Float, Float, Float> fromDouble(Triple<Float, Float, Float> value, double d) {
         switch(this.element) {
         case LEFT:
            return Triple.of((float)d, value.getMiddle(), value.getRight());
         case MIDDLE:
            return Triple.of(value.getLeft(), (float)d, value.getRight());
         case RIGHT:
            return Triple.of(value.getLeft(), value.getMiddle(), (float)d);
         default:
            throw new AssertionError(this.element);
         }
      }
   }

   public static class ForDoubleTriple extends AbstractPropertyPart<Triple<Double, Double, Double>> {
      private final PropertyParts.TripleElement element;

      public ForDoubleTriple(Property<Triple<Double, Double, Double>> property, boolean interpolatable, PropertyParts.TripleElement element) {
         super(property, interpolatable);
         this.element = element;
      }

      public ForDoubleTriple(Property<Triple<Double, Double, Double>> property, boolean interpolatable, double upperBound, PropertyParts.TripleElement element) {
         super(property, interpolatable, upperBound);
         this.element = element;
      }

      public double toDouble(Triple<Double, Double, Double> value) {
         switch(this.element) {
         case LEFT:
            return (Double)value.getLeft();
         case MIDDLE:
            return (Double)value.getMiddle();
         case RIGHT:
            return (Double)value.getRight();
         default:
            throw new AssertionError(this.element);
         }
      }

      public Triple<Double, Double, Double> fromDouble(Triple<Double, Double, Double> value, double d) {
         switch(this.element) {
         case LEFT:
            return Triple.of(d, value.getMiddle(), value.getRight());
         case MIDDLE:
            return Triple.of(value.getLeft(), d, value.getRight());
         case RIGHT:
            return Triple.of(value.getLeft(), value.getMiddle(), d);
         default:
            throw new AssertionError(this.element);
         }
      }
   }

   public static class ForInteger extends AbstractPropertyPart<Integer> {
      public ForInteger(Property<Integer> property, boolean interpolatable) {
         super(property, interpolatable);
      }

      public ForInteger(Property<Integer> property, boolean interpolatable, int upperBound) {
         super(property, interpolatable, (double)upperBound);
      }

      public double toDouble(Integer value) {
         return (double)value;
      }

      public Integer fromDouble(Integer value, double d) {
         return (int)Math.round(d);
      }
   }
}
