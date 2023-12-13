package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_4to1_19_3.storage;

import com.replaymod.replaystudio.lib.viaversion.api.connection.StoredObject;
import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;

public class PlayerVehicleTracker extends StoredObject {
   private int vehicleId = -1;

   public PlayerVehicleTracker(UserConnection user) {
      super(user);
   }

   public int getVehicleId() {
      return this.vehicleId;
   }

   public void setVehicleId(int vehicleId) {
      this.vehicleId = vehicleId;
   }
}
