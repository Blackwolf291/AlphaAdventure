package TextGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class HPItemTest {

	@Test
	public void testHPItemHeals() {
		Character player = AllTests.kickUpAPlayer();
		player.addHP(-75);
		Item potion = new HPItem(null, 1, false, false, false, 0, 50, null);
		int oldHP = player.getHP();
		player = potion.use(player);
		assertEquals(oldHP+50, player.getHP());
	}
	@Test
	public void testHPItemCount0DoesntHeal() {
		Character player = AllTests.kickUpAPlayer();
		player.addHP(-75);
		Item potion = new HPItem(null, 0, false, false, false, 0, 50, null);
		int oldHP = player.getHP();
		player = potion.use(player);
		assertEquals(oldHP, player.getHP());
	}
	@Test
	public void testHPItemCountHasMaxHP() {
		Character player = AllTests.kickUpAPlayer();
		Item potion = new HPItem(null, 1, false, false, false, 0, 50, null);
		int oldHP = player.getHP();
		player = potion.use(player);
		assertEquals(oldHP, player.getHP());
	}
}
