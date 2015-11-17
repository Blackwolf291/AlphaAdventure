package TextGame;

public class Weapon extends Item{
	private int damage;
	private int attackType;
	private String description;
	private int damageType;
	
	public Weapon(String name, int damage, int attackType, String description, int damageType,int count, boolean combatUse, boolean use, boolean keyItem, int value){
		super(name, count, combatUse, use, keyItem, value);
		this.damage = damage;
		this.attackType = attackType;
		this.description = description;
		this.damageType = damageType;
	}
	public Weapon(String name, String attackDescription){
		super(name, 0, false, false, false, 0);
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
	public void attack(Character player, Creature enemy) {
		player.setPlayerTurn(false);
		boolean hit = decideHit(player, enemy);
		if (hit){
			dealDamage(player, enemy);
		}else {
			System.out.println("You missed");
		}
		if (player.getEnemy().getHP() <= 0){
			player.setWin(true);
		}
	}
	private void dealDamage(Character player, Creature enemy) {
		System.out.println("You hit the " + player.getEnemy().getName());
		int playerDamage = getDamage();
		if (playerDamage >= enemy.getShield()){
			int damage = playerDamage - enemy.getShield();
			int HP = enemy.getHP() - damage;
			enemy.setHP(HP);
			System.out.println("for " + damage + " damage");
		} else{
			System.out.println("but it did no damage.");
		}
	}
	private boolean decideHit(Character player, Creature enemy) {
		boolean hit;
		int attackDie = Input.dice(1,6);
		switch (attackDie){
		case 6:
			hit = true;
			break;
		case 0:
			hit = false;
			break;
		default:
			int attack = player.getAttack() + attackDie;
			if (attack>=enemy.getDodge()){
				hit = true;
			}
			else{
				hit = false;
			}
		}
		return hit;
	}
}
