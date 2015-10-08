package TextGame;

public class Attack {

	private String name;
	private String description;
	private int attack;
	private int damage;
	
	public Attack(String name, String description, int attack, int damage){
		this.name = name;
		this.description = description;
		this.attack = attack;
		this.damage = damage;
	}

	public int getDamage(){	
		return damage;
	}
	public int getAttack(){	
		return attack;
	}
	public String getDescription(){	
		return description;
	}
	public String getName(){	
		return name;
	}
}
