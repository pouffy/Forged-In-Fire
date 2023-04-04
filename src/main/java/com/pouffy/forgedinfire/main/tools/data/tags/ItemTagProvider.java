package com.pouffy.forgedinfire.main.tools.data.tags;

import com.github.alexthe666.iceandfire.item.IafItemRegistry;
import com.pouffy.forgedinfire.main.ForgedTags;
import com.pouffy.forgedinfire.main.tools.ForgedTools;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.shared.TinkerMaterials;

public class ItemTagProvider extends ItemTagsProvider {
    public ItemTagProvider(DataGenerator generatorIn, BlockTagsProvider blockTagProvider, ExistingFileHelper existingFileHelper) {
        super(generatorIn, blockTagProvider, "forgedinfire", existingFileHelper);
    }
    public String getName() {
        return "Forged In Fire Item Tags";
    }

    protected void addTags() {
        this.addCommon();
    }
    private void addCommon() {
        this.tag(ForgedTags.Items.DRAGON_SCALES).add((Item) IafItemRegistry.DRAGONSCALES_BRONZE.get());
        this.tag(ForgedTags.Items.DRAGON_SCALES).add((Item) IafItemRegistry.DRAGONSCALES_GREEN.get());
        this.tag(ForgedTags.Items.DRAGON_SCALES).add((Item) IafItemRegistry.DRAGONSCALES_AMYTHEST.get());
        this.tag(ForgedTags.Items.DRAGON_SCALES).add((Item) IafItemRegistry.DRAGONSCALES_BLACK.get());
        this.tag(ForgedTags.Items.DRAGON_SCALES).add((Item) IafItemRegistry.DRAGONSCALES_BLUE.get());
        this.tag(ForgedTags.Items.DRAGON_SCALES).add((Item) IafItemRegistry.DRAGONSCALES_COPPER.get());
        this.tag(ForgedTags.Items.DRAGON_SCALES).add((Item) IafItemRegistry.DRAGONSCALES_ELECTRIC.get());
        this.tag(ForgedTags.Items.DRAGON_SCALES).add((Item) IafItemRegistry.DRAGONSCALES_GRAY.get());
        this.tag(ForgedTags.Items.DRAGON_SCALES).add((Item) IafItemRegistry.DRAGONSCALES_RED.get());
        this.tag(ForgedTags.Items.DRAGON_SCALES).add((Item) IafItemRegistry.DRAGONSCALES_SAPPHIRE.get());
        this.tag(ForgedTags.Items.DRAGON_SCALES).add((Item) IafItemRegistry.DRAGONSCALES_SILVER.get());
        this.tag(ForgedTags.Items.DRAGON_SCALES).add((Item) IafItemRegistry.DRAGONSCALES_WHITE.get());
        this.tag(ForgedTags.Items.DRAGONSTEEL).add((Item) IafItemRegistry.DRAGONSTEEL_FIRE_INGOT.get());
        this.tag(ForgedTags.Items.DRAGONSTEEL).add((Item) IafItemRegistry.DRAGONSTEEL_ICE_INGOT.get());
        this.tag(ForgedTags.Items.DRAGONSTEEL).add((Item) IafItemRegistry.DRAGONSTEEL_LIGHTNING_INGOT.get());

        this.tag(TinkerTags.Items.MODIFIABLE).add((Item) ForgedTools.glaive.get());
        this.tag(TinkerTags.Items.HELD).add((Item) ForgedTools.glaive.get());
        this.tag(TinkerTags.Items.MELEE).add((Item) ForgedTools.glaive.get());
        this.tag(TinkerTags.Items.DURABILITY).add((Item) ForgedTools.glaive.get());
        this.tag(TinkerTags.Items.ONE_HANDED).add((Item) ForgedTools.glaive.get());
    }
}
