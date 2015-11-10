package TextGame;

public class InGameTime {
	private static int turnCounter;
	private static int hourCounter;
	private static String ampm;
	private static int dayCounter;
	private static int trueTurnCount;
	public static void addTurn(){
		addTime(1);
	}
	public static void addTime(int turns) {
		turnCounter += turns;
		trueTurnCount += turns;
		calcHour();
	}
	private static void calcHour(){
		while (turnCounter >= 12){
			turnCounter -= 12;
			hourCounter++;
			calcHalfDay();
		}
	}
	private static void calcHalfDay(){
		if (hourCounter > 12){
			hourCounter -= 12;
			setHalfDayChange();
		}
	}
	private static void setHalfDayChange(){
		if (ampm.equals("PM")){
			ampm = "AM";
			dayCounter++;
		}else{
			ampm = "PM";
		}
	}
	public static void setDefaultTime(){
		turnCounter = 0;
		hourCounter = 1;
		ampm = "PM";
		dayCounter = 1;
		trueTurnCount = 0;
	}
	public static String getTime(){
		String time = ("Day " + dayCounter + ", " + hourCounter + ":" + makeMinutes() + ampm);
	return time;
	}
	public static int getTurnCount(){
		return trueTurnCount;
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
