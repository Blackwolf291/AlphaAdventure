package TextGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class SpellBookTest {

	@Test
	public void testSpellBookMethodsOnEmptySpellBook() {
		SpellBook spells = new SpellBook();
		Spell s1 = new DamageSpell(null, 0, null, 0);
		spells.printSpellBook();
		assertFalse(spells.hasSpells());
		assertFalse(spells.hasSpell(s1));
	}
	@Test
	public void testAddSpell(){
		SpellBook spells = new SpellBook();
		Spell s1 = new DamageSpell(null, 0, null, 0);
		Spell s2 = new UtilitySpell(null, 0, null);
		spells.addSpell(s1);
		spells.printSpellBook();
		assertTrue(spells.hasSpells());
		assertFalse(spells.hasSpell(s2));
		assertTrue(spells.hasSpell(s1));
	}

}
