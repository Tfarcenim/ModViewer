package com.replaymod.lib.com.llamalad7.mixinextras.injector.wrapoperation;

import com.replaymod.lib.com.llamalad7.mixinextras.utils.CompatibilityHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.MethodNode;
import org.spongepowered.asm.mixin.injection.code.Injector;
import org.spongepowered.asm.mixin.injection.points.BeforeConstant;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo.AnnotationType;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo.HandlerPrefix;
import org.spongepowered.asm.mixin.transformer.MixinTargetContext;
import org.spongepowered.asm.util.Annotations;

@AnnotationType(WrapOperation.class)
@HandlerPrefix("wrapOperation")
public class WrapOperationInjectionInfo extends InjectionInfo {
   public WrapOperationInjectionInfo(MixinTargetContext mixin, MethodNode method, AnnotationNode annotation) {
      super(mixin, method, annotation, determineAtKey(mixin, method, annotation));
   }

   protected Injector parseInjector(AnnotationNode injectAnnotation) {
      return new WrapOperationInjector(this);
   }

   public void inject() {
      ((List)WrapOperationApplicatorExtension.QUEUED_INJECTIONS.computeIfAbsent(this.mixin.getTarget(), (k) -> {
         return new ArrayList();
      })).add(this);
   }

   public void postInject() {
   }

   public void lateApply() {
      super.inject();
      super.postInject();
   }

   protected void parseInjectionPoints(List<AnnotationNode> ats) {
      if (this.atKey.equals("at")) {
         super.parseInjectionPoints(ats);
      } else {
         Type returnType = Type.getReturnType(this.method.desc);
         Iterator var3 = ats.iterator();

         while(var3.hasNext()) {
            AnnotationNode at = (AnnotationNode)var3.next();
            this.injectionPoints.add(new BeforeConstant(CompatibilityHelper.getMixin(this), at, returnType.getDescriptor()));
         }

      }
   }

   private static String determineAtKey(MixinTargetContext mixin, MethodNode method, AnnotationNode annotation) {
      boolean at = Annotations.getValue(annotation, "at") != null;
      boolean constant = Annotations.getValue(annotation, "constant") != null;
      if (at == constant) {
         throw new IllegalStateException(String.format("@WrapOperation injector %s::%s must specify exactly one of `at` and `constant`, got %s.", mixin.getMixin().getClassName(), method.name, at ? "both" : "neither"));
      } else {
         return at ? "at" : "constant";
      }
   }
}
