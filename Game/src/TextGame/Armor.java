package TextGame;

public class Armor extends Item{
	private int dodgePenalty;
	private int shielding;
	public Armor(String name, int count, boolean combatUse, boolean use, boolean keyItem, int value, int shielding, int dodgePenalty) {
		super(name, count, combatUse, use, keyItem, value);
		this.dodgePenalty = dodgePenalty;
		this.shielding = shielding;
	}
	public Armor(){
		super("no armor", 0, false, false, false, 0);
		this.dodgePenalty = 0;
		this.shielding = 0;
	}
	public int getShielding(){
		return shielding;
	}
	public int getSpeedPenalty(){
		return dodgePenalty;
	}
}
