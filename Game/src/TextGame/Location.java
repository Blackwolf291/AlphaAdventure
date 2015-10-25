package TextGame;

import java.util.Vector;

public class Location {

	
	private String locName;
	private String locDescription;
	private Vector<Creature> creatures;
	private Vector<NPC> npcs;
	private Vector<Exit> exits;
	private boolean lock = false;
	public Location(){
		locName = new String ();
		locDescription = new String();
		creatures = new Vector<Creature>();
		npcs = new Vector<NPC>();
		exits = new Vector<Exit>();
		
	}
	public Location( String loc ){
		locName = loc;
		locDescription = new String();
		npcs = new Vector<NPC>();
		creatures = new Vector<Creature>();
		exits = new Vector<Exit>();
		}	

	public Location( String loc, String description){
		locName = loc;
		locDescription = description;
		npcs = new Vector<NPC>();
		creatures = new Vector<Creature>();
		exits = new Vector<Exit>();
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
	
	public void addExit ( Exit exit ){
		exits.addElement (exit);
	}

	public void removeExit ( Exit exit )
	{
		if (exits.contains (exit))
		{
			exits.removeElement (exit);
		}
	}

	@SuppressWarnings("unchecked")
	public Vector<Exit> getExits (){
		return (Vector<Exit>) exits.clone();
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
}
