package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.blockconnections.providers;

import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_13to1_12_2.storage.BlockConnectionStorage;

public class PacketBlockConnectionProvider extends BlockConnectionProvider {
   public void storeBlock(UserConnection connection, int x, int y, int z, int blockState) {
      ((BlockConnectionStorage)connection.get(BlockConnectionStorage.class)).store(x, y, z, blockState);
   }

   public void removeBlock(UserConnection connection, int x, int y, int z) {
      ((BlockConnectionStorage)connection.get(BlockConnectionStorage.class)).remove(x, y, z);
   }

   public int getBlockData(UserConnection connection, int x, int y, int z) {
      return ((BlockConnectionStorage)connection.get(BlockConnectionStorage.class)).get(x, y, z);
   }

   public void clearStorage(UserConnection connection) {
      ((BlockConnectionStorage)connection.get(BlockConnectionStorage.class)).clear();
   }

   public void unloadChunk(UserConnection connection, int x, int z) {
      ((BlockConnectionStorage)connection.get(BlockConnectionStorage.class)).unloadChunk(x, z);
   }

   public void unloadChunkSection(UserConnection connection, int chunkX, int chunkY, int chunkZ) {
      ((BlockConnectionStorage)connection.get(BlockConnectionStorage.class)).unloadSection(chunkX, chunkY, chunkZ);
   }

   public boolean storesBlocks() {
      return true;
   }

   public UserBlockData forUser(UserConnection connection) {
      BlockConnectionStorage storage = (BlockConnectionStorage)connection.get(BlockConnectionStorage.class);
      return (x, y, z) -> {
         return storage.get(x, y, z);
      };
   }
}
