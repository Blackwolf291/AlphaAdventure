package TextGame;

import java.util.ArrayList;

public class SpellBook {
	ArrayList<Spell> spells = new ArrayList<>();

	public void printSpellBook() {
		if(hasSpells()){
			printSpells();
		} else{
			System.out.println("You don\'t have any spells.");
		}
	}
	
	public void printSpells(){
		for (int i = 0; i == spells.size(); i++){
			System.out.println(spells.get(i).getName() + "Mana Cost" + spells.get(i).getCost());
			}
	}

	public boolean hasSpells() {
		return spells.size()>0;
	}
	public boolean hasSpell(Spell spell){
		return spells.contains(spell);
	}

	public void addSpell(Spell spell) {
		spells.add(spell);
	}
	public void castSpell(Character player, Spell spell){
		spell.cast(player);
	}
}
