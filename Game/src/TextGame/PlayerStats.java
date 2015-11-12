package TextGame;

public class PlayerStats {
	private CoreStats stats;
	private int hp;
	private int xp = 0;
	private int level = 1;
	private int gold = 0;
	private int mana;
	private int shielding;
	private int dodgePenalty;
	public PlayerStats(int Shielding, int DodgePenalty){
		stats = new CoreStats();
		stats.pickABoon(5);
		calcDerivedStats(Shielding, DodgePenalty);
		healAllHP();
		rechargeAllMana();
	}
	public PlayerStats(){
		stats = new CoreStats();
		calcDerivedStats(0, 0);
		healAllHP();
		rechargeAllMana();
	}
	public void calcDerivedStats(int shielding, int dodgePenalty){
		this.shielding = shielding;
		this.dodgePenalty = dodgePenalty;
		calcDerivedStats();
	}
	public void calcDerivedStats(){
		calcAttack();
		calcShield();
		calcMaxHP();
		calcDodge();
		calcMaxMana();
	}
	public void increaseCoreStat(String ability, int gain){
		stats.applyBoon(ability, gain);
		calcDerivedStats();
	}
	public int calcDodge(){
		int dodge = stats.getSpd() - dodgePenalty;
		if (dodge<0){
			dodge = 0;
		}
		return dodge;
	}
	public int getInt() {
		return stats.getInt();
	}
	public int getCha() {
		return stats.getCha();
	}
	public int calcMaxMana(){
		return stats.getInt()*(9+level);
	}
	public int calcAttack(){
		return stats.getStr() + level;
	}
	public int calcShield(){
		int shield = level + shielding;
		if (shield<level){
			shield = level;
		}
		return shield;
	}
	public int calcRun(){
		return calcDodge() + level;
	}
	public int calcMaxHP(){
		return stats.getTgh()*(9+level);
	}
	public void addMana(int value){
		mana += value;
		if (mana > calcMaxMana()){
			rechargeAllMana();
		}
		if (mana<0){
			mana = 0;
		}
	}
	public void updateStatsScreen() {
		GameScreen.statsScreen.append("level" + level+ "\n");
		GameScreen.statsScreen.append("XP: " + xp + "/" + (level*100)+ "\n");
		GameScreen.statsScreen.append("HP: " + hp + "/" + calcMaxHP()+ "\n");
		GameScreen.statsScreen.append("MP: " + mana + "/" + calcMaxMana() + "\n");
		GameScreen.statsScreen.append("Strength: " + stats.getStr()+ "\n");
		GameScreen.statsScreen.append("Speed: " + stats.getSpd()+ "\n");
		GameScreen.statsScreen.append("Toughness: " + stats.getTgh()+ "\n");
		GameScreen.statsScreen.append("Intelligence: " + stats.getInt()+ "\n");
		GameScreen.statsScreen.append("Persuasion: " + stats.getCha() + "\n");
		GameScreen.statsScreen.append("Gold: " + gold + "\n");
	}
	public void addXP(int gainedXP){
		if (xp>0){
			xp = xp + gainedXP;
			while (xp > level*100) {
				lvlUp();
			}
		}
		return;
	}
	private void lvlUp() {
		xp = xp - 100*level;
		++level;
		stats.pickABoon(1);
		calcDerivedStats();
		healAllHP();
		rechargeAllMana();			
		System.out.println("Congratulations, you are now level " + level);
		System.out.println("Your max HP is now " + hp);
		System.out.println("Your max mana is now " + mana);
	}
	private void rechargeAllMana() {
		mana = calcMaxMana();
	}
	public int getMana() {
		return mana;
	}
	public int getHP() {
		return hp;
	}
	public boolean manaIsFull() {
		return (mana>=calcMaxMana());
	}
	public boolean hpIsFull() {
		return (hp>=calcMaxHP());
	}
	public int getLvl() {
		return level;
	}
	public void addHP(int HP){
		hp += HP;
		if (hp > calcMaxHP()){
			healAllHP();
		}
		if (hp<0){
			hp = 0;
		}
	}
	public void healAllHP(){
		hp = calcMaxHP();
	}
	public void addGold(int goldGained){
		gold = gold + goldGained;
		if (gold<0){
			gold = 0;
		}
	}
	public int getGold(){
		return gold;
	}
	public int getXP() {
		return xp;
	}
	public void addHPWithBonus(int HP) {
		hp += HP;
		if (hp<0){
			hp = 0;
		}
	}
	public void revive() {
		if (hp == 0){
			hp = calcMaxHP()/2;
		}
	}
}
