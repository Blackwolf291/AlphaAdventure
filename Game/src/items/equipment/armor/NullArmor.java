package items.equipment.armor;

import items.Target;
import items.equipment.Armor;

public class NullArmor extends Armor{

	@Override
	public int getDefenseBoost() {
		return 0;
	}

	@Override
	public int getDodgePenalty() {
		return 0;
	}

	@Override
	public int getValue() {
		return 0;
	}

	@Override
	public void use(Target target) {}

	@Override
	public void printDescription() {}

	@Override
	public void printEquipText() {}

	@Override
	public void printUnequipText() {}

}
