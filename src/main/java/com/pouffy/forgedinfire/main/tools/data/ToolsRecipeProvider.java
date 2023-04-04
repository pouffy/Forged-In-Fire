package com.pouffy.forgedinfire.main.tools.data;

import com.pouffy.forgedinfire.main.tools.ForgedToolParts;
import com.pouffy.forgedinfire.main.tools.ForgedTools;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;
import slimeknights.tconstruct.library.data.recipe.IToolRecipeHelper;

import java.util.function.Consumer;

public class ToolsRecipeProvider extends BaseRecipeProvider implements IMaterialRecipeHelper, IToolRecipeHelper {
    public ToolsRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    public String getName() {
        return "Forged In Fire Tool Recipes";
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        this.addToolBuildingRecipes(consumer);
        this.addPartRecipes(consumer);
    }
    private void addToolBuildingRecipes(Consumer<FinishedRecipe> consumer) {
        String folder = "tools/building/";
        String repairFolder = "tools/repair/";
        String armorFolder = "armor/building/";
        String armorRepairFolder = "armor/repair/";
        toolBuilding(consumer, ForgedTools.glaive , folder);

    }
    private void addPartRecipes(Consumer<FinishedRecipe> consumer) {
        String partFolder = "tools/parts/";
        String castFolder = "smeltery/casts/";
    }
}
