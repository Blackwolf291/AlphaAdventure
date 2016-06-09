package items.equipment;

import TextGame.Attack;
import TextGame.RandomValueGenerator;
import items.Attacker;
import items.Combatant;
import items.Defender;
import items.Equipment;

public abstract class Weapon extends Equipment implements Attack {
	
	protected RandomValueGenerator random = RandomValueGenerator.getGenerator();
	protected Attacker attacker;
	private Defender defender;

	@Override
	public final void attack(Defender defender, Attacker attacker) {
		this.attacker = attacker;
		this.defender = defender;
		if (isHit()){
			defender.dealDamage(getDamage());
			printHit();
		} else {
			printMiss();
		}
	}

	protected abstract void printMiss();

	protected abstract void printHit();

	protected abstract int getRandomDamage();

	@Override
	public final void equip(Combatant target) {
		target.setEquipt(this);
	}
	
	@Override
	public final void unequip(Combatant target){}
	
	private boolean isHit(){
		return attacker.getAccuracy()-defender.getDodge()+random.rollDice(10)>10;
	}
	private int getDamage(){
		return getRandomDamage()+attacker.getBaseDamage()-defender.getDefense();
	}
}
