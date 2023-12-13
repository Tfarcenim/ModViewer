package com.replaymod.lib.org.mortbay.jetty.security;

import com.replaymod.lib.org.mortbay.jetty.Request;
import java.security.Principal;

public interface UserRealm {
   String getName();

   Principal getPrincipal(String var1);

   Principal authenticate(String var1, Object var2, Request var3);

   boolean reauthenticate(Principal var1);

   boolean isUserInRole(Principal var1, String var2);

   void disassociate(Principal var1);

   Principal pushRole(Principal var1, String var2);

   Principal popRole(Principal var1);

   void logout(Principal var1);
}
