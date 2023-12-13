package com.replaymod.lib.org.mortbay.jetty.servlet;

import com.replaymod.lib.org.mortbay.log.Log;
import java.util.Enumeration;
import javax.servlet.Filter;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;

public class FilterHolder extends Holder {
   private transient Filter _filter;
   private transient FilterHolder.Config _config;

   public static int dispatch(String type) {
      if ("request".equalsIgnoreCase(type)) {
         return 1;
      } else if ("forward".equalsIgnoreCase(type)) {
         return 2;
      } else if ("include".equalsIgnoreCase(type)) {
         return 4;
      } else if ("error".equalsIgnoreCase(type)) {
         return 8;
      } else {
         throw new IllegalArgumentException(type);
      }
   }

   public FilterHolder() {
   }

   public FilterHolder(Class filter) {
      super(filter);
   }

   public FilterHolder(Filter filter) {
      this.setFilter(filter);
   }

   public void doStart() throws Exception {
      super.doStart();
      if (!Filter.class.isAssignableFrom(this._class)) {
         String msg = this._class + " is not a javax.servlet.Filter";
         super.stop();
         throw new IllegalStateException(msg);
      } else {
         if (this._filter == null) {
            this._filter = (Filter)this.newInstance();
         }

         this._filter = this.getServletHandler().customizeFilter(this._filter);
         this._config = new FilterHolder.Config();
         this._filter.init(this._config);
      }
   }

   public void doStop() {
      if (this._filter != null) {
         try {
            this.destroyInstance(this._filter);
         } catch (Exception var2) {
            Log.warn((Throwable)var2);
         }
      }

      if (!this._extInstance) {
         this._filter = null;
      }

      this._config = null;
      super.doStop();
   }

   public void destroyInstance(Object o) throws Exception {
      if (o != null) {
         Filter f = (Filter)o;
         f.destroy();
         this.getServletHandler().customizeFilterDestroy(f);
      }
   }

   public synchronized void setFilter(Filter filter) {
      this._filter = filter;
      this._extInstance = true;
      this.setHeldClass(filter.getClass());
      if (this.getName() == null) {
         this.setName(filter.getClass().getName());
      }

   }

   public Filter getFilter() {
      return this._filter;
   }

   public String toString() {
      return this.getName();
   }

   class Config implements FilterConfig {
      public String getFilterName() {
         return FilterHolder.this._name;
      }

      public ServletContext getServletContext() {
         return FilterHolder.this._servletHandler.getServletContext();
      }

      public String getInitParameter(String param) {
         return FilterHolder.this.getInitParameter(param);
      }

      public Enumeration getInitParameterNames() {
         return FilterHolder.this.getInitParameterNames();
      }
   }
}
