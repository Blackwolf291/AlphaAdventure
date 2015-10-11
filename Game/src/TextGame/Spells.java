package TextGame;

public class Spells {

	
	public static Character minorHeal(Character player){
		System.out.println("Your hands glow white as you cast Heal");
		player.setHP(player.getHP() + 100);
		player.applyManaCost(75);
		return player;
	}
	public static Character fireball(Character player){
		if (player.getCombat()){
		System.out.println("Your hands glow red as you throw a fireball");
		player.getEnemy().setHP(player.getEnemy().getHP() - Input.dice(10, 10));
		player.applyManaCost(100);
		} else{
			System.out.println("You can't use that here.");
		}
		return player;
	}
	
}
