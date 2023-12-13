package com.replaymod.core.utils;

import com.replaymod.replaystudio.data.ModInfo;
import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;

class ModInfoGetter {
   static Collection<ModInfo> getInstalledNetworkMods() {
      Map<String, ModInfo> modInfoMap = (Map)FabricLoader.getInstance().getAllMods().stream().map(ModContainer::getMetadata).map((m) -> {
         return new ModInfo(m.getId(), m.getName(), m.getVersion().toString());
      }).collect(Collectors.toMap(ModInfo::getId, Function.identity()));
      Stream var10000 = BuiltInRegistries.REGISTRY.stream().map(Registry::keySet).flatMap(Collection::stream).map(ResourceLocation::getNamespace).filter((s) -> {
         return !s.equals("minecraft");
      }).distinct();
      Objects.requireNonNull(modInfoMap);
      return (Collection)var10000.map(modInfoMap::get).filter(Objects::nonNull).collect(Collectors.toList());
   }
}
