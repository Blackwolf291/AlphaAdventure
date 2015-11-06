package TextGame;

public class Main{
	static int turnCounter = 0;
	static int hourCounter = 1;
	static boolean pm = true;
	static String ampm = "PM";
	static int dayCounter = 1;
	static String command;
	static Items items;
	static Character player;
	private static void initiateGame(){
		Runnable frame = new GameScreen();
		frame.run();
		items = new Items();
		player = new Character();
		@SuppressWarnings("unused")
		Locations worldMap = new Locations(items, player);
    	System.out.println("Alpha adventure");  
    	System.out.println("Do you wish to load your last save game?");
    	boolean load = Input.yesNo(player);
    	if (load){
    	  		player = SaveAndLoad.loadGame(player);
    	}
    	GameScreen.textArea.setText("");
		System.out.println( "You wake up on the beach.\nThe sand feels warm, and you can't remember how you got here.\nYou see the wreck of a ship to the North, \nand a dense forest to the East.");
		
	}
	private static void startTurn(){
		increaseIngameTime();
		player.setMana(player.getMana() + player.getInt());
		System.out.println("Other commands: Inventory, Stats, Save");
	}
	private static void runGameLoop(){
		boolean running = true;
		while (running == true){
			startTurn();
			command = Input.getInput();
			parseAndExecuteCommand();
		}
	}
	public static void main (String[] args) {
		initiateGame();
		runGameLoop();
	}
	private static void increaseIngameTime() {
		turnCounter++;
		if (turnCounter >= 12){
			turnCounter -= 12;
			hourCounter++;
		}
		if (hourCounter > 12){
			hourCounter -= 12;
			if (pm){
				ampm = "AM";
				dayCounter++;
			}else{
				ampm = "PM";
			}
			pm = !pm;
			
		}
	}
	private static void parseAndExecuteCommand(){
		switch (CommandList.valueOf(command)){
		case inventory:
			player = player.getInventory().checkInventory(player, items);
			if (!player.getItemUsed()){
				command = "";
			}
			break;
		case hunt:
			player = player.hunt(player, items);
			break;
		case spells:
			player.printSpellList();
			break;
		case talk:
			LocHandlers.talk(player, items);
			break;
		case open:
			LocHandlers.open(player);
			break;
		case save:
			SaveAndLoad.saveGame(player);
			break;
		case make:
			LocHandlers.make(player);
			break;
		case look:
			LocHandlers.look(player);
			break;
		case heal:
			if (player.getSpells().contains(Locations.minorHeal)){
				player = Locations.minorHeal.cast(player);
			}else{
				System.out.println("No such move");
			}
			break;
		case fire:
			if (player.getSpells().contains(Locations.fireball)){
				player = Locations.fireball.cast(player);
			}else{
				System.out.println("No such move");
			}
			break;
		case search:
			player = LocHandlers.search(player, items);
			break;
			default:
				switch (ShorthandCommands.valueOf(command.split("")[0])){
				case use:
					items.useItem(command, player);
					break;
				case talk:
					LocHandlers.talk(player, items);
					break;
				case look:
					LocHandlers.look(player);
					break;
				case open:
					LocHandlers.open(player);
					break;
				case hunt:
					player.hunt(player, items);
					break;
				case make:
					LocHandlers.make(player);
					break;
				case equip:
					items.equipItem(command, player);
					break;
				default:
					player = Locations.action(command, player, items);
			}	
		}		
	}
}

				

		
		


	
	
