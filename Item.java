package TextGame;

public class Item {

	private String itemName;
	private int itemCount;
	private boolean itemUseInCombat;
	private boolean itemUseOutsideCombat;
	private boolean itemKey;
	private int itemValue;
	private int itemEquipment;
	public Item(String name, int count, boolean combatUse, boolean use, boolean keyItem, int value, int equipment) {
		itemName = name;
		itemCount = count;
		itemUseInCombat = combatUse;
		itemUseOutsideCombat = use;
		itemKey = keyItem;
		itemValue = value;
		itemEquipment = equipment;
	}
	public String getName(){
		return itemName;
	}
	public void setCount(int count){
		itemCount = count;
		return;
	}
	public int getEquipment(){
		return itemEquipment;
	}
	public int getValue(){
		return itemValue;
	}
	public boolean getKeyItem(){
		return itemKey;
	}
	public boolean getUse(){
		return itemUseOutsideCombat;
	}
	public boolean getCombatUse(){
		return itemUseInCombat;
	}
	public int getCount(){
		return itemCount;
	}
}
