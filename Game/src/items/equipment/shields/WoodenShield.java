package items.equipment.shields;

import items.Target;
import items.equipment.Shield;

public class WoodenShield extends Shield {

	@Override
	protected int getAttackPenalty() {
		return 2;
	}

	@Override
	protected int getDodgeBonus() {
		return 2;
	}

	@Override
	protected int getDefenseBonus() {
		return 2;
	}

	@Override
	public int getValue() {
		return 10;
	}

	@Override
	public void use(Target target) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printDescription() {
		// TODO Auto-generated method stub
		
	}

	

}
