package TextGame;

import static org.junit.Assert.*;

import org.junit.Test;

import items.Helmet;
import items.ItemFactory;
import items.equipment.Armor;
import items.equipment.Shield;

public class EquipmentTest {
	Equipment equipment;
	ItemFactory items = new ItemFactory();
	@Test
	public void testDefaults() {
		equipment = new Equipment();
		assertEquals(0, equipment.calcShield());
		assertEquals(0, equipment.speedPenalty());
	}
	@Test
	public void testEquipmentSwap() {
		equipment = new Equipment();
		equipment.swapArmor((Armor) items.copperArmor);
		equipment.swapShield((Shield) items.copperShield);
		equipment.swapHelmet((Helmet) items.copperHelmet);
		assertEquals(15, equipment.calcShield());
		assertEquals(1, equipment.speedPenalty());
	}
}
