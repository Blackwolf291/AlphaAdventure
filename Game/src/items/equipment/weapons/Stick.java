package items.equipment.weapons;

import items.Target;
import items.equipment.Weapon;

public class Stick extends Weapon {

	@Override
	public int getValue() {
		return 1;
	}

	@Override
	public void use(Target target) {
	}

	@Override
	public void printDescription() {
	}

	@Override
	protected int getRandomDamage() {
		return random.rollDice(4);
	}

	@Override
	protected void printMiss() {
		
	}

	@Override
	protected void printHit() {
		
	}

}
