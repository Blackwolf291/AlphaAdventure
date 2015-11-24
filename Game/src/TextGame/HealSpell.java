package TextGame;

public class HealSpell extends Spell{
	int HPHealed;
	public HealSpell(String name, int manaCost, String castDescription, int HPHealed) {
		super(name, manaCost, castDescription);
		this.HPHealed = HPHealed;
	}
	public Character cast (Character player){
		if (player.getMana()>=getCost()){
			printCastDescription();
			player.addHP(player.getHP() + HPHealed);
			player.applyManaCost(getCost());
		}
		else {
			cantCast();
		}
		return player;
	}
}
