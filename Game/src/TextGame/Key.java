package TextGame;

public class Key extends Item{
	private Location location;
	private Location destination;
	public Key(String name, int count, Location location, Location destination) {
		super(name, count, false, true, true, 0);
		this.location = location;
	}
	Location getLocation(){
		return location;
	}
	Location getDestination(){
		return destination;
	}
}
