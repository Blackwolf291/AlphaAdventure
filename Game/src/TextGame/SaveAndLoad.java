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
	public static Character loadGame(Character player) throws IOException, ClassNotFoundException{
			FileInputStream playerLoad = new FileInputStream("/tmp/saveGame.ser");
			ObjectInputStream load = new ObjectInputStream(playerLoad);
			player = (Character) load.readObject();
			load.close();
			playerLoad.close();
		
		
		return player;
	}
}
