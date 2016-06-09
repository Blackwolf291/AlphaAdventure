package items.equipment.weapons;

import TextGame.RandomValueGenerator;
import items.Target;
import items.equipment.Weapon;

public class CopperSword extends Weapon {

	@Override
	protected void printMiss() {
		
	}

	@Override
	protected void printHit() {
		
	}

	@Override
	protected int getRandomDamage() {
		return RandomValueGenerator.getGenerator().rollDice(6);
	}

	@Override
	public int getValue() {
		return 100;
	}

	@Override
	public void use(Target target) {
		
	}

	@Override
	public void printDescription() {
		
	}

}
