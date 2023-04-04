package com.pouffy.forgedinfire.main.fluid;

import com.pouffy.forgedinfire.ForgedInFire;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.tags.FluidTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import slimeknights.mantle.registration.object.FluidObject;
import slimeknights.tconstruct.common.TinkerTags;
@SuppressWarnings("unchecked")
public class FluidTagProvider extends FluidTagsProvider {

    public FluidTagProvider(DataGenerator generatorIn, ExistingFileHelper helper) {
        super(generatorIn, ForgedInFire.MOD_ID, helper);
    }

    @Override
    public void addTags() {
        tagAll(ForgedFluids.moltenFireDragonsteel);
        tagAll(ForgedFluids.fireBlood);
        tagAll(ForgedFluids.iceBlood);
        tagAll(ForgedFluids.lightningBlood);

        this.tag(TinkerTags.Fluids.METAL_TOOLTIPS).addTags(ForgedFluids.moltenFireDragonsteel.getForgeTag());
        this.tag(TinkerTags.Fluids.SLIME_TOOLTIPS).add(ForgedFluids.iceBlood.get(), ForgedFluids.fireBlood.get(), ForgedFluids.lightningBlood.get());
    }
    @Override
    public String getName() {
        return "Forged In Fire Fluid Tags";
    }
    private void tagLocal(FluidObject<?> fluid) {
        tag(fluid.getLocalTag()).add(fluid.getStill(), fluid.getFlowing());
    }
    private void tagAll(FluidObject<?> fluid) {
        tagLocal(fluid);
        tag(fluid.getForgeTag()).addTag(fluid.getLocalTag());
    }
}
