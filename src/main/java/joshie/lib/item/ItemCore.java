package joshie.lib.item;

import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemCore extends Item {
    @Override
    public Item setUnlocalizedName(String unlocalizedName) {
        super.setUnlocalizedName(unlocalizedName);
        GameRegistry.registerItem(this, unlocalizedName);
        return this;
    }
}
