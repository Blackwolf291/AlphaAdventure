package items.equipment.shields;

import items.Target;
import items.equipment.Shield;

public class CopperShield extends Shield {

	@Override
	protected int getAttackPenalty() {
		return 1;
	}

	@Override
	protected int getDodgeBonus() {
		return 3;
	}

	@Override
	protected int getDefenseBonus() {
		return 2;
	}

	@Override
	public int getValue() {
		return 100;
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
