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

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
