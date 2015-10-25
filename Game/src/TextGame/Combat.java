package TextGame;

import java.util.Enumeration;

public class Combat {
	static boolean creatureTurn;
	static boolean playerTurn;
	static boolean hit;
	static boolean win;
	static boolean lose;
	static boolean escape;
	public static Character combat(Character player, Items items){
		player.setCombat(true);
		player.setWin(false);
		win = false;
		lose = false;
		creatureTurn = true;
		playerTurn = true;
		System.out.println("You face a " + player.getEnemy().getName());
		System.out.println(player.getEnemy().getInitialDescription());
		while (player.getCombat()){
			while (playerTurn){
				player.printSituation();
				String action = Input.getInput();
				switch (action){
				case "attack":
				case "a":
					player = attack(player);
					break;
			case "flee":
			case "f":
				player = flee(player);
				break;
			case "item":
			case "i":
			case "use item":
			case "u":
			case "inventory":
					player = combatInventory(player, items);
				break;
			case "minor heal":
			case "heal":
				if (player.getSpells().contains(Locations.minorHeal)){
				Locations.minorHeal.cast(player);
				playerTurn = false;
				}else{
					System.out.println("No such move");
				}
				break;
			case "fireball":
			case "fire":
				if (player.getSpells().contains(Locations.fireball)){
				Locations.fireball.cast(player);
				playerTurn = false;
				}else{
					System.out.println("No such move");
				}
				break;
			default:
					System.out.println("No such move");
					}
			}
			if (win) {
				creatureTurn = false;
				player.setCombat(false);
						}
			if (creatureTurn){
				player = player.getEnemy().turn(player);
				if (player.getHP() <= 0){
					lose = true;
					player.setCombat(false);
				}else{ 
					playerTurn = true;
				}
			}
}
		if (win){
			player.playerWin();
		}
		else if (lose){
			player.playerLose();
		}
		System.out.println( player.getCurrentLocation().getDescription());

		// Show available exits
		System.out.println( "\nAvailable exits :" );
		for (Enumeration<Exit> e = player.getCurrentLocation().getExits().elements(); e.hasMoreElements();)
		{
			Exit an_exit = (Exit) e.nextElement();
			System.out.println(an_exit);
		}
			if (player.getCurrentLocation().getNPCs().size() != 0){
			System.out.println("You see " + player.getCurrentLocation().getNPCs().get(0).getName());
			System.out.println("You can LOOK or TALK");
			}
	return player;	
	}
	private static Character flee(Character player) {
		if (player.getEnemy().getCanFlee()){
			playerTurn = false;
			escape = player.decideEscape();
		
		
		if (escape){
			player.setCombat(false);
			creatureTurn = false;
		}
		}else{
			System.out.println("There's no escaping this foe.");
		}
		return player;
	}
	private static Character attack(Character player) {
		playerTurn = false;
		hit = player.decideHit();
		if (hit){
			player.dealDamage();
		}
		if (player.getEnemy().getHP() <= 0){
			win = true;
		}
		return player;
	}
	private static Character combatInventory(Character player, Items items) {
		player.printCombatInventory();
		String item = Input.getInput();
		if (item.equals("return")){ 
			player = items.useItem(item, player);
			playerTurn = !player.getItemUsed();
		}
		return player;
	}
}
	
