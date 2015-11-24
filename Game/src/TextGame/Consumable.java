package TextGame;

public abstract class Consumable extends Item{
	String useDescription;
	public Consumable(String name, int count, boolean combatUse, boolean use, boolean keyItem, int value, String useDescription) {
		super(name, count, combatUse, use, keyItem, value);
	}
	public abstract Character use (Character player);
}
