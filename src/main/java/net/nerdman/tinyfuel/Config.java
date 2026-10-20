package net.nerdman.tinyfuel;

import net.minecraftforge.common.ForgeConfigSpec;
import net.minecraftforge.fml.common.Mod;

// An example config class. This is not required, but it's a good idea to have one to keep your config organized.
// Demonstrates how to use Forge's config APIs
@Mod.EventBusSubscriber(modid = TinyFuel.MODID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class Config
{
    private static final ForgeConfigSpec.Builder BUILDER = new ForgeConfigSpec.Builder();

    public static final ForgeConfigSpec.BooleanValue TORCH_RECIPE = BUILDER.comment("Enable crafting torches with tiny fuel").define("torchRecipe", false);
    //public static final ForgeConfigSpec.BooleanValue WITHER_SKELETON_LOOT = BUILDER.comment("Enable wither skeleton dropping tiny coal").define("weletonLoot", false);
    //public static final ForgeConfigSpec.BooleanValue DUNGEON_LOOT = BUILDER.comment("Enable tiny coal appearing in loot chests").define("dungeonLoot", true);

    static final ForgeConfigSpec SPEC = BUILDER.build();
}
