package items;

import TextGame.Item;

public class NullItem extends Item{

	@Override
	public int getCount() {return 0;}

	@Override
	public int getValue() {return 0;}

	@Override
	public void use(Target target) {}

	@Override
	public void trash(int number) {}

	@Override
	public void trashAll() {}

	@Override
	public void printDescription() {}

}
