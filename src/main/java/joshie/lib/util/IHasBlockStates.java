package joshie.lib.util;

import net.minecraft.item.ItemBlock;

public interface IHasBlockStates {
    Class<? extends ItemBlock> getItemClass();
}
