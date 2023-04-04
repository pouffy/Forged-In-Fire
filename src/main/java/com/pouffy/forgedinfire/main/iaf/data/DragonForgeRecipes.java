package com.pouffy.forgedinfire.main.iaf.data;

import com.github.alexthe666.iceandfire.block.IafBlockRegistry;
import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.Items;

import java.util.function.Consumer;

public class DragonForgeRecipes {
    public DragonForgeRecipes() {}

    public static void register(Consumer<FinishedRecipe> consumer) {
        fireForge(consumer);
    }

    private static void fireForge(Consumer<FinishedRecipe> consumer) {
        new DragonForgeRecipeBuilder("fire", 1000, Items.IRON_BLOCK, IafItemRegistry.FIRE_DRAGON_BLOOD.get(), IafBlockRegistry.DRAGONSTEEL_FIRE_BLOCK.get());
    }
}
