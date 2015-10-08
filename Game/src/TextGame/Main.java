package TextGame;

public class Main {
	public static void main(String[] args) {
		
		
		//gamestart
		Items items = new Items();
		Character player = new Character(items);
		@SuppressWarnings("unused")
		Locations worldMap = new Locations(items, player);
    	System.out.println("Alpha adventure");  
    	System.out.println("Do you wish to load your last save game?");
    	boolean load = Input.yesNo(player);
    	if (load){
    	  		player = SaveAndLoad.loadGame(player);
    	}
		System.out.println( "You wake up on the beach.\nThe sand feels warm, and you can't remember how you got here.\nYou see the wreck of a ship to the North, \nand a dense forest to the East.");
		//start of main game
		@SuppressWarnings("unused")
		int turnCounter = 0;
		boolean running = true;
		while (running == true){
			player.setMana(player.getMana() + player.getInt());
			turnCounter++;
			System.out.println("Other commands: Inventory, Stats, Save");
			String Command = Input.getInput();
			switch (Command){
			case "inventory":
				System.out.println("You got " + player.getGold() + " gold.");
				if (player.getInventory().size() > 0){
				for (int i = 0; i < player.getInventory().size(); i++){
					System.out.println(player.getInventory().get(i).getCount() + player.getInventory().get(i).getName() + ", ");
				}
				System.out.println("or you can RETURN.");
				String item = Input.getInput();
				player = items.useItem(item, player);
				if (!player.getItemUsed()){
					Command = "";
				}
					}
				break;
			case "stats":
				player.stats();
				break;
			case "hunt":
				if (player.getCurrentLocation().getCreatures().size() > 0){
					player.setEnemy(player.getCurrentLocation().getCreatures().get(Input.dice(1,player.getCurrentLocation().getCreatures().size()))); 
					player = Combat.combat(player, items);
				}else{
					System.out.println("There's nothing to hunt here.");
				}
				break;
			case "spells":
				player.spellList();
				break;
			case "talk":
				LocHandlers.talk(player, items);
				break;
			case "open":
				LocHandlers.open(player, items);
			case "save":
				SaveAndLoad.saveGame(player);
				break;
			case "make":
				LocHandlers.make(player);
				break;
			case "look":
				LocHandlers.look(player);
				break;
			case "minor heal":
			case "heal":
				if (player.getSpells().contains(Locations.minorHeal)){
				Spells.minorHeal(player);
				}else{
					System.out.println("No such move");
				}
				break;
			case "fireball":
			case "fire":
				if (player.getSpells().contains(Locations.fireball)){
				Spells.fireball(player);
				}else{
					System.out.println("No such move");
				}
				break;
			case "search":
				player = LocHandlers.search(player, items);
				break;
				default:
					if (Command.length() >= 4){
					String handle = Command.substring(0,3);
					switch (handle){
					case "use ":
						items.useItem(Command, player);
						break;
					case "talk":
						LocHandlers.talk(player, items);
						break;
					case "look":
						LocHandlers.look(player);
						break;
					case "open":
						LocHandlers.open(player, items);
					case "hunt":
						if (player.getCurrentLocation().getCreatures().size() > 0){
							player.setEnemy(player.getCurrentLocation().getCreatures().get(Input.dice(1,player.getCurrentLocation().getCreatures().size()))); 
							player = Combat.combat(player, items);
						}else{
							System.out.println("There's nothing to hunt here.");
						}
						break;
					case "make":
						LocHandlers.make(player);
						break;
					case "equi":
						items.equipItem(Command, player);
						break;
						default:
							player = Locations.action(Command, player, items);
					}
			} else {
				player = Locations.action(Command, player, items);
			}
			}
					
			}
	}
}
				

		
		


	
	