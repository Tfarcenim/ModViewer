package com.replaymod.replaystudio.pathing.interpolation;

import com.replaymod.replaystudio.pathing.path.Keyframe;
import com.replaymod.replaystudio.pathing.path.PathSegment;
import com.replaymod.replaystudio.pathing.property.Property;
import com.replaymod.replaystudio.pathing.property.PropertyPart;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public class LinearInterpolator extends AbstractInterpolator {
   private Map<Property, Set<Keyframe>> framesToProperty = new HashMap();

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

      Iterator var4;
      Property property;
      while(var2.hasNext()) {
         PathSegment segment = (PathSegment)var2.next();
         var4 = this.getKeyframeProperties().iterator();

         while(var4.hasNext()) {
            property = (Property)var4.next();
            if (segment.getStartKeyframe().getValue(property).isPresent()) {
               this.addToMap(property, segment.getStartKeyframe());
            }

            if (segment.getEndKeyframe().getValue(property).isPresent()) {
               this.addToMap(property, segment.getEndKeyframe());
            }
         }
      }

      Keyframe lastKeyframe = ((PathSegment)this.getSegments().get(this.getSegments().size() - 1)).getEndKeyframe();
      Map<PropertyPart, InterpolationParameters> lastParameters = new HashMap();
      var4 = this.getKeyframeProperties().iterator();

      while(true) {
         Optional optionalValue;
         do {
            if (!var4.hasNext()) {
               return lastParameters;
            }

            property = (Property)var4.next();
            optionalValue = lastKeyframe.getValue(property);
         } while(!optionalValue.isPresent());

         Object value = optionalValue.get();
         Iterator var8 = property.getParts().iterator();

         while(var8.hasNext()) {
            PropertyPart part = (PropertyPart)var8.next();
            lastParameters.put(part, new InterpolationParameters(part.toDouble(value), 1.0D, 0.0D));
         }
      }
   }

   public <T> Optional<T> getValue(Property<T> property, long time) {
      Set<Keyframe> kfSet = (Set)this.framesToProperty.get(property);
      if (kfSet == null) {
         return Optional.empty();
      } else {
         Keyframe kfBefore = null;
         Keyframe kfAfter = null;
         Iterator var7 = kfSet.iterator();

         while(var7.hasNext()) {
            Keyframe keyframe = (Keyframe)var7.next();
            if (keyframe.getTime() == time) {
               return keyframe.getValue(property);
            }

            if (keyframe.getTime() < time) {
               kfBefore = keyframe;
            } else if (keyframe.getTime() > time) {
               kfAfter = keyframe;
               break;
            }
         }

         if (kfBefore != null && kfAfter != null) {
            T valueBefore = kfBefore.getValue(property).get();
            T valueAfter = kfAfter.getValue(property).get();
            double fraction = (double)(time - kfBefore.getTime()) / (double)(kfAfter.getTime() - kfBefore.getTime());
            T interpolated = valueBefore;
            Iterator var12 = property.getParts().iterator();

            while(var12.hasNext()) {
               PropertyPart<T> part = (PropertyPart)var12.next();
               if (part.isInterpolatable()) {
                  double before = part.toDouble(valueBefore);
                  double after = part.toDouble(valueAfter);
                  double bound = part.getUpperBound();
                  if (!Double.isNaN(bound)) {
                     before = this.mod(before, bound);
                     after = this.mod(after, bound);
                     if (Math.abs(after - before) > bound / 2.0D) {
                        if (before < bound / 2.0D) {
                           after -= bound;
                        } else {
                           after += bound;
                        }
                     }
                  }

                  double value = (after - before) * fraction + before;
                  if (!Double.isNaN(bound)) {
                     value = this.mod(value, bound);
                  }

                  interpolated = part.fromDouble(interpolated, value);
               }
            }

            return Optional.of(interpolated);
         } else {
            return Optional.empty();
         }
      }
   }

   private double mod(double val, double m) {
      double off = Math.floor(val / m);
      return val - off * m;
   }
}
