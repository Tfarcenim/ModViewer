package com.replaymod.lib.com.fasterxml.jackson.databind.type;

import com.replaymod.lib.com.fasterxml.jackson.databind.JavaType;
import java.lang.reflect.Type;

public abstract class TypeModifier {
   public abstract JavaType modifyType(JavaType var1, Type var2, TypeBindings var3, TypeFactory var4);
}
