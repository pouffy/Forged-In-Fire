package com.pouffy.forgedinfire.main.tools.data;

import com.pouffy.forgedinfire.ForgedInFire;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import slimeknights.tconstruct.library.data.recipe.IRecipeHelper;

import java.util.function.Consumer;

public abstract class BaseRecipeProvider extends RecipeProvider implements IConditionBuilder, IRecipeHelper {
    public BaseRecipeProvider(DataGenerator generator) {
        super(generator);
        ForgedInFire.sealForgedClass(this, "BaseRecipeProvider", "BaseRecipeProvider is trivial to recreate and directly extending can lead to addon recipes polluting our namespace.");
    }

    protected abstract void buildCraftingRecipes(Consumer<FinishedRecipe> var1);

    public abstract String getName();

    public String getModId() {
        return "forgedinfire";
    }
}
