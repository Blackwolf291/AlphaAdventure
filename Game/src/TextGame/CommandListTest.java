package TextGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class CommandListTest {

	@Test
	public void checkValidImputRecognition() {
		assertEquals(CommandList.hunt, CommandList.find("hunt"));
	}
	@Test
	public void checkInvalidInputRecognition(){
		assertEquals(CommandList.other, CommandList.find("wolf"));
	}

}
