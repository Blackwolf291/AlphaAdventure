package items;

import TextGame.Attack;

public interface Attacker extends Target{

	Attack getAttack();

	int getAccuracy();

	int getBaseDamage();

}
