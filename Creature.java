package TextGame;

import java.util.Vector;

public class Creature {

	private String creatureName;
	private String creatureInitialDescription;
	private String creatureDescription;
	private int creatureHP;
	private int creatureDodge;
	private int creatureShield;
	private Vector<Attack> creatureAttacks;
	private int creatureChase;
	private String creatureVictory;
	private String creatureLoss;
	private int creatureXP;
	private int creatureGold;
	private int creatureGoldLoss;
	private Item creatureItemDrop;
	private int creatureDropChance;
	private boolean creatureCanFlee;
	private int creatureAttack;
	private int creatureDamage;
	
	public Creature (){
		
	}
	
	public Creature (String name, String initialDescription, String description, int hp, int dodge, int shield, int chase, String victory, String loss, int xp, int gold, int goldLoss, Item itemDrop, int dropChance, boolean canFlee, int attack, int damage) {
		creatureName = name;
		creatureInitialDescription = initialDescription;
		creatureDescription = description;
		creatureHP = hp;
		creatureDodge = dodge;
		creatureShield = shield;
		creatureChase = chase;
		creatureAttacks = new Vector<Attack>();
		creatureVictory = victory;
		creatureLoss = loss;
		creatureXP = xp;
		creatureGold = gold;
		creatureItemDrop = itemDrop;
		creatureDropChance = dropChance;
		creatureCanFlee = canFlee;
		creatureAttack = attack;
		creatureDamage = damage;
	}
	public int getDamage(){
		return creatureDamage;
	}
	public int getHit(){
		return creatureAttack;
	}
	public boolean getCanFlee(){
		return creatureCanFlee;
	}
	public void setDodge(int value){
		creatureDodge = value;
	}
	public void setHP(int HP){
	creatureHP = HP;
	}
	public void addAttack (Attack attack){
		creatureAttacks.add(attack);
	}
	public String getDescription(){
		return creatureDescription;
	}
	public int getDropChance(){
		return creatureDropChance;
	}
	public Item getItemDrop(){
		return creatureItemDrop;
	}
	public int getGoldLoss(){
		return creatureGoldLoss;
	}
	public int getGold(){
		return creatureGold;
	}
	public int getXP(){
		return creatureXP;
	}
	public String getLoss(){
		return creatureLoss;
	}
	public String getVictory(){
		return creatureVictory;
	}
	public int getChase(){
		return creatureChase;
	}
	public Vector<Attack> getAttack(){
		return creatureAttacks;
	}
	public int getShield(){
		return creatureShield;
	}
	public int getDodge(){
		return creatureDodge;
	}
 	public int getHP(){
		return creatureHP;
	}
	public String getName(){
		return creatureName;
		
	}
	public String getInitialDescription() {
		return creatureInitialDescription;
	}
}