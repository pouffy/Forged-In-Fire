package com.pouffy.forgedinfire.main;

import com.pouffy.forgedinfire.ForgedInFire;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.Fluid;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.TinkerTags;

public class ForgedTags {
    public ForgedTags() {
    }
    public static void init() {
        //ForgedTags.Blocks.init();
        Items.init();
        Fluids.init();
    }
    public static class Items {
        private static void init() {
        }

        public static final TagKey<Item> DRAGON_SCALES = tag("dragon_scales");
        public static final TagKey<Item> DRAGONSTEEL = tag("dragonsteel");

        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registry.ITEM_REGISTRY, ForgedInFire.getResource(name));
        }

        public static TagKey<Item> forgeTag(String name) {
            return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", name));
        }
    }
    public static class Fluids {
        private static void init() {}
        private static TagKey<Fluid> tag(String name) {
            return TagKey.create(Registry.FLUID_REGISTRY, ForgedInFire.getResource(name));
        }

        private static TagKey<Fluid> forgeTag(String name) {
            return TagKey.create(Registry.FLUID_REGISTRY, new ResourceLocation("forge", name));
        }
    }
}
