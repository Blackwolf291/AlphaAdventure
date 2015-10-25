package TextGame;

public class SpecialAttack extends AttackWithSideEffect{

	public SpecialAttack(String name, String description, int attack, boolean hasEffect, int effectValue) {
		super(name, description, attack, false, 0, hasEffect, effectValue);
	}

}
