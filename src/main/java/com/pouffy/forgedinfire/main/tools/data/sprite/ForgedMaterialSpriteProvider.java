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
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF4c4a3f).addARGB(102, 0xFF807a68).addARGB(140, 0xFF969083).addARGB(178, 0xFFa39f93).addARGB(216, 0xFFa8a39b).addARGB(255, 0xFFc9c4bb).build());
        buildMaterial(MaterialIds.wither_bone)
                .meleeHarvest().ranged()
                .fallbacks("bone", "rock")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xff1a1a1a).addARGB(102, 0xff2a2a2a).addARGB(140, 0xff303030).addARGB(178, 0xff353535).addARGB(216, 0xff363636).addARGB(255, 0xff424242).build());
        buildMaterial(MaterialIds.dragon_scale)
                .statType(RepairKitStats.ID, ExtraMaterialStats.ID)
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF3D1C10).addARGB(102, 0xFF542716).addARGB(140, 0xFF893B25).addARGB(178, 0xFF9E492A).addARGB(216, 0xFFC65C35).addARGB(255, 0xFFD76B43).build());
        ResourceLocation fireBaseTexture = ForgedInFire.getResource("generator/dragonsteel_fire");
        ResourceLocation fireHighlightTexture = ForgedInFire.getResource("generator/dragonsteel_fire_highlight");
        ResourceLocation fireBorderTexture = ForgedInFire.getResource("generator/dragonsteel_fire_border");
        ResourceLocation iceBaseTexture = ForgedInFire.getResource("generator/dragonsteel_ice");
        ResourceLocation iceHighlightTexture = ForgedInFire.getResource("generator/dragonsteel_ice_highlight");
        ResourceLocation iceBorderTexture = ForgedInFire.getResource("generator/dragonsteel_ice_border");
        buildMaterial(MaterialIds.iceDragonsteel)
                .meleeHarvest().ranged().statType(RepairKitStats.ID, ExtraMaterialStats.ID)
                .fallbacks("bone", "metal")
                .transformer(GreyToSpriteTransformer.builderFromBlack()
                        .addTexture( 63, iceBorderTexture,    0xFF4d6465).addTexture(102, iceBorderTexture)
                        .addTexture(140, iceBaseTexture,      0xFFa1e7e0).addTexture(178, iceBaseTexture)
                        .addTexture(216, iceHighlightTexture, 0xFFa1e7e0).addTexture(255, iceHighlightTexture)
                        .build());
        buildMaterial(MaterialIds.fireDragonsteel)
                .meleeHarvest().ranged().statType(RepairKitStats.ID, ExtraMaterialStats.ID)
                .fallbacks("bone", "metal")
                .transformer(GreyToSpriteTransformer.builderFromBlack()
                        .addTexture( 63, fireBorderTexture,    0xFF241512).addTexture(102, fireBorderTexture)
                        .addTexture(140, fireBaseTexture,      0xFF221a19).addTexture(178, fireBaseTexture)
                        .addTexture(216, fireHighlightTexture, 0xFF383232).addTexture(255, fireHighlightTexture)
                        .build());
        buildMaterial(MaterialIds.lightningDragonsteel)
                .meleeHarvest().ranged().statType(RepairKitStats.ID, ExtraMaterialStats.ID)
                .fallbacks("bone", "metal")
                .colorMapper(GreyToColorMapping.builderFromBlack().addARGB(63, 0xFF2e103d).addARGB(102, 0xFF301654).addARGB(140, 0xFF342589).addARGB(178, 0xFF552a9e).addARGB(216, 0xFF6435c6).addARGB(255, 0xFF7943d7).build());
    }
}
