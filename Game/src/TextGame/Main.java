package TextGame;

import java.io.IOException;

public class Main{
	
	static String command;
	static Items items;
	static Character player;
	static void initiateGame(){
		launchFrame();
		items = new Items();
		tryLoadGame();
		InGameTime.setDefaultTime();
		if (player == null){
			player = new Character();
		}
		@SuppressWarnings("unused")
		Locations worldMap = new Locations(items, player);
    	System.out.println("Alpha adventure");  
    	GameScreen.textArea.setText("");
		System.out.println( "You wake up on the beach.\nThe sand feels warm, and you can't remember how you got here.\nYou see the wreck of a ship to the North, \nand a dense forest to the East.");
		
	}
	static void launchFrame() {
		Runnable frame = new GameScreen();
		frame.run();
	}
	private static void tryLoadGame() {
		
		try {
			persistLoadGame();
		} catch (ClassNotFoundException e) {
			System.out.println("save data corrupted");
			tryLoadGame();
		} catch (IOException e) {
			System.out.println("no save data present");
			tryLoadGame();
		}
		
	}
	private static void persistLoadGame() throws ClassNotFoundException, IOException {
		System.out.println("Do you wish to load your last save game?");
    	if (Input.yesNo(player)){
    	  		player = SaveAndLoad.loadGame(player);
    	}
    	else{
    		player = null;
    	}
	}
	private static void startTurn(){
		InGameTime.addTurn();
		player.addMana(player.think());
		System.out.println("Other commands: Inventory, Stats, Save");
	}
	private static void runGameLoop(){
		boolean running = true;
		while (running){
			startTurn();
			command = Input.getInput();
			parseAndExecuteCommand();
		}
	}
	public static void main (String[] args) {
		initiateGame();
		runGameLoop();
	}
	
	private static void parseAndExecuteCommand(){
		switch (CommandList.find(command)){
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
			if (player.hasSpell(Locations.minorHeal)){
				player = Locations.minorHeal.cast(player);
			}else{
				System.out.println("No such move");
			}
			break;
		case fire:
			if (player.hasSpell(Locations.fireball)){
				player = Locations.fireball.cast(player);
			}else{
				System.out.println("No such move");
			}
			break;
		case search:
			player = LocHandlers.search(player, items);
			break;
			default:
				switch (ShorthandCommands.find(command.split("")[0])){
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
					player.getInventory().equipItem(command, items);
					break;
				default:
					player = Locations.action(command, player, items);
			}	
		}
		Input.waitForPlayer();
		GameScreen.textArea.setText("");
		System.out.println( player.getCurrentLocation().toString());
		System.out.println( player.getCurrentLocation().getDescription());
		player.getCurrentLocation().printOptions();
	}
}

				

		
		


	
	
