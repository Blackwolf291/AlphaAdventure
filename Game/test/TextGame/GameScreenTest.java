package TextGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class GameScreenTest {

	@Test
	public void testOutputRedirect() {
		String test = "test";
		GameScreen screen = new GameScreen();
		screen.run();
		System.out.println(test);
		assertEquals(test, GameScreen.textArea.getText().trim().intern());
	}
	@Test
	public void testOutputIntegerHandling() {
		String test = "1";
		GameScreen screen = new GameScreen();
		screen.run();
		System.out.println(test);
		assertEquals(Integer.parseInt(test), Integer.parseInt(GameScreen.textArea.getText().trim()));
	}
}
