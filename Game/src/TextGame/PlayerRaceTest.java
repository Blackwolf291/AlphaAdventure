package TextGame;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PlayerRaceTest {

	@Test
	public void testRaceSelect() {
		ArrayList<String> commands = new ArrayList<>();
		commands.add("fox");
		commands.add("n");
		commands.add("tiger");
		commands.add("wolf");
		commands.add("yes");
		InputHolder.preStore(commands);
		assertEquals(PlayerRace.wolf, PlayerRace.setRace());
		PlayerRace.bear.printFullBodyDescription();
	}

}
