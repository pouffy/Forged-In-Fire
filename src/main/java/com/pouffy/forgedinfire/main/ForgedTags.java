package com.pouffy.forgedinfire.main;

import com.pouffy.forgedinfire.ForgedInFire;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.common.TinkerTags;

public class ForgedTags {
    public ForgedTags() {
    }
    public static void init() {
        //ForgedTags.Blocks.init();
        ForgedTags.Items.init();
    }
    public static class Items {
        public static final TagKey<Item> DRAGON_SCALES = tag("dragon_scales");
        public static final TagKey<Item> DRAGONSTEEL = tag("dragonsteel");


        public Items() {
        }

        private static void init() {
        }

        private static TagKey<Item> tag(String name) {
            return TagKey.create(Registry.ITEM_REGISTRY, ForgedInFire.getResource(name));
        }

        public static TagKey<Item> forgeTag(String name) {
            return TagKey.create(Registry.ITEM_REGISTRY, new ResourceLocation("forge", name));
        }
    }
}
