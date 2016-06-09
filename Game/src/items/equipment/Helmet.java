package items.equipment;

import items.Combatant;
import items.Equipment;

public abstract class Helmet extends Equipment {

	protected abstract int getDefenseBonus();
	protected abstract int getAccuracyPenalty();
	@Override
	public void equip(Combatant target) {
		target.addTempDefense(getDefenseBonus());
		target.reduceTempAccuracy(getAccuracyPenalty());
		target.setEquipt(this);
	}
	@Override
	public void unequip(Combatant target) {
		target.reduceTempDefense(getDefenseBonus());
		target.addTempAccuracy(getAccuracyPenalty());
	}
}
