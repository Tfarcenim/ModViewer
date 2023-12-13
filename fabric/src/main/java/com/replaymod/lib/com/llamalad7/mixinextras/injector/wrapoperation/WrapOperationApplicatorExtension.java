package com.replaymod.lib.com.llamalad7.mixinextras.injector.wrapoperation;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.transformer.ext.IExtension;
import org.spongepowered.asm.mixin.transformer.ext.ITargetClassContext;

public class WrapOperationApplicatorExtension implements IExtension {
   static Map<ITargetClassContext, List<WrapOperationInjectionInfo>> QUEUED_INJECTIONS = Collections.synchronizedMap(new WeakHashMap());

   public boolean checkActive(MixinEnvironment environment) {
      return true;
   }

   public void preApply(ITargetClassContext context) {
   }

   public void postApply(ITargetClassContext context) {
      List<WrapOperationInjectionInfo> queuedInjections = (List)QUEUED_INJECTIONS.get(context);
      if (queuedInjections != null) {
         Iterator var3 = queuedInjections.iterator();

         while(var3.hasNext()) {
            WrapOperationInjectionInfo injection = (WrapOperationInjectionInfo)var3.next();
            injection.lateApply();
         }
      }

   }

   public void export(MixinEnvironment env, String name, boolean force, ClassNode classNode) {
   }
}
