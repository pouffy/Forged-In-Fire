package com.pouffy.forgedinfire.main.tools.data.material;

import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.pouffy.forgedinfire.main.ForgedTags;
import com.pouffy.forgedinfire.main.fluid.ForgedFluids;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import com.pouffy.forgedinfire.main.tools.data.BaseRecipeProvider;
import slimeknights.mantle.recipe.helper.ItemOutput;
import slimeknights.tconstruct.library.data.recipe.IMaterialRecipeHelper;

import java.util.function.Consumer;

public class MaterialRecipeProvider extends BaseRecipeProvider implements IMaterialRecipeHelper {
    public MaterialRecipeProvider(DataGenerator generator) {
        super(generator);
    }

    @Override
    public String getName() {
        return "Forged In Fire Material Recipe";
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        addMaterialItems(consumer);
        addMaterialSmeltery(consumer);
    }

    private void addMaterialItems(Consumer<FinishedRecipe> consumer) {
        String folder = "tools/materials/";
        materialRecipe(consumer, MaterialIds.dragon_scale,   Ingredient.of(ForgedTags.Items.DRAGON_SCALES), 1, 2, folder + "scales/dragon");

        materialRecipe(consumer, MaterialIds.red,          Ingredient.of(IafItemRegistry.DRAGONSCALES_RED.get()),      1, 1, folder + "scales/dragon/red");
        materialRecipe(consumer, MaterialIds.emerald,      Ingredient.of(IafItemRegistry.DRAGONSCALES_GREEN.get()),      1, 1, folder + "scales/dragon/emerald");
        materialRecipe(consumer, MaterialIds.bronze,       Ingredient.of(IafItemRegistry.DRAGONSCALES_BRONZE.get()),      1, 1, folder + "scales/dragon/bronze");
        materialRecipe(consumer, MaterialIds.amethyst,     Ingredient.of(IafItemRegistry.DRAGONSCALES_AMYTHEST.get()),      1, 1, folder + "scales/dragon/amethyst");
        materialRecipe(consumer, MaterialIds.black,        Ingredient.of(IafItemRegistry.DRAGONSCALES_BLACK.get()),      1, 1, folder + "scales/dragon/black");
        materialRecipe(consumer, MaterialIds.blue,         Ingredient.of(IafItemRegistry.DRAGONSCALES_BLUE.get()),      1, 1, folder + "scales/dragon/blue");
        materialRecipe(consumer, MaterialIds.copper,       Ingredient.of(IafItemRegistry.DRAGONSCALES_COPPER.get()),      1, 1, folder + "scales/dragon/copper");
        materialRecipe(consumer, MaterialIds.electric_blue,     Ingredient.of(IafItemRegistry.DRAGONSCALES_ELECTRIC.get()),      1, 1, folder + "scales/dragon/electric_blue");
        materialRecipe(consumer, MaterialIds.gray,         Ingredient.of(IafItemRegistry.DRAGONSCALES_GRAY.get()),      1, 1, folder + "scales/dragon/gray");
        materialRecipe(consumer, MaterialIds.sapphire,     Ingredient.of(IafItemRegistry.DRAGONSCALES_SAPPHIRE.get()),      1, 1, folder + "scales/dragon/sapphire");
        materialRecipe(consumer, MaterialIds.silver,       Ingredient.of(IafItemRegistry.DRAGONSCALES_SILVER.get()),      1, 1, folder + "scales/dragon/silver");
        materialRecipe(consumer, MaterialIds.white,        Ingredient.of(IafItemRegistry.DRAGONSCALES_WHITE.get()),      1, 1, folder + "scales/dragon/white");

        materialRecipe(consumer, MaterialIds.dragon_bone,     Ingredient.of(IafItemRegistry.DRAGON_BONE.get()),      1, 1, folder + "dragon_bone");
        materialRecipe(consumer, MaterialIds.wither_bone,     Ingredient.of(IafItemRegistry.WITHERBONE.get()),      1, 1, folder + "wither_bone");
        materialRecipe(consumer, MaterialIds.dragon_bone,     Ingredient.of(IafItemRegistry.DRAGON_SKULL_FIRE.get()),      4, 1, ItemOutput.fromStack(new ItemStack(IafItemRegistry.DRAGON_BONE.get())), folder + "dragon_bone_from_fire_skull");
        materialRecipe(consumer, MaterialIds.dragon_bone,     Ingredient.of(IafItemRegistry.DRAGON_SKULL_ICE.get()),      4, 1, ItemOutput.fromStack(new ItemStack(IafItemRegistry.DRAGON_BONE.get())), folder + "dragon_bone_from_ice_skull");
        materialRecipe(consumer, MaterialIds.dragon_bone,     Ingredient.of(IafItemRegistry.DRAGON_SKULL_LIGHTNING.get()),      4, 1, ItemOutput.fromStack(new ItemStack(IafItemRegistry.DRAGON_BONE.get())), folder + "dragon_bone_from_lightning_skull");

    }
    private void addMaterialSmeltery(Consumer<FinishedRecipe> consumer) {
        String folder = "tools/materials/";
        materialMeltingCasting(consumer, MaterialIds.fireDragonsteel, ForgedFluids.moltenFireDragonsteel, false, folder);
    }
}
