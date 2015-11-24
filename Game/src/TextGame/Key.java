package TextGame;

public class Key extends Item{
	private Location location;
	private Location destination;
	private Exit exitType;
	public Key(String name, int count, Location location, Exit exitType, Location destination) {
		super(name, count, false, true, true, 0);
		this.location = location;
		this.exitType = exitType;
		this.destination = destination;
	}
	Location getLocation(){
		return location;
	}
	Location getDestination(){
		return destination;
	}
	public Character use(Character player){
		if (player.getCurrentLocation()==location){
			location.setLock(false);
			location.addExit(exitType, destination);
		}
		return player;
	}
}
