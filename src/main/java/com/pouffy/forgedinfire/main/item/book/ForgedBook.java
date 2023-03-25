package com.pouffy.forgedinfire.main.item.book;

import com.pouffy.forgedinfire.main.item.ForgedBookItem;
import net.minecraft.resources.ResourceLocation;
import slimeknights.mantle.client.book.BookLoader;
import slimeknights.mantle.client.book.data.BookData;
import slimeknights.mantle.client.book.repository.FileRepository;
import slimeknights.mantle.client.book.transformer.BookTransformer;
import slimeknights.tconstruct.TConstruct;
import slimeknights.tconstruct.library.client.book.content.*;
import slimeknights.tconstruct.library.client.book.sectiontransformer.ModifierSectionTransformer;
import slimeknights.tconstruct.library.client.book.sectiontransformer.ToolSectionTransformer;
import slimeknights.tconstruct.library.client.book.sectiontransformer.materials.TierRangeMaterialSectionTransformer;
import slimeknights.tconstruct.library.client.book.sectiontransformer.materials.TieredMaterialSectionTransformer;
import slimeknights.tconstruct.tools.stats.*;

import static com.pouffy.forgedinfire.main.item.book.ForgedBookIDs.DRACONIC_WEAPONRY_ID;

public class ForgedBook extends BookData {
    public static final BookData DRACONIC_WEAPONRY = BookLoader.registerBook(DRACONIC_WEAPONRY_ID,    true, true);

    /**
     * Initializes the books
     */
    public static void initBook() {
        // register page types
        //BookLoader.registerPageType(ContentMaterial.ID, ContentMaterial.class);
        //BookLoader.registerPageType(ContentTool.ID,     ContentTool.class);
        //BookLoader.registerPageType(ContentModifier.ID, ContentModifier.class);

        //TierRangeMaterialSectionTransformer.registerMaterialType(TConstruct.getResource("melee_harvest"), ContentMaterial::new, HeadMaterialStats.ID, HandleMaterialStats.ID, ExtraMaterialStats.ID);
        //TierRangeMaterialSectionTransformer.registerMaterialType(TConstruct.getResource("ranged"), RangedMaterialContent::new, LimbMaterialStats.ID, GripMaterialStats.ID, BowstringMaterialStats.ID);
        //TierRangeMaterialSectionTransformer.registerMaterialType(TConstruct.getResource("skull"), ContentMaterialSkull::new, SkullStats.ID);

        // tool transformers
        ToolSectionTransformer armorTransformer = new ToolSectionTransformer("armor");
        DRACONIC_WEAPONRY.addTransformer(armorTransformer);


        // material tier transformers
        // TODO 1.19: remove old materail section transformers
        DRACONIC_WEAPONRY.addTransformer(new TieredMaterialSectionTransformer("mythological_materials", 7, false));
        // detailed transformers

        // modifier transformers
        //ModifierSectionTransformer upgrades = new ModifierSectionTransformer("upgrades");
        ModifierSectionTransformer defense = new ModifierSectionTransformer("defense");
        ModifierSectionTransformer slotless = new ModifierSectionTransformer("slotless");
        //ModifierSectionTransformer abilities = new ModifierSectionTransformer("abilities");
        //DRACONIC_WEAPONRY.addTransformer(upgrades);
        DRACONIC_WEAPONRY.addTransformer(slotless);
        DRACONIC_WEAPONRY.addTransformer(defense);
        //DRACONIC_WEAPONRY.addTransformer(abilities);

        // TODO: do we want to fire an event to add transformers to our books? Since we need the next two to be last
        addStandardData(DRACONIC_WEAPONRY, DRACONIC_WEAPONRY_ID);
    }

    /**
     * Adds the repository and the relevant transformers to the books
     *
     * @param book Book instance
     * @param id   Book ID
     */
    private static void addStandardData(BookData book, ResourceLocation id) {
        book.addRepository(new FileRepository(new ResourceLocation(id.getNamespace(), "book/" + id.getPath())));
        book.addTransformer(BookTransformer.indexTranformer());
        // padding needs to be last to ensure page counts are right
        book.addTransformer(BookTransformer.paddingTransformer());
        book.addTransformer(TierRangeMaterialSectionTransformer.INSTANCE);
    }

    /**
     * Gets the book for the enum value
     *
     * @param bookType Book type
     * @return Book
     */
    public static BookData getBook(ForgedBookItem.BookType bookType) {
        return switch (bookType) {
            case DRACONIC_WEAPONRY -> DRACONIC_WEAPONRY;
        };
    }
}
