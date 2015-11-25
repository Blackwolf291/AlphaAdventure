package TextGame;

public class HPItem extends HPAndMPItem{
	public HPItem(String name, int count, boolean combatUse, boolean use, boolean keyItem, int value, int hpBoost, String useDescription) {
		super(name, count, combatUse, use, keyItem, value, useDescription);
		hp = hpBoost;
	}
	public Character use(Character player){
		player = heal(player);
		player.getInventory().removeItem(this);
		return player;
	}
}
