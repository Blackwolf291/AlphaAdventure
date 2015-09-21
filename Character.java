package TextGame;

import java.io.Serializable;
import java.util.Vector;

public class Character implements Serializable{

	private static final long serialVersionUID = 1L;
	private String name;
	private PlayerRace species;
	private int strength;
	private int speed;
	private int toughness;
	private int intelligence;
	private int charisma;
	private int maxHP;
	private int hp;
	private int xp;
	private int level;
	private int gold;
	private int shield;
	private int attack;
	private int mana;
	private int maxMana;
	private Vector<Spell> spells;
	private Location currentLocation;
	static private Vector<Item> playerInventory; 
	static private Vector<Item> equipment; 
	private Location base;
	private boolean combat;
	private boolean win;
	private boolean itemUsed;
	private Weapon currentWeapon;
	private Creature enemy;
	private Input input;
	
	public Character (Items inventory){
		input = new Input();
		name = setName();
		species = setRace();
		byte boon = boonChoice();
		if (boon == 1) strength = 15;
		else strength = 10;
		if (boon == 2) speed = 15;
		else speed = 10;
		if (boon == 3) toughness = 15;
		else toughness = 10;
		if (boon == 4) intelligence = 15;
		else intelligence = 10;
		if (boon == 5) charisma = 15;
		else charisma = 10;
		xp = 0;
		level = 1;
		maxHP = toughness*(9+level);
		hp = maxHP;
		gold = 0;
		shield = 10 + level;
		attack = strength + level;
		maxMana = intelligence + level;
		mana = maxMana;
		playerInventory = new Vector<Item>();
		equipment = new Vector<Item>();
		combat = false;
		win = true;
		itemUsed = false;
		currentWeapon = new Weapon (species.getAttack(), input.dice(5,10) + 5, 1, species.getUnarmedStrike(), 1);
		enemy = new Creature();
	}
	public Input getInput(){
		return input;
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
		return currentWeapon;
	}
	public Vector<Spell> getSpells(){
		return spells;
	}
	public void spellList(){
		if(spells.size() > 0){
			for (int i = 0; i == spells.size(); i++){
			System.out.println(spells.get(i).getName());
			}
		} else{
			System.out.println("You don\'t have any spells.");
		}
	}
	public boolean getItemUsed(){
		return itemUsed;
	}
	public int getMaxMana(){
		return maxMana;
	}
	public void setMana(int value){
		mana = value;
		if (mana > maxMana){
			mana = maxMana;
		}
	}
	public int getMana(){
		return mana;
	}
	public void setSpeed(int value){
		speed = value;
	}
	public void setShield(int value){
		shield = value;
	}
	public void setAttack(int value){
		attack = value;
	}
	public void stats(){
		System.out.println("Level = " + level);
		System.out.println("XP = " + xp);
		System.out.println("HP = " + hp + "/" + maxHP);
		System.out.println("Mana = " + mana + "/" + maxMana);
		System.out.println("Strength = " + strength);
		System.out.println("Speed = " + speed);
		System.out.println("Toughness = " + toughness);
		System.out.println("Intelligance = " + intelligence);
		System.out.println("Charisma = " + charisma);
		System.out.println("Your current home base is the " + base.getLocName());
	}
	public Vector<Item> getEquipment(){
		return equipment;
	}
	public boolean getCombat(){
		return combat;
	}
	public void setCombat(boolean fighting){
		combat = fighting;
	}
	public void addItem(Item item){
		if (playerInventory.contains(item)){
			item.setCount(item.getCount() + 1);
		} else {
			playerInventory.addElement(item);
		if (item.getCount() == 0){
			playerInventory.removeElement(item);
		}
		}
	}
	public void removeItem(Item item){
		item.setCount(item.getCount() - 1);
		if (item.getCount() == 0){
			playerInventory.removeElement(item);
		}
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
	public Vector<Item> getInventory(){
		return playerInventory;
	}
	public void setGold(int goldGained){
		gold = gold + goldGained;
		return;
	}
	public int getGold(){
		return gold;
	}
	public void setCurrentLocation(Location newLocation){
		currentLocation = newLocation;
		return;
	}
	public void setCurrentLocation(Exit an_exit){
		currentLocation = an_exit.getLeadsTo();
		return;
	}
	public Location getCurrentLocation(){
		return currentLocation;
	}
	public int getMaxHP(){
		return maxHP;
	}
	public int getAttack(){
		return attack;
	}
	public int getShield(){
		return shield;
	}
	public void setHP(int HP){
		hp = HP;
		if (HP > maxHP){
			HP = maxHP;
		}
	}
	public void setGainedXP(int gainedXP){
	xp = xp + gainedXP;
	while (xp > level*100) {
		xp = xp - 100*level;
		++level;
		hp = maxHP;
		mana = maxMana;
		System.out.println("Gain a bonus to a stat.");
		System.out.println("Strength, Speed, Toughness, Intelligence, Charisma.");
		String boonchoice = input.getInput();
		switch (boonchoice) {
			case "strength":
				System.out.println("You have gotten stronger");
				strength++;
				break;
			case "speed":
				System.out.println("You have gotten faster.");
				speed++;
				break;
			case "toughness":
				System.out.println("You have gotten tougher.");
				toughness++;
				break;
			case "intelligence":
				System.out.println("You have gotten smarter.");
				intelligence++;
				break;
			case "charisma":
				System.out.println("You have gotten more persuasive.");
				charisma++;
				break;
				default:
					System.out.println("please pick one");
		System.out.println("Congratulations, you are now level " + level);
		System.out.println("Your max HP is now " + hp);
		System.out.println("Your max mana is now " + mana);
		}
	}
	return;
	}
	public int getLvl(){
		return level;
	}
	public int getHP(){
		return hp;
	}
	public int getXP(){
		return xp;
	}
	public int getCha(){
		return charisma;
	}
	public int getInt(){
		return intelligence;
	}
	public int getTgh(){
		return toughness;
	}
	public int getSpd(){
		return speed;
	}
	public int getStr(){
		return strength;
	}
	public PlayerRace getspecies(){
		return species;
	}
	public String getName(){
		return name;
	}
	private String setName (){
		String playerName = "";
		boolean nameChoice = false;
    	while (!nameChoice) {
    		while (playerName.length() < 1) {
    			System.out.println("Please enter your name");
    			playerName = input.getCapInput();
    		}	
    		System.out.println("Your name is " + playerName);
    		nameChoice = input.okay();
    		if (nameChoice == false){
    			playerName = "";
        	
    		}
    		}	
		return playerName;
	}
	
	private PlayerRace setRace (){
		boolean speciesChoice = false;
		PlayerRace race = new PlayerRace("", "", "", "", "", "", "", false, "");
		String playerSpecies = "";
		while (!speciesChoice) {
    		while (playerSpecies.length() < 1) {
    			System.out.println("Please enter your species");
    			System.out.println("option species so far:");
    			System.out.println("Wolf, Lion, Bear, Eagle, Fox and Crocodile");
    			playerSpecies = input.getInput();
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
    		}
    		}
    		System.out.println("Your a " + playerSpecies);
    		speciesChoice = input.okay();
    		if (speciesChoice == false){
    			playerSpecies = "";
        		}		 
    	}
	return race;
	}
	private byte boonChoice(){
		byte boon = 0;
		while (boon == 0){
		while (boon == 0){
			System.out.println("Please select your boon.");
		System.out.println("Strength, Speed, Toughness, Intelligence, Charisma.");
		String boonchoice = input.getInput();
		switch (boonchoice) {
			case "strength":
				System.out.println("You are blessed with strength");
				boon = 1;
				break;
			case "speed":
				System.out.println("You are blessed with speed");
				boon = 2;
				break;
			case "toughness":
				System.out.println("You are blessed with toughness");
				boon = 3;
				break;
			case "intelligence":
				System.out.println("You are blessed with intelligence");
				boon = 4;
				break;
			case "charisma":
				System.out.println("You are blessed with charisma");
				boon = 5;
				break;
				default:
					System.out.println("please pick one");
			}
		}
		if (!input.okay()){
			boon = 0;
		}
		}
		return boon;
	}
}
