package TextGame;

import java.io.Serializable;
import java.util.Vector;

public class Character implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private PlayerRace species;
	private PlayerStats stats;
	private Vector<Spell> spells = new Vector<>();
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
		species = setRace();
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
	public Vector<Spell> getSpells(){
		return spells;
	}
	public void printSpellList(){
		if(spells.size() > 0){
			printSpells();
		} else{
			System.out.println("You don\'t have any spells.");
		}
	}
	public void printSpells(){
		for (int i = 0; i == spells.size(); i++){
			System.out.println(spells.get(i).getName());
			}
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
	private String getPlayerSpecies(){
		String playerSpecies = "";
		while (playerSpecies.length() < 1) {
			System.out.println("Please enter your species");
			System.out.println("option species so far:");
			System.out.println("Wolf, Lion, Bear, Eagle, Fox and Crocodile");
			playerSpecies = Input.getUntimedInput();
		}
		return playerSpecies;
	}
	private PlayerRace setRace (){
		boolean speciesChoice = false;
		PlayerRace race = new PlayerRace("", "", "", "", "", "", "", false, "");
		while (!speciesChoice) {
			String playerSpecies = getPlayerSpecies();
    		switch (playerSpecies){
        	case "wolf":
        		race = new PlayerRace("wolf", "lupine", "You have a stretched muzzle, \npointy ears standing proud on your head. \nYour eyes are golden, and your nose is prominent \nand sharp on top of your muzzle.", "Your gray fur is short and well kept, but a little sandy. \nIt accentuates your lean, slim build and gives you a flat belly.", "Your paws start well below the wrist. \nThey mostly consist of your fingers, but you are blessed with opposable thumbs. \nThey end in sharp claws, but they are not long enough to do real damage.", "bite","You lunge at your opponent, mouth wide open \nand fangs bared, ready to tear your enemy to shreds.", true, "Your tail is sleek with a slight bit of fur hanging underneath. \nIt's hanging loosely behind you, moving in a slight wag.");
        		break;
        	case "lion":
        		race = new PlayerRace("lion", "leonine", "A stretched, round muzzle with wide wiskers dominates most of your face. \nGolden eyes above it scan around by instinct. \nA dark brownish red mane frames your head.", "Your golden fur is short and well kept, but a little sandy. \nIt accentuates your powerful build, and gives you a slim looking waist.", "Your paws start well below the wrist. \nThey mostly consist of your fingers, but you are blessed with opposable thumbs. \nThey end in sharp, strong retractable claws \nthat will slash and bludgeon all at once.", "Slash","You leap ar your enemy, claws out and sharp, \nready to tere your enemy to shreds.", true, "Your tail is straight and short furred, with a wide bushy tip. \nIt sways a little with your step.");
        		break;
            case "bear":
        		race = new PlayerRace("bear", "ursine", "Black beady eyes sit above a short, broad muzzle.", "Brown fur coats your features. You are well muscled, \nbut it's not obvious due to an insulating layer of body fat.", "Your large paws have barely any nails on it, but you do have opposable thumbs. \nThey are strong and heavy.", "slam","You charge at your foe and slam him hard with your paws, \nknocking him back a few feet.", false, "You have a stump more than a tail.");
        		break;
            case "eagle":
        		race = new PlayerRace("eagle", "avian", "Golden eyes sit above a golden beak. Your head is white feathered and you have no visible ears.", "Brown feathers cover most of your body. Your chest is big and strong \nto drive your wings. Your body is light and your feathers are a bit sandy.", "Your wings are ill suited for holding anything, but you have learned to hover in place. \nThis allows you to use your feet with an opposable tallon in many ways others use their paws.", "tallon scratch","You fly straight at your enemy with a furious shriek, tallons sharp.", true, "Your tail feathers stand tall and proud. They are your basic \nnavigations tools as well as a pride to see, after all.");
        		break;
            case "fox":
        		race = new PlayerRace("fox", "vulpine", "You have a long, pointy nuzzle, and large wiskers stretching wider than your face. \nYour bright blue eyes sit above your muzzle, scanning for prey and pred alike.", "Your silk red fur gives you a slim sleek look, clearly build for speed. \nIt's perfectly clean despite having slept in the sand.", "Your paws have opposable thumbs and reasonably sharp nails, \nbut you wouldn't wanna rely on those for attacking.", "pounce","You jump on your opponent, punching, clawing and biting.", true, "Your tail is almost as long as you are, \nit's bushy and fluffy. It weaves lightly on the wind.");
        		break;
            case "crocodile":
        		race = new PlayerRace("crocodile", "reptile", "A mouth as long as one of your arms completely dominates your face. \n your nositrils are to the side of your snout and you have your eyes sitting on top of your head.", "Your green scales leave nothing of your muscular build to the imagination.", "Your arms and legs are short compared to other species, \nbut they do the job. Thankfully you were given opposable thumbs, \nunlike your feral counterparts", "bite","You lunge with your mouth wide open, trying to take a good chomp out of your enemy.", true, "It's not really clear where your tail starts, \nbut there is a lot of it, and it's very strong.");
        		break;
        	default:
        		System.out.println("Sorry, that animal is not available at this time.");
        		playerSpecies = "";
        		continue;
    		}
    		System.out.println("Your a " + playerSpecies);
    		speciesChoice = Input.okay();	 
    	}
	return race;
	}
	void printSituation() {
		System.out.println(getEnemy().getDescription());
		System.out.println("You may try to ATTACK, FLEE, use an ITEM.");
		if (spells.size() > 0){
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
				if (getSpells().contains(Locations.minorHeal)){
				Locations.minorHeal.cast(this);
				playerTurn = false;
				}else{
					System.out.println("No such move");
				}
				break;
			case "fireball":
			case "fire":
				if (getSpells().contains(Locations.fireball)){
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
}
