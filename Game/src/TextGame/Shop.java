package TextGame;

import java.util.Vector;

public class Shop {
	ShopNPC salesPerson;
	Item[] buyables;
	Vector<Item> craftables;
	boolean willBuy;
	public Shop(NPC coon, Item[] shopList, boolean willBuy, Vector<Item> craftables){
		this.salesPerson = (ShopNPC) coon;
		this.buyables = shopList;
		this.craftables = craftables;
		this.willBuy = willBuy;
	}
	
	public Character runShop(Character player) {
		System.out.println(salesPerson.getTalkTo());
		String shop = "";
		while (shop == "");
		System.out.println("Buy, Sell, Craft, Talk");
		shop = Input.getInput();
		switch (shop){
		case "buy": 
		case "b": 
			player = buyShop(player);
		case "sell":
		case "s":
			if (willBuy){
				player = sell(player);
			} else {
				System.out.println(salesPerson.standardRefuse);
			}
			break;
		case "talk":
		case "t":
			System.out.println(salesPerson.conversation);	
			break;
		case "craft":
		case "c":
			if (craftables != null){
				player = craft(player);
			}else{
				System.out.println(salesPerson.standardRefuse);
			}
			break;
		default: 
			System.out.println(salesPerson.whatAreYouSaying);
			shop = "";
		}
		return player;
	}
	
	public Character buyShop (Character player){
		System.out.println(salesPerson.choosePurchase);
		printItemList(buyables);
		System.out.println("You have " + player.getGold() + "gold.");
		return player;
	}
	
	private static void printItemList(Item[] forSale){
		System.out.println("Item \tPrice.");
		for (int i = 0; i< forSale.length; i++){
			System.out.println(forSale[i] + "\t" + forSale[i].getValue());
		}
	}
	
	private static Character canBuyItem(Character player, Item item){
		if (player.getGold() >= item.getValue()){
			player = buyItem(player, item);
		} else {
			System.out.println("You don\'t have that kind of money.");
		}
		return player;
	}
	
	private static Character buyItem(Character player, Item item){
		player.setGold(player.getGold()-item.getValue());
		System.out.println("You bought the " + item);
		return player;
	}
	
	Character sell(Character player) {
			return player;
	}
	private Character sellItem(Item itemToSell, Character player){
		System.out.println(salesPerson.sellAmount);	
		int number = -1;
		while (number == -1){
			number = Input.getInteger();
			if (number >= 0 && number <= itemToSell.getCount()){
				System.out.println("Sold for " + itemToSell.getValue()/2 + " Gold");
				player.setGold(itemToSell.getValue()/2);
			} else{
				System.out.println(salesPerson.playerOversell);
				number = -1;
			}
		}
		return player;
	}
	private static Item inputToItem(Vector<Item> vector){
		String Sale = Input.getInput();
		for (int i = 0;i < vector.size();i++){
			if (Sale.equals(vector.get(i))){
				return vector.get(i);
			}
		}
		return null;
	}

	

	private Character craft(Character player) {
		// TODO Auto-generated method stub
		return null;
	}
}
