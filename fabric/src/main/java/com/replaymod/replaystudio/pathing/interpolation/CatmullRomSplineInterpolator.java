package com.replaymod.replaystudio.pathing.interpolation;

import com.replaymod.replaystudio.pathing.path.Keyframe;
import com.replaymod.replaystudio.pathing.path.PathSegment;
import com.replaymod.replaystudio.pathing.property.Property;
import com.replaymod.replaystudio.pathing.property.PropertyPart;
import java.beans.ConstructorProperties;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.Map.Entry;

public class CatmullRomSplineInterpolator extends AbstractInterpolator {
   private final double alpha;
   private Map<PropertyPart<?>, PolynomialSplineInterpolator.Polynomial[]> cubicPolynomials = new HashMap();
   private Map<Property<?>, Set<Keyframe>> framesToProperty = new HashMap();

   private void addToMap(Property property, Keyframe keyframe) {
      Set<Keyframe> set = (Set)this.framesToProperty.get(property);
      if (set == null) {
         this.framesToProperty.put(property, set = new LinkedHashSet());
      }

      ((Set)set).add(keyframe);
   }

   protected Map<PropertyPart, InterpolationParameters> bakeInterpolation(Map<PropertyPart, InterpolationParameters> parameters) {
      this.framesToProperty.clear();
      Iterator var2 = this.getSegments().iterator();

      while(var2.hasNext()) {
         PathSegment segment = (PathSegment)var2.next();
         Iterator var4 = this.getKeyframeProperties().iterator();

         while(var4.hasNext()) {
            Property property = (Property)var4.next();
            if (segment.getStartKeyframe().getValue(property).isPresent()) {
               this.addToMap(property, segment.getStartKeyframe());
            }

            if (segment.getEndKeyframe().getValue(property).isPresent()) {
               this.addToMap(property, segment.getEndKeyframe());
            }
         }
      }

      this.calcPolynomials();
      Map<PropertyPart, InterpolationParameters> lastParameters = new HashMap();
      Iterator var16 = this.getKeyframeProperties().iterator();

      while(var16.hasNext()) {
         Property<?> property = (Property)var16.next();
         Iterator var18 = property.getParts().iterator();

         while(var18.hasNext()) {
            PropertyPart<?> part = (PropertyPart)var18.next();
            PolynomialSplineInterpolator.Polynomial[] polynomials = (PolynomialSplineInterpolator.Polynomial[])this.cubicPolynomials.get(part);
            PolynomialSplineInterpolator.Polynomial last = polynomials[polynomials.length - 1];
            double value = last.eval(1.0D);
            double velocity = last.derivative().eval(1.0D);
            double acceleration = last.derivative().derivative().eval(1.0D);
            lastParameters.put(part, new InterpolationParameters(value, velocity, acceleration));
         }
      }

      return lastParameters;
   }

   protected void calcPolynomials() {
      Iterator var1 = this.framesToProperty.entrySet().iterator();

      label74:
      while(var1.hasNext()) {
         Entry<Property<?>, Set<Keyframe>> e = (Entry)var1.next();
         Property<?> property = (Property)e.getKey();
         Set<Keyframe> keyframes = (Set)e.getValue();
         Iterator var5 = property.getParts().iterator();

         while(true) {
            PropertyPart part;
            do {
               if (!var5.hasNext()) {
                  continue label74;
               }

               part = (PropertyPart)var5.next();
            } while(!part.isInterpolatable());

            List<Double> values = new ArrayList();
            double p0;
            double p3;
            if (Double.isNaN(part.getUpperBound())) {
               Iterator var23 = keyframes.iterator();

               while(var23.hasNext()) {
                  Keyframe k = (Keyframe)var23.next();
                  values.add(this.getValueAsDouble(k, part));
               }
            } else {
               double bound = part.getUpperBound();
               p0 = bound / 2.0D;
               Iterator<Keyframe> it = keyframes.iterator();
               Double lastValue = null;

               for(Integer offset = null; it.hasNext(); lastValue = p3) {
                  Keyframe keyframe = (Keyframe)it.next();
                  p3 = this.mod(this.getValueAsDouble(keyframe, part), bound);
                  if (lastValue == null) {
                     lastValue = p3;
                     offset = (int)Math.floor(p3 / bound);
                  }

                  if (Math.abs(p3 - lastValue) > p0) {
                     if (lastValue < p0) {
                        offset = offset - 1;
                     } else {
                        offset = offset + 1;
                     }
                  }

                  values.add(p3 + (double)offset * bound);
               }
            }

            PolynomialSplineInterpolator.Polynomial[] polynomials = new PolynomialSplineInterpolator.Polynomial[values.size() - 1];

            for(int i = 0; i < values.size() - 1; ++i) {
               double p1 = (Double)values.get(i);
               double p2 = (Double)values.get(i + 1);
               if (i > 0) {
                  p0 = (Double)values.get(i - 1);
               } else {
                  p0 = p1;
               }

               if (i < keyframes.size() - 2) {
                  p3 = (Double)values.get(i + 2);
               } else {
                  p3 = p2;
               }

               double t0 = this.alpha * (p2 - p0);
               double t1 = this.alpha * (p3 - p1);
               double[] c = new double[]{2.0D * p1 - 2.0D * p2 + t0 + t1, -3.0D * p1 + 3.0D * p2 - 2.0D * t0 - t1, t0, p1};
               polynomials[i] = new PolynomialSplineInterpolator.Polynomial(c);
            }

            this.cubicPolynomials.put(part, polynomials);
         }
      }

   }

   private double mod(double val, double m) {
      double off = Math.floor(val / m);
      return val - off * m;
   }

   private <T> double getValueAsDouble(Keyframe keyframe, PropertyPart<T> part) {
      return part.toDouble(keyframe.getValue(part.getProperty()).get());
   }

   public <T> Optional<T> getValue(Property<T> property, long time) {
      Set<Keyframe> kfSet = (Set)this.framesToProperty.get(property);
      if (kfSet == null) {
         return Optional.empty();
      } else {
         T valueBefore = null;
         long timeBefore = -1L;
         long timeAfter = -1L;
         int index = 0;
         int i = 0;

         for(Iterator var12 = kfSet.iterator(); var12.hasNext(); ++i) {
            Keyframe keyframe = (Keyframe)var12.next();
            if (keyframe.getTime() == time) {
               return keyframe.getValue(property);
            }

            if (keyframe.getTime() < time) {
               index = i;
               timeBefore = keyframe.getTime();
               valueBefore = keyframe.getValue(property).get();
            } else if (keyframe.getTime() > time) {
               timeAfter = keyframe.getTime();
               break;
            }
         }

         if (timeBefore != -1L && timeAfter != -1L) {
            double fraction = (double)(time - timeBefore) / (double)(timeAfter - timeBefore);
            T interpolated = valueBefore;
            Iterator var15 = property.getParts().iterator();

            while(var15.hasNext()) {
               PropertyPart<T> part = (PropertyPart)var15.next();
               if (part.isInterpolatable()) {
                  PolynomialSplineInterpolator.Polynomial[] polynomials = (PolynomialSplineInterpolator.Polynomial[])this.cubicPolynomials.get(part);
                  interpolated = part.fromDouble(interpolated, polynomials[index].eval(fraction));
               }
            }

            return Optional.of(interpolated);
         } else {
            return Optional.empty();
         }
      }
   }

   @ConstructorProperties({"alpha"})
   public CatmullRomSplineInterpolator(double alpha) {
      this.alpha = alpha;
   }

   public double getAlpha() {
      return this.alpha;
   }
}
