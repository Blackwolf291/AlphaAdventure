package items.equipment.helmets;

import items.Target;
import items.equipment.Helmet;

public class LeatherHelmet extends Helmet {

	@Override
	protected int getDefenseBonus() {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	protected int getAccuracyPenalty() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public int getValue() {
		// TODO Auto-generated method stub
		return 25;
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
