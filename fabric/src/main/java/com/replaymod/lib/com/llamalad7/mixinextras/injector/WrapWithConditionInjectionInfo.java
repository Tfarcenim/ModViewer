package com.replaymod.lib.com.llamalad7.mixinextras.injector;

import java.util.Iterator;
import java.util.List;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.AnnotationNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.objectweb.asm.tree.MethodNode;
import org.spongepowered.asm.mixin.injection.code.Injector;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo.AnnotationType;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo.HandlerPrefix;
import org.spongepowered.asm.mixin.injection.struct.InjectionNodes.InjectionNode;
import org.spongepowered.asm.mixin.transformer.MixinTargetContext;

@AnnotationType(WrapWithCondition.class)
@HandlerPrefix("wrapWithCondition")
public class WrapWithConditionInjectionInfo extends InjectionInfo {
   static final String POPPED_OPERATION_DECORATOR = "mixinextras_operationIsImmediatelyPopped";

   public WrapWithConditionInjectionInfo(MixinTargetContext mixin, MethodNode method, AnnotationNode annotation) {
      super(mixin, method, annotation);
   }

   protected Injector parseInjector(AnnotationNode injectAnnotation) {
      return new WrapWithConditionInjector(this);
   }

   public void prepare() {
      super.prepare();
      Iterator var1 = this.targetNodes.values().iterator();

      while(var1.hasNext()) {
         List<InjectionNode> nodeList = (List)var1.next();
         Iterator var3 = nodeList.iterator();

         while(var3.hasNext()) {
            InjectionNode node = (InjectionNode)var3.next();
            AbstractInsnNode currentTarget = node.getCurrentTarget();
            if (currentTarget instanceof MethodInsnNode) {
               Type returnType = Type.getReturnType(((MethodInsnNode)currentTarget).desc);
               if (this.isTypePoppedByInstruction(returnType, currentTarget.getNext())) {
                  node.decorate("mixinextras_operationIsImmediatelyPopped", true);
               }
            }
         }
      }

   }

   private boolean isTypePoppedByInstruction(Type type, AbstractInsnNode insn) {
      switch(type.getSize()) {
      case 1:
         return insn.getOpcode() == 87;
      case 2:
         return insn.getOpcode() == 88;
      default:
         return false;
      }
   }
}
