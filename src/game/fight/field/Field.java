package game.fight.field;

import java.util.ArrayList;

import game.fight.character.Character;

public interface Field {
	public boolean areAllDead();
	
	public ArrayList<Character> getAllCharacters();
}
