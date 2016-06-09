package TextGame;

import java.io.IOException;

import items.ItemFactory;

public class Main{
	private static boolean running = true;
	private static String command;
	private static ItemFactory items;
	static Character player;
	static Runnable frame = new GameScreen();
	static void initiateGame(){
		launchFrame();
		items = ItemFactory.getFactory();
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
    	if (Input.convertYesNoToBoolean()){
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
			break;
		case open:
			break;
		case save:
			SaveAndLoad.saveGame(player);
			break;
		case make:
			break;
		case look:
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
			break;
		case quit:
			running = false;
			default:
				switch (ShorthandCommands.find(command.split("")[0])){
				case use:
					break;
				case talk:
					break;
				case look:
					break;
				case open:
					break;
				case hunt:
					player.hunt(player, items);
					break;
				case make:
					break;
				case equip:
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

				

		
		


	
	
