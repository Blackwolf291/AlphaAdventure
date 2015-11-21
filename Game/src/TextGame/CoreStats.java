package TextGame;

public class CoreStats {
	private int strength = 10;
	private int speed = 10;
	private int toughness = 10;
	private int intelligence = 10;
	private int charisma = 10;
	
	public void pickABoon(int boonSize){
		System.out.println("Gain a bonus to a stat.");
		System.out.println("Strength, Speed, Toughness, Intelligence, Charisma.");
		persistOnBoonChoice(boonSize);
	}
	
	private void persistOnBoonChoice(int boonSize){
		try{
			String boonChoice = Input.getUntimedInput();
			boonChoice = applyBoon(boonChoice, boonSize);
		}catch (IllegalArgumentException e){
			System.out.println("Please pick one of the stats presented.");
			persistOnBoonChoice(boonSize);
		}
	}
	
	String applyBoon(String boonChoice, int x){
		switch (boonChoice) {
		case "strength":
		case "str":
			strength = gainStat(strength, x, "You have gotten stronger.");
			break;
		case "speed":
		case "spd":
			speed = gainStat(speed, x, "You have gotten faster.");
			break;
		case "toughness":
		case "tgh":
			toughness = gainStat(toughness, x, "You have gotten tougher.");
			break;
		case "intelligence":
		case "int":
			intelligence = gainStat(intelligence, x, "You have gotten smarter.");
			break;
		case "persuasion":
		case "per":
			charisma = gainStat(charisma, x, "You have gotten more convincing.");
			break;
			default:
				throw new IllegalArgumentException();
		}
		return boonChoice;
	}
	
	public int gainStat(int stat, int boostValue, String description){
		System.out.println(description);
		stat += boostValue;
		if (stat<0){
			stat = 0;
		}
		return stat;
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
}
