package TextGame;

public class Weapon extends Item{
	private int damage;
	private int attackType;
	private String description;
	private int damageType;
	
	public Weapon(String name, int damage, int attackType, String description, int damageType,int count, boolean combatUse, boolean use, boolean keyItem, int value, int equipment){
		this.name = name;
		this.count = count;
		this.useInCombat = combatUse;
		this.useOutsideCombat = use;
		this.keyItem = keyItem;
		this.value = value;
		this.equipmentSlot = equipment;
		this.damage = damage;
		this.attackType = attackType;
		this.description = description;
		this.damageType = damageType;
		
	return ;
	}
	public int getDmgType(){
		return damageType;
	}
	public String getDescription(){
		return description;
	}
	public int getAttackType(){
		return attackType;
	}
	public int getDamage(){
		return damage;
	}
	public String getName(){
		return name;
	}
}
