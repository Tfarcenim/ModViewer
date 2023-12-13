package com.replaymod.lib.com.google.api.services.youtube.model;

import com.replaymod.lib.com.google.api.client.json.GenericJson;
import com.replaymod.lib.com.google.api.client.util.Key;

public final class GeoPoint extends GenericJson {
   @Key
   private Double altitude;
   @Key
   private Double latitude;
   @Key
   private Double longitude;

   public Double getAltitude() {
      return this.altitude;
   }

   public GeoPoint setAltitude(Double var1) {
      this.altitude = var1;
      return this;
   }

   public Double getLatitude() {
      return this.latitude;
   }

   public GeoPoint setLatitude(Double var1) {
      this.latitude = var1;
      return this;
   }

   public Double getLongitude() {
      return this.longitude;
   }

   public GeoPoint setLongitude(Double var1) {
      this.longitude = var1;
      return this;
   }

   public GeoPoint set(String var1, Object var2) {
      return (GeoPoint)super.set(var1, var2);
   }

   public GeoPoint clone() {
      return (GeoPoint)super.clone();
   }
}
