package TextGame;

public abstract class Spell {
	private String name;
	private int manaCost;
	private String castDescription;
	public Spell(String name, int manaCost, String castDescription){
		this.name = name;
		this.manaCost = manaCost;
		this.castDescription = castDescription;
	}
	public int getCost(){
		return manaCost;
	}
	public void setCost(int value){
		manaCost = value;
	}
	public void printCastDescription(){
		System.out.println(castDescription);
	}
	public String getName(){
		return name;
	}
	public void cantCast(){
		System.out.println("But you don't have the mana.");
	}
	public abstract Character cast(Character player);
}
