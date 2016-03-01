package joshie.lib.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;

public abstract class SlotSpecial extends Slot {

    public SlotSpecial(IInventory inv, int id, int x, int y) {
        super(inv, id, x, y);
    }

    public abstract ItemStack handle(EntityPlayer player, int mouseButton, Slot slot);
}
