package com.pouffy.forgedinfire.main.tools;

import com.pouffy.forgedinfire.ForgedInFire;
import com.pouffy.forgedinfire.main.ForgedModule;
import com.pouffy.forgedinfire.main.tools.data.StationSlotLayoutProvider;
import com.pouffy.forgedinfire.main.tools.data.ToolDefinitionDataProvider;
import com.pouffy.forgedinfire.main.tools.data.ToolsRecipeProvider;
import com.pouffy.forgedinfire.main.tools.data.material.*;
import com.pouffy.forgedinfire.main.tools.data.sprite.ForgedMaterialSpriteProvider;
import com.pouffy.forgedinfire.main.tools.data.sprite.ForgedPartSpriteProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.registration.CastItemObject;
import slimeknights.tconstruct.common.registration.ItemDeferredRegisterExtension;
import slimeknights.tconstruct.library.client.data.material.GeneratorPartTextureJsonGenerator;
import slimeknights.tconstruct.library.client.data.material.MaterialPartTextureGenerator;
import slimeknights.tconstruct.library.tools.item.ModifiableItem;

import static slimeknights.tconstruct.smeltery.TinkerSmeltery.TAB_SMELTERY;
import static slimeknights.tconstruct.tools.TinkerTools.TAB_TOOLS;

public class ForgedTools {
    public ForgedTools() {
    }
    public static final ItemDeferredRegisterExtension ITEMS = new ItemDeferredRegisterExtension(ForgedInFire.MOD_ID);

    private static final Item.Properties TOOL = new Item.Properties().stacksTo(1).tab(TAB_TOOLS);
    public static final ItemObject<ModifiableItem> glaive = ITEMS.register("glaive", () -> new ModifiableGlaiveItem(TOOL, ForgedToolDefinitions.GLAIVE));
    @SubscribeEvent
    void gatherData(final GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        if (event.includeServer()) {
            generator.addProvider(new ToolsRecipeProvider(generator));
            generator.addProvider(new MaterialRecipeProvider(generator));
            MaterialDataProvider materials = new MaterialDataProvider(generator);
            generator.addProvider(materials);
            generator.addProvider(new MaterialStatsDataProvider(generator, materials));
            generator.addProvider(new MaterialTraitsDataProvider(generator, materials));
            generator.addProvider(new ToolDefinitionDataProvider(generator));
            generator.addProvider(new StationSlotLayoutProvider(generator));
        }
        if (event.includeClient()) {
            ForgedMaterialSpriteProvider materialSprites = new ForgedMaterialSpriteProvider();
            ForgedPartSpriteProvider partSprites = new ForgedPartSpriteProvider();
            generator.addProvider(new MaterialRenderInfoProvider(generator, materialSprites));
            generator.addProvider(new GeneratorPartTextureJsonGenerator(generator, ForgedInFire.MOD_ID, partSprites));
            generator.addProvider(new GeneratorPartTextureJsonGenerator(generator, TConstruct.MOD_ID, partSprites));
            generator.addProvider(new MaterialPartTextureGenerator(generator, existingFileHelper, partSprites, materialSprites));
        }
    }
}
