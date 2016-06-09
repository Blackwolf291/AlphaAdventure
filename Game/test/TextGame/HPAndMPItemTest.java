package TextGame;

import static org.junit.Assert.*;

import org.junit.Test;

import items.HPAndMPItem;
import items.Item;

public class HPAndMPItemTest {

	@Test
	public void testHPAndMPItemHeals() {
		Character player = AllTests.kickUpAPlayer();
		player.addHP(-75);
		player.addMana(-75);
		Item elixer = new HPAndMPItem(null, 1, false, false, false, 0, 50, 25, null);
		int oldHP = player.getHP();
		int oldMana = player.getMana();
		player = elixer.use(player);
		assertEquals(oldHP+50, player.getHP());
		assertEquals(oldMana+25, player.getMana());
	}
	@Test
	public void testHPAndManaItemCountHasMaxHP() {
		Character player = AllTests.kickUpAPlayer();
		player.addMana(-75);
		Item elixer = new HPAndMPItem(null, 1, false, false, false, 0, 50, 25, null);
		int oldHP = player.getHP();
		int oldMana = player.getMana();
		player = elixer.use(player);
		assertEquals(oldHP, player.getHP());
		assertEquals(oldMana+25, player.getMana());
	}
	@Test
	public void testHPAndManaItemCountHasMaxHPAndMaxMana() {
		Character player = AllTests.kickUpAPlayer();
		Item elixer = new HPAndMPItem(null, 1, false, false, false, 0, 50, 25, null);
		int oldHP = player.getHP();
		int oldMana = player.getMana();
		player = elixer.use(player);
		assertEquals(oldHP, player.getHP());
		assertEquals(oldMana, player.getMana());
	}
}
