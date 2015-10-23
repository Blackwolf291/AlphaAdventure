package TextGame;

public class Shield extends Item{
	private int shieldBonus;
	private int dodgeBonus;
	public Shield(String name, int count, boolean combatUse, boolean use, boolean keyItem, int value, int shieldBonus, int dodgeBonus) {
		super(name, count, combatUse, use, keyItem, value);
		this.shieldBonus = shieldBonus;
		this.dodgeBonus = dodgeBonus;
	}
	public Shield(){
		super("no shield", 0, false, false, false, 0);
		shieldBonus = 0;
		dodgeBonus = 0;
	}
	public int getShieldBonus(){
		return shieldBonus;
	}
	public int getDodgeBonus(){
		return dodgeBonus;
	}
}
