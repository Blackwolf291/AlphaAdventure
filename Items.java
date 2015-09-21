package TextGame;

import java.util.Vector;

public class Items {

	Vector<Item> items = new Vector<Item>();
	Vector<Item> inventory = new Vector<Item>();
	private Item None;
	private Item brothersScarf;
	private Item vineJuice;
	private Item potion;
	private Item ether;
	private Item elixer;
	private Item copperSword;
	private Item copperShield;
	private Item copperHelmet;
	private Item copperArmor;
	private Item leatherArmor;
	private Item hide;
	private Item goldenChestnut;
	private Item farmKey;
	private Item milk;
	private Item cheese;
	public Items(){		
		None = new Item ("none", 0, false, false, false, 0, 0);
		items.add(None);
		brothersScarf = new Item ("brother\'s scarf", 1, false, false, true, 0, 2);
		items.add(brothersScarf);
		vineJuice = new Item ("vine juice", 1, true, true, false, 5, 0);
		items.add(vineJuice);
		potion = new Item ("potion", 1, true, true, false, 100, 0);
		items.add(potion);
		ether = new Item ("ether", 1, true, true, false, 100, 0);
		items.add(ether);
		elixer = new Item ("elixer", 1, true, true, false, 400, 0);
		items.add(elixer);
		copperSword = new Item ("copper sword", 1, false, false, false, 500, 4);
		items.add(copperSword);
		copperHelmet = new Item ("copper helmet", 1, false, false, false, 200, 1);
		items.add(copperHelmet);
		copperArmor = new Item ("copper armor", 1, false, false, false, 750, 3);
		items.add(copperArmor);
		copperShield = new Item ("copper shield", 1, false, false, false, 300, 5);
		items.add(copperShield);
		leatherArmor = new Item ("leather armor", 1, false, false, false, 250, 3);
		items.add(leatherArmor);
		hide = new Item ("hide", 1, false, false, false, 20, 0);
		items.add(hide);
		goldenChestnut = new Item ("golden chestnut", 1, true, true, false, 15, 0);
		items.add(goldenChestnut);
		farmKey = new Item ("farm key", 1, false, false, true, 0, 0);
		items.add(farmKey);
	}
	public Character addCopperSword (Character player){
		player.setAttack(player.getAttack() + 10);
		return player;
	}
	public Character removeCopperSword (Character player){
		player.setAttack(player.getAttack() - 10);
		return player;
	}
	public Character addCopperShield (Character player){
		player.setShield(player.getShield() + 5);
		return player;
	}
	public Character removeCopperShield(Character player){
		player.setShield(player.getShield() - 5);
		return player;
		
	}
	public Character addCopperHelmet (Character player){
		player.setShield(player.getShield() + 5);
		return player;
	}
	public Character removeCopperHelmet(Character player){
		player.setShield(player.getShield() - 5);
		return player;
	}
	public Character addCopperArmor (Character player){
		player.setShield(player.getShield() + 10);
		player.setSpeed(player.getSpd() - 4);
		return player;
	}
	public Character removeCopperArmor (Character player){
		player.setShield(player.getShield() - 10);
		player.setSpeed(player.getSpd() + 4);
		return player;
	}
	public Character addLeatherArmor (Character player){
		player.setShield(player.getShield() + 5);
		player.setSpeed(player.getSpd() - 2);
		return player;
	}
	public Character removeLeatherArmor (Character player){
		player.setShield(player.getShield() - 5);
		player.setSpeed(player.getSpd() + 2);
		return player;
	}
	public Character setEquipment (Item item, Character player){
		Item oldItem = player.getEquipment().set(item.getEquipment(), item);
		if (item != oldItem){
		switch (item.getName()){
		case "copper sword":
			player.removeItem(copperSword);
			addCopperSword(player);
			System.out.println("You equipped a copper sword.");
			break;
		case "copper shield":
			player.removeItem(copperShield);
			addCopperShield(player);
			System.out.println("You equipped a copper shield.");
			break;
		case "copper helmet":
			player.removeItem(copperHelmet);
			addCopperHelmet(player);
			System.out.println("You equipped a copper helmet.");
			break;
		case "copper armor":
			switch (oldItem.getName()){
			case "none":
				player.removeItem(copperArmor);
				addCopperArmor(player);
				System.out.println("You equipped a copper armor.");
			case "leather armor":
				player.removeItem(copperArmor);
				player.addItem(leatherArmor);
				addCopperArmor(player);
				removeLeatherArmor(player);
				System.out.println("You equipped a copper armor. \nYour leather armor was added to your inventory.");
			}
			break;
		case "leather armor":
					switch (oldItem.getName()){
					case "none":
						player.removeItem(leatherArmor);
						addLeatherArmor(player);
						System.out.println("You equipped a leather armor.");
					case "leather armor":
						player.removeItem(leatherArmor);
						player.addItem(copperArmor);
						addLeatherArmor(player);
						removeCopperArmor(player);
						System.out.println("You equipped a leather armor. \nYour copper armor was added to your inventory.");
					}
					break;
		}
		}
		return player;
		}
	public Character useItem(String command, Character player){
		switch (command){
		case "use vine juice": 
		case "use vinejuice": 
		case "vinejuice":
		case "vine juice":
		player = useVineJuice(player);
		break;
		case "use potion":
		case "potion":
			player = usePotion(player);
		break;
		case "use ether":
		case "ether":
			player = useEther(player);
			break;
		case "use elixer":
		case "elixer":
			player = useElixer(player);
		break;
		case "return":
			player.setItemUsed(false);
			break;
		default:
			System.out.println("You don't own such a thing.");
		}
		return player;
	}
	public Character equipItem(String command, Character player){
		switch (command){
		case "equip copper armor": 
		case "equip copperarmor": 
		player = setEquipment(copperArmor, player);
		break;
		case "equip copper helmet":
		case "equip copperhelmet":
			player = setEquipment(copperHelmet, player);
		break;
		case "equip copper shield":
		case "equip coppershield":
			player = setEquipment(copperShield, player);
		break;
		case "equip copper sword":
		case "equip coppersword":
			player = setEquipment(copperSword, player);
		break;
		case "equip leather armor": 
		case "equip leatherarmor": 
		player = setEquipment(leatherArmor, player);
		break;
		default:
			System.out.println("You don't own such a thing.");
		}
		return player;
	}
	public Character useEther(Character player){
		if (player.getInventory().contains(ether)){
			player.removeItem(ether);
			player.setMana(player.getMana() + 100);
			System.out.println("It tastes bitter but it is strongly healing.");
			System.out.println("You gained 100 hp.");
			player.setItemUsed(true);
		} else {
			System.out.println("You don\'t have any Ethers.");
		}
		return player;
	}
	public Character useElixer(Character player){
		if (player.getInventory().contains(elixer)){
			player.removeItem(ether);
			player.setHP(player.getHP() + 100);
			player.setMana(player.getMana() + 100);
			System.out.println("It tastes bitter but it is strongly healing.");
			System.out.println("You gained 100 hp.");
			player.setItemUsed(true);
		} else {
			System.out.println("You don\'t have any Ethers.");
		}
		return player;
	}
	public Character usePotion(Character player){
		if (player.getInventory().contains(potion)){
			player.removeItem(potion);
			player.setHP(player.getHP() + 100);
			System.out.println("It tastes bitter but it is strongly healing.");
			System.out.println("You gained 100 hp.");
			player.setItemUsed(true);
		} else {
			System.out.println("You don\'t have any potions.");
		}
		return player;
	}
	public Character useVineJuice(Character player){
		if (player.getInventory().contains(vineJuice)){
			player.removeItem(vineJuice);
			player.setHP(player.getHP() + 25);
			System.out.println("It tastes like honey syrup, and refuels you for the journey.");
			System.out.println("You gained 25 hp.");
			player.setItemUsed(true);
		} else {
			System.out.println("You don\'t have any vine juice.");
		}
		return player;
	}
	public Vector<Item> getItems(){
		return items;
	}
	public Vector<Item> getInventory(){
	return inventory;
	}
	
	public static boolean Item () {
		boolean used = false;
		return used;
		
	}
}
