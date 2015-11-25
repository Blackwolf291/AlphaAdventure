package TextGame;

public class MPItem extends HPAndMPItem{

	public MPItem(String name, int count, boolean combatUse, boolean use, boolean keyItem, int value, int manaBoost, String useDescription) {
		super(name, count, combatUse, use, keyItem, value, useDescription);
		this.manaBoost = manaBoost;
	}
	public Character use(Character player){
		player = manaRec(player);
		player.getInventory().removeItem(this);
		return player;
	}
}