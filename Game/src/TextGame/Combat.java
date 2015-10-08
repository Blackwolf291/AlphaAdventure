package TextGame;

import java.util.Enumeration;

public class Combat {

	public static Character combat(Character player, Items items){
		player.setCombat(true);
		player.setWin(false);
		boolean win = false;
		boolean lose = false;
		System.out.println("You face a " + player.getEnemy().getName());
		System.out.println(player.getEnemy().getInitialDescription());
		while (player.getCombat()){
			boolean creatureTurn = true;
			boolean playerTurn = true;
			while (playerTurn){
			System.out.println(player.getEnemy().getDescription());
				System.out.println("You have " + player.getHP() + "HP");
			System.out.println("You may try to ATTACK, FLEE, use an ITEM.");
			if (player.getSpells().size() > 0){
				System.out.println("Or you may cast a spell.");
			}
			String action = Input.getInput();
			switch (action){
			case "attack":
			case "a":
				boolean hit;
				playerTurn = false;
				int attackDie = Input.dice(1,6);
				switch (attackDie){
				case 6:
					hit = true;
					break;
				case 0:
					hit = false;
					break;
				default:
					int attack = player.getAttack() + attackDie;
					if (attack>=player.getEnemy().getDodge()){
						hit = true;
					}
					else{
						hit = false;
					}
				}
				
				
				if (hit){
					System.out.println("You hit the " + player.getEnemy().getName());
					int playerDamage = player.getWeapon().getDamage();
					if (playerDamage >= player.getEnemy().getShield()){
						int damage = playerDamage - player.getEnemy().getShield();
						int HP = player.getEnemy().getHP() - damage;
						player.getEnemy().setHP(HP);
						System.out.println("for " + damage + " damage");
					} else{
						System.out.println("but it did no damage.");
					}
					
				}
				if (player.getEnemy().getHP() <= 0){
				win = true;
				}
				break;
				
			case "flee":
			case "f":
				if (player.getEnemy().getCanFlee()){
					playerTurn = false;
					boolean escape;
				int escapeDie = Input.dice(1,6);
				switch (escapeDie){
				case 6:
					escape = true;
					System.out.println("The " + player.getEnemy().getName() + "tripped when trying to chase you. you manage to get away.");
					break;
				case 0:
					escape = false;
					System.out.println("You tripped while trying to escape. it easily caught up.");
					break;
				default:
					int run = player.getLvl() + player.getSpd() + escapeDie;
					if (run >= player.getEnemy().getChase()){
						escape = true;
						System.out.println("You manage to get away.");
					}else{
						escape = false;
						System.out.println("You fail to get away.");
					}
				}
				if (escape){
					player.setCombat(false);
					creatureTurn = false;
				}
				}else{
					System.out.println("There's no escaping this foe.");
				}
				break;
			case "item":
			case "i":
			case "use item":
			case "u":
			case "inventory":
					System.out.println("You got " + player.getGold() + " gold.");
					for (int i = 0; i < player.getInventory().size(); i++){
						if (player.getInventory().get(i).getCombatUse()){
						System.out.println(player.getInventory().get(i).getCount() + player.getInventory().get(i).getName() + ", ");
						}
					}
					System.out.println("or you can RETURN.");
					String item = Input.getInput();
					player = items.useItem(item, player);
					playerTurn = !player.getItemUsed();
				break;
			case "minor heal":
			case "heal":
				if (player.getSpells().contains(Locations.minorHeal)){
				Spells.minorHeal(player);
				playerTurn = false;
				}else{
					System.out.println("No such move");
				}
				break;
			case "fireball":
			case "fire":
				if (player.getSpells().contains(Locations.fireball)){
				Spells.fireball(player);
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
				Attack currentAttack = player.getEnemy().getAttack().get(Input.dice(1,player.getEnemy().getAttack().size()));
				System.out.println(currentAttack.getDescription());
				if (currentAttack.getAttack() + player.getEnemy().getHit() >= player.getSpd()){
					if (currentAttack.getDamage() + player.getEnemy().getDamage() > player.getShield()){
						int damage = currentAttack.getDamage() + player.getEnemy().getDamage() - player.getShield();
						int playerHP = player.getHP() - damage;
						player.setHP(playerHP);
						System.out.println("It hit you for " + damage + "damage");
					}
					else{
						System.out.println("It hit you but failed to do any damage");
					}
				}
				else {
					System.out.println("It missed");
		
				}
				if (player.getHP() <= 0){
					lose = true;
					player.setCombat(false);
				}
				
			}
}
		if (win){
			System.out.println(player.getEnemy().getVictory());
			System.out.println("You gained " + player.getEnemy().getXP() + " experience.");
			player.setGainedXP(player.getEnemy().getXP());
			player.setGold(player.getEnemy().getGold());
			player.setWin(true);
			System.out.println("You gained " + player.getEnemy().getGold() + " gold.");
			if (Input.dice(1,100) >= player.getEnemy().getDropChance()){
			System.out.println("You gained 1" + player.getEnemy().getItemDrop());
			player.getInventory().add(player.getEnemy().getItemDrop());
			}
		}
		else if (lose){
			System.out.println(player.getEnemy().getLoss());
			int hp = player.getMaxHP()/2;
			player.setHP(hp);
			player.setCurrentLocation(player.getBase());
			if (player.getBase() == Locations.l1);
			System.out.println("You wake up the next day. sagged into the sand. feeling refreshed.");
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
}
	
