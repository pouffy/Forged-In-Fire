package com.pouffy.forgedinfire.main.iaf.data;

import com.github.alexthe666.iceandfire.recipe.DragonForgeRecipe;
import com.github.alexthe666.iceandfire.recipe.IafRecipeSerializers;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.pouffy.forgedinfire.ForgedInFire;
import net.minecraft.advancements.Advancement;
import net.minecraft.advancements.AdvancementRewards;
import net.minecraft.advancements.CriterionTriggerInstance;
import net.minecraft.advancements.RequirementsStrategy;
import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import org.jetbrains.annotations.Nullable;

import javax.annotation.ParametersAreNonnullByDefault;
import java.util.function.Consumer;

@ParametersAreNonnullByDefault
public class DragonForgeRecipeBuilder implements RecipeBuilder {
    private final Item result;
    private final Ingredient input;
    private final Ingredient blood;
    private final int cookTime;
    private final String dragonType;
    private final Advancement.Builder advancement = Advancement.Builder.advancement();

    DragonForgeRecipeBuilder(String dragonType, int cookTime, ItemLike input, ItemLike blood, ItemLike result) {
        this.dragonType = dragonType;
        this.cookTime = cookTime;
        this.input = Ingredient.of(input);
        this.blood = Ingredient.of(blood);
        this.result = result.asItem();
    }

    @Override
    public RecipeBuilder unlockedBy(String pCriterionName, CriterionTriggerInstance pCriterionTrigger) {
        this.advancement.addCriterion(pCriterionName, pCriterionTrigger);
        return null;
    }

    @Override
    public RecipeBuilder group(@Nullable String pGroupName) {
        return null;
    }

    @Override
    public Item getResult() {
        return result;
    }

    @Override
    public void save(Consumer<FinishedRecipe> pFinishedRecipeConsumer, ResourceLocation pRecipeId) {
        this.advancement.parent(new ResourceLocation("recipes/root"))
                .addCriterion("has_the_recipe",
                        RecipeUnlockedTrigger.unlocked(pRecipeId))
                .rewards(AdvancementRewards.Builder.recipe(pRecipeId)).requirements(RequirementsStrategy.OR);
        pFinishedRecipeConsumer.accept(new DragonForgeRecipeBuilder.Result(pRecipeId, this.result, this.cookTime, this.dragonType, this.input, this.blood,
                this.advancement, new ResourceLocation(pRecipeId.getNamespace(), "recipes/" +
                this.result.getItemCategory().getRecipeFolderName() + "/" + pRecipeId.getPath())));
    }

    public static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Item result;
        private final Ingredient input;
        private final Ingredient blood;
        private final int cookTime;
        private final String dragonType;
        private final Advancement.Builder advancement;
        private final ResourceLocation advancementId;

        public Result(ResourceLocation id, Item pResult, int cookTime, String dragonType, Ingredient input, Ingredient blood, Advancement.Builder pAdvancement,
                      ResourceLocation pAdvancementId) {
            this.id = id;
            this.result = pResult;
            this.cookTime = cookTime;
            this.input = input;
            this.dragonType = dragonType;
            this.blood = blood;
            this.advancement = pAdvancement;
            this.advancementId = pAdvancementId;
        }
        @Override
        public void serializeRecipeData(JsonObject json) {
            JsonArray inputJsonarray = new JsonArray();
            JsonArray bloodJsonarray = new JsonArray();

            inputJsonarray.add(input.toJson());
            bloodJsonarray.add(blood.toJson());

            json.addProperty("dragon_type", this.dragonType);
            json.addProperty("cook_time", this.cookTime);
            json.add("input", inputJsonarray);
            json.add("blood", bloodJsonarray);
            JsonObject jsonobject = new JsonObject();
            jsonobject.addProperty("item", this.result.getRegistryName().toString());

        }
        @Override
        public ResourceLocation getId() {
            return new ResourceLocation(ForgedInFire.MOD_ID,
                    this.result.getRegistryName().getPath() + "_dragon_forge");
        }

        @Override
        public RecipeSerializer<?> getType() {
            return IafRecipeSerializers.DRAGONFORGE_SERIALIZER.get();
        }

        @javax.annotation.Nullable
        public JsonObject serializeAdvancement() {
            return this.advancement.serializeToJson();
        }

        @javax.annotation.Nullable
        public ResourceLocation getAdvancementId() {
            return this.advancementId;
        }
    }
}
