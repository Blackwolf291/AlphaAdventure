package TextGame;

import items.Target;

public abstract class Item {
	
	private int count;
	
	public int getCount(){
		return count;
	}
	
	public abstract int getValue();
	
	public abstract void use(Target target);
	
	public void gain(int number){
		count += number;
	}
	
	public void trash(int number){
		count -= number;
	}
	
	public void trashAll(){
		count = 0;
	}
	
	public boolean sellable(){return true;}
	
	public abstract void printDescription();
}
