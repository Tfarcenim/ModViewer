package com.replaymod.lib.org.mortbay.jetty.security;

import com.replaymod.lib.org.mortbay.jetty.Request;
import com.replaymod.lib.org.mortbay.jetty.Response;
import java.io.IOException;
import java.io.Serializable;
import java.security.Principal;

public interface Authenticator extends Serializable {
   Principal authenticate(UserRealm var1, String var2, Request var3, Response var4) throws IOException;

   String getAuthMethod();
}
