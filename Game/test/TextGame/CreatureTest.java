package TextGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class CreatureTest {

	@Test
	public void testCreatureCloneMethod() {
		Creature dummy = new Creature();
		Creature clone = dummy.clone();
		assertEquals(dummy.getDamage(), clone.getDamage());
	}
	@Test
	public void testCreatureBattleWithoutDamage() {
		Character player = AllTests.kickUpAPlayer();
		Creature dummy = new Creature();
		int oldHP = player.getHP();
		dummy.addAttack(new Attack(null, null, 0, 0));
		player = dummy.turn(player);
		assertEquals(oldHP, player.getHP());
	}
}
