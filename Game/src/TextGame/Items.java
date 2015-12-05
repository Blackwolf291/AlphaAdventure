package TextGame;

import java.util.Vector;

public class Items {

	Vector<Item> items = new Vector<Item>();
	Item None;
	Item brothersScarf;
	Item vineJuice;
	Item potion;
	Item ether;
	Item elixer;
	Item copperSword;
	Item copperShield;
	Item copperHelmet;
	Item copperArmor;
	Item leatherArmor;
	Item hide;
	Item goldenChestnut;
	Item farmKey;
	Item milk;
	Item cheese;
	public Items(){		
		None = new Item ("none", 0, false, false, false, 0);
		items.add(None);
		brothersScarf = new Item ("brother\'s scarf", 1, false, false, true, 0);
		items.add(brothersScarf);
		vineJuice = new HPItem ("vine juice", 1, true, true, false, 5, 50, "It\'s sweet and invigorating.");
		items.add(vineJuice);
		potion = new HPItem ("potion", 1, true, true, false, 100, 100, "It\'s bitter, and tastes medicinal.");
		items.add(potion);
		ether = new MPItem ("ether", 1, true, true, false, 100, 100, "It\'s bitter, and tastes medicinal.");
		items.add(ether);
		elixer = new HPAndMPItem ("elixer", 1, true, true, false, 400, 100, 100, "It\'s bitter, and tastes medicinal.");
		items.add(elixer);
		copperSword = new Weapon ("copper sword", Input.dice(6,10) + 6 , 0, "You slash it with your copper sword.", 0, 1, false, false, false, 500);
		items.add(copperSword);
		copperHelmet = new Helmet ("copper helmet", 1, false, false, false, 200, 5);
		items.add(copperHelmet);
		copperArmor = new Armor ("copper armor", 1, false, false, false, 750, 5, 1);
		items.add(copperArmor);
		copperShield = new Shield ("copper shield", 1, false, false, false, 300, 5, 0);
		items.add(copperShield);
		leatherArmor = new Armor ("leather armor", 1, false, false, false, 250, 1, 5);
		items.add(leatherArmor);
		hide = new Material ("hide", 1, false, false, false, 20);
		items.add(hide);
		goldenChestnut = new HPItem ("golden chestnut", 1, true, true, false, 15, 0, "It\'s crunchy, but does feel great.");
		items.add(goldenChestnut);
		farmKey = new Key ("farm key", 1, Locations.farmHouse, Exit.in, Locations.farmHouseInside);
		items.add(farmKey);
		milk = new HPItem ("milk", 1, true, true, false, 20, 100, "It\'s creamy.");
		items.add(milk);
		cheese = new HPAndMPItem ("cheese", 1, true, true, false, 40, 50, 50, "");
		items.add(cheese);
	}
	public Character useItem(String command, Character player){
		switch (command){
		case "use vine juice": 
		case "use vinejuice": 
		case "drink vinejuice":
		case "drink vine juice":
		case "vinejuice":
		case "vine juice":
		player = vineJuice.use(player);
		player.setItemUsed(true);
		break;
		case "use potion":
		case "drink potion":
		case "potion":
			player = potion.use(player);
			player.setItemUsed(true);
			break;
		case "use ether":
		case "drink ether":
		case "ether":
			player = ether.use(player);
			player.setItemUsed(true);
			break;
		case "use elixer":
		case "drink elixer":
		case "elixer":
			player = elixer.use(player);
			player.setItemUsed(true);
		break;
		case "drink milk":
		case "use milk":
		case "milk":
			player = milk.use(player);
			break;
		case "use cheese":
		case "eat cheese":
		case "cheese":
			player = cheese.use(player);
			break;
		case "return":
			player.setItemUsed(false);
			break;
		default:
			System.out.println("You don't own such a thing.");
			player.setItemUsed(false);
		}
		return player;
	}
	public Vector<Item> getItems(){
		return items;
	}
	public static boolean Item () {
		boolean used = false;
		return used;
		
	}
}
