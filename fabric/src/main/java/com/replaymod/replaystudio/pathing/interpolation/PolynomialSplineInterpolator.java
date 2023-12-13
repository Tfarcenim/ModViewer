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
import java.util.Map.Entry;

public abstract class PolynomialSplineInterpolator extends AbstractInterpolator {
   private final int degree;
   private Map<Property<?>, Set<Keyframe>> framesToProperty = new HashMap();
   private Map<PropertyPart, PolynomialSplineInterpolator.Polynomials> polynomials = new HashMap();

   protected PolynomialSplineInterpolator(int degree) {
      this.degree = degree;
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
               this.addToMap(this.framesToProperty, property, segment.getStartKeyframe());
            }

            if (segment.getEndKeyframe().getValue(property).isPresent()) {
               this.addToMap(this.framesToProperty, property, segment.getEndKeyframe());
            }
         }
      }

      this.polynomials.clear();
      Map<PropertyPart, InterpolationParameters> parameters = new HashMap(parameters);
      var2 = this.framesToProperty.entrySet().iterator();

      while(var2.hasNext()) {
         Entry<Property<?>, Set<Keyframe>> entry = (Entry)var2.next();
         this.prepareProperty((Property)entry.getKey(), (Set)entry.getValue(), parameters);
      }

      return parameters;
   }

   private <U> void prepareProperty(Property<U> property, Set<Keyframe> keyframes, Map<PropertyPart, InterpolationParameters> parameters) {
      Iterator var4 = property.getParts().iterator();

      while(true) {
         PropertyPart part;
         do {
            if (!var4.hasNext()) {
               return;
            }

            part = (PropertyPart)var4.next();
         } while(!part.isInterpolatable());

         double[] time = new double[keyframes.size()];
         double[] values = new double[keyframes.size()];
         int i = 0;

         Keyframe keyframe;
         for(Iterator var9 = keyframes.iterator(); var9.hasNext(); values[i++] = part.toDouble(keyframe.getValue(property).get())) {
            keyframe = (Keyframe)var9.next();
            time[i] = (double)keyframe.getTime();
         }

         PolynomialSplineInterpolator.Polynomials polynomials = this.calcPolynomials(part, time, values, (InterpolationParameters)parameters.get(part));
         double lastTime = time[time.length - 1];
         PolynomialSplineInterpolator.Polynomial lastPolynomial = polynomials.polynomials[polynomials.polynomials.length - 1];
         double lastValue = lastPolynomial.eval(lastTime) + polynomials.yOffset;
         double lastVelocity = (lastPolynomial = lastPolynomial.derivative()).eval(lastTime);
         double lastAcceleration = lastPolynomial.derivative().eval(lastTime);
         parameters.put(part, new InterpolationParameters(lastValue, lastVelocity, lastAcceleration));
         this.polynomials.put(part, polynomials);
      }
   }

   private void addToMap(Map<Property<?>, Set<Keyframe>> map, Property property, Keyframe keyframe) {
      Set<Keyframe> set = (Set)map.get(property);
      if (set == null) {
         map.put(property, set = new LinkedHashSet());
      }

      ((Set)set).add(keyframe);
   }

   protected <U> PolynomialSplineInterpolator.Polynomials calcPolynomials(PropertyPart<U> part, double[] xs, double[] ys, InterpolationParameters params) {
      int unknowns = this.degree + 1;
      int num = xs.length - 1;
      if (num == 0) {
         return new PolynomialSplineInterpolator.Polynomials(0.0D, new PolynomialSplineInterpolator.Polynomial[]{new PolynomialSplineInterpolator.Polynomial(new double[]{ys[0]})});
      } else {
         for(int i = 0; i < xs.length; ++i) {
            xs[i] /= 1000.0D;
         }

         double bound;
         int j;
         double yOffset;
         int i;
         if (Double.isNaN(part.getUpperBound())) {
            bound = 0.0D;
            double[] var11 = ys;
            int var12 = ys.length;

            for(j = 0; j < var12; ++j) {
               double y = var11[j];
               bound += y;
            }

            yOffset = bound / (double)ys.length;

            for(i = 0; i < ys.length; ++i) {
               ys[i] -= yOffset;
            }

            if (params != null) {
               params = new InterpolationParameters(params.getValue() - yOffset, params.getVelocity(), params.getAcceleration());
            }
         } else {
            bound = part.getUpperBound();
            double halfBound = bound / 2.0D;
            double firstValue = params != null ? params.getValue() : ys[0];
            int offset = (int)Math.floor(firstValue / bound);
            double lastValue = this.mod(firstValue, bound);

            for(int i = 1; i < ys.length; ++i) {
               double value = this.mod(ys[i], bound);
               if (Math.abs(value - lastValue) > halfBound) {
                  if (lastValue < halfBound) {
                     --offset;
                  } else {
                     ++offset;
                  }
               }

               ys[i] = value + (double)offset * bound;
               lastValue = value;
            }

            yOffset = 0.0D;
         }

         double[][] matrix = new double[num * unknowns][num * unknowns + 1];
         this.fillMatrix(matrix, xs, ys, num, params);
         solveMatrix(matrix);
         PolynomialSplineInterpolator.Polynomial[] polynomials = new PolynomialSplineInterpolator.Polynomial[num];

         for(i = 0; i < num; ++i) {
            double[] coefficients = new double[this.degree + 1];

            for(j = 0; j <= this.degree; ++j) {
               coefficients[j] = matrix[i * unknowns + j][num * unknowns];
            }

            polynomials[i] = new PolynomialSplineInterpolator.Polynomial(coefficients);
         }

         return new PolynomialSplineInterpolator.Polynomials(yOffset, polynomials);
      }
   }

   private double mod(double val, double m) {
      double off = Math.floor(val / m);
      return val - off * m;
   }

   protected abstract void fillMatrix(double[][] var1, double[] var2, double[] var3, int var4, InterpolationParameters var5);

   protected static void solveMatrix(double[][] matrix) {
      int i;
      int j;
      for(i = 0; i < matrix.length; ++i) {
         if (matrix[i][i] == 0.0D) {
            for(j = i + 1; j < matrix.length; ++j) {
               if (matrix[j][i] != 0.0D) {
                  double[] s = matrix[j];
                  matrix[j] = matrix[i];
                  matrix[i] = s;
                  break;
               }
            }
         }

         double factor = matrix[i][i];
         int j;
         if (factor != 1.0D) {
            matrix[i][i] = 1.0D;

            for(j = i + 1; j < matrix[i].length; ++j) {
               matrix[i][j] /= factor;
            }
         }

         for(j = i + 1; j < matrix.length; ++j) {
            factor = matrix[j][i];
            if (factor != 0.0D) {
               matrix[j][i] = 0.0D;

               for(int k = i + 1; k < matrix[j].length; ++k) {
                  matrix[j][k] -= matrix[i][k] * factor;
               }
            }
         }
      }

      for(i = matrix.length - 1; i >= 0; --i) {
         for(j = i - 1; j >= 0; --j) {
            if (matrix[j][i] != 0.0D) {
               int k = matrix[j].length - 1;
               matrix[j][k] -= matrix[j][i] / matrix[i][i] * matrix[i][k];
               matrix[j][i] = 0.0D;
            }
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
         int index = 0;

         for(Iterator var8 = kfSet.iterator(); var8.hasNext(); ++index) {
            Keyframe keyframe = (Keyframe)var8.next();
            if (keyframe.getTime() == time) {
               return keyframe.getValue(property);
            }

            if (keyframe.getTime() < time) {
               kfBefore = keyframe;
            } else if (keyframe.getTime() > time) {
               kfAfter = keyframe;
               --index;
               break;
            }
         }

         if (kfBefore != null && kfAfter != null) {
            T interpolated = kfBefore.getValue(property).get();
            Iterator var14 = property.getParts().iterator();

            while(var14.hasNext()) {
               PropertyPart<T> part = (PropertyPart)var14.next();
               if (part.isInterpolatable()) {
                  double value = ((PolynomialSplineInterpolator.Polynomials)this.polynomials.get(part)).eval((double)time, index);
                  if (!Double.isNaN(part.getUpperBound())) {
                     value = this.mod(value, part.getUpperBound());
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

   public static class Polynomial {
      public final double[] coefficients;

      public Polynomial(double[] coefficients) {
         this.coefficients = coefficients;
      }

      public double eval(double at) {
         double val = 0.0D;
         double[] var5 = this.coefficients;
         int var6 = var5.length;

         for(int var7 = 0; var7 < var6; ++var7) {
            double coefficient = var5[var7];
            val = val * at + coefficient;
         }

         return val;
      }

      public PolynomialSplineInterpolator.Polynomial derivative() {
         if (this.coefficients.length == 0) {
            return this;
         } else {
            PolynomialSplineInterpolator.Polynomial derived = new PolynomialSplineInterpolator.Polynomial(new double[this.coefficients.length - 1]);

            for(int i = 0; i < this.coefficients.length - 1; ++i) {
               derived.coefficients[i] = this.coefficients[i] * (double)(this.coefficients.length - 1 - i);
            }

            return derived;
         }
      }
   }

   private static class Polynomials {
      private final double yOffset;
      private final PolynomialSplineInterpolator.Polynomial[] polynomials;

      private Polynomials(double yOffset, PolynomialSplineInterpolator.Polynomial[] polynomials) {
         this.yOffset = yOffset;
         this.polynomials = polynomials;
      }

      public double eval(double time, int index) {
         return this.polynomials[index].eval(time / 1000.0D) + this.yOffset;
      }

      // $FF: synthetic method
      Polynomials(double x0, PolynomialSplineInterpolator.Polynomial[] x1, Object x2) {
         this(x0, x1);
      }
   }
}
