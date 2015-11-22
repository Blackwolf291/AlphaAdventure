package TextGame;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CoreStatsTest.class, InGameTimeTest.class, EquipmentTest.class, PlayerStatsTest.class, LocationTest.class, CommandListTest.class, ExitTest.class, GameStartTest.class, SpellBookTest.class, PlayerRaceTest.class})
public class AllTests {

}
