package com.replaymod.lib.com.fasterxml.jackson.databind.deser;

import com.replaymod.lib.com.fasterxml.jackson.databind.BeanDescription;
import com.replaymod.lib.com.fasterxml.jackson.databind.DeserializationConfig;

public interface ValueInstantiators {
   ValueInstantiator findValueInstantiator(DeserializationConfig var1, BeanDescription var2, ValueInstantiator var3);

   public static class Base implements ValueInstantiators {
      public ValueInstantiator findValueInstantiator(DeserializationConfig config, BeanDescription beanDesc, ValueInstantiator defaultInstantiator) {
         return defaultInstantiator;
      }
   }
}
