package TextGame;

public class MPItem extends HPAndMPItem{
	int manaBoost;
	public MPItem(String name, int count, boolean combatUse, boolean use, boolean keyItem, int value, int manaBoost, String useDescription) {
		super(name, count, combatUse, use, keyItem, value, useDescription);
		this.manaBoost = manaBoost;
	}
	Character use(Character player){
		manaRec(player);
		return player;
	}
}