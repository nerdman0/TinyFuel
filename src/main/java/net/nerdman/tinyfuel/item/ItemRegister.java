package net.nerdman.tinyfuel.item;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.nerdman.tinyfuel.TinyFuel;
import net.nerdman.tinyfuel.item.fuel.FuelItem;

public class ItemRegister {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, TinyFuel.MODID);

    public static final RegistryObject<Item> TINY_COAL = ITEMS.register("tiny_coal",
            () -> new FuelItem(new Item.Properties(), 200));
    public static final RegistryObject<Item> TINY_CHARCOAL = ITEMS.register("tiny_charcoal",
            () -> new FuelItem(new Item.Properties(), 200));
    public static final RegistryObject<Item> MINI_FUEL = ITEMS.register("mini_fuel",
            () -> new FuelItem(new Item.Properties(), 20));
    public static final RegistryObject<Item> MICRO_FUEL = ITEMS.register("micro_fuel",
            () -> new FuelItem(new Item.Properties(), 2));
    public static final RegistryObject<Item> NANO_FUEL = ITEMS.register("nano_fuel",
            () -> new FuelItem(new Item.Properties(), 1));
    public static final RegistryObject<Item> TINY_NETHERWOOD_CHARCOAL = ITEMS.register("tiny_netherwood_charcoal",
            () -> new FuelItem(new Item.Properties(), 200));
    public static final RegistryObject<Item> TINY_COAL_COKE_IE = ITEMS.register("tiny_coal_coke_ie",
            () -> new FuelItem(new Item.Properties(), 200));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
