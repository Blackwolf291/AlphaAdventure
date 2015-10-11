package TextGame;

import java.util.Random;
import java.util.Scanner;

public class Input{
	public static Scanner scan = new Scanner(System.in);
	public static Random randomGenerator = new Random();
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
	public static String getInput() {
		String input = scan.nextLine();
        input.toLowerCase();
        return input;
    }
	
	public static String getCapInput() {
		String capInput = scan.nextLine();
        return capInput;
	}
	public static int getInteger() {
		int number = scan.nextInt();
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