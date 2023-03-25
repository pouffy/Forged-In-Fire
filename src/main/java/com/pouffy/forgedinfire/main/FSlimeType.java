package com.pouffy.forgedinfire.main;

import lombok.Getter;
import net.minecraft.tags.TagKey;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.MaterialColor;
import slimeknights.tconstruct.common.TinkerTags;
import slimeknights.tconstruct.shared.block.SlimeType;

import java.util.Locale;
@Getter
public enum FSlimeType implements StringRepresentable {
    FIRE_BLOOD(0x01cd4e, 0x8CD782, Tiers.STONE,   MaterialColor.COLOR_ORANGE, false),
    ICE_BLOOD  (0x01cbcd, 0x00F4DA, Tiers.GOLD,    MaterialColor.DIAMOND, false),
    LIGHTNING_BLOOD(0xff970d, 0xd09800, Tiers.IRON,    MaterialColor.COLOR_PURPLE, true, 10);

    /** Slime types added by the mod */
    public static final FSlimeType[] FORGED = {FIRE_BLOOD, ICE_BLOOD, LIGHTNING_BLOOD};
    public static final FSlimeType[] LIQUID = {FIRE_BLOOD, ICE_BLOOD, LIGHTNING_BLOOD};
    /** Slime types that use overworld foliage */
    public static final FSlimeType[] OVERWORLD = {FIRE_BLOOD, ICE_BLOOD, LIGHTNING_BLOOD};
    /** Slime types that use overworld foliage */

    /* Block color for this slime type */
    private final int color;
    /** Default color for this foliage, used in inventory */
    private final int defaultFoliageColor;

    private final Tiers harvestTier;

    private final MaterialColor mapColor;
    /** If true, this block type has fungus foliage instead of grass */
    private final boolean nether;
    /** Light level of slime blocks of this type */
    private final int lightLevel;

    /* Tags */
    /** Tag for dirt blocks of this type, including blocks with grass on top */
    private final TagKey<Block> dirtBlockTag;
    /** Tag for grass blocks with this foliage type */
    private final TagKey<Block> grassBlockTag;
    /** Tag for slime balls of this type */
    private final TagKey<Item> slimeballTag;

    FSlimeType(int color, int defaultFoliageColor, Tiers harvestTier, MaterialColor mapColor, boolean nether, int lightLevel) {
        this.color = color;
        this.defaultFoliageColor = defaultFoliageColor;
        this.harvestTier = harvestTier;
        this.mapColor = mapColor;
        this.nether = nether;
        this.lightLevel = lightLevel;
        // tags
        String name = this.getSerializedName();
        grassBlockTag = TinkerTags.Blocks.tag((nether ? "slimy_nylium/" : "slimy_grass/") + name);
        dirtBlockTag = TinkerTags.Blocks.tag("slimy_soil/" + ("blood".equals(name) ? "vanilla" : name));
        slimeballTag = TinkerTags.Items.forgeTag("slimeball/" + name);
    }

    FSlimeType(int color, int defaultFoliageColor, Tiers harvestTier, MaterialColor mapColor, boolean nether) {
        this(color, defaultFoliageColor, harvestTier, mapColor, nether, 0);
    }

    @Override
    public String getSerializedName() {
        return this.name().toLowerCase(Locale.US);
    }
}
