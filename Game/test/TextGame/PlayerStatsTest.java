package TextGame;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class PlayerStatsTest {

	@Test
	public void testPlayerStatReturns() {
		ArrayList<String> commands = new ArrayList<>();
		commands.add("speed");
		InputHolder.preStore(commands);
		PlayerStats stats = new PlayerStats();
		assertEquals(0, stats.getXP());
		assertEquals(1, stats.getLvl());
		assertEquals(1, stats.calcShield());
		assertEquals(15, stats.calcDodge());
		assertEquals(16, stats.calcRun());
		assertEquals(true, stats.hpIsFull());
		assertEquals(true, stats.manaIsFull());
		assertEquals(100, stats.getHP());
		assertEquals(0, stats.getGold());
		assertEquals(100, stats.getMana());
	}
	@Test
		public void testValidStatEdits(){
			ArrayList<String> commands = new ArrayList<>();
			commands.add("str");
			commands.add("perception");
			commands.add("strength");
			commands.add("intelligence");
			InputHolder.preStore(commands);
			PlayerStats stats = new PlayerStats();
			stats.addXP(350);
			stats.increaseCoreStat("spd", 5);
			stats.increaseCoreStat("tgh", 5);
			stats.increaseCoreStat("per", 5);
			stats.calcDerivedStats(1, 1);
			stats.addHP(5);
			stats.addMana(-5);
			stats.addGold(5);
			assertEquals(50, stats.getXP());
			assertEquals(3, stats.getLvl());
			assertEquals(4, stats.calcShield());
			assertEquals(14, stats.calcDodge());
			assertEquals(17, stats.calcRun());
			assertEquals(false, stats.hpIsFull());
			assertEquals(false, stats.manaIsFull());
			assertEquals(125, stats.getHP());
			assertEquals(5, stats.getGold());
			assertEquals(127, stats.getMana());
		}
		@Test
		public void testInvalidStatEdits() {
			ArrayList<String> commands = new ArrayList<>();
			commands.add("per");
			InputHolder.preStore(commands);
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
			assertEquals(0, stats.calcShield());
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
			ArrayList<String> commands = new ArrayList<>();
			commands.add("spd");
			InputHolder.preStore(commands);
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
			ArrayList<String> commands = new ArrayList<>();
			commands.add("int");
			InputHolder.preStore(commands);
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
		@Test
		public void testNegativeStatsProtection(){
			ArrayList<String> commands = new ArrayList<>();
			commands.add("intelligence");
			InputHolder.preStore(commands);
			PlayerStats stats = new PlayerStats();
			stats.calcDerivedStats(-50, 50);
			stats.addMana(-200);
			assertEquals(0, stats.getMana());
			assertEquals(0, stats.calcDodge());
			
		}
}
