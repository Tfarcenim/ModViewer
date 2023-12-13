package com.replaymod.lib.com.fasterxml.jackson.databind.jsontype.impl;

import com.replaymod.lib.com.fasterxml.jackson.databind.BeanDescription;
import com.replaymod.lib.com.fasterxml.jackson.databind.DeserializationContext;
import com.replaymod.lib.com.fasterxml.jackson.databind.JavaType;
import com.replaymod.lib.com.fasterxml.jackson.databind.JsonMappingException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class SubTypeValidator {
   protected static final String PREFIX_SPRING = "org.springframework.";
   protected static final String PREFIX_C3P0 = "com.mchange.v2.c3p0.";
   protected static final Set<String> DEFAULT_NO_DESER_CLASS_NAMES;
   protected Set<String> _cfgIllegalClassNames;
   private static final SubTypeValidator instance;

   protected SubTypeValidator() {
      this._cfgIllegalClassNames = DEFAULT_NO_DESER_CLASS_NAMES;
   }

   public static SubTypeValidator instance() {
      return instance;
   }

   public void validateSubType(DeserializationContext ctxt, JavaType type, BeanDescription beanDesc) throws JsonMappingException {
      Class<?> raw = type.getRawClass();
      String full = raw.getName();
      if (!this._cfgIllegalClassNames.contains(full)) {
         if (raw.isInterface()) {
            return;
         }

         if (full.startsWith("org.springframework.")) {
            Class cls = raw;

            while(true) {
               if (cls == null || cls == Object.class) {
                  return;
               }

               String name = cls.getSimpleName();
               if ("AbstractPointcutAdvisor".equals(name) || "AbstractApplicationContext".equals(name)) {
                  break;
               }

               cls = cls.getSuperclass();
            }
         } else if (!full.startsWith("com.mchange.v2.c3p0.") || !full.endsWith("DataSource")) {
            return;
         }
      }

      ctxt.reportBadTypeDefinition(beanDesc, "Illegal type (%s) to deserialize: prevented for security reasons", full);
   }

   static {
      Set<String> s = new HashSet();
      s.add("org.apache.commons.collections.functors.InvokerTransformer");
      s.add("org.apache.commons.collections.functors.InstantiateTransformer");
      s.add("com.replaymod.lib.org.apache.commons.collections4.functors.InvokerTransformer");
      s.add("com.replaymod.lib.org.apache.commons.collections4.functors.InstantiateTransformer");
      s.add("com.replaymod.lib.org.codehaus.groovy.runtime.ConvertedClosure");
      s.add("com.replaymod.lib.org.codehaus.groovy.runtime.MethodClosure");
      s.add("org.springframework.beans.factory.ObjectFactory");
      s.add("com.sun.org.apache.xalan.internal.xsltc.trax.TemplatesImpl");
      s.add("org.apache.xalan.xsltc.trax.TemplatesImpl");
      s.add("com.sun.rowset.JdbcRowSetImpl");
      s.add("java.util.logging.FileHandler");
      s.add("java.rmi.server.UnicastRemoteObject");
      s.add("org.springframework.beans.factory.config.PropertyPathFactoryBean");
      s.add("org.apache.tomcat.dbcp.dbcp2.BasicDataSource");
      s.add("com.sun.org.apache.bcel.internal.util.ClassLoader");
      s.add("org.hibernate.jmx.StatisticsService");
      s.add("org.apache.ibatis.datasource.jndi.JndiDataSourceFactory");
      s.add("org.apache.ibatis.parsing.XPathParser");
      s.add("jodd.db.connection.DataSourceConnectionProvider");
      s.add("oracle.jdbc.connector.OracleManagedConnectionFactory");
      s.add("oracle.jdbc.rowset.OracleJDBCRowSet");
      s.add("com.replaymod.lib.org.slf4j.ext.EventData");
      s.add("flex.messaging.util.concurrent.AsynchBeansWorkManagerExecutor");
      s.add("com.sun.deploy.security.ruleset.DRSHelper");
      s.add("org.apache.axis2.jaxws.spi.handler.HandlerResolverImpl");
      s.add("org.jboss.util.propertyeditor.DocumentEditor");
      s.add("org.apache.openjpa.ee.RegistryManagedRuntime");
      s.add("org.apache.openjpa.ee.JNDIManagedRuntime");
      s.add("org.apache.axis2.transport.jms.JMSOutTransportInfo");
      DEFAULT_NO_DESER_CLASS_NAMES = Collections.unmodifiableSet(s);
      instance = new SubTypeValidator();
   }
}
