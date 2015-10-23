package TextGame;

public class HPItem extends HPAndMPItem{
	int hp;
	public HPItem(String name, int count, boolean combatUse, boolean use, boolean keyItem, int value, int hpBoost, String useDescription) {
		super(name, count, combatUse, use, keyItem, value, useDescription);
		hp = hpBoost;
	}
	Character use(Character player){
		heal(player);
		return player;
	}
}
