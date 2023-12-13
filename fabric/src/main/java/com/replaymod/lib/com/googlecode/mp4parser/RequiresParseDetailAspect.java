package com.replaymod.lib.com.googlecode.mp4parser;

import com.replaymod.lib.org.aspectj.lang.JoinPoint;
import com.replaymod.lib.org.aspectj.lang.NoAspectBoundException;
import com.replaymod.lib.org.aspectj.lang.annotation.Aspect;
import com.replaymod.lib.org.aspectj.lang.annotation.Before;

@Aspect
public class RequiresParseDetailAspect {
   // $FF: synthetic field
   private static Throwable ajc$initFailureCause;
   // $FF: synthetic field
   public static final RequiresParseDetailAspect ajc$perSingletonInstance;

   @Before("this(com.googlecode.mp4parser.AbstractBox) && ((execution(public * * (..)) && !( execution(* parseDetails()) || execution(* getNumOfBytesToFirstChild()) || execution(* getType()) || execution(* isParsed()) || execution(* getHeader(*)) || execution(* parse()) || execution(* getBox(*)) || execution(* getSize()) || execution(* getOffset()) || execution(* parseDetails()) || execution(* _parseDetails(*)) || execution(* parse(*,*,*,*)) || execution(* getIsoFile()) || execution(* getParent()) || execution(* setParent(*)) || execution(* getUserType()) || execution(* setUserType(*))) && !@annotation(com.googlecode.mp4parser.annotations.DoNotParseDetail)) || @annotation(com.googlecode.mp4parser.annotations.ParseDetail))")
   public void before(JoinPoint joinPoint) {
      if (joinPoint.getTarget() instanceof AbstractBox) {
         if (!((AbstractBox)joinPoint.getTarget()).isParsed()) {
            ((AbstractBox)joinPoint.getTarget()).parseDetails();
         }

      } else {
         throw new RuntimeException("Only methods in subclasses of " + AbstractBox.class.getName() + " can  be annotated with ParseDetail");
      }
   }

   public static RequiresParseDetailAspect aspectOf() {
      if (ajc$perSingletonInstance == null) {
         throw new NoAspectBoundException("com.replaymod.lib.com.googlecode.mp4parser.RequiresParseDetailAspect", ajc$initFailureCause);
      } else {
         return ajc$perSingletonInstance;
      }
   }

   public static boolean hasAspect() {
      return ajc$perSingletonInstance != null;
   }

   // $FF: synthetic method
   private static void ajc$postClinit() {
      ajc$perSingletonInstance = new RequiresParseDetailAspect();
   }

   static {
      try {
         ajc$postClinit();
      } catch (Throwable var1) {
         ajc$initFailureCause = var1;
      }

   }
}
