package com.pouffy.forgedinfire;

import com.mojang.logging.LogUtils;
import com.pouffy.forgedinfire.main.ForgedClient;
import com.pouffy.forgedinfire.main.ForgedCommons;
import com.pouffy.forgedinfire.main.ForgedTags;
import com.pouffy.forgedinfire.main.fluid.FluidTagProvider;
import com.pouffy.forgedinfire.main.fluid.ForgedFluids;
import com.pouffy.forgedinfire.main.item.book.ForgedBookIDs;
import com.pouffy.forgedinfire.main.tools.ForgedTools;
import com.pouffy.forgedinfire.main.tools.data.tags.BlockTagProvider;
import com.pouffy.forgedinfire.main.tools.data.tags.ItemTagProvider;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.InterModComms;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.InterModEnqueueEvent;
import net.minecraftforge.fml.event.lifecycle.InterModProcessEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;
import org.slf4j.Logger;
import slimeknights.tconstruct.library.utils.Util;

import java.util.stream.Collectors;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("forgedinfire")
public class ForgedInFire
{
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();
    public static final String MOD_ID = "forgedinfire";


    public ForgedInFire()
    {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        // Register the setup method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);
        // Register the enqueueIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::enqueueIMC);
        // Register the processIMC method for modloading
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::processIMC);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        bus.register(new ForgedTools());
        ForgedFluids.FLUIDS.register(bus);
        ForgedCommons.ITEMS.register(bus);
        ForgedBookIDs.registerCommandSuggestion();
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ForgedClient::onForged);
        ForgedTags.init();
    }
    @SubscribeEvent
    static void gatherData(final GatherDataEvent event) {
        DataGenerator datagenerator = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        if (event.includeServer()) {
            BlockTagProvider blockTags = new BlockTagProvider(datagenerator, existingFileHelper);
            datagenerator.addProvider(new ItemTagProvider(datagenerator, blockTags, existingFileHelper));
            datagenerator.addProvider(new FluidTagProvider(datagenerator, existingFileHelper));
        }
    }

    private void setup(final FMLCommonSetupEvent event)
    {
        // some preinit code
        LOGGER.info("HELLO FROM PREINIT");
        LOGGER.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
    }

    private void enqueueIMC(final InterModEnqueueEvent event)
    {
        // Some example code to dispatch IMC to another mod
        InterModComms.sendTo("forgedinfire", "helloworld", () -> { LOGGER.info("Hello world from the MDK"); return "Hello world";});
    }

    private void processIMC(final InterModProcessEvent event)
    {
        // Some example code to receive and process InterModComms from other mods
        LOGGER.info("Got IMC {}", event.getIMCStream().
                map(m->m.messageSupplier().get()).
                collect(Collectors.toList()));
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event)
    {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
    // Event bus for receiving Registry Events)
    @Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
    public static class RegistryEvents
    {
        @SubscribeEvent
        public static void onBlocksRegistry(final RegistryEvent.Register<Block> blockRegistryEvent)
        {
            // Register a new block here
            LOGGER.info("HELLO from Register Block");
        }
    }
    public static String makeTranslationKey(String base, String name) {
        return Util.makeTranslationKey(base, getResource(name));
    }
    public static ResourceLocation getResource(String name) {
        return new ResourceLocation("forgedinfire", name);
    }
    public static void sealForgedClass(Object self, String base, String solution) {
        // note for future maintainers: this does not use Java 9's sealed classes as unless you use modules those are restricted to the same package.
        // Dumb restriction but not like we can change it.
        String name = self.getClass().getName();
        if (!name.startsWith("com.pouffy.forgedinfire.")) {
            throw new IllegalStateException(base + " being extended from invalid package " + name + ". " + solution);
        }
    }
}
