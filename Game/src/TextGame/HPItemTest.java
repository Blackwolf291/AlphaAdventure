package TextGame;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class HPItemTest {

	@Test
	public void testHPItemHeals() {
		ArrayList<String> commands = new ArrayList<>();
		commands.add("Shade");
		commands.add("y");
		commands.add("wolf");
		commands.add("y");
		commands.add("persuasion");
		commands.add("yes");
		InputHolder.preStore(commands);
		Main.launchFrame();
		Character player = new Character();
		player.addHP(-75);
		Item potion = new HPItem(null, 1, false, false, false, 0, 50, null);
		int oldHP = player.getHP();
		player = potion.use(player);
		assertEquals(oldHP+50, player.getHP());
	}
	@Test
	public void testHPItemCount0DoesntHeal() {
		ArrayList<String> commands = new ArrayList<>();
		commands.add("Shade");
		commands.add("y");
		commands.add("wolf");
		commands.add("y");
		commands.add("persuasion");
		commands.add("yes");
		InputHolder.preStore(commands);
		Main.launchFrame();
		Character player = new Character();
		player.addHP(-75);
		Item potion = new HPItem(null, 0, false, false, false, 0, 50, null);
		int oldHP = player.getHP();
		player = potion.use(player);
		assertEquals(oldHP, player.getHP());
	}
}
