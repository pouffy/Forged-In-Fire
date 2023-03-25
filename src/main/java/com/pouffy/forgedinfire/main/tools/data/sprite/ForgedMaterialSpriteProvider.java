package com.pouffy.forgedinfire.main.tools.data.sprite;

import com.pouffy.forgedinfire.ForgedInFire;
import com.pouffy.forgedinfire.main.tools.data.material.MaterialIds;
import net.minecraft.resources.ResourceLocation;
import slimeknights.tconstruct.library.client.data.material.AbstractMaterialSpriteProvider;
import slimeknights.tconstruct.library.client.data.spritetransformer.GreyToColorMapping;
import slimeknights.tconstruct.library.client.data.spritetransformer.GreyToSpriteTransformer;
import slimeknights.tconstruct.tools.stats.ExtraMaterialStats;
import slimeknights.tconstruct.tools.stats.RepairKitStats;

public class ForgedMaterialSpriteProvider extends AbstractMaterialSpriteProvider {

    @Override
    public String getName() {
        return "Forged In Fire Materials";
    }

    @Override
    protected void addAllMaterials() {
        buildMaterial(MaterialIds.dragon_bone)
                .meleeHarvest().ranged()
                .fallbacks("bone", "rock")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF7B7E6B).addARGB(102, 0xFFA09F86).addARGB(140, 0xFFCBC6A5).addARGB(178, 0xFFDAD6BC).addARGB(216, 0xFFE8E5D2).addARGB(255, 0xFFFCFBED).build());
        buildMaterial(MaterialIds.wither_bone)
                .meleeHarvest().ranged()
                .fallbacks("bone", "rock")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF7B7E6B).addARGB(102, 0xFFA09F86).addARGB(140, 0xFFCBC6A5).addARGB(178, 0xFFDAD6BC).addARGB(216, 0xFFE8E5D2).addARGB(255, 0xFFFCFBED).build());
        buildMaterial(MaterialIds.dragon_scale)
                .statType(RepairKitStats.ID, ExtraMaterialStats.ID)
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF3D1C10).addARGB(102, 0xFF542716).addARGB(140, 0xFF893B25).addARGB(178, 0xFF9E492A).addARGB(216, 0xFFC65C35).addARGB(255, 0xFFD76B43).build());
        ResourceLocation fireBaseTexture = ForgedInFire.getResource("generator/dragonsteel_fire");
        ResourceLocation fireHighlightTexture = ForgedInFire.getResource("generator/dragonsteel_fire_highlight");
        ResourceLocation fireBorderTexture = ForgedInFire.getResource("generator/dragonsteel_fire_border");
        buildMaterial(MaterialIds.fireDragonsteel)
                .meleeHarvest().ranged().statType(RepairKitStats.ID, ExtraMaterialStats.ID)
                .fallbacks("bone", "metal")
                .transformer(GreyToSpriteTransformer.builderFromBlack()
                        .addTexture( 63, fireBorderTexture,    0xFFC8C8C8).addTexture(102, fireBorderTexture)
                        .addTexture(140, fireBaseTexture,      0xFFE1E1E1).addTexture(178, fireBaseTexture)
                        .addTexture(216, fireHighlightTexture, 0xFFE1E1E1).addTexture(255, fireHighlightTexture)
                        .build());
        buildMaterial(MaterialIds.iceDragonsteel)
                .meleeHarvest().ranged().statType(RepairKitStats.ID, ExtraMaterialStats.ID)
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF3D1C10).addARGB(102, 0xFF542716).addARGB(140, 0xFF893B25).addARGB(178, 0xFF9E492A).addARGB(216, 0xFFC65C35).addARGB(255, 0xFFD76B43).build());
        buildMaterial(MaterialIds.lightningDragonsteel)
                .meleeHarvest().ranged().statType(RepairKitStats.ID, ExtraMaterialStats.ID)
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF3D1C10).addARGB(102, 0xFF542716).addARGB(140, 0xFF893B25).addARGB(178, 0xFF9E492A).addARGB(216, 0xFFC65C35).addARGB(255, 0xFFD76B43).build());
    }
}
