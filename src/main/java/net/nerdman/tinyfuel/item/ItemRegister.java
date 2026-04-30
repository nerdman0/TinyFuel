package net.nerdman.tinyfuel.item;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

import net.nerdman.tinyfuel.TinyFuel;
import net.nerdman.tinyfuel.item.fuel.FuelItem;

public class ItemRegister {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(TinyFuel.MODID);

    public static final DeferredItem<Item> TINY_COAL = ITEMS.register("tiny_coal",
            () -> new FuelItem(new Item.Properties(), 200));
    public static final DeferredItem<Item> TINY_CHARCOAL = ITEMS.register("tiny_charcoal",
            () -> new FuelItem(new Item.Properties(), 200));
    public static final DeferredItem<Item> MINI_FUEL = ITEMS.register("mini_fuel",
            () -> new FuelItem(new Item.Properties(), 20));
    public static final DeferredItem<Item> MICRO_FUEL = ITEMS.register("micro_fuel",
            () -> new FuelItem(new Item.Properties(), 2));
    public static final DeferredItem<Item> NANO_FUEL = ITEMS.register("nano_fuel",
            () -> new FuelItem(new Item.Properties(), 1));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
