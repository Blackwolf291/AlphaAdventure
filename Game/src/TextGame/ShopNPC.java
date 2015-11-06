package TextGame;

public class ShopNPC extends NPC{

	public String salesLine;
	public String playerOversell;
	public String sellAmount;
	public String choosePurchase;
	public String whatAreYouSaying;
	public char[] conversation;
	public char[] craftMessage;
	public String standardRefuse;

	public ShopNPC(String npcName, String npcDescription, String npcTalkTo) {
		super(npcName, npcDescription, npcTalkTo);
		// TODO Auto-generated constructor stub
	}

}
