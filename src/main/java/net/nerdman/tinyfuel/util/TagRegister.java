package net.nerdman.tinyfuel.util;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.nerdman.tinyfuel.TinyFuel;

public class TagRegister {
    public static class Items {
        public static final TagKey<Item> TINY_FUELS = createTag("tiny_fuels");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(TinyFuel.MODID, name));
        }
    }
}
