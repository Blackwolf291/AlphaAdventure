package TextGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class CoreStatsTest {

	CoreStats stats;
	@Test
	public void testIfStatsBehaveWhenSpeedBoonApplied() {
		stats =  new CoreStats();
		assertEquals(55, statsTest("speed"));
		assertEquals(15, stats.getSpd());
	}
	@Test
	public void testIfStatsBehaveWhenIntelligenceBoonApplied() {
		stats =  new CoreStats();
		assertEquals(55, statsTest("int"));
		assertEquals(15, stats.getInt());
	}
	@Test (expected = IllegalArgumentException.class)
	public void testIfBoonsWillFailWhenGivenABadArgument(){
		stats =  new CoreStats();
		assertEquals(statsTest("junk"), 55);
	}
	
	public int statsTest(String x){
		stats.applyBoon(x,5);
		int statsSum = stats.getStr()+stats.getSpd()+stats.getTgh()+stats.getInt()+stats.getCha();
		return statsSum;
	}
}
