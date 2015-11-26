package TextGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class HealSpellTest {

	@Test
	public void castHealSpell() {
		Character player = AllTests.kickUpAPlayer();
		player.addHP(-75);
		Spell healSpell = new HealSpell(null, 25, null, 50);
		int oldMana = player.getMana();
		int oldHP = player.getHP();
		player = healSpell.cast(player);
		assertEquals(oldMana-25, player.getMana());
		assertEquals(oldHP+50, player.getHP());
	}
	@Test
	public void castHealSpellCantCastWithoutMana() {
		Character player = AllTests.kickUpAPlayer();
		player.addHP(-75);
		player.addMana(-100);
		Spell healSpell = new HealSpell(null, 25, null, 50);
		int oldMana = player.getMana();
		int oldHP = player.getHP();
		player = healSpell.cast(player);
		assertEquals(oldMana, player.getMana());
		assertEquals(oldHP, player.getHP());
	}
}
