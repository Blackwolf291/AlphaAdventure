package TextGame;

public class Weapon {
	private String name;
	private int damage;
	private int attackType;
	private String description;
	private int damageType;
	
	public Weapon(String weaponName, int weaponDamage, int weaponAttackType, String attackDescription, int weaponDamageType){
		name = weaponName;
		damage = weaponDamage;
		attackType = weaponAttackType;
		description = attackDescription;
		damageType = weaponDamageType;
		
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
