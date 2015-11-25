package TextGame;

public class BonusHPItem extends HPAndMPItem{
	public BonusHPItem(String name, int count, boolean combatUse, boolean use, boolean keyItem, int value, int hpBoost, String useDescription) {
		super(name, count, combatUse, use, keyItem, value, useDescription);
		hp = hpBoost;
	}
	public Character use(Character player){
		player = healWithBonusHP(player);
		player.getInventory().removeItem(this);
		return player;
	}
}
