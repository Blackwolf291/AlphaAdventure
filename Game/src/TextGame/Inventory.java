package TextGame;

import java.util.Vector;

public class Inventory {
	Vector<Item> items = new Vector<>();
	private Vector<Key> keychain = new Vector<>();
	public void printCombatInventory(){
		for (int i = 0; i < items.size(); i++){
			if (items.get(i).getCombatUse()){
				System.out.println(items.get(i).getCount() + items.get(i).getName() + ", ");
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
				System.out.println(this.items.get(i).getCount() + this.items.get(i).getName() + ", ");
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
				System.out.println(items.get(i).getCount() + "  " + items.get(i).getName() + "  " + items.get(i).getValue()/2);
			}
		}
	}
	Character weaponSwap (Character player, Item weapon){
		removeItem(weapon);
		Item spare = player.setWeapon((Weapon) weapon);
		System.out.println("You equipped a " + weapon.getName() + ".");
		addItem(spare);
		return player;
	}
	Character shieldSwap (Character player, Item shield){
		removeItem(shield);
		Item spare = player.setShield((Shield) shield);
		System.out.println("You equipped a " + shield.getName() + ".");
		addItem(spare);
		return player;
	}
	Character armorSwap (Character player, Item armor){
		removeItem(armor);
		Item spare = player.setArmor((Armor) armor);
		System.out.println("You equipped a " + armor.getName() + ".");
		addItem(spare);
		return player;
	}
	Character helmetSwap (Character player, Item helmet){
		removeItem(helmet);
		Item spare = player.setHelmet((Helmet) helmet);
		System.out.println("You equipped a " + helmet.getName() + ".");
		addItem(spare);
		return player;
	}
	public Vector<Key> getKeychain() {
		return keychain;
	}
	
}
