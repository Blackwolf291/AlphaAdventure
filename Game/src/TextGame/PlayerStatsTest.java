package TextGame;

import static org.junit.Assert.*;

import java.util.Vector;

import org.junit.Test;

public class PlayerStatsTest {

	@Test
	public void testPlayerStatReturns() {
		PlayerStats stats = new PlayerStats();
		assertEquals(0, stats.getXP());
		assertEquals(1, stats.getLvl());
		assertEquals(1, stats.calcShield());
		assertEquals(10, stats.calcDodge());
		assertEquals(11, stats.calcRun());
		assertEquals(true, stats.hpIsFull());
		assertEquals(true, stats.manaIsFull());
		assertEquals(100, stats.getHP());
		assertEquals(0, stats.getGold());
		assertEquals(100, stats.getMana());
	}
	@Test
		public void testValidStatEdits(){
			PlayerStats stats = new PlayerStats();
			Vector<String> commands = new Vector<>();
			commands.add("str");
			commands.add("charisma");
			InputHolder.preStore(commands);
			stats.addXP(350);
			stats.increaseCoreStat("str", 5);
			stats.increaseCoreStat("spd", 5);
			stats.increaseCoreStat("tgh", 5);
			stats.increaseCoreStat("int", 5);
			stats.increaseCoreStat("per", 5);
			stats.calcDerivedStats(1, 1);
			stats.addHP(5);
			stats.addMana(5);
			stats.addGold(5);
			//assertEquals(50, stats.getXP());
			//assertEquals(3, stats.getLvl());
			assertEquals(2, stats.calcShield());
			assertEquals(14, stats.calcDodge());
			assertEquals(15, stats.calcRun());
			assertEquals(false, stats.hpIsFull());
			assertEquals(false, stats.manaIsFull());
			assertEquals(105, stats.getHP());
			assertEquals(5, stats.getGold());
			assertEquals(105, stats.getMana());
		}
		@Test
		public void testInvalidStatEdits() {
			PlayerStats stats = new PlayerStats();
			stats.addXP(-50);
			stats.increaseCoreStat("str", -15);
			stats.increaseCoreStat("spd", -15);
			stats.increaseCoreStat("tgh", -15);
			stats.increaseCoreStat("int", -15);
			stats.increaseCoreStat("per", -15);
			stats.calcDerivedStats(-20, 0);
			stats.addHP(-5);
			stats.addMana(-5);
			stats.addGold(-5);
			assertEquals(0, stats.getXP());
			assertEquals(1, stats.getLvl());
			assertEquals(1, stats.calcShield());
			assertEquals(0, stats.calcDodge());
			assertEquals(1, stats.calcRun());
			assertEquals(true, stats.hpIsFull());
			assertEquals(true, stats.manaIsFull());
			assertEquals(0, stats.getHP());
			assertEquals(0, stats.getGold());
			assertEquals(0, stats.getMana());
		}
		@Test
		public void testIfBonusHPBehaves(){
			PlayerStats stats = new PlayerStats();
			stats.addHPWithBonus(5);
			assertEquals(105, stats.getHP());
			stats.addHP(5);
			assertEquals(100, stats.getHP());
			stats.addHPWithBonus(-200);
			assertEquals(0, stats.getHP());
		}
		@Test
		public void testIfReviveHealsHalfHPOnlyIfPassedOut(){
			PlayerStats stats = new PlayerStats();
			stats.revive();
			assertEquals(100, stats.getHP());
			stats.addHP(-99);
			stats.revive();
			assertEquals(1, stats.getHP());
			stats.addHP(-100);
			stats.revive();
			assertEquals(50, stats.getHP());
		}
}
