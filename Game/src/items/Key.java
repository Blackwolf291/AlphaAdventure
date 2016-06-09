package items;

import TextGame.Door;
import TextGame.Item;

public abstract class Key extends Item {

	@Override
	public int getValue() {
		return 0;
	}

	@Override
	public void use(Target target) {
		if (target.equals(getDoor())){
			getDoor().open();
		}
	}

	@Override
	public void trash(int number) {
		System.out.println("You can't trash Key items");
	}

	@Override
	public void trashAll() {
		System.out.println("You can't trash Key items");
	}
	@Override
	public boolean sellable(){return false;}

	
	protected abstract Door getDoor();

}
