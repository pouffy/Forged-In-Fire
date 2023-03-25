package com.pouffy.forgedinfire.main;

import com.pouffy.forgedinfire.ForgedInFire;
import com.pouffy.forgedinfire.main.item.ForgedBookItem;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.apache.logging.log4j.Logger;
import slimeknights.mantle.registration.object.ItemObject;
import slimeknights.tconstruct.common.registration.ItemDeferredRegisterExtension;

import static com.pouffy.forgedinfire.main.ForgedModule.TAB_GENERAL;


public class ForgedCommons{
    static final Logger log = Util.getLogger("forged_commons");
    public static final ItemDeferredRegisterExtension ITEMS = new ItemDeferredRegisterExtension(ForgedInFire.MOD_ID);

    private static final Item.Properties BOOK = new Item.Properties().tab(TAB_GENERAL).stacksTo(1);
    public static final ItemObject<ForgedBookItem> draconicWeaponry = ITEMS.register("draconic_weaponry", () -> new ForgedBookItem(BOOK, ForgedBookItem.BookType.DRACONIC_WEAPONRY));


    @SubscribeEvent
    void gatherData(final GatherDataEvent event) {
        if (event.includeServer()) {
            DataGenerator datagenerator = event.getGenerator();
            datagenerator.addProvider(new CommonRecipeProvider(datagenerator));
        }
    }
}
