package TextGame;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

public class DamageSpellTest {

	@Test
	public void DamageSpellOutsideCombat() {
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
		Spell spell = new DamageSpell(null, 10, null, 25);
		player.addSpell(spell);
		player.castSpell(spell);
		assertEquals(90, player.getMana());
	}
	@Test
	public void DamageSpellInCombat() {
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
		player.setCombat(true);
		player.setEnemy(new Creature());
		int firstHP = player.getEnemyHP();
		Spell spell = new DamageSpell(null, 10, null, 25);
		player.addSpell(spell);
		player.castSpell(spell);
		assertEquals(90, player.getMana());
		assertEquals(firstHP - 25, player.getEnemyHP());
	}

}
