package com.pouffy.forgedinfire.main.tools.data.tags;

import com.pouffy.forgedinfire.ForgedInFire;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class BlockTagProvider extends BlockTagsProvider {

    public BlockTagProvider(DataGenerator generatorIn, ExistingFileHelper existingFileHelper) {
        super(generatorIn, ForgedInFire.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags() {
        this.addCommon();
        //this.addTools();
        //this.addWorld();
        //this.addSmeltery();
        //this.addFluids();
        //this.addHarvest();
    }

    private void addCommon() {

    }

    @Override
    public String getName() {
        return "Forged In Fire Block Tags";
    }
}
