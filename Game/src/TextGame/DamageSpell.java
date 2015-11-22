package TextGame;

public class DamageSpell extends Spell{
	int damage;
	public DamageSpell(String name, int manaCost, String castDescription, int damage) {
		super(name, manaCost, castDescription);
		this.damage = damage;
	}
	public Character cast(Character player) {
		if (player.getCombat()){
			if (player.getMana()>=getCost()){
				printCastDescription();
				int rolledDamage = damage;
				System.out.println("You deal " + rolledDamage + " Damage.");
				player.dealDamage(rolledDamage);
				player.applyManaCost(getCost());
			}else{
				cantCast();
			}
		}else{
			printCastDescription();
			player.applyManaCost(getCost());
			System.out.println("But it accomplished nothing.");
		}
		return player;
	}

}
