package TextGame;

public class Attack {

	private String name;
	private String description;
	private int attack;
	private int damage;
	
	public Attack(String attackName, String attackDescription, int attackAttack, int
			attackDamage){
		name = attackName;
		description = attackDescription;
		attack = attackAttack;
		damage = attackDamage;
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
