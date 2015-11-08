package TextGame;

public class ShopNPC extends NPC{

	public String salesLine;
	public String playerOversell;
	public String sellAmount;
	public String choosePurchase;
	public String whatAreYouSaying;
	public String conversation;
	public String craftMessage;
	public String standardRefuse;

	public ShopNPC(String npcName, String npcDescription, String npcTalkTo, String salesLine, String playerOversell, String whatAreYouSaying, String sellAmount, String conversation, String choosePurchase, String craftMessage, String standardRefuse) {
		super(npcName, npcDescription, npcTalkTo);
		this.salesLine = salesLine;
		this.playerOversell = playerOversell;
		this.sellAmount = sellAmount;
		this.conversation = conversation;
		this.choosePurchase = choosePurchase;
		this.craftMessage = craftMessage;
		this.standardRefuse = standardRefuse;
		this.whatAreYouSaying = whatAreYouSaying;
	}

}
