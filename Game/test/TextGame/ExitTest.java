package TextGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExitTest {

	@Test
	public void exitShouldMatch() {
		assertEquals(Exit.north,Exit.find("north"));
	}
	@Test
	public void exitShouldNotMatchAnything() {
		assertEquals(Exit.undefined,Exit.find("ape"));
	}
	@Test
	public void exitShouldBeFound(){
		assertTrue(Exit.north.is("n"));
		assertTrue(Exit.east.is("east"));
	}
	@Test
	public void exitShouldNotBeFound(){
		assertFalse(Exit.north.is("s"));
		assertFalse(Exit.east.is("up"));
	}
}
