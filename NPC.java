package TextGame;

public class NPC {

	private String name;
	private String description;
	private String talkTo;
	public NPC(String npcName, String npcDescription, String npcTalkTo){
		name = npcName;
		description = npcDescription;
		talkTo = npcTalkTo;
	}
	public String getName(){
		return name;
	}
	public String getDescription(){
		return description;
	}
	public String getTalkTo(){
		return talkTo;
	}
}
