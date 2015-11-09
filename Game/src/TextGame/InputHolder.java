package TextGame;

public class InputHolder {
	private String storage;
	public void addNewInput(String input){
		storage = input;
		storage.intern();
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
