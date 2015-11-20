package TextGame;

import java.util.Vector;

public class Creature {

	private String name;
	private String initialDescription;
	private String description;
	private int hp;
	private int dodge;
	private int shield;
	private Vector<AttackWithSideEffect> attacks;
	private int chase;
	private String victory;
	private String loss;
	private int xp;
	private int gold;
	private int goldLoss;
	private Item itemDrop;
	private int dropChance;
	private boolean canFlee;
	private int attack;
	private int damage;
	
	public Creature (){
	}
	public Creature(Creature enemy){
		this.name = enemy.name;
		this.initialDescription = enemy.initialDescription;
		this.description = enemy.description;
		this.hp = enemy.hp;
		this.dodge = enemy.dodge;
		this.shield = enemy.shield;
		this.chase = enemy.chase;
		this.attacks = enemy.attacks;
		this.victory = enemy.victory;
		this.loss = enemy.loss;
		this.xp = enemy.xp;
		this.gold = enemy.gold;
		this.goldLoss = enemy.goldLoss;
		this.itemDrop = enemy.itemDrop;
		this.dropChance = enemy.dropChance;
		this.canFlee = enemy.canFlee;
		this.attack = enemy.attack;
		this.damage = enemy.damage;
	}
	public Creature (String name, String initialDescription, String description, int hp, int dodge, int shield, int chase, String victory, String loss, int xp, int gold, int goldLoss, Item itemDrop, int dropChance, boolean canFlee, int attack, int damage) {
		this.name = name;
		this.initialDescription = initialDescription;
		this.description = description;
		this.hp = hp;
		this.dodge = dodge;
		this.shield = shield;
		this.chase = chase;
		this.attacks = new Vector<>();
		this.victory = victory;
		this.loss = loss;
		this.xp = xp;
		this.gold = gold;
		this.goldLoss = goldLoss;
		this.itemDrop = itemDrop;
		this.dropChance = dropChance;
		this.canFlee = canFlee;
		this.attack = attack;
		this.damage = damage;
	}
	public Creature clone(){
		return new Creature(this);
	}
	public int getDamage(){
		return damage;
	}
	public int getHit(){
		return attack;
	}
	public boolean getCanFlee(){
		return canFlee;
	}
	public void setDodge(int value){
		dodge = value;
	}
	public void setHP(int HP){
	hp = HP;
	}
	public void addAttack (Attack attack){
		attacks.add(attack);
	}
	public String getDescription(){
		return description;
	}
	public int getDropChance(){
		return dropChance;
	}
	public Item getItemDrop(){
		return itemDrop;
	}
	public int getGoldLoss(){
		return goldLoss;
	}
	public int getGold(){
		return gold;
	}
	public int getXP(){
		return xp;
	}
	public String getLoss(){
		return loss;
	}
	public String getVictory(){
		return victory;
	}
	public int getChase(){
		return chase;
	}
	public Vector<AttackWithSideEffect> getAttack(){
		return attacks;
	}
	public int getShield(){
		return shield;
	}
	public int getDodge(){
		return dodge;
	}
 	public int getHP(){
		return hp;
	}
	public String getName(){
		return name;
		
	}
	public String getInitialDescription() {
		return initialDescription;
	}
	public Character turn(Character player) {
		AttackWithSideEffect currentAttack = getAttack().get(Input.dice(1,getAttack().size()));
		currentAttack.attack(player, this);
		return player;
	}
}