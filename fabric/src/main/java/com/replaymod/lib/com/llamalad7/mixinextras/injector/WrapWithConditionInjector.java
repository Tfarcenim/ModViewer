package com.replaymod.lib.com.llamalad7.mixinextras.injector;

import com.replaymod.lib.com.llamalad7.mixinextras.utils.CompatibilityHelper;
import com.replaymod.lib.com.llamalad7.mixinextras.utils.InjectorUtils;
import com.replaymod.lib.org.apache.commons.lang3.ArrayUtils;
import org.objectweb.asm.Type;
import org.objectweb.asm.tree.AbstractInsnNode;
import org.objectweb.asm.tree.FieldInsnNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.JumpInsnNode;
import org.objectweb.asm.tree.LabelNode;
import org.objectweb.asm.tree.MethodInsnNode;
import org.spongepowered.asm.mixin.injection.code.Injector;
import org.spongepowered.asm.mixin.injection.code.Injector.InjectorData;
import org.spongepowered.asm.mixin.injection.struct.InjectionInfo;
import org.spongepowered.asm.mixin.injection.struct.Target;
import org.spongepowered.asm.mixin.injection.struct.InjectionNodes.InjectionNode;

public class WrapWithConditionInjector extends Injector {
   public WrapWithConditionInjector(InjectionInfo info) {
      super(info, "@WrapWithCondition");
   }

   protected void inject(Target target, InjectionNode node) {
      this.checkTargetIsLogicallyVoid(target, node);
      this.checkTargetModifiers(target, false);
      this.wrapTargetWithCondition(target, node);
   }

   private void checkTargetIsLogicallyVoid(Target target, InjectionNode node) {
      if (!node.hasDecoration("mixinextras_operationIsImmediatelyPopped")) {
         Type returnType = this.getReturnType(node.getCurrentTarget());
         if (returnType == null) {
            throw CompatibilityHelper.makeInvalidInjectionException(this.info, String.format("%s annotation is targeting an invalid insn in %s in %s", this.annotationType, target, this));
         } else if (returnType != Type.VOID_TYPE) {
            throw CompatibilityHelper.makeInvalidInjectionException(this.info, String.format("%s annotation is targeting an instruction with a non-void return type in %s in %s", this.annotationType, target, this));
         }
      }
   }

   private void wrapTargetWithCondition(Target target, InjectionNode node) {
      AbstractInsnNode currentTarget = node.getCurrentTarget();
      Type returnType = this.getReturnType(currentTarget);
      Type[] originalArgTypes = this.getEffectiveArgTypes(node.getOriginalTarget());
      Type[] currentArgTypes = this.getEffectiveArgTypes(currentTarget);
      InsnList before = new InsnList();
      InsnList after = new InsnList();
      boolean isVirtualRedirect = InjectorUtils.isVirtualRedirect(node);
      this.invokeHandler(target, returnType, originalArgTypes, currentArgTypes, isVirtualRedirect, before, after);
      target.wrapNode(currentTarget, currentTarget, before, after);
   }

   private void invokeHandler(Target target, Type returnType, Type[] originalArgTypes, Type[] currentArgTypes, boolean isVirtualRedirect, InsnList before, InsnList after) {
      InjectorData handler = new InjectorData(target, "condition wrapper");
      this.validateParams(handler, Type.BOOLEAN_TYPE, originalArgTypes);
      int[] argMap = this.storeArgs(target, currentArgTypes, before, 0);
      int[] handlerArgMap = ArrayUtils.addAll(argMap, target.getArgIndices());
      if (isVirtualRedirect) {
         handlerArgMap = ArrayUtils.remove((int[])handlerArgMap, 0);
      }

      this.invokeHandlerWithArgs(this.methodArgs, before, handlerArgMap);
      LabelNode afterOperation = new LabelNode();
      LabelNode afterDummy = new LabelNode();
      before.add(new JumpInsnNode(153, afterOperation));
      this.pushArgs(currentArgTypes, before, argMap, 0, argMap.length);
      after.add(new JumpInsnNode(167, afterDummy));
      after.add(afterOperation);
      if (returnType != Type.VOID_TYPE) {
         after.add(new InsnNode(this.getDummyOpcodeForType(returnType)));
      }

      after.add(afterDummy);
   }

   private Type getReturnType(AbstractInsnNode node) {
      if (node instanceof MethodInsnNode) {
         MethodInsnNode methodInsnNode = (MethodInsnNode)node;
         return Type.getReturnType(methodInsnNode.desc);
      } else if (node instanceof FieldInsnNode) {
         FieldInsnNode fieldInsnNode = (FieldInsnNode)node;
         return fieldInsnNode.getOpcode() != 180 && fieldInsnNode.getOpcode() != 178 ? Type.VOID_TYPE : Type.getType(fieldInsnNode.desc);
      } else {
         return null;
      }
   }

   private Type[] getEffectiveArgTypes(AbstractInsnNode node) {
      if (node instanceof MethodInsnNode) {
         MethodInsnNode methodInsnNode = (MethodInsnNode)node;
         return node.getOpcode() == 184 ? Type.getArgumentTypes(methodInsnNode.desc) : (Type[])ArrayUtils.addAll((Object[])(new Type[]{Type.getObjectType(methodInsnNode.owner)}), (Object[])Type.getArgumentTypes(methodInsnNode.desc));
      } else {
         if (node instanceof FieldInsnNode) {
            FieldInsnNode fieldInsnNode = (FieldInsnNode)node;
            if (fieldInsnNode.getOpcode() == 181) {
               return new Type[]{Type.getObjectType(fieldInsnNode.owner), Type.getType(fieldInsnNode.desc)};
            }

            if (fieldInsnNode.getOpcode() == 179) {
               return new Type[]{Type.getType(fieldInsnNode.desc)};
            }
         }

         throw new UnsupportedOperationException();
      }
   }

   private int getDummyOpcodeForType(Type type) {
      switch(type.getSort()) {
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
         return 3;
      case 6:
         return 11;
      case 7:
         return 9;
      case 8:
         return 14;
      case 9:
      case 10:
         return 1;
      default:
         throw new UnsupportedOperationException();
      }
   }
}
