package com.pouffy.forgedinfire.main.tools.data.material;

import net.minecraft.data.DataGenerator;
import slimeknights.tconstruct.library.data.material.AbstractMaterialDataProvider;
import slimeknights.tconstruct.library.data.material.AbstractMaterialStatsDataProvider;
import slimeknights.tconstruct.tools.stats.*;

import static net.minecraft.world.item.Tiers.*;

public class MaterialStatsDataProvider  extends AbstractMaterialStatsDataProvider {
    public MaterialStatsDataProvider(DataGenerator gen, AbstractMaterialDataProvider materials) {
        super(gen, materials);
    }

    @Override
    public String getName() {
        return "Forged In Fire Material Stats";
    }

    @Override
    protected void addMaterialStats() {
        addMeleeHarvest();
        addRanged();
        addMisc();
    }

    private void addMeleeHarvest() {
        addMaterialStats(MaterialIds.dragon_bone,
                new HeadMaterialStats(200, 2.5f, IRON, 1.2f),
                HandleMaterialStats.DEFAULT.withDurability(1.05f).withAttackSpeed(1.25f),
                ExtraMaterialStats.DEFAULT);
        addMaterialStats(MaterialIds.wither_bone,
                new HeadMaterialStats(150, 2.0f, STONE, 1.3f),
                HandleMaterialStats.DEFAULT.withDurability(1.25f).withAttackSpeed(1.5f),
                ExtraMaterialStats.DEFAULT);
        addMaterialStats(MaterialIds.dragon_scale, ExtraMaterialStats.DEFAULT, BowstringMaterialStats.DEFAULT, GripMaterialStats.DEFAULT.withDurability(1.1f).withAccuracy(0.25f).withMeleeAttack(3));
        addMaterialStats(MaterialIds.fireDragonsteel,
                new HeadMaterialStats(500, 3.0f, NETHERITE, 2.4f),
                HandleMaterialStats.DEFAULT.withDurability(2.5f).withAttackSpeed(0.75f),
                ExtraMaterialStats.DEFAULT);
        addMaterialStats(MaterialIds.iceDragonsteel,
                new HeadMaterialStats(500, 3.0f, NETHERITE, 2.4f),
                HandleMaterialStats.DEFAULT.withDurability(2.5f).withAttackSpeed(0.75f),
                ExtraMaterialStats.DEFAULT);
        addMaterialStats(MaterialIds.lightningDragonsteel,
                new HeadMaterialStats(500, 3.0f, NETHERITE, 2.4f),
                HandleMaterialStats.DEFAULT.withDurability(2.5f).withAttackSpeed(0.75f),
                ExtraMaterialStats.DEFAULT);
    }
    private void addRanged() {
        addMaterialStats(MaterialIds.dragon_bone,
                new LimbMaterialStats(200, 0.07f, -0.07f, 0.07f),
                new GripMaterialStats(1.0f, 0.15f, 1.5f));
        addMaterialStats(MaterialIds.fireDragonsteel,
                new LimbMaterialStats(400, 0.25f, 0.25f, 0.3f),
                new GripMaterialStats(2.0f, 0.25f, 2.5f));
        addMaterialStats(MaterialIds.iceDragonsteel,
                new LimbMaterialStats(400, 0.25f, 0.25f, 0.3f),
                new GripMaterialStats(2.0f, 0.25f, 2.5f));
        addMaterialStats(MaterialIds.lightningDragonsteel,
                new LimbMaterialStats(400, 0.25f, 0.25f, 0.3f),
                new GripMaterialStats(2.0f, 0.25f, 2.5f));
    }
    private void addMisc() {
        addMaterialStats(MaterialIds.dragon_bone,  new SkullStats(200, 0));
        addMaterialStats(MaterialIds.dragon_scale, new RepairKitStats(250));
        addMaterialStats(MaterialIds.fireDragonsteel, new RepairKitStats(500));
        addMaterialStats(MaterialIds.iceDragonsteel, new RepairKitStats(500));
        addMaterialStats(MaterialIds.lightningDragonsteel, new RepairKitStats(500));

    }

}
