package TextGame;

import static org.junit.Assert.*;

import org.junit.Test;

import items.Item;
import items.MPItem;

public class MPItemTest {

	@Test
	public void testManaItemHeals() {
		Character player = AllTests.kickUpAPlayer();
		player.addMana(-75);
		Item ether = new MPItem(null, 1, false, false, false, 0, 50, null);
		int oldMana = player.getMana();
		player = ether.use(player);
		assertEquals(oldMana+50, player.getMana());
	}
	@Test
	public void testManaItemCount0DoesntHeal() {
		Character player = AllTests.kickUpAPlayer();
		player.addMana(-75);
		Item ether = new MPItem(null, 0, false, false, false, 0, 50, null);
		int oldMana = player.getMana();
		player = ether.use(player);
		assertEquals(oldMana, player.getMana());
	}

}
