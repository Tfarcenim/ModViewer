package com.replaymod.lib.com.googlecode.mp4parser.util;

import com.replaymod.lib.com.coremedia.iso.IsoTypeReader;
import com.replaymod.lib.com.coremedia.iso.IsoTypeWriter;
import java.nio.ByteBuffer;

public class Matrix {
   double u;
   double v;
   double w;
   double a;
   double b;
   double c;
   double d;
   double tx;
   double ty;
   public static final Matrix ROTATE_0 = new Matrix(1.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D);
   public static final Matrix ROTATE_90 = new Matrix(0.0D, 1.0D, -1.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D);
   public static final Matrix ROTATE_180 = new Matrix(-1.0D, 0.0D, 0.0D, -1.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D);
   public static final Matrix ROTATE_270 = new Matrix(0.0D, -1.0D, 1.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D, 0.0D);

   public Matrix(double a, double b, double c, double d, double u, double v, double w, double tx, double ty) {
      this.u = u;
      this.v = v;
      this.w = w;
      this.a = a;
      this.b = b;
      this.c = c;
      this.d = d;
      this.tx = tx;
      this.ty = ty;
   }

   public boolean equals(Object o) {
      if (this == o) {
         return true;
      } else if (o != null && this.getClass() == o.getClass()) {
         Matrix matrix = (Matrix)o;
         if (Double.compare(matrix.a, this.a) != 0) {
            return false;
         } else if (Double.compare(matrix.b, this.b) != 0) {
            return false;
         } else if (Double.compare(matrix.c, this.c) != 0) {
            return false;
         } else if (Double.compare(matrix.d, this.d) != 0) {
            return false;
         } else if (Double.compare(matrix.tx, this.tx) != 0) {
            return false;
         } else if (Double.compare(matrix.ty, this.ty) != 0) {
            return false;
         } else if (Double.compare(matrix.u, this.u) != 0) {
            return false;
         } else if (Double.compare(matrix.v, this.v) != 0) {
            return false;
         } else {
            return Double.compare(matrix.w, this.w) == 0;
         }
      } else {
         return false;
      }
   }

   public int hashCode() {
      long temp = Double.doubleToLongBits(this.u);
      int result = (int)(temp ^ temp >>> 32);
      temp = Double.doubleToLongBits(this.v);
      result = 31 * result + (int)(temp ^ temp >>> 32);
      temp = Double.doubleToLongBits(this.w);
      result = 31 * result + (int)(temp ^ temp >>> 32);
      temp = Double.doubleToLongBits(this.a);
      result = 31 * result + (int)(temp ^ temp >>> 32);
      temp = Double.doubleToLongBits(this.b);
      result = 31 * result + (int)(temp ^ temp >>> 32);
      temp = Double.doubleToLongBits(this.c);
      result = 31 * result + (int)(temp ^ temp >>> 32);
      temp = Double.doubleToLongBits(this.d);
      result = 31 * result + (int)(temp ^ temp >>> 32);
      temp = Double.doubleToLongBits(this.tx);
      result = 31 * result + (int)(temp ^ temp >>> 32);
      temp = Double.doubleToLongBits(this.ty);
      result = 31 * result + (int)(temp ^ temp >>> 32);
      return result;
   }

   public String toString() {
      if (this.equals(ROTATE_0)) {
         return "Rotate 0°";
      } else if (this.equals(ROTATE_90)) {
         return "Rotate 90°";
      } else if (this.equals(ROTATE_180)) {
         return "Rotate 180°";
      } else {
         return this.equals(ROTATE_270) ? "Rotate 270°" : "Matrix{u=" + this.u + ", v=" + this.v + ", w=" + this.w + ", a=" + this.a + ", b=" + this.b + ", c=" + this.c + ", d=" + this.d + ", tx=" + this.tx + ", ty=" + this.ty + '}';
      }
   }

   public static Matrix fromFileOrder(double a, double b, double u, double c, double d, double v, double tx, double ty, double w) {
      return new Matrix(a, b, c, d, u, v, w, tx, ty);
   }

   public static Matrix fromByteBuffer(ByteBuffer byteBuffer) {
      return fromFileOrder(IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint0230(byteBuffer), IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint0230(byteBuffer), IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint1616(byteBuffer), IsoTypeReader.readFixedPoint0230(byteBuffer));
   }

   public void getContent(ByteBuffer byteBuffer) {
      IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.a);
      IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.b);
      IsoTypeWriter.writeFixedPoint0230(byteBuffer, this.u);
      IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.c);
      IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.d);
      IsoTypeWriter.writeFixedPoint0230(byteBuffer, this.v);
      IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.tx);
      IsoTypeWriter.writeFixedPoint1616(byteBuffer, this.ty);
      IsoTypeWriter.writeFixedPoint0230(byteBuffer, this.w);
   }
}
