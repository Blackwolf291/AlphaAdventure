package TextGame;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class MPItemTest {

	@Test
	public void testManaItemHeals() {
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
		player.addMana(-75);
		Item ether = new MPItem(null, 1, false, false, false, 0, 50, null);
		int oldMana = player.getMana();
		player = ether.use(player);
		assertEquals(oldMana+50, player.getMana());
	}
	@Test
	public void testManaItemCount0DoesntHeal() {
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
		player.addMana(-75);
		Item ether = new MPItem(null, 0, false, false, false, 0, 50, null);
		int oldMana = player.getMana();
		player = ether.use(player);
		assertEquals(oldMana, player.getMana());
	}

}
