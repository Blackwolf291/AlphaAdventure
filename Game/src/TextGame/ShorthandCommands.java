package TextGame;

public enum ShorthandCommands {
	use, talk, look, open, hunt, equip, make, other;
	public static ShorthandCommands find(String command) {
		try{
			return ShorthandCommands.valueOf(command);
		}catch(IllegalArgumentException e){
		return other;
		}
	}
}
