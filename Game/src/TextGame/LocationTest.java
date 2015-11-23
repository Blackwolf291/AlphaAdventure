package TextGame;

import static org.junit.Assert.*;

import org.junit.Test;

public class LocationTest {

	@Test
	public void onKnownExitLocationShouldChange() {
		Location l1 = new Location();
		Location l2 = new Location();
		l1.addExit(Exit.special, l2);
		assertEquals(l2,l1.getNewLocation(Exit.special));
	}
	@Test
	public void onUnknownExitLocationShouldNotChange() {
		Location l1 = new Location();
		Location l2 = new Location();
		l1.addExit(Exit.north, l2);
		assertEquals(l1,l1.getNewLocation(Exit.special));
	}
	@Test
	public void testIfRemoveExitFunctions(){
		Location l1 = new Location();
		Location l2 = new Location();
		l1.addExit(Exit.north, l2);
		l1.removeExit(Exit.north);
		assertEquals(l1,l1.getNewLocation(Exit.north));
	}
	@Test
	public void testRemoveSafety(){
		Location l1 = new Location();
		Location l2 = new Location();
		l1.addExit(Exit.north, l2);
		l1.removeExit(Exit.special);
		assertEquals(l2,l1.getNewLocation(Exit.north));
	}
	@Test
	public void testCreatureSelectionWhenNoCreaturePresent(){
		Location l1 = new Location();
		assertEquals(null,l1.chooseEnemy());
	}
	@Test
	public void testCreatureSelectionUnderNormalCircumstances(){
		Location l1 = new Location();
		Creature enemy = new Creature();
		Creature friend = new Creature();
		l1.addCreature(enemy);
		l1.addCreature(friend);
		assertEquals(enemy,l1.chooseEnemy(0));
	}
	@Test
	public void testCreatureOutOfBoundsShouldReturnNull(){
		Location l1 = new Location();
		Creature enemy = new Creature();
		Creature friend = new Creature();
		l1.addCreature(enemy);
		l1.addCreature(friend);
		assertEquals(null,l1.chooseEnemy(2));
	}
	@Test
	public void testRemoveCreature(){
		Location l1 = new Location();
		Creature enemy = new Creature();
		Creature friend = new Creature();
		l1.addCreature(enemy);
		l1.addCreature(friend);
		l1.removeCreature(enemy);
		assertEquals(null,l1.chooseEnemy(1));
	}
	@Test
	public void testArrangeNPC(){
		Location l1 = new Location();
		NPC Shade = new NPC(null, null, null);
		NPC Tiger = new NPC(null, null, null);
		assertEquals(null, l1.getNPC());
		l1.addNPC(Shade);
		assertEquals(Shade, l1.getNPC());
		assertTrue(l1.hasNPC());
		assertTrue(l1.isNPC(Shade));
		assertFalse(l1.isNPC(Tiger));
		l1.removeNPC();
		assertEquals(null, l1.getNPC());
		assertFalse(l1.hasNPC());
		assertFalse(l1.isNPC(Shade));
	}
}
