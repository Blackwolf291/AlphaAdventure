package items;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import TextGame.Item;

public class ItemIT {

	ItemFactory factory = ItemFactory.getFactory();
	
	@Test 
	public void factoryBuildsProperly(){
		ItemFactory factory = ItemFactory.getFactory();
		for (ItemList itemName : ItemList.values()){
			Item item = factory.get(itemName);
			assertEquals(itemName.toString().toLowerCase(),item.getClass().getName().toLowerCase());
		}
	}
	
	@Test
	public void itemFactoryBuildsAllItems(){
		
	}

}
