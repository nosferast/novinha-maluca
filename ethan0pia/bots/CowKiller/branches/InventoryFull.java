package com.ethan0pia.bots.CowKiller.branches;

import com.runemate.game.api.script.framework.tree.BranchTask;
import com.runemate.game.api.script.framework.tree.TreeTask;
import com.runemate.game.api.hybrid.local.hud.interfaces.Inventory;

public class InventoryFull extends BranchTask {

	private BankOpen bankOpn= new BankOpen();
	private ContainsMeat containsMeat= new ContainsMeat();

	@Override
	public TreeTask successTask() {
		return containsMeat;
	}

	@Override
	public TreeTask failureTask() {
		return bankOpn;
	}

	@Override
	public boolean validate() {
		//inventory full?
		return Inventory.getEmptySlots()<1;
	}

}