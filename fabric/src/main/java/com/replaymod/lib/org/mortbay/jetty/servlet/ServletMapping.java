package com.replaymod.lib.org.mortbay.jetty.servlet;

import java.util.Arrays;

public class ServletMapping {
   private String[] _pathSpecs;
   private String _servletName;

   public String[] getPathSpecs() {
      return this._pathSpecs;
   }

   public String getServletName() {
      return this._servletName;
   }

   public void setPathSpecs(String[] pathSpecs) {
      this._pathSpecs = pathSpecs;
   }

   public void setPathSpec(String pathSpec) {
      this._pathSpecs = new String[]{pathSpec};
   }

   public void setServletName(String servletName) {
      this._servletName = servletName;
   }

   public String toString() {
      return "(S=" + this._servletName + "," + (this._pathSpecs == null ? "[]" : Arrays.asList(this._pathSpecs).toString()) + ")";
   }
}
