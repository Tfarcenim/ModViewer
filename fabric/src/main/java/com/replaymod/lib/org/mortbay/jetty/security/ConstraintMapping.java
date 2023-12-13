package com.replaymod.lib.org.mortbay.jetty.security;

public class ConstraintMapping {
   String method;
   String pathSpec;
   Constraint constraint;

   public Constraint getConstraint() {
      return this.constraint;
   }

   public void setConstraint(Constraint constraint) {
      this.constraint = constraint;
   }

   public String getMethod() {
      return this.method;
   }

   public void setMethod(String method) {
      this.method = method;
   }

   public String getPathSpec() {
      return this.pathSpec;
   }

   public void setPathSpec(String pathSpec) {
      this.pathSpec = pathSpec;
   }
}
