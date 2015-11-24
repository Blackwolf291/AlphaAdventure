package TextGame;

import java.util.Vector;

public class Inventory {
	Vector<Item> items = new Vector<>();
	private Vector<Key> keychain = new Vector<>();
	Equipment equipment;
	public void printCombatInventory(){
		for (int i = 0; i < items.size(); i++){
			if (items.get(i).getCombatUse()){
				System.out.println(items.get(i).getCount() + items.get(i).toString() + ", ");
			}
		}
		System.out.println("or you can RETURN.");
	}
	public void addItem(Item item){
		if (items.contains(item)){
			item.setCount(item.getCount() + 1);
			if (item instanceof Key){
				keychain.add((Key) item);
			}
		} else {
			items.addElement(item);
		}
		itemCleanup(item);
	}
	public void itemCleanup(Item item){
		if (item.getCount() == 0){
			items.removeElement(item);
		}
	}
	public void removeItem(Item item){
		item.setCount(item.getCount() - 1);
		itemCleanup(item);
	}
	public Character checkInventory(Character player, Items items) {
		if (this.items.size() > 0){
			for (int i = 0; i < this.items.size(); i++){
				System.out.println(this.items.get(i).getCount() + this.items.get(i).toString() + ", ");
			}
			System.out.println("or you can RETURN.");
		}else{
			System.out.println("Your pockets and bags are empty.");
		}
		String item = Input.getInput();
		player = items.useItem(item, player);
		return player;
	}
	public void printSellable(String salesLine) {
		System.out.println(salesLine);
		System.out.println("Count\tItem\tGoldvalue.");
		for (int i = 0;i < items.size();i++){
			if (!items.get(i).getKeyItem()){
				System.out.println(items.get(i).getCount() + "  " + items.get(i) + "  " + items.get(i).getValue()/2);
			}
		}
	}
	public void equipItem(String command, Items items){
		switch (command){
		case "equip copper armor": 
		case "equip copperarmor": 
			armorSwap((Armor) items.copperArmor);
		break;
		case "equip copper helmet":
		case "equip copperhelmet":
			helmetSwap((Helmet) items.copperHelmet);
		break;
		case "equip copper shield":
		case "equip coppershield":
			shieldSwap((Shield) items.copperShield);
		break;
		case "equip copper sword":
		case "equip coppersword":
			weaponSwap((Weapon) items.copperSword);
		break;
		case "equip leather armor": 
		case "equip leatherarmor": 
			armorSwap((Armor) items.leatherArmor);
		break;
		default:
			System.out.println("Sorry, you cannot equip that or");
			System.out.println("you don\'t own such a thing.");
		}
	}
	void weaponSwap (Weapon weapon){
		removeItem(weapon);
		addItem(equipment.swapWeapon(weapon));
		System.out.println("You equipped a " + weapon + ".");
	}
	void shieldSwap (Shield shield){
		removeItem(shield);
		addItem(equipment.swapShield(shield));
		System.out.println("You equipped a " + shield + ".");
	}
	void armorSwap (Armor armor){
		removeItem(armor);
		addItem(equipment.swapArmor(armor));
		System.out.println("You equipped a " + armor + ".");
	}
	void helmetSwap (Helmet helmet){
		removeItem(helmet);
		addItem(equipment.swapHelmet(helmet));
		System.out.println("You equipped a " + helmet + ".");
	}
	public Vector<Key> getKeychain() {
		return keychain;
	}
	
}
