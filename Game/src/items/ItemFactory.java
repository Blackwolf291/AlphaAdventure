package items;

import static items.ItemList.copperArmor;
import static items.ItemList.copperHelmet;
import static items.ItemList.copperShield;
import static items.ItemList.copperSword;
import static items.ItemList.farmKey;
import static items.ItemList.hide;
import static items.ItemList.leatherArmor;
import static items.ItemList.leatherHelmet;
import static items.ItemList.none;
import static items.ItemList.nullArmor;
import static items.ItemList.nullHelmet;
import static items.ItemList.nullShield;
import static items.ItemList.nullWeapon;
import static items.ItemList.stick;
import static items.ItemList.woodenShield;

import java.util.EnumMap;
import java.util.Map;

import TextGame.Item;
import items.equipment.armor.CopperArmor;
import items.equipment.armor.LeatherArmor;
import items.equipment.armor.NullArmor;
import items.equipment.helmets.CopperHelmet;
import items.equipment.helmets.LeatherHelmet;
import items.equipment.helmets.NullHelmet;
import items.equipment.shields.CopperShield;
import items.equipment.shields.NullShield;
import items.equipment.shields.WoodenShield;
import items.equipment.weapons.CopperSword;
import items.equipment.weapons.NullWeapon;
import items.equipment.weapons.Stick;
import items.keys.FarmKey;
import items.materials.Hide;

public class ItemFactory {
	private static ItemFactory factory = new ItemFactory();
	public static ItemFactory getFactory(){
		return factory;
	}
	private Map<ItemList, Item> itemMap = new EnumMap<>(ItemList.class);
	
private ItemFactory(){
		itemMap.put(none, new NullItem());
		itemMap.put(hide, new Hide());
		itemMap.put(farmKey, new FarmKey());
		itemMap.put(nullArmor, new NullArmor());
		itemMap.put(leatherArmor, new LeatherArmor());
		itemMap.put(copperArmor, new CopperArmor());
		itemMap.put(nullWeapon, new NullWeapon());
		itemMap.put(stick, new Stick());
		itemMap.put(copperSword, new CopperSword());
		itemMap.put(nullShield, new NullShield());
		itemMap.put(woodenShield, new WoodenShield());
		itemMap.put(copperShield, new CopperShield());
		itemMap.put(nullHelmet, new NullHelmet());
		itemMap.put(leatherHelmet, new LeatherHelmet());
		itemMap.put(copperHelmet, new CopperHelmet());
	}
	public Item get(ItemList itemName){
		return itemMap.get(itemName);
	}
}
