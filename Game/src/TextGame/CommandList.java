package TextGame;

public enum CommandList {
	inventory, hunt, spells, talk, open, save, make, look, heal, fire, search, other;

	public static CommandList find(String command) {
		try{
			return CommandList.valueOf(command);
		}catch(IllegalArgumentException e){
		return other;
		}
	}
}
