package TextGame;

import java.util.EnumMap;
import java.util.Map;
import java.util.Set;
import java.util.Vector;

public class Location {

	
	private String locName;
	private String locDescription;
	private Vector<Creature> creatures = new Vector<>();
	private NPC npc = null;
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
			this.npc = npc;
	}

	public void removeNPC (){
		npc = null;
	}
	public NPC getNPC (){
		return npc;
	}
	public boolean hasNPC() {
		return npc != null;
	}
	public boolean isNPC(NPC npc){
		return npc.equals(this.npc);
	}
	public void addCreature ( Creature creature ){
		creatures.addElement (creature);
	}

	public void removeCreature ( Creature creature ){
		if (creatures.contains (creature)){
			creatures.removeElement (creature);
		}
	}

	public Creature chooseEnemy (){
		if (creatures.size()>0){
			return chooseEnemy(Input.dice(1,creatures.size())).clone();
		}else{
			return null;
		}
	}
	public Creature chooseEnemy (int index){
		try{
			return creatures.get(index);
		}catch(IndexOutOfBoundsException e){
			return null;
		}
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
		Location newLocation = exits.get(exit);
		if (newLocation != null){
			return newLocation;
		}
		return this;
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
			System.out.println(exit.toString());
		}
		if (npc != null){
			System.out.println("You see " + npc.toString());
			System.out.println("You can LOOK or TALK");
		}
	}
	
}
