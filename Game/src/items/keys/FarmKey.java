package items.keys;

import TextGame.Door;
import doors.DoorList;
import factories.DoorFactory;
import items.Key;

public class FarmKey extends Key{
	private Door farmDoor = DoorFactory.getFactory().get(DoorList.farmDoor);
	
	
	@Override
	protected Door getDoor(){
		return farmDoor;
	}


	@Override
	public void printDescription() {
		System.out.println("It's a simple copper key, probably for a simple door");
	}
}
