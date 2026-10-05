package net.nerdman.tinyfuel;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.ModList;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import net.nerdman.tinyfuel.block.BlockRegister;
import net.nerdman.tinyfuel.item.ItemRegister;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(TinyFuel.MODID)
public class TinyFuel {
    // Define mod id in a common place for everything to reference
    public static final String MODID = "tinyfuel";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    // The constructor for the mod class is the first code that is run when your mod is loaded.
    // FML will recognize some parameter types like IEventBus or ModContainer and pass them in automatically.
    public TinyFuel(IEventBus modEventBus, ModContainer modContainer) {
        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);

        // Register the items from itemregister
        ItemRegister.register(modEventBus);

        // Register the blocks from blockregister
        BlockRegister.register(modEventBus);

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

        // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS){
            event.insertAfter(Items.COAL_BLOCK.getDefaultInstance(), BlockRegister.CHARCOAL_BLOCK.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.insertAfter(Items.CHARCOAL.getDefaultInstance(), ItemRegister.NANO_FUEL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.CHARCOAL.getDefaultInstance(), ItemRegister.MICRO_FUEL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.CHARCOAL.getDefaultInstance(), ItemRegister.MINI_FUEL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.CHARCOAL.getDefaultInstance(), ItemRegister.TINY_CHARCOAL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.insertAfter(Items.CHARCOAL.getDefaultInstance(), ItemRegister.TINY_COAL.toStack(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            if(ModList.get().isLoaded("silentgear")) {
                event.accept(ItemRegister.TINY_NETHERWOOD_CHARCOAL);
            }
            if(ModList.get().isLoaded("immersiveengineering")){
                event.accept(ItemRegister.TINY_COAL_COKE_IE);
            }
        }
    }
}
