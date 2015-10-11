package TextGame;

public class Consumable extends Item{

	public Consumable(String name, int count, boolean combatUse, boolean use, boolean keyItem, int value, int equipment) {
		super(name, count, combatUse, use, keyItem, value, 0);
	}
}
