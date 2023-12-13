package com.replaymod.lib.org.aspectj.lang.reflect;

import java.lang.reflect.Field;

public interface FieldSignature extends MemberSignature {
   Class getFieldType();

   Field getField();
}
