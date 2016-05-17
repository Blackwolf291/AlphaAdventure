package TextGame;

import java.util.ArrayList;

import org.junit.Test;

public class MainTest {

	@Test (timeout = 2000)
	public void testTheGameCanOpenAndShut() {
		ArrayList<String> commands = new ArrayList<>();
		commands.add("no");
		commands.add("Shade");
		commands.add("y");
		commands.add("wolf");
		commands.add("y");
		commands.add("persuasion");
		commands.add("yes");
		commands.add("");
		commands.add("quit");
		commands.add("");
		InputHolder.preStore(commands);
		Main.main(null);
		
	}

}
