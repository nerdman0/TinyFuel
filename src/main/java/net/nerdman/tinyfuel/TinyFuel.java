package net.nerdman.tinyfuel;

import com.mojang.logging.LogUtils;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.nerdman.tinyfuel.block.BlockRegister;
import net.nerdman.tinyfuel.item.ItemRegister;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(TinyFuel.MODID)
public class TinyFuel
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "tinyfuel";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public TinyFuel(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

        ItemRegister.register(modEventBus);

        BlockRegister.register(modEventBus);

        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
        modEventBus.addListener(this::addCreative);

        // Register our mod's ForgeConfigSpec so that Forge can create and load the config file for us
        context.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event){
        if(event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.getEntries().putAfter(Items.COAL_BLOCK.getDefaultInstance(), BlockRegister.CHARCOAL_BLOCK.get().asItem().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.getEntries().putAfter(Items.CHARCOAL.getDefaultInstance(), ItemRegister.NANO_FUEL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.CHARCOAL.getDefaultInstance(), ItemRegister.MICRO_FUEL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.CHARCOAL.getDefaultInstance(), ItemRegister.MINI_FUEL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.CHARCOAL.getDefaultInstance(), ItemRegister.TINY_CHARCOAL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.CHARCOAL.getDefaultInstance(), ItemRegister.TINY_COAL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            if(ModList.get().isLoaded("silentgear")) {
                event.accept(ItemRegister.TINY_NETHERWOOD_CHARCOAL);
            }
            if(ModList.get().isLoaded("immersiveengineering")){
                event.accept(ItemRegister.TINY_COAL_COKE_IE);
            }
        }
    }
}
