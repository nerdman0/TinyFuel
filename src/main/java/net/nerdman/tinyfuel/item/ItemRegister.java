package net.nerdman.tinyfuel.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.nerdman.tinyfuel.TinyFuel;
import net.nerdman.tinyfuel.item.fuel.FuelItem;

public class ItemRegister {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TinyFuel.MODID);

    public static final DeferredItem<Item> Tiny_Coal = ITEMS.register("tiny_coal",
            () -> new FuelItem(new Item.Properties(), 200));
    public static final DeferredItem<Item> Tiny_Charcoal = ITEMS.register("tiny_charcoal",
            () -> new FuelItem(new Item.Properties(), 200));
    public static final DeferredItem<Item> Mini_Fuel = ITEMS.register("mini_fuel",
            () -> new FuelItem(new Item.Properties(), 20));
    public static final DeferredItem<Item> Micro_Fuel = ITEMS.register("micro_fuel",
            () -> new FuelItem(new Item.Properties(), 2));
    public static final DeferredItem<Item> Nano_Fuel = ITEMS.register("nano_fuel",
            () -> new FuelItem(new Item.Properties(), 1));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
