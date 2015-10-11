package TextGame;

public class Item {

	private String name;
	private int count;
	private boolean useInCombat;
	private boolean useOutsideCombat;
	private boolean keyItem;
	private int value;
	private int equipmentSlot;
	public Item(String name, int count, boolean combatUse, boolean use, boolean keyItem, int value, int equipment) {
		this.name = name;
		this.count = count;
		this.useInCombat = combatUse;
		this.useOutsideCombat = use;
		this.keyItem = keyItem;
		this.value = value;
		this.equipmentSlot = equipment;
	}
	public String getName(){
		return name;
	}
	public void setCount(int count){
		this.count = count;
		return;
	}
	public int getEquipment(){
		return equipmentSlot;
	}
	public int getValue(){
		return value;
	}
	public boolean getKeyItem(){
		return keyItem;
	}
	public boolean getUse(){
		return useOutsideCombat;
	}
	public boolean getCombatUse(){
		return useInCombat;
	}
	public int getCount(){
		return count;
	}
}
