package com.replaymod.replaystudio.lib.viaversion.protocols.protocol1_19_3to1_19_1.rewriter;

import com.replaymod.replaystudio.lib.viaversion.api.minecraft.item.Item;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.Protocol;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.ClientboundPacketType;
import com.replaymod.replaystudio.lib.viaversion.api.protocol.packet.PacketWrapper;
import com.replaymod.replaystudio.lib.viaversion.api.type.Type;
import com.replaymod.replaystudio.lib.viaversion.rewriter.RecipeRewriter;

public class RecipeRewriter1_19_3<C extends ClientboundPacketType> extends RecipeRewriter<C> {
   public RecipeRewriter1_19_3(Protocol<C, ?, ?, ?> protocol) {
      super(protocol);
      this.recipeHandlers.put("crafting_special_armordye", this::handleSimpleRecipe);
      this.recipeHandlers.put("crafting_special_bookcloning", this::handleSimpleRecipe);
      this.recipeHandlers.put("crafting_special_mapcloning", this::handleSimpleRecipe);
      this.recipeHandlers.put("crafting_special_mapextending", this::handleSimpleRecipe);
      this.recipeHandlers.put("crafting_special_firework_rocket", this::handleSimpleRecipe);
      this.recipeHandlers.put("crafting_special_firework_star", this::handleSimpleRecipe);
      this.recipeHandlers.put("crafting_special_firework_star_fade", this::handleSimpleRecipe);
      this.recipeHandlers.put("crafting_special_tippedarrow", this::handleSimpleRecipe);
      this.recipeHandlers.put("crafting_special_bannerduplicate", this::handleSimpleRecipe);
      this.recipeHandlers.put("crafting_special_shielddecoration", this::handleSimpleRecipe);
      this.recipeHandlers.put("crafting_special_shulkerboxcoloring", this::handleSimpleRecipe);
      this.recipeHandlers.put("crafting_special_suspiciousstew", this::handleSimpleRecipe);
      this.recipeHandlers.put("crafting_special_repairitem", this::handleSimpleRecipe);
   }

   public void handleCraftingShapeless(PacketWrapper wrapper) throws Exception {
      wrapper.passthrough(Type.STRING);
      wrapper.passthrough(Type.VAR_INT);
      this.handleIngredients(wrapper);
      this.rewrite((Item)wrapper.passthrough(Type.FLAT_VAR_INT_ITEM));
   }

   public void handleCraftingShaped(PacketWrapper wrapper) throws Exception {
      int ingredients = (Integer)wrapper.passthrough(Type.VAR_INT) * (Integer)wrapper.passthrough(Type.VAR_INT);
      wrapper.passthrough(Type.STRING);
      wrapper.passthrough(Type.VAR_INT);

      for(int i = 0; i < ingredients; ++i) {
         this.handleIngredient(wrapper);
      }

      this.rewrite((Item)wrapper.passthrough(Type.FLAT_VAR_INT_ITEM));
   }

   public void handleSmelting(PacketWrapper wrapper) throws Exception {
      wrapper.passthrough(Type.STRING);
      wrapper.passthrough(Type.VAR_INT);
      this.handleIngredient(wrapper);
      this.rewrite((Item)wrapper.passthrough(Type.FLAT_VAR_INT_ITEM));
      wrapper.passthrough(Type.FLOAT);
      wrapper.passthrough(Type.VAR_INT);
   }
}
