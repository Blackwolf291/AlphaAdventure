package TextGame;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ CoreStatsTest.class, InGameTimeTest.class, EquipmentTest.class, PlayerStatsTest.class})
public class AllTests {

}
