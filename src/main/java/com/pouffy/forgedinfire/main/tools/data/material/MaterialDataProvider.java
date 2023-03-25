package com.pouffy.forgedinfire.main.tools.data.material;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;

public class MaterialDataProvider extends AbstractMaterialDataProvider {
    public MaterialDataProvider(DataGenerator gen) {
        super(gen);
    }

    @Override
    public String getName() {
        return "Forged In Fire Materials";
    }

    @Override
    protected void addMaterials() {
        addMaterial(MaterialIds.dragon_bone,   7, ORDER_COMPAT, true);
        addMaterial(MaterialIds.wither_bone,   7, ORDER_COMPAT, true);
        addMaterial(MaterialIds.dragon_scale, 7, ORDER_COMPAT, true);
        addMaterial(MaterialIds.fireDragonsteel, 7, ORDER_COMPAT, false);
        addMaterial(MaterialIds.iceDragonsteel, 7, ORDER_COMPAT, false);
        addMaterial(MaterialIds.lightningDragonsteel, 7, ORDER_COMPAT, false);

    }
}
