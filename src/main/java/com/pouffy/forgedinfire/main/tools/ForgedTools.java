package com.pouffy.forgedinfire.main.tools;

import com.pouffy.forgedinfire.main.ForgedModule;
import com.pouffy.forgedinfire.main.tools.data.material.*;
import com.pouffy.forgedinfire.main.tools.data.sprite.ForgedMaterialSpriteProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

public class ForgedTools extends ForgedModule {
    public ForgedTools() {
    }

    @SubscribeEvent
    void gatherData(final GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        if (event.includeServer()) {
            generator.addProvider(new MaterialRecipeProvider(generator));
            MaterialDataProvider materials = new MaterialDataProvider(generator);
            generator.addProvider(materials);
            generator.addProvider(new MaterialStatsDataProvider(generator, materials));
            generator.addProvider(new MaterialTraitsDataProvider(generator, materials));
            //generator.addProvider(new MaterialTagProvider(generator, existingFileHelper));
        }
        if (event.includeClient()) {
            ForgedMaterialSpriteProvider materialSprites = new ForgedMaterialSpriteProvider();
            generator.addProvider(new MaterialRenderInfoProvider(generator, materialSprites));
            //generator.addProvider(new GeneratorPartTextureJsonGenerator(generator, TConstruct.MOD_ID, partSprites));
            //generator.addProvider(new MaterialPartTextureGenerator(generator, existingFileHelper, partSprites, materialSprites));
        }
    }
}
