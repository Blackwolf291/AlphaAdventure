package items;

public interface Combatant extends Target{

	void addTempDodge(int value);
	void reduceTempDodge(int value);
	void addTempDefense(int value);
	void reduceTempDefense(int value);
	void addTempAccuracy(int value);
	void reduceTempAccuracy(int value);
	void setEquipt(Equipment equipment);
	void reduceTempAttack(int attackPenalty);
	void addTempAttack(int attackPenalty);

}
