package net.nerdman.tinyfuel;

import com.mojang.logging.LogUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.config.ModConfig;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
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

        // Register our mod's ModConfigSpec so that FML can create and load the config file for us
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ItemRegister.TINY_COAL);
            event.accept(ItemRegister.TINY_CHARCOAL);
            event.accept(ItemRegister.MINI_FUEL);
            event.accept(ItemRegister.MICRO_FUEL);
            event.accept(ItemRegister.NANO_FUEL);
        }
    }
}
