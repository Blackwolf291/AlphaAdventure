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
	public void testCreatureBattle() {
		Creature dummy = new Creature();
		Creature clone = dummy.clone();
		assertEquals(dummy.getDamage(), clone.getDamage());
		//TODO
	}
}
