package TextGame;

import java.io.Serializable;

public class Character implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private PlayerRace species;
	private PlayerStats stats;
	private SpellBook spells = new SpellBook();
	private Location currentLocation;
	private Inventory inventory = new Inventory(); 
	private Equipment equipment;
	private Location base;
	private boolean combat = false;
	private boolean win = true;
	private boolean itemUsed = false;
	private Creature enemy;
	private boolean playerTurn;
	private boolean creatureTurn;
	private boolean lose;
	
	public Character (){
		setName();
		species = PlayerRace.setRace();
		equipment = new Equipment(species);
		stats = new PlayerStats(equipment.calcShield(), equipment.speedPenalty());
		enemy = new Creature();
		updateStatsScreen();
	}
	
	public int think(){
		return stats.getInt();
	}
	public int persuade(){
		return stats.getCha();
	}
	public int getDodge(){
		return stats.calcDodge();
	}
	
	public void setEnemy(Creature newCreature){
		enemy = newCreature;
	}
	public Creature getEnemy(){
		return enemy;
	}
	public void setItemUsed(boolean real){
		itemUsed = real;
	}
	public Weapon getWeapon(){
		return equipment.getWeapon();
	}
	public void printSpellBook(){
		spells.printSpellBook();
	}
	public boolean getItemUsed(){
		return itemUsed;
	}
	public void applyManaCost(int cost){
		stats.addMana(getMana() - cost);
	}
	public int getMana(){
		return stats.getMana();
	}
	public boolean getCombat(){
		return combat;
	}
	public void setCombat(boolean fighting){
		combat = fighting;
	}
	public void setWin(boolean fightWin) {
		win = fightWin;
	}
	public boolean getWin () {
		return win;
	}
	public boolean hasSpell(Spell spell){
		return spells.hasSpell(spell);
	}
	public void setBase(Location playerBase){
		base = playerBase;
		return;
	}
	public Location getBase(){
		return base;
	}
	public Inventory getInventory(){
		return inventory;
	}
	public void setGold(int goldGained){
		stats.addGold(goldGained);
	}
	public int getGold(){
		return stats.getGold();
	}
	public void setCurrentLocation(Location newLocation){
		currentLocation = newLocation;
		return;
	}
	public Location getCurrentLocation(){
		return currentLocation;
	}
	public boolean manaIsFull(){
		return stats.manaIsFull();
	}
	public boolean hpIsFull(){
		return stats.hpIsFull();
	}
	public int getAttack(){
		return stats.calcAttack();
	}
	public int getShield(){
		return stats.calcShield();
	}
	public void setHPWithBonus(int HP){
		stats.addHPWithBonus(HP);
		updateStatsScreen();
	}
	public void setHP(int HP){
		stats.addHP(HP);
		updateStatsScreen();
	}
	public int getLvl(){
		return stats.getLvl();
	}
	public int getHP(){
		return stats.getHP();
	}
	
	public PlayerRace getspecies(){
		return species;
	}
	public String getName(){
		return name;
	}
	private String askName(){
		while (name.length() < 1) {
			System.out.println("Please enter your name");
			name = Input.getCapInput();
		}
		return name;
	}
	private boolean nameAccept(boolean nameChoice){
		name = askName();
		System.out.println("Your name is " + name);
		nameChoice = Input.okay();
		return nameChoice;
	}
	private void setName(){
		boolean nameChoice = false;
    	while (!nameChoice) {
    		name = "";
    		nameChoice = nameAccept(nameChoice);
    	}	
	}
	
	void printSituation() {
		System.out.println(getEnemy().getDescription());
		System.out.println("You may try to ATTACK, FLEE, use an ITEM.");
		if (spells.hasSpells()){
			System.out.println("Or you may cast a spell.");
		}
	}
	void playerLose() {
		GameScreen.textArea.setText("");
		System.out.println(getEnemy().getLoss());
		revive();
		setCurrentLocation(getBase());
		if (base == Locations.beach){
			System.out.println("You wake up the next day. sagged into the sand. feeling refreshed.");
		}
	}
	public void playerWin() {
		GameScreen.textArea.setText("");
		System.out.println(enemy.getVictory());
		System.out.println("You gained " + enemy.getXP() + " experience.");
		stats.addXP(enemy.getXP());
		setGold(enemy.getGold());
		updateStatsScreen();
		win = true;
		System.out.println("You gained " + enemy.getGold() + " gold.");
		if (Input.dice(1,100) >= enemy.getDropChance()){
			System.out.println("You gained 1" + enemy.getItemDrop());
			inventory.addItem(enemy.getItemDrop());
		}
	}
	
	public boolean decideEscape() {
		boolean escape;
		int escapeDie = Input.dice(1,6);
		switch (escapeDie){
		case 6:
			escape = true;
			System.out.println("The " + enemy.getName() + "tripped when trying to chase you. you manage to get away.");
			break;
		case 0:
			escape = false;
			System.out.println("You tripped while trying to escape. it easily caught up.");
			break;
		default:
			int run = stats.calcRun() + escapeDie;
			if (run >= enemy.getChase()){
				escape = true;
				System.out.println("You manage to get away.");
			}else{
				escape = false;
				System.out.println("You fail to get away.");
			}
		}
		return escape;
	}
	boolean hasEnemy(){
		return enemy != null;
	}
	Character hunt(Character player, Items items){
		if (hasEnemy()){
			enemy = currentLocation.chooseEnemy(); 
			player = combat(items);
		}else{
			System.out.println("There's nothing to hunt here.");
		}
		return player;
	}
	private void updateStatsScreen(){
		GameScreen.statsScreen.setText(name + "\n");
		stats.updateStatsScreen();
	}
	private Character combatInventory(Items items) {
		inventory.printCombatInventory();
		String item = Input.getInput();
		if (item.equals("return")){ 
			items.useItem(item, this);
			playerTurn = !getItemUsed();
		}
		return this;
	}
	private void flee() {
		if (getEnemy().getCanFlee()){
			playerTurn = false;
			boolean escape = decideEscape();
		if (escape){
			setCombat(false);
			creatureTurn = false;
		}
		}else{
			System.out.println("There's no escaping this foe.");
		}
		return;
	}
	private void combatRoundUp() {
		System.out.println(getCurrentLocation().getDescription());
		
		getCurrentLocation().printOptions();
		
	}
	public Character combat(Items items){
		setCombat(true);
		GameScreen.textArea.setText("");
		setWin(false);
		win = false;
		lose = false;
		creatureTurn = true;
		playerTurn = true;
		System.out.println("You face a " + getEnemy().getName());
		System.out.println(getEnemy().getInitialDescription());
		while (getCombat()){
			while (playerTurn){
				printSituation();
				String action = Input.getInput();
				switch (action){
				case "attack":
				case "a":
					equipment.attack(this, enemy);;
					break;
			case "flee":
			case "f":
				flee();
				break;
			case "item":
			case "i":
			case "use item":
			case "u":
			case "inventory":
					combatInventory(items);
				break;
			case "minor heal":
			case "heal":
				if (hasSpell(Locations.minorHeal)){
				Locations.minorHeal.cast(this);
				playerTurn = false;
				}else{
					System.out.println("No such move");
				}
				break;
			case "fireball":
			case "fire":
				if (hasSpell(Locations.fireball)){
				Locations.fireball.cast(this);
				playerTurn = false;
				}else{
					System.out.println("No such move");
				}
				break;
			default:
					System.out.println("No such move");
					}
			}
			if (win) {
				creatureTurn = false;
				setCombat(false);
						}
			if (creatureTurn){
				getEnemy().turn(this);
				if (getHP() <= 0){
					lose = true;
					setCombat(false);
				}else{ 
					playerTurn = true;
				}
			}
		}
		if (!combat){
			endCombat();
		}
		
	return this;	
	}
	private void endCombat() {
		if (win){
			playerWin();
		}
		else if (lose){
			playerLose();
		}
		combatRoundUp();
		
	}
	public void setPlayerTurn(boolean b) {
		playerTurn=b;
	}
	public void revive(){
		stats.revive();
	}
	public void setMana(int value) {
		stats.addMana(value);
	}
	public void setLocation(Exit exit){
		currentLocation = getCurrentLocation().getNewLocation(exit);
	}

	public void setBoss(int index) {
		enemy = Locations.extraLocation.chooseEnemy(index);
		
	}
	public boolean hasSpells(){
		return spells.hasSpells();
	}

	public void printSpellList() {
		spells.printSpellBook();
		
	}

	public void addSpell(Spell spell) {
		spells.addSpell(spell);
	}
}
