package items.materials;

import items.Material;
import items.Target;

public class Hide extends Material{

	private int value = 20;

	@Override
	public int getValue() {
		return value;
	}

	@Override
	public void use(Target target) {
		System.out.println("No way you can craft anything of leather without a work bench.");
	}

	@Override
	public void printDescription() {
		System.out.println("Not formerly a not so lucky fur.");
	}
}
