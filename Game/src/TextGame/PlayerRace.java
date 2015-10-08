package TextGame;

public class PlayerRace {

	private String name;
	private String altName;
	private String faceDescription;
	private String bodyDescription;
	private String pawDescription;
	private String unarmedStrikeName;
	private String unarmedStrikeDescription;
	private boolean tail;
	private String tailDescription;
	public PlayerRace(String raceName, String raceAltName, String raceFace, String raceBody, String racePaw, String raceAttack, String raceUnarmedStrike, boolean raceTail, String raceTailDescription){
		name = raceName;
		altName = raceAltName;
		faceDescription = raceFace;
		bodyDescription = raceBody;
		pawDescription = racePaw;
		unarmedStrikeName = raceAttack;
		unarmedStrikeDescription = raceUnarmedStrike;
		tail = raceTail;
		tailDescription = raceTailDescription;
	}

	public String getAttack(){
		return unarmedStrikeName;
	}
	public boolean hasTail(){
		return tail;
	}
	public String getTail(){
		return tailDescription;
	}
	public String getUnarmedStrike(){
		return unarmedStrikeDescription;
	}
	public String getPaw(){
		return pawDescription;
	}
	public String getbody(){
		return bodyDescription;
	}
	public String getface(){
		return faceDescription;
	}
	public String getAltName(){
		return altName;
	}
	public String getName(){
		return name;
	}
}
