package TextGame;

public class InGameTime {
	private static int turnCounter = 0;
	private static int hourCounter = 1;
	private static String ampm = "PM";
	private static int dayCounter = 1;
	public static void addTime(int turns) {
		turnCounter += turns;
		if (turnCounter >= 12){
			turnCounter -= 12;
			hourCounter++;
		}
		if (hourCounter > 12){
			hourCounter -= 12;
			if (ampm.equals("PM")){
				ampm = "AM";
				dayCounter++;
			}else{
				ampm = "PM";
			}
		}
	}
	public static void addTurn(){
		addTime(1);
	}
	public static String getTime(){
		String time = ("Day " + dayCounter + ", " + hourCounter + ":" + makeMinutes() + ampm);
	return time;
	}
	public static int getTurnCount(){
		return turnCounter;
	}
	private static String makeMinutes(){
		String minutes = "";
		if (turnCounter%12 == 1){
			minutes = "05";
		} else if (turnCounter%12 == 0){
			minutes = "00";
		} else {
			minutes += turnCounter%12*5;
		}
		return minutes;
	}
}
