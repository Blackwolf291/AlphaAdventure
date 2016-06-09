package TextGame;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import items.Item;

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
	@Test
	public void testIfChooseItemFindsTheRightItem(){
		ArrayList<String> commands = new ArrayList<>();
		commands.add("d");
		commands.add("B");
		InputHolder.preStore(commands);
		Item[] items = new Item[3];
		items[0] = new Item("a", 0, false, false, false, 0);
		items[1] = new Item("b", 0, false, false, false, 0);
		items[2] = new Item("c", 0, false, false, false, 0);
		assertEquals(items[1],Input.chooseItem(items));
	}
	@Test
	public void testEnteredInputsMatchEndBoolean() {
		ArrayList<String> commands = new ArrayList<>();
		commands.add("ape");
		commands.add("y");
		InputHolder.preStore(commands);
		assertEquals(true, Input.convertYesNoToBoolean());
	}
}
