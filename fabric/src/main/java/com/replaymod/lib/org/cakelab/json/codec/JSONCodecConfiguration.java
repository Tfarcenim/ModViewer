package com.replaymod.lib.org.cakelab.json.codec;

import java.nio.charset.Charset;

public class JSONCodecConfiguration {
   public Charset charset;
   public boolean ignoreNull;
   public boolean ignoreMissingFields;
   public boolean considerClassAttribute;
   public JSONStringFormatterConfiguration format;

   public JSONCodecConfiguration(Charset charset, boolean ignoreNull, boolean ignoreMissingFields, boolean considerClassAttribute) {
      this.charset = Charset.defaultCharset();
      this.ignoreNull = false;
      this.ignoreMissingFields = false;
      this.considerClassAttribute = false;
      this.format = new JSONStringFormatterConfiguration();
      this.charset = charset;
      this.ignoreNull = ignoreNull;
      this.ignoreMissingFields = ignoreMissingFields;
      this.considerClassAttribute = considerClassAttribute;
   }

   public JSONCodecConfiguration(Charset charset, boolean ignoreNull, boolean ignoreMissingFields) {
      this(charset, ignoreNull, ignoreMissingFields, false);
   }

   public JSONCodecConfiguration(Charset charset, boolean ignoreNull) {
      this(charset, ignoreNull, false, false);
   }

   public JSONCodecConfiguration(Charset charset) {
      this(charset, false, false, false);
   }

   public JSONCodecConfiguration(boolean ignoreNull, boolean ignoreMissingFields, boolean considerClassAttribute) {
      this(Charset.defaultCharset(), ignoreNull, ignoreMissingFields, considerClassAttribute);
   }

   public JSONCodecConfiguration(boolean ignoreNull, boolean ignoreMissingFields) {
      this(Charset.defaultCharset(), ignoreNull, ignoreMissingFields, false);
   }

   public JSONCodecConfiguration(boolean ignoreNull) {
      this(Charset.defaultCharset(), ignoreNull, false, false);
   }

   public JSONCodecConfiguration() {
      this(Charset.defaultCharset(), false, false, false);
   }
}
