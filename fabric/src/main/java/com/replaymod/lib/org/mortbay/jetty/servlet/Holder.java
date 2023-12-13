package com.replaymod.lib.org.mortbay.jetty.servlet;

import com.replaymod.lib.org.mortbay.component.AbstractLifeCycle;
import com.replaymod.lib.org.mortbay.log.Log;
import com.replaymod.lib.org.mortbay.util.Loader;
import java.io.Serializable;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.UnavailableException;

public class Holder extends AbstractLifeCycle implements Serializable {
   protected transient Class _class;
   protected String _className;
   protected String _displayName;
   protected Map _initParams;
   protected boolean _extInstance;
   protected String _name;
   protected ServletHandler _servletHandler;

   protected Holder() {
   }

   protected Holder(Class held) {
      this._class = held;
      if (held != null) {
         this._className = held.getName();
         this._name = held.getName() + "-" + this.hashCode();
      }

   }

   public void doStart() throws Exception {
      if (this._class != null || this._className != null && !this._className.equals("")) {
         if (this._class == null) {
            try {
               this._class = Loader.loadClass(Holder.class, this._className);
               if (Log.isDebugEnabled()) {
                  Log.debug("Holding {}", this._class);
               }
            } catch (Exception var2) {
               Log.warn((Throwable)var2);
               throw new UnavailableException(var2.getMessage(), -1);
            }
         }

      } else {
         throw new UnavailableException("No class for Servlet or Filter", -1);
      }
   }

   public void doStop() {
      if (!this._extInstance) {
         this._class = null;
      }

   }

   public String getClassName() {
      return this._className;
   }

   public Class getHeldClass() {
      return this._class;
   }

   public String getDisplayName() {
      return this._displayName;
   }

   public String getInitParameter(String param) {
      return this._initParams == null ? null : (String)this._initParams.get(param);
   }

   public Enumeration getInitParameterNames() {
      return this._initParams == null ? Collections.enumeration(Collections.EMPTY_LIST) : Collections.enumeration(this._initParams.keySet());
   }

   public Map getInitParameters() {
      return this._initParams;
   }

   public String getName() {
      return this._name;
   }

   public ServletHandler getServletHandler() {
      return this._servletHandler;
   }

   public synchronized Object newInstance() throws InstantiationException, IllegalAccessException {
      if (this._class == null) {
         throw new InstantiationException("!" + this._className);
      } else {
         return this._class.newInstance();
      }
   }

   public void destroyInstance(Object instance) throws Exception {
   }

   public void setClassName(String className) {
      this._className = className;
      this._class = null;
   }

   public void setHeldClass(Class held) {
      this._class = held;
      this._className = held != null ? held.getName() : null;
   }

   public void setDisplayName(String name) {
      this._displayName = name;
   }

   public void setInitParameter(String param, String value) {
      if (this._initParams == null) {
         this._initParams = new HashMap(3);
      }

      this._initParams.put(param, value);
   }

   public void setInitParameters(Map map) {
      this._initParams = map;
   }

   public void setName(String name) {
      this._name = name;
   }

   public void setServletHandler(ServletHandler servletHandler) {
      this._servletHandler = servletHandler;
   }

   public String toString() {
      return this._name;
   }
}
