package items.equipment.weapons;

import items.Target;
import items.equipment.Weapon;

public class NullWeapon extends Weapon {

	@Override
	public int getValue() {return 0;}

	@Override
	public void use(Target target) {}

	@Override
	public void printDescription() {}

	@Override
	protected int getRandomDamage() {
		return 0;
	}

	@Override
	protected void printMiss() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void printHit() {
		// TODO Auto-generated method stub
		
	}

}
