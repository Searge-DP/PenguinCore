package joshie.lib.editables;

import net.minecraft.item.ItemStack;

public class ItemEditor {
	public static final ItemEditor INSTANCE = new ItemEditor();
	private IItemSelectable editable = null;
	private boolean isSelectingItem;

	public void setEditable(IItemSelectable editable) {
		this.isSelectingItem = true;
		this.editable = editable;
	}

	public void clearEditable() {
		this.isSelectingItem = false;
		this.editable = null;
	}
	
	//Used if I am using a different item selector than the default advanced item selector
	public boolean setItem(ItemStack stack) {
		if (isSelectingItem && editable != null) {
			editable.setItemStack(stack);
			return true;
		}
		
		return false;
	}
}
