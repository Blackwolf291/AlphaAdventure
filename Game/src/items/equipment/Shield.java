package items.equipment;

import items.Combatant;
import items.Equipment;

public abstract class Shield extends Equipment{

	@Override
	public void equip(Combatant target) {
		target.addTempDefense(getDefenseBonus());
		target.addTempDodge(getDodgeBonus());
		target.reduceTempAttack(getAttackPenalty());
		target.setEquipt(this);
	}

	@Override
	public void unequip(Combatant target) {
		target.reduceTempDefense(getDefenseBonus());
		target.reduceTempDodge(getDodgeBonus());
		target.addTempAttack(getAttackPenalty());
	}
	
	protected abstract int getAttackPenalty();
	protected abstract int getDodgeBonus();
	protected abstract int getDefenseBonus();
	

	
	
}
