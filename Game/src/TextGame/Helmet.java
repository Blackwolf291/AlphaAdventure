package TextGame;

public class Helmet extends Item{
	private int shieldBonus;
	public Helmet(String name, int count, boolean combatUse, boolean use, boolean keyItem, int value, int shieldBonus) {
		super(name, count, combatUse, use, keyItem, value, 1);
		this.shieldBonus = shieldBonus;
	}
	public Helmet(){
		super("no helmet", 0, false, false, false, 0, 1);
		shieldBonus = 0;
	}
	public int getShieldBonus(){
		return shieldBonus;
	}
}
