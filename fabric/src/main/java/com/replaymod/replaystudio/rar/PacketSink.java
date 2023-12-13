package com.replaymod.replaystudio.rar;

import com.replaymod.replaystudio.protocol.Packet;
import java.util.function.Consumer;

public interface PacketSink extends Consumer<Packet> {
}
