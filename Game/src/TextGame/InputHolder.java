package TextGame;

import java.util.Vector;

public class InputHolder {
	private String storage;
	public void addNewInput(String input){
		storage = input;
		synchronized(this){
			this.notify();
		}
	}
	public String getNewInput(){
		try {
			synchronized(this){
				this.wait();
			}
		} catch (InterruptedException e) {
		}
		return storage;
	}
}
