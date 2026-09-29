package net.nerdman.tinyfuel;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.event.config.ModConfigEvent;
import net.neoforged.neoforge.common.ModConfigSpec;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Neo's config APIs
//@EventBusSubscriber(modid = TinyFuel.MODID, bus = EventBusSubscriber.Bus.MOD)
public class Config {
    private static final ModConfigSpec.Builder BUILDER = new ModConfigSpec.Builder();

    public static final ModConfigSpec.BooleanValue TORCH_RECIPE = BUILDER.comment("Enable crafting torches with tiny fuel").define("torchRecipe", false);
    public static final ModConfigSpec.BooleanValue WITHER_SKELETON_LOOT = BUILDER.comment("Enable wither skeleton dropping tiny coal").define("weletonLoot", false);
    public static final ModConfigSpec.BooleanValue DUNGEON_LOOT = BUILDER.comment("Enable tiny coal appearing in loot chests").define("dungeonLoot", true);

    static final ModConfigSpec SPEC = BUILDER.build();
}
