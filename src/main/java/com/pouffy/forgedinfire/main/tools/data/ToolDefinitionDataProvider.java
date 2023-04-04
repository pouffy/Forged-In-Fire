package com.pouffy.forgedinfire.main.tools.data;

import com.pouffy.forgedinfire.ForgedInFire;
import com.pouffy.forgedinfire.main.tools.ForgedToolDefinitions;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.ToolActions;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.library.data.tinkering.AbstractToolDefinitionDataProvider;
import slimeknights.tconstruct.library.tools.definition.harvest.IHarvestLogic;
import slimeknights.tconstruct.library.tools.definition.harvest.ModifiedHarvestLogic;
import slimeknights.tconstruct.library.tools.stat.ToolStats;
import slimeknights.tconstruct.tools.TinkerModifiers;

import static slimeknights.tconstruct.tools.TinkerToolParts.*;

public class ToolDefinitionDataProvider extends AbstractToolDefinitionDataProvider {
    public ToolDefinitionDataProvider(DataGenerator generator) {
        super(generator, ForgedInFire.MOD_ID);
    }
    @Override
    protected void addToolDefinitions() {
        define(ForgedToolDefinitions.GLAIVE)
                // parts
                .part(smallBlade)
                .part(toughHandle)
                .part(toughHandle)
                .part(toolBinding)
                // stats
                .stat(ToolStats.ATTACK_DAMAGE, 3.0f)
                .stat(ToolStats.ATTACK_SPEED, 1.0f)
                .multiplier(ToolStats.ATTACK_DAMAGE, 1.5f)
                .multiplier(ToolStats.MINING_SPEED, 0.25f)
                .multiplier(ToolStats.DURABILITY, 3.5f)
                .largeToolStartingSlots()
                // traits
                .trait(TinkerModifiers.aoeSilkyShears)
                // behavior
                .action(ToolActions.SWORD_DIG);
    }
    @Override
    public String getName() {
        return "Forged In Fire Tool Definition Data Generator";
    }
}
