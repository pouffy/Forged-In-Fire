package com.pouffy.forgedinfire.main.tools.data.material;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialTraitDataProvider;
import slimeknights.tconstruct.tools.TinkerModifiers;

public class MaterialTraitsDataProvider extends AbstractMaterialTraitDataProvider {
    public MaterialTraitsDataProvider(DataGenerator gen, AbstractMaterialDataProvider materials) {
        super(gen, materials);
    }

    @Override
    public String getName() {
        return "Forged In Fire Material Traits";
    }
    @Override
    protected void addMaterialTraits() {
        addDefaultTraits(MaterialIds.dragon_scale, TinkerModifiers.fiery);
        addDefaultTraits(MaterialIds.dragon_bone, TinkerModifiers.firestarter);
        addDefaultTraits(MaterialIds.wither_bone, TinkerModifiers.necrotic);
        addDefaultTraits(MaterialIds.fireDragonsteel, TinkerModifiers.fiery);
        addDefaultTraits(MaterialIds.iceDragonsteel, TinkerModifiers.freezing);
        addDefaultTraits(MaterialIds.lightningDragonsteel, TinkerModifiers.necrotic);
    }
}
