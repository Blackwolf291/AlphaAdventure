package TextGame;

import java.io.*;

public class SaveAndLoad {

	public static void saveGame(Character player){
		try {
			FileOutputStream playerSave = new FileOutputStream("/tmp/saveGame.ser");
			ObjectOutputStream save = new ObjectOutputStream(playerSave);
			save.writeObject(player);
			save.close();
			playerSave.close();
			System.out.println("game saved!");
		} catch (IOException e) {
			System.out.println("Failed to save the game.");
		}
		
	}
	public static Character loadGame(Character player){
		try {
			FileInputStream playerLoad = new FileInputStream("/tmp/saveGame.ser");
			ObjectInputStream load = new ObjectInputStream(playerLoad);
			player = (Character) load.readObject();
			load.close();
			playerLoad.close();
		} catch (IOException e) {
			System.out.println("No save game recorded.");
		} catch (ClassNotFoundException e) {
			System.out.println("You found a glitch in the save/load system. Please copy-paste this message to me.");
			e.printStackTrace();
		}
		
		return player;
	}
}
