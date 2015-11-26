package TextGame;

import java.util.ArrayList;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ 
	CoreStatsTest.class, 
	BonusHPItemTest.class,
	MPItemTest.class, 
	HPItemTest.class, 
	InGameTimeTest.class, 
	EquipmentTest.class, 
	PlayerStatsTest.class, 
	LocationTest.class, 
	DamageSpellTest.class, 
	CommandListTest.class, 
	ExitTest.class, 
	GameStartTest.class, 
	SpellBookTest.class, 
	HPAndMPItemTest.class,
	CreatureTest.class,
	HealSpellTest.class,
	PlayerRaceTest.class})
public class AllTests {
	public static Character kickUpAPlayer(){
		ArrayList<String> commands = new ArrayList<>();
		commands.add("Shade");
		commands.add("y");
		commands.add("wolf");
		commands.add("y");
		commands.add("persuasion");
		commands.add("yes");
		InputHolder.preStore(commands);
		Main.launchFrame();
		Character player = new Character();
		return player;
	}
}
