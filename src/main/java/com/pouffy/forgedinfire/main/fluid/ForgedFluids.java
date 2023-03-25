package com.pouffy.forgedinfire.main.fluid;

import com.pouffy.forgedinfire.ForgedInFire;
import com.pouffy.forgedinfire.main.FSlimeType;
import com.pouffy.forgedinfire.main.ForgedModule;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.DispensibleContainerItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import slimeknights.mantle.registration.ModelFluidAttributes;
import slimeknights.mantle.registration.deferred.FluidDeferredRegister;
import slimeknights.mantle.registration.object.FluidObject;

import java.util.EnumMap;
import java.util.Map;

public class ForgedFluids {
    public static final FluidDeferredRegister FLUIDS = new FluidDeferredRegister(ForgedInFire.MOD_ID);

    public static final FluidObject<ForgeFlowingFluid> fireBlood = registerSlime("fire_dragon_blood", 0);
    public static final FluidObject<ForgeFlowingFluid> iceBlood = registerSlime("ice_dragon_blood", 0);
    public static final FluidObject<ForgeFlowingFluid> lightningBlood = registerSlime("lightning_dragon_blood", 0);
    public static final FluidObject<ForgeFlowingFluid> moltenFireDragonsteel = register("molten_fire_dragonsteel", 4);


    /** Creates a builder for a cool fluid with textures */
    private static FluidAttributes.Builder coolBuilder() {
        return ModelFluidAttributes.builder().sound(SoundEvents.BUCKET_FILL, SoundEvents.BUCKET_EMPTY);
    }
    private static FluidAttributes.Builder hotBuilder() {
        return ModelFluidAttributes.builder().density(2000).viscosity(10000).temperature(1000).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA);
    }
    public static final Map<FSlimeType, FluidObject<ForgeFlowingFluid>> slime;
    static {
        slime = new EnumMap<>(FSlimeType.class);
        slime.put(FSlimeType.FIRE_BLOOD, fireBlood);
        slime.put(FSlimeType.ICE_BLOOD, iceBlood);
        slime.put(FSlimeType.LIGHTNING_BLOOD, lightningBlood);
    }
    private static FluidObject<ForgeFlowingFluid> register(String name, int lightLevel) {
        String still = String.format("forgedinfire:block/fluid/%s/still", name);
        String flow = String.format("forgedinfire:block/fluid/%s/flowing", name);
        return FLUIDS.register(name, FluidAttributes.builder(new ResourceLocation(still), new ResourceLocation(flow)).density(2000).viscosity(10000).temperature(1000).sound(SoundEvents.BUCKET_FILL_LAVA, SoundEvents.BUCKET_EMPTY_LAVA), Material.LAVA, lightLevel);
    }
    private static FluidObject<ForgeFlowingFluid> registerSlime(String name, int lightLevel) {
        String still = String.format("forgedinfire:block/fluid/%s/still", name);
        String flow = String.format("forgedinfire:block/fluid/%s/flowing", name);
        return FLUIDS.register(name, FluidAttributes.builder(new ResourceLocation(still), new ResourceLocation(flow)).density(2000).viscosity(10000).temperature(1000).sound(SoundEvents.BUCKET_FILL, SoundEvents.BUCKET_EMPTY), Material.WATER, lightLevel);
    }
    @SubscribeEvent
    void gatherData(final GatherDataEvent event) {
        if (event.includeClient()) {
            DataGenerator datagenerator = event.getGenerator();
            //datagenerator.addProvider(new FluidTooltipProvider(datagenerator));
        }
    }
    @SubscribeEvent
    void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {

        });
        DispenseItemBehavior dispenseBucket = new DefaultDispenseItemBehavior() {
            private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();

            @Override
            public ItemStack execute(BlockSource source, ItemStack stack) {
                DispensibleContainerItem container = (DispensibleContainerItem)stack.getItem();
                BlockPos blockpos = source.getPos().relative(source.getBlockState().getValue(DispenserBlock.FACING));
                Level level = source.getLevel();
                if (container.emptyContents(null, level, blockpos, null)) {
                    container.checkExtraContent(null, level, stack, blockpos);
                    return new ItemStack(Items.BUCKET);
                } else {
                    return this.defaultDispenseItemBehavior.dispense(source, stack);
                }
            }
        };
        event.enqueueWork(() -> {
            DispenserBlock.registerBehavior(fireBlood, dispenseBucket);
            DispenserBlock.registerBehavior(iceBlood, dispenseBucket);
            DispenserBlock.registerBehavior(lightningBlood, dispenseBucket);
            DispenserBlock.registerBehavior(moltenFireDragonsteel, dispenseBucket);

        });
    }
}
