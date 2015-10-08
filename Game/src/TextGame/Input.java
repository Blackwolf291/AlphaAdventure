package TextGame;

import java.util.Random;
import java.util.Scanner;

public class Input{
	
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
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String input = scan.nextLine();
        input.toLowerCase();
        return input;
    }
	
	public static String getCapInput() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		String capInput = scan.nextLine();
        return capInput;
	}
	public static int getInteger() {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
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

			Random randomGenerator = new Random();
			int result = 0;
			for (int i = dice; i > 0;i--){
				result = result + randomGenerator.nextInt(diesize);
			}
			return result;
			}
			public static boolean coin () {
				Random randomGenerator = new Random();
				boolean result = randomGenerator.nextBoolean();
				return result;
			}
	
}