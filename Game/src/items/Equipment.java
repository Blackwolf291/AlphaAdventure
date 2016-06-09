package items;

import TextGame.Item;

public abstract class Equipment extends Item{

	public abstract void equip(Combatant target);
	public abstract void unequip(Combatant target);
}
