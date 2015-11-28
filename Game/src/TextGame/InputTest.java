package TextGame;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class InputTest {

	@Test
	public void testEnteredInputsMatchEndResult() {
		ArrayList<String> commands = new ArrayList<>();
		commands.add("0");
		InputHolder.preStore(commands);
		assertEquals(0, Input.getInteger());
	}
	@Test
	public void testEnteredIntegerRepromptOnNumberFormatException() {
		ArrayList<String> commands = new ArrayList<>();
		commands.add("n");
		commands.add("-2");
		InputHolder.preStore(commands);
		assertEquals(-2, Input.getInteger());
	}
	@Test
	public void testEnteredInputsAreNotCaseSensitive() {
		ArrayList<String> commands = new ArrayList<>();
		String str = "ApE";
		commands.add(str);
		InputHolder.preStore(commands);
		assertEquals(str.toLowerCase(), Input.getInput());
	}
	@Test
	public void testEnteredNameIsCaseSensitive() {
		ArrayList<String> commands = new ArrayList<>();
		String str = "ApE";
		commands.add(str);
		InputHolder.preStore(commands);
		assertEquals(str, Input.getCapInput());
	}
}
