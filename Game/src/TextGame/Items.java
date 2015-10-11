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
		copperSword = new Weapon ("copper sword", Input.dice(6,10) + 6 , 0, "You slash it with your copper sword.", 0, 1, false, false, false, 500);
		items.add(copperSword);
		copperHelmet = new Helmet ("copper helmet", 1, false, false, false, 200, 5);
		items.add(copperHelmet);
		copperArmor = new Armor ("copper armor", 1, false, false, false, 750, 2, 10);
		items.add(copperArmor);
		copperShield = new Shield ("copper shield", 1, false, false, false, 300, 5, 5);
		items.add(copperShield);
		leatherArmor = new Armor ("leather armor", 1, false, false, false, 250, 1, 5);
		items.add(leatherArmor);
		hide = new Item ("hide", 1, false, false, false, 20, 0);
		items.add(hide);
		goldenChestnut = new Item ("golden chestnut", 1, true, true, false, 15, 0);
		items.add(goldenChestnut);
		farmKey = new Item ("farm key", 1, false, false, true, 0, 0);
		items.add(farmKey);
		milk = new Item ("milk", 1, true, true, false, 20, 0);
		items.add(milk);
		cheese = new Item ("cheese", 1, true, true, false, 40, 0);
		items.add(cheese);
	}
	private Character weaponSwap (Character player, Item weapon){
		player.removeItem(weapon);
		Item spare = player.setWeapon((Weapon) weapon);
		System.out.println("You equipped a " + weapon.getName() + ".");
		player.addItem(spare);
		return player;
	}
	private Character shieldSwap (Character player, Item shield){
		player.removeItem(shield);
		Item spare = player.setShield((Shield) shield);
		System.out.println("You equipped a " + shield.getName() + ".");
		player.addItem(spare);
		return player;
	}
	private Character armorSwap (Character player, Item armor){
		player.removeItem(armor);
		Item spare = player.setArmor((Armor) armor);
		System.out.println("You equipped a " + armor.getName() + ".");
		player.addItem(spare);
		return player;
	}
	private Character helmetSwap (Character player, Item helmet){
		player.removeItem(helmet);
		Item spare = player.setHelmet((Helmet) helmet);
		System.out.println("You equipped a " + helmet.getName() + ".");
		player.addItem(spare);
		return player;
	}
	public Character setEquipment (Item item, Character player){
		Item oldItem = player.getEquipment().set(item.getEquipment(), item);
		if (item != oldItem){
			switch (item.getName()){
			case "copper sword":
				player = weaponSwap(player, copperSword);
				break;
			case "copper shield":
				player = shieldSwap(player, copperShield);
				break;
			case "copper helmet":
				player = helmetSwap(player, copperHelmet);
				break;
			case "copper armor":
				player = armorSwap(player, copperArmor);
				break;
			case "leather armor":
				player = armorSwap(player, leatherArmor);
				break;
				default:
					System.out.println("Sorry, you cannot equip that.");
			}
		}
		return player;
	}
	public Character useItem(String command, Character player){
		switch (command){
		case "use vine juice": 
		case "use vinejuice": 
		case "drink vinejuice":
		case "drink vine juice":
		case "vinejuice":
		case "vine juice":
		player = useVineJuice(player);
		player.setItemUsed(true);
		break;
		case "use potion":
		case "drink potion":
		case "potion":
			player = usePotion(player);
			player.setItemUsed(true);
			break;
		case "use ether":
		case "drink ether":
		case "ether":
			player = useEther(player);
			player.setItemUsed(true);
			break;
		case "use elixer":
		case "drink elixer":
		case "elixer":
			player = useElixer(player);
			player.setItemUsed(true);
		break;
		case "drink milk":
		case "use milk":
		case "milk":
			player = useMilk(player);
			break;
		case "use cheese":
		case "eat cheese":
		case "cheese":
			player = useCheese(player);
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
	public Character useMilk(Character player){
		if (player.getInventory().contains(milk)){
			player.removeItem(milk);
			player.setHP(player.getHP() + 50);
			System.out.println("It tastes pleasant and creamy.");
			System.out.println("You gained 50 hp.");
			player.setItemUsed(true);
		} else {
			System.out.println("You don\'t have any milk.");
		}
		return player;
	}
	public Character useCheese(Character player){
		if (player.getInventory().contains(cheese)){
			player.removeItem(cheese);
			player.setMana(player.getMana() + 50);
			System.out.println("It tastes rich and salty.");
			System.out.println("You gained 50 mana.");
			player.setItemUsed(true);
		} else {
			System.out.println("You don\'t have any cheese.");
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
