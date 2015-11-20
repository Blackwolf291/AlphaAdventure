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
		assert(Exit.north.is("n"));
		assert(Exit.east.is("east"));
	}
	@Test
	public void exitShouldNotBeFound(){
		assert(!Exit.north.is("s"));
		assert(!Exit.east.is("up"));
	}
}
