package TextGame;
import java.util.*;
public class InputHolder {
	
	private static ArrayList<String> storage = new ArrayList<>();
	public void addNewInput(String input){
		storage.add(input);
		synchronized(this){
			this.notify();
		}
	}
	public String getNewInput(){
		if (storage.size()==0){
			try {
				synchronized(this){
					this.wait();
				}
			} catch (InterruptedException e) {
			}
		}
		return storage.remove(0);
	}
	public static void preStore(ArrayList<String> commands){
		storage = commands;
	}
}
