package doors;

import TextGame.Door;
import TextGame.Exit;

public class FarmDoor implements Door {
	private boolean locked;
	private Exit exit;
	@Override
	public void open() {
		locked = false;
	}

	@Override
	public boolean isLocked() {
		return locked;
	}
	
}
