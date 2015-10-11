package TextGame;

public class Weapon extends Item{
	private int damage;
	private int attackType;
	private String description;
	private int damageType;
	
	public Weapon(String name, int damage, int attackType, String description, int damageType,int count, boolean combatUse, boolean use, boolean keyItem, int value){
		super(name, count, combatUse, use, keyItem, value, 4);
		this.damage = damage;
		this.attackType = attackType;
		this.description = description;
		this.damageType = damageType;
	}
	public Weapon(String name, String attackDescription){
		super(name, 0, false, false, false, 0, 4);
		damage = Input.dice(5,10) + 5;
		attackType = 1;
		description = attackDescription;
		damageType = 1;
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
}
