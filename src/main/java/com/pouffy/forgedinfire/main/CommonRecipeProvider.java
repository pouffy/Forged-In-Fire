package com.pouffy.forgedinfire.main;

import com.pouffy.forgedinfire.main.tools.data.BaseRecipeProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.world.item.Items;
import slimeknights.mantle.recipe.data.ICommonRecipeHelper;
import slimeknights.tconstruct.shared.TinkerCommons;

import java.util.function.Consumer;

public class CommonRecipeProvider extends BaseRecipeProvider implements ICommonRecipeHelper {
    public CommonRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    public String getName() {
        return "Tinkers' Construct Common Recipes";
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        this.addCommonRecipes(consumer);
        //this.addMaterialRecipes(consumer);
    }
    private void addCommonRecipes(Consumer<FinishedRecipe> consumer) {
        ShapelessRecipeBuilder.shapeless(ForgedCommons.draconicWeaponry)
                .requires(Items.BOOK)
                .requires(ForgedTags.Items.DRAGON_SCALES)
                .unlockedBy("has_item", has(ForgedTags.Items.DRAGON_SCALES))
                .save(consumer, prefix(ForgedCommons.draconicWeaponry, "common/"));
    }
}
