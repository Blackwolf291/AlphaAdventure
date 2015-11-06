package TextGame;

import java.util.Random;

public class Input{
	public static Random randomGenerator = new Random();
	public static InputHolder holder = new InputHolder();
	public static boolean yesNo(Character player){
		boolean confirm = false;
 		String Choice = "";
 		while (Choice.length() < 1){
 			Choice = getInput();
     		switch(Choice) {
         		case "yes":
         		case "y":
         			confirm = true;
         			break;
         		case "no":
         		case "n": 	
         			confirm = false;
         			break;
         		default:
         			System.out.println("a yes or no answer will do");
         			Choice = "";
     		}
 		
 		}	
 		return confirm;
	}
	public static Item chooseItem (Item[] options){
		Item itemChoice = null;
		while (itemChoice == null){
			String choice = Input.getInput();
			itemChoice = findItem(options, choice);
		}
		return itemChoice;
	}
	public static Item findItem(Item[] options, String choice){
		for (int i = 0; i< options.length; i++){
			if (choice == options[i].getName()){
				return options[i];
			}
		}
		System.out.println("Sorry, that's not an option.");
		return null;
	}
	public static String getInput() {
		System.out.print("Day " + Main.dayCounter + ", " + Main.hourCounter + ":" + (Main.turnCounter*5) + Main.ampm + ">");
		String input = holder.getNewInput();
        return input.toLowerCase();
    }
	
	public static String getCapInput() {
		System.out.print("Day " + Main.dayCounter + ", " + Main.hourCounter + ":" + (Main.turnCounter*5) + Main.ampm + ">");
		String capInput = holder.getNewInput();
        return capInput;
	}
	public static int getInteger() {
		System.out.print("Day " + Main.dayCounter + ", " + Main.hourCounter + ":" + (Main.turnCounter*5) + Main.ampm + ">");
		int number = Integer.parseInt(holder.getNewInput());
        return number;
	}
	 public static boolean okay() {
			System.out.println("are you sure?");
	 		System.out.println("Yes or No");
	 		boolean confirm = false;
	 		String Choice = "";
	 		while (Choice.length() < 1){
	 			Choice = getInput();
	     		switch(Choice) {
	         		case "yes":
	         		case "y":
	         			confirm = true;
	         			break;
	         		case "no":
	         		case "n": 	
	         			confirm = false;
	         			break;
	         		default:
	         			System.out.println("a yes or no answer will do");
	         			Choice = "";
	     		}
	 		
	 		}	
	 		return confirm;
		 }
	 public static int dice(int dice, int diesize){
		int result = 0;
		for (int i = dice; i > 0;i--){
			result = result + randomGenerator.nextInt(diesize);
		}
		return result;
	}
	public static boolean coin () {
		boolean result = randomGenerator.nextBoolean();
		return result;
	}
	
}