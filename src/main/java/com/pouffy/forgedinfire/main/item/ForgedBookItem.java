package com.pouffy.forgedinfire.main.item;

import com.pouffy.forgedinfire.main.item.book.ForgedBook;
import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import slimeknights.mantle.item.LecternBookItem;

public class ForgedBookItem extends LecternBookItem {
    private final BookType bookType;
    public ForgedBookItem(Properties props, BookType bookType) {
        super(props);
        this.bookType = bookType;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (world.isClientSide) {
            ForgedBook.getBook(bookType).openGui(hand, stack);
        }
        return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
    }

    @Override
    public void openLecternScreenClient(BlockPos pos, ItemStack stack) {
        ForgedBook.getBook(bookType).openGui(pos, stack);
    }

    /** Simple enum to allow selecting the book on the client */
    public enum BookType {
        DRACONIC_WEAPONRY
    }
}
