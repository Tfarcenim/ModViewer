package com.replaymod.render.mixin;

import com.replaymod.render.capturer.IrisODSFrameCapturer;
import java.nio.file.Path;
import net.coderbot.iris.Iris;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;

@Pseudo
@Mixin(
   value = {Iris.class},
   remap = false
)
public class Mixin_LoadIrisOdsShaderPack {
   @Redirect(
      method = {"loadExternalShaderpack"},
      at = @At(
   value = "INVOKE",
   target = "Lnet/coderbot/iris/Iris;getShaderpacksDirectory()Ljava/nio/file/Path;"
)
   )
   private static Path loadReplayModOdsPack(String name) {
      return IrisODSFrameCapturer.INSTANCE != null && "assets/replaymod/iris/ods".equals(name) ? ((ModContainer)FabricLoader.getInstance().getModContainer("replaymod").orElseThrow(() -> {
         return new RuntimeException("Failed to get mod container for ReplayMod");
      })).getRootPath() : Iris.getShaderpacksDirectory();
   }
}
