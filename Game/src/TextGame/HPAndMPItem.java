package TextGame;

public class HPAndMPItem extends Consumable{
	int hp;
	int manaBoost;
	
	public HPAndMPItem(String name, int count, boolean combatUse, boolean use, boolean keyItem, int value, int hp, int manaBoost, String useDescription) {
		super(name, count, combatUse, use, keyItem, value, useDescription);
		this.hp = hp;
		this.manaBoost = manaBoost;
	}
	public HPAndMPItem(String name, int count, boolean combatUse, boolean use, boolean keyItem, int value, String useDescription) {
		super(name, count, combatUse, use, keyItem, value, useDescription);
	}
	Character use(Character player) {
		player = heal(player);
		return player;
	}
	Character manaRec(Character player){
		if (getCount()>0){
			player.getInventory().removeItem(this);
			player.setMana(player.getMana() + manaBoost);
			System.out.println(useDescription);
			System.out.println("You gained "+ manaBoost + " mana.");
			player.setItemUsed(true);
		} else {
			System.out.println("You don\'t have any " + getName() + " .");
		}
		return player;
	}
	Character heal(Character player){
		if (getCount()>0){
			player.getInventory().removeItem(this);
			player.setHP(player.getHP() + hp);
			System.out.println(useDescription);
			System.out.println("You gained "+ hp + " hp.");
			player.setItemUsed(true);
		} else {
			System.out.println("You don\'t have any " + getName() + " .");
		}
		return player;
	}
	Character healWithBonusHP(Character player){
		if (getCount()>0){
			player.getInventory().removeItem(this);
			player.setHPWithBonus(player.getHP() + hp);
			System.out.println(useDescription);
			System.out.println("You gained "+ hp + " hp.\nYou feel better than normal.");
			player.setItemUsed(true);
		} else {
			System.out.println("You don\'t have any " + getName() + " .");
		}
		return player;
	}
}