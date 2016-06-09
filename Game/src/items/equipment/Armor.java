package items.equipment;

import items.Combatant;
import items.Equipment;

public abstract class Armor extends Equipment{

	@Override
	public void equip(Combatant target) {
		target.addTempDefense(getDefenseBoost());
		target.reduceTempDodge(getDodgePenalty());
		target.setEquipt(this);
		printEquipText();
	}

	public abstract void printEquipText();

	@Override
	public void unequip(Combatant target) {
		target.reduceTempDefense(getDefenseBoost());
		target.addTempDodge(getDodgePenalty());
		printUnequipText();
	}

	public abstract void printUnequipText();

	public abstract int getDefenseBoost();
	public abstract int getDodgePenalty();


}
