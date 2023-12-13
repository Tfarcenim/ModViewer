package com.replaymod.replaystudio.lib.viaversion.protocol;

import com.replaymod.replaystudio.lib.guava.collect.Sets;
import com.replaymod.replaystudio.lib.viaversion.api.Via;
import com.replaymod.replaystudio.lib.viaversion.api.connection.UserConnection;
import com.replaymod.replaystudio.lib.viaversion.api.debug.DebugHandler;
import com.replaymod.replaystudio.lib.viaversion.api.platform.ViaPlatform;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.AbstractSimpleProtocol;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.Protocol;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.ProtocolPipeline;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.Direction;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.State;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Level;
import org.checkerframework.checker.nullness.qual.Nullable;

public class ProtocolPipelineImpl extends AbstractSimpleProtocol implements ProtocolPipeline {
   private final UserConnection userConnection;
   private List<Protocol> protocolList;
   private Set<Class<? extends Protocol>> protocolSet;

   public ProtocolPipelineImpl(UserConnection userConnection) {
      this.userConnection = userConnection;
      userConnection.getProtocolInfo().setPipeline(this);
      this.registerPackets();
   }

   protected void registerPackets() {
      this.protocolList = new CopyOnWriteArrayList();
      this.protocolSet = Sets.newSetFromMap(new ConcurrentHashMap());
      Protocol baseProtocol = Via.getManager().getProtocolManager().getBaseProtocol();
      this.protocolList.add(baseProtocol);
      this.protocolSet.add(baseProtocol.getClass());
   }

   public void init(UserConnection userConnection) {
      throw new UnsupportedOperationException("ProtocolPipeline can only be initialized once");
   }

   public void add(Protocol protocol) {
      this.protocolList.add(protocol);
      this.protocolSet.add(protocol.getClass());
      protocol.init(this.userConnection);
      if (!protocol.isBaseProtocol()) {
         this.moveBaseProtocolsToTail();
      }

   }

   public void add(Collection<Protocol> protocols) {
      this.protocolList.addAll(protocols);
      Iterator var2 = protocols.iterator();

      while(var2.hasNext()) {
         Protocol protocol = (Protocol)var2.next();
         protocol.init(this.userConnection);
         this.protocolSet.add(protocol.getClass());
      }

      this.moveBaseProtocolsToTail();
   }

   private void moveBaseProtocolsToTail() {
      List<Protocol> baseProtocols = null;
      Iterator var2 = this.protocolList.iterator();

      while(var2.hasNext()) {
         Protocol protocol = (Protocol)var2.next();
         if (protocol.isBaseProtocol()) {
            if (baseProtocols == null) {
               baseProtocols = new ArrayList();
            }

            baseProtocols.add(protocol);
         }
      }

      if (baseProtocols != null) {
         this.protocolList.removeAll(baseProtocols);
         this.protocolList.addAll(baseProtocols);
      }

   }

   public void transform(Direction direction, State state, PacketWrapper packetWrapper) throws Exception {
      int originalID = packetWrapper.getId();
      DebugHandler debugHandler = Via.getManager().debugHandler();
      if (debugHandler.enabled() && !debugHandler.logPostPacketTransform() && debugHandler.shouldLog(packetWrapper, direction)) {
         this.logPacket(direction, state, packetWrapper, originalID);
      }

      packetWrapper.apply(direction, state, 0, this.protocolList, direction == Direction.CLIENTBOUND);
      super.transform(direction, state, packetWrapper);
      if (debugHandler.enabled() && debugHandler.logPostPacketTransform() && debugHandler.shouldLog(packetWrapper, direction)) {
         this.logPacket(direction, state, packetWrapper, originalID);
      }

   }

   private void logPacket(Direction direction, State state, PacketWrapper packetWrapper, int originalID) {
      int clientProtocol = this.userConnection.getProtocolInfo().getProtocolVersion();
      ViaPlatform<?> platform = Via.getPlatform();
      String actualUsername = packetWrapper.user().getProtocolInfo().getUsername();
      String username = actualUsername != null ? actualUsername + " " : "";
      platform.getLogger().log(Level.INFO, "{0}{1} {2}: {3} ({4}) -> {5} ({6}) [{7}] {8}", new Object[]{username, direction, state, originalID, AbstractSimpleProtocol.toNiceHex(originalID), packetWrapper.getId(), AbstractSimpleProtocol.toNiceHex(packetWrapper.getId()), Integer.toString(clientProtocol), packetWrapper});
   }

   public boolean contains(Class<? extends Protocol> protocolClass) {
      return this.protocolSet.contains(protocolClass);
   }

   @Nullable
   public <P extends Protocol> P getProtocol(Class<P> pipeClass) {
      Iterator var2 = this.protocolList.iterator();

      Protocol protocol;
      do {
         if (!var2.hasNext()) {
            return null;
         }

         protocol = (Protocol)var2.next();
      } while(protocol.getClass() != pipeClass);

      return protocol;
   }

   public List<Protocol> pipes() {
      return this.protocolList;
   }

   public boolean hasNonBaseProtocols() {
      Iterator var1 = this.protocolList.iterator();

      Protocol protocol;
      do {
         if (!var1.hasNext()) {
            return false;
         }

         protocol = (Protocol)var1.next();
      } while(protocol.isBaseProtocol());

      return true;
   }

   public void cleanPipes() {
      this.registerPackets();
   }
}
