package TextGame;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class GameStartTest {

	@Test
	public void testNormalStartWithoutLoading() {
		ArrayList<String> commands = new ArrayList<>();
		commands.add("no");
		commands.add("Shade");
		commands.add("y");
		commands.add("Wolf");
		commands.add("y");
		commands.add("persuasion");
		commands.add("yes");
		InputHolder.preStore(commands);
		Main.initiateGame();
		assertEquals(1, Main.player.getLvl());
	}

}
