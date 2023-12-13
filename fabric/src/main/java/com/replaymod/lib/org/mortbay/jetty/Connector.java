package com.replaymod.lib.org.mortbay.jetty;

import com.replaymod.lib.org.mortbay.component.LifeCycle;
import com.replaymod.lib.org.mortbay.io.Buffers;
import com.replaymod.lib.org.mortbay.io.EndPoint;
import com.replaymod.lib.org.mortbay.util.ajax.Continuation;
import java.io.IOException;

public interface Connector extends LifeCycle, Buffers {
   String getName();

   void open() throws IOException;

   void close() throws IOException;

   void setServer(Server var1);

   Server getServer();

   int getHeaderBufferSize();

   void setHeaderBufferSize(int var1);

   int getRequestBufferSize();

   void setRequestBufferSize(int var1);

   int getResponseBufferSize();

   void setResponseBufferSize(int var1);

   int getIntegralPort();

   String getIntegralScheme();

   boolean isIntegral(Request var1);

   int getConfidentialPort();

   String getConfidentialScheme();

   boolean isConfidential(Request var1);

   void customize(EndPoint var1, Request var2) throws IOException;

   void persist(EndPoint var1) throws IOException;

   Continuation newContinuation();

   String getHost();

   void setHost(String var1);

   void setPort(int var1);

   int getPort();

   int getLocalPort();

   int getMaxIdleTime();

   void setMaxIdleTime(int var1);

   int getLowResourceMaxIdleTime();

   void setLowResourceMaxIdleTime(int var1);

   Object getConnection();

   boolean getResolveNames();

   int getRequests();

   long getConnectionsDurationMin();

   long getConnectionsDurationTotal();

   int getConnectionsOpenMin();

   int getConnectionsRequestsMin();

   int getConnections();

   int getConnectionsOpen();

   int getConnectionsOpenMax();

   long getConnectionsDurationAve();

   long getConnectionsDurationMax();

   int getConnectionsRequestsAve();

   int getConnectionsRequestsMax();

   void statsReset();

   void setStatsOn(boolean var1);

   boolean getStatsOn();

   long getStatsOnMs();
}
