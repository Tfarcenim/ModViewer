package com.replaymod.lib.com.fasterxml.jackson.databind.node;

import com.replaymod.lib.com.fasterxml.jackson.core.JsonParser;
import java.math.BigDecimal;
import java.math.BigInteger;

public abstract class NumericNode extends ValueNode {
   protected NumericNode() {
   }

   public final JsonNodeType getNodeType() {
      return JsonNodeType.NUMBER;
   }

   public abstract JsonParser.NumberType numberType();

   public abstract Number numberValue();

   public abstract int intValue();

   public abstract long longValue();

   public abstract double doubleValue();

   public abstract BigDecimal decimalValue();

   public abstract BigInteger bigIntegerValue();

   public abstract boolean canConvertToInt();

   public abstract boolean canConvertToLong();

   public abstract String asText();

   public final int asInt() {
      return this.intValue();
   }

   public final int asInt(int defaultValue) {
      return this.intValue();
   }

   public final long asLong() {
      return this.longValue();
   }

   public final long asLong(long defaultValue) {
      return this.longValue();
   }

   public final double asDouble() {
      return this.doubleValue();
   }

   public final double asDouble(double defaultValue) {
      return this.doubleValue();
   }

   public boolean isNaN() {
      return false;
   }
}
