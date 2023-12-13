package com.replaymod.lib.com.fasterxml.jackson.databind.ser.std;

import com.replaymod.lib.com.fasterxml.jackson.core.JsonGenerator;
import com.replaymod.lib.com.fasterxml.jackson.databind.SerializerProvider;
import com.replaymod.lib.com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Calendar;

@JacksonStdImpl
public class CalendarSerializer extends DateTimeSerializerBase<Calendar> {
   public static final CalendarSerializer instance = new CalendarSerializer();

   public CalendarSerializer() {
      this((Boolean)null, (DateFormat)null);
   }

   public CalendarSerializer(Boolean useTimestamp, DateFormat customFormat) {
      super(Calendar.class, useTimestamp, customFormat);
   }

   public CalendarSerializer withFormat(Boolean timestamp, DateFormat customFormat) {
      return new CalendarSerializer(timestamp, customFormat);
   }

   protected long _timestamp(Calendar value) {
      return value == null ? 0L : value.getTimeInMillis();
   }

   public void serialize(Calendar value, JsonGenerator g, SerializerProvider provider) throws IOException {
      if (this._asTimestamp(provider)) {
         g.writeNumber(this._timestamp(value));
      } else {
         this._serializeAsString(value.getTime(), g, provider);
      }
   }
}
