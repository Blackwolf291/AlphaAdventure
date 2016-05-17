package TextGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class InGameTimeTest {

	
	@Test
	public void addTurnShouldAddJustOne() {
		InGameTime.setDefaultTime();
		InGameTime.addTurn();
		assertEquals("Day 1, 1:05PM",InGameTime.getTime());
		assertEquals(1,InGameTime.getTurnCount());
	}
	@Test
	public void addTimeShouldAdd200AtOnceProperly() {
		InGameTime.setDefaultTime();
		InGameTime.addTime(200);
		assertEquals("Day 2, 5:40AM",InGameTime.getTime());
		assertEquals(200,InGameTime.getTurnCount());
		
	}

}
