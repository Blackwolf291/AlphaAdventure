package TextGame;

public class AttackWithSideEffect {
	private String name;
	private String description;
	private int attack;
	private int damage;
	private boolean dealsDamage;
	private int effectValue;
	private boolean hasEffect;
	public AttackWithSideEffect(String name, String description, int attack, boolean dealsDamage, int damage, boolean hasEffect, int effectValue){
		this.name = name;
		this.description = description;
		this.attack = attack;
		this.damage = damage;
	}
	public int getDamage(){	
		return damage;
	}
	public int getAttack(){	
		return attack;
	}
	public String getDescription(){	
		return description;
	}
	public String getName(){	
		return name;
	}
	public boolean dealsDamage(){
		return dealsDamage;
	}
	public int getEffectValue(){
		return effectValue;
	}
	public boolean hasEffect(){
		return hasEffect;
	}
	public Character attack(Character player, Creature enemy){
		System.out.println(getDescription());
		if (getAttack() + enemy.getHit() >= player.getDodge()){
			if (dealsDamage()){
				if (getDamage() + enemy.getDamage() > player.getShield()){
					int damage = getDamage() + enemy.getDamage() - player.getShield();
					player.setHP(player.getHP() - damage);
					System.out.println("It hit you for " + damage + "damage");
				}
				else{
					System.out.println("It hit you but failed to do any damage");
				}
			}
		}
		else {
			System.out.println("It missed");
		}
		return player;
	}
}
