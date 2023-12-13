package com.replaymod.lib.org.mortbay.jetty.security;

import com.replaymod.lib.org.mortbay.jetty.Request;
import com.replaymod.lib.org.mortbay.jetty.Response;
import java.security.Principal;

public interface SSORealm {
   Credential getSingleSignOn(Request var1, Response var2);

   void setSingleSignOn(Request var1, Response var2, Principal var3, Credential var4);

   void clearSingleSignOn(String var1);
}
