package factories;

import java.util.EnumMap;
import java.util.Map;

import TextGame.Door;
import doors.DoorList;
import doors.FarmDoor;

public class DoorFactory {

	private static DoorFactory factory = new DoorFactory();
	public static DoorFactory getFactory(){
		return factory;
	}
	private Map<DoorList, Door> doorMap = new EnumMap<>(DoorList.class);
	private DoorFactory(){
		doorMap.put(DoorList.farmDoor, new FarmDoor());
	}
	public Door get(DoorList door){
		return doorMap.get(door);
	}
}
