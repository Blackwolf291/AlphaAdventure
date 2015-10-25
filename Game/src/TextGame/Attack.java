package TextGame;

public class Attack extends AttackWithSideEffect{

	public Attack(String name, String description, int attack, int damage){
		super(name, description, attack, true, damage, false, 0);
	}
}
