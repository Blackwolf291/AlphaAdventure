package TextGame;

public enum PlayerRace {
	wolf("wolf", "lupine", "You have a stretched muzzle, \npointy ears standing proud on your head. \nYour eyes are golden, and your nose is prominent \nand sharp on top of your muzzle.", "Your gray fur is short and well kept, but a little sandy. \nIt accentuates your lean, slim build and gives you a flat belly.", "Your paws start well below the wrist. \nThey mostly consist of your fingers, but you are blessed with opposable thumbs. \nThey end in sharp claws, but they are not long enough to do real damage.", "bite","You lunge at your opponent, mouth wide open \nand fangs bared, ready to tear your enemy to shreds.", true, "Your tail is sleek with a slight bit of fur hanging underneath. \nIt's hanging loosely behind you, moving in a slight wag."),
	lion("lion", "leonine", "A stretched, round muzzle with wide wiskers dominates most of your face. \nGolden eyes above it scan around by instinct. \nA dark brownish red mane frames your head.", "Your golden fur is short and well kept, but a little sandy. \nIt accentuates your powerful build, and gives you a slim looking waist.", "Your paws start well below the wrist. \nThey mostly consist of your fingers, but you are blessed with opposable thumbs. \nThey end in sharp, strong retractable claws \nthat will slash and bludgeon all at once.", "Slash","You leap ar your enemy, claws out and sharp, \nready to tere your enemy to shreds.", true, "Your tail is straight and short furred, with a wide bushy tip. \nIt sways a little with your step."),
	bear("bear", "ursine", "Black beady eyes sit above a short, broad muzzle.", "Brown fur coats your features. You are well muscled, \nbut it's not obvious due to an insulating layer of body fat.", "Your large paws have barely any nails on it, but you do have opposable thumbs. \nThey are strong and heavy.", "slam","You charge at your foe and slam him hard with your paws, \nknocking him back a few feet.", false, "You have a stump more than a tail."),
	eagle("eagle", "avian", "Golden eyes sit above a golden beak. Your head is white feathered and you have no visible ears.", "Brown feathers cover most of your body. Your chest is big and strong \nto drive your wings. Your body is light and your feathers are a bit sandy.", "Your wings are ill suited for holding anything, but you have learned to hover in place. \nThis allows you to use your feet with an opposable tallon in many ways others use their paws.", "tallon scratch","You fly straight at your enemy with a furious shriek, tallons sharp.", true, "Your tail feathers stand tall and proud. They are your basic \nnavigations tools as well as a pride to see, after all."),
	fox("fox", "vulpine", "You have a long, pointy nuzzle, and large wiskers stretching wider than your face. \nYour bright blue eyes sit above your muzzle, scanning for prey and pred alike.", "Your silk red fur gives you a slim sleek look, clearly build for speed. \nIt's perfectly clean despite having slept in the sand.", "Your paws have opposable thumbs and reasonably sharp nails, \nbut you wouldn't wanna rely on those for attacking.", "pounce","You jump on your opponent, punching, clawing and biting.", true, "Your tail is almost as long as you are, \nit's bushy and fluffy. It weaves lightly on the wind."),
	crocodile("crocodile", "reptile", "A mouth as long as one of your arms completely dominates your face. \n your nositrils are to the side of your snout and you have your eyes sitting on top of your head.", "Your green scales leave nothing of your muscular build to the imagination.", "Your arms and legs are short compared to other species, \nbut they do the job. Thankfully you were given opposable thumbs, \nunlike your feral counterparts", "bite","You lunge with your mouth wide open, trying to take a good chomp out of your enemy.", true, "It's not really clear where your tail starts, \nbut there is a lot of it, and it's very strong."),
	undefined(null,null, null, null, null, null, null,false, null);
	private final String name;
	private final String altName;
	private final String faceDescription;
	private final String bodyDescription;
	private final String pawDescription;
	private final String unarmedStrikeName;
	private final String unarmedStrikeDescription;
	private final boolean tail;
	private final String tailDescription;
	private PlayerRace(String raceName, String raceAltName, String raceFace, String raceBody, String racePaw, String raceAttack, String raceUnarmedStrike, boolean raceTail, String raceTailDescription){
		name = raceName;
		altName = raceAltName;
		faceDescription = raceFace;
		bodyDescription = raceBody;
		pawDescription = racePaw;
		unarmedStrikeName = raceAttack;
		unarmedStrikeDescription = raceUnarmedStrike;
		tail = raceTail;
		tailDescription = raceTailDescription;
	}
	public String toString(){
		return name;
	}
	public String getAttack(){
		return unarmedStrikeName;
	}
	public boolean hasTail(){
		return tail;
	}
	public String getTail(){
		return tailDescription;
	}
	public String getUnarmedStrike(){
		return unarmedStrikeDescription;
	}
	public String getPaw(){
		return pawDescription;
	}
	public String getBody(){
		return bodyDescription;
	}
	public String getFace(){
		return faceDescription;
	}
	public String getAltName(){
		return altName;
	}
	public void printFullBodyDescription(){
		System.out.println(getBody());
		System.out.println(getFace());
		System.out.println(getPaw());
		System.out.println(getTail());
	}
	public static PlayerRace find(String choice){
		try{
			return valueOf(choice);
		} catch (IllegalArgumentException e){
			return undefined;
		}
	}
	private static String getPlayerSpecies(){
		String species = "";
		while (species.length() < 1) {
			System.out.println("Please enter your species");
			System.out.println("option species so far:");
			System.out.println("Wolf, Lion, Bear, Eagle, Fox and Crocodile");
			species = Input.getUntimedInput();
		}
		return species;
	}
	private static PlayerRace chooseRace(PlayerRace race){
		while (race.equals(undefined)) {
			String species = getPlayerSpecies();
    		race = find(species);
    		System.out.println("That's not a race.");
		}
		return race;
	}
	public static PlayerRace setRace(){
		PlayerRace race = undefined;
		while (race.equals(undefined)) {
			race = chooseRace(race);
    		System.out.println("Your a " + race);
    		if (!Input.okay()){
    			race = undefined;
    		}
    	}
	return race;
	}
	public PlayerRace getRace(String newRace){
		return valueOf(newRace);
	}
}
