package com.replaymod.lib.org.mortbay.jetty.webapp;

import java.io.Serializable;

public interface Configuration extends Serializable {
   void setWebAppContext(WebAppContext var1);

   WebAppContext getWebAppContext();

   void configureClassLoader() throws Exception;

   void configureDefaults() throws Exception;

   void configureWebApp() throws Exception;

   void deconfigureWebApp() throws Exception;
}
