package TextGame;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class Location {

	
	private String locName;
	private String locDescription;
	private Vector<Creature> creatures = new Vector<>();
	private Vector<NPC> npcs = new Vector<>();
	private Map<Exit, Location> exits = new EnumMap<Exit, Location>(Exit.class);
	private boolean lock = false;
	public Location(){
		locName = new String ();
		locDescription = new String();
	}
	public Location( String loc ){
		locName = loc;
		locDescription = new String();
		}	

	public Location( String loc, String description){
		locName = loc;
		locDescription = description;
		}

	public String toString(){
		return locName;
	}

	public void addNPC ( NPC npc ){
		npcs.addElement (npc);
	}

	public void removeNPC ( NPC npc )
	{
		if (npcs.contains (npc))
		{
			npcs.removeElement (npc);
		}
	}
	public Vector<NPC> getNPCs (){
		return (Vector<NPC>) npcs;
	}
	public void addCreature ( Creature creature ){
		creatures.addElement (creature);
	}

	public void removeCreature ( Creature creature )
	{
		if (creatures.contains (creature))
		{
			creatures.removeElement (creature);
		}
	}

	@SuppressWarnings("unchecked")
	public Vector<Creature> getCreatures (){
		return (Vector<Creature>) creatures.clone();
	}
	
	public void addExit (Exit exit, Location destination){
		exits.put(exit, destination);
	}

	public void removeExit ( Exit exit )
	{
		if (exits.containsKey(exit))
		{
			exits.remove(exit);
		}
	}
	public Set<Exit> getExits (){
		return exits.keySet();
	}
	public Location getNewLocation(Exit exit){
		return exits.get(exit);
	}
	public String getLocName(){
	return locName;
	}

	public void setLocName( String lName){
	locName = lName;
	}

	public String getDescription(){
		return locDescription;
	}

	public void setLocDescription( String lDescription )
	{
		locDescription = lDescription;
	}
	public boolean hasLock() {
		return lock;
	}
	public void setLock(boolean lock) {
		this.lock = lock;
	}
	public void printOptions() {
		System.out.println( "\nAvailable exits :" );
		for (Exit exit : getExits()){
			System.out.println(exit.getDirectionName());
		}
		if (npcs.size() != 0){
			System.out.println("You see " + npcs.get(0).getName());
			System.out.println("You can LOOK or TALK");
		}
	}
}
