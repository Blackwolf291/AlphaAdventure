package TextGame;

import java.util.Random;

public class Input{
	private static Random randomGenerator = new Random();
	private static InputHolder holder = new InputHolder();
	public static boolean convertYesNoToBoolean(){
		boolean confirm = false;
 		try{
 			confirm = askYesNo();
 		}catch (IllegalArgumentException e){
 			confirm = convertYesNoToBoolean();
 		}
 		return confirm;
	}
	private static boolean askYesNo() {
		boolean confirm;
 		switch(getUntimedInput()) {
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
     			throw new IllegalArgumentException();
 		}
		return confirm;
	}
	public static Item chooseItem (Item[] options){
		Item itemChoice = null;
		while (itemChoice == null){
			itemChoice = findItem(options, Input.getInput());
		}
		return itemChoice;
	}
	private static Item findItem(Item[] options, String choice){
		for (int i = 0; i< options.length; i++){
			if (choice.equals(options[i].toString())){
				return options[i];
			}
		}
		System.out.println("Sorry, that's not an option.");
		return null;
	}
	public static String getInput() {
		System.out.print(InGameTime.getTime()+">");
		String input = holder.getNewInput();
		String result = input.toLowerCase();
		return result;
    }
	public static String getUntimedInput() {
		System.out.print(">");
		String input = holder.getNewInput();
        return input.toLowerCase();
	}
	public static void waitForPlayer(){
		System.out.println("Press enter to continue.");
		holder.getNewInput();
	}
	public static String getCapInput() {
		System.out.print(">");
		String capInput = holder.getNewInput();
        return capInput;
	}
	public static int getInteger() {
		int number = 0;
		try{
			number = askInteger();
		} catch (NumberFormatException e) { 
			number = getInteger();
		}
		return number;
	}
	private static int askInteger(){
		System.out.print(InGameTime.getTime()+">");
		return Integer.parseInt(holder.getNewInput());
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
	public static void addInput(String input){
		holder.addNewInput(input);
	}
}