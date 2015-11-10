package TextGame;

public class Equipment {
	private Weapon weapon;
	private Shield shield;
	private Armor armor;
	private Helmet helmet;
	public Equipment(PlayerRace species) {
		this();
		setDefaultWeapon(species);
	}
	public Equipment() {
		shield = new Shield();
		armor = new Armor();
		helmet = new Helmet();
	}
	private void setDefaultWeapon(PlayerRace species){
		new Weapon (species.getAttack(), species.getUnarmedStrike());
	}
	public int calcShield(){
		int shielding = shield.getShieldBonus()+armor.getShielding()+helmet.getShieldBonus();
		return shielding;
	}
	public int speedPenalty(){
		int speedPenalty = armor.getSpeedPenalty()-shield.getDodgeBonus();
		return speedPenalty;
	}
	public Weapon getWeapon(){
		return weapon;
	}
	public Weapon swapWeapon (Weapon weapon){
		Weapon spare = this.weapon;
		this.weapon = weapon;
		return spare;
	}
	public Shield swapShield(Shield shield){
		Shield spare = this.shield;
		this.shield = shield;
		return spare;
	}
	public Helmet swapHelmet(Helmet helmet){
		Helmet spare = this.helmet;
		this.helmet = helmet;
		return spare;
	}
	public Armor swapArmor(Armor armor){
		Armor spare = this.armor;
		this.armor = armor;
		return spare;
	}
}
