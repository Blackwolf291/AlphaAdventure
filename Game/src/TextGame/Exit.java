package TextGame;

public enum Exit {
	undefined("undefined","null"),
	north("north", "n"), 
	east("east", "e"), 
	south("south", "e"), 
	west("west", "w"), 
	northeast("northeast", "ne"), 
	northwest("northwest", "nw"), 
	southeast("southeast", "se"), 
	southwest("southwest", "sw"), 
	up("up", "u"), 
	down("down", "d"), 
	in("in", "i"), 
	out("out", "o"), 
	special("special", "sp");
	private final String fullName;
	private final String shortName;
	Exit(String fullName, String shortName){
		this.fullName = fullName;
		this.shortName = shortName;
	}

	public String getDirectionName() {
		return fullName;
	}

	public String getShortDirectionName() {
		return shortName;
	}
	public static Exit find(String command) {
		try{
			return Exit.valueOf(command);
		}catch(IllegalArgumentException e){
		return undefined;
		}
	}
}