package com.pouffy.forgedinfire.main.item.book;

import com.pouffy.forgedinfire.ForgedInFire;
import net.minecraft.resources.ResourceLocation;
import slimeknights.mantle.command.BookTestCommand;

public class ForgedBookIDs {
    public static final ResourceLocation DRACONIC_WEAPONRY_ID = ForgedInFire.getResource("draconic_weaponry");

    /** Regsiters suggestions with the mantle command */
    public static void registerCommandSuggestion() {
        BookTestCommand.addBookSuggestion(DRACONIC_WEAPONRY_ID);
    }
}
