package TextGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class BonusHPItemTest {

	@Test
	public void testBonusHPItemHeals() {
		Character player = AllTests.kickUpAPlayer();
		player.addHP(-75);
		Item potion = new BonusHPItem(null, 1, false, false, false, 0, 50, null);
		int oldHP = player.getHP();
		player = potion.use(player);
		assertEquals(oldHP+50, player.getHP());
	}
	@Test
	public void testBonusHPItemCount0DoesntHeal() {
		Character player = AllTests.kickUpAPlayer();
		player.addHP(-75);
		Item potion = new BonusHPItem(null, 0, false, false, false, 0, 50, null);
		int oldHP = player.getHP();
		player = potion.use(player);
		assertEquals(oldHP, player.getHP());
	}
	@Test
	public void testBonusHPItemCountIgnoresMaxHP() {
		Character player = AllTests.kickUpAPlayer();
		Item potion = new BonusHPItem(null, 1, false, false, false, 0, 50, null);
		int oldHP = player.getHP();
		player = potion.use(player);
		assertEquals(oldHP+50, player.getHP());
	}

}
