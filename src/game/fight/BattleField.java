package game.fight;

import game.fight.field.Field;
import game.fight.field.Field4;

import java.util.ArrayList;

import game.fight.character.Character;

public class BattleField{
    private Field allyField;
    private Field ennemyField;

    public BattleField(Field4 allyField, Field4 ennemyField){
        this.allyField = allyField;
        this.ennemyField = ennemyField;
    }

    public BattleStatus getBattleStatus(){
        if (this.allyField.areAllDead()){
            return BattleStatus.ALLY_DEAD;
        }else if (this.ennemyField.areAllDead()){
            return BattleStatus.ENNEMY_DEAD;
        }
        return BattleStatus.PROCESSING;
    }
    
    public Character getNextActiveCharacter() {
    	ArrayList<Character> allCharacters = this.getAllCharacters();
    	
    	while (true) {    		
    		for (Character character : allCharacters) {
    			if (character.isFullAtb()) {
    				return character;
    			}
    		}
    		
    		this.increaseAllAtb();
    		
    	}
    }
    
    public void increaseAllAtb() {
    	ArrayList<Character> allCharacters = this.getAllCharacters();
    	
    	for (Character character : allCharacters) {
    		character.increaseAtb();
    	}
    }
    
    public ArrayList<Character> getAllCharacters(){
    	ArrayList<Character> allCharacters = new ArrayList<Character>();
    	
		allCharacters.addAll(this.allyField.getAllCharacters());
		allCharacters.addAll(this.ennemyField.getAllCharacters());
		
		return allCharacters;
    }
    
    public Field getAllyField() { return this.allyField; }
    public Field getEnnemyField() { return this.ennemyField; }

    public String toString(){
        return "----------------\nAlly field :\n" + this.allyField.toString() +
        "\n--\nEnnemy Field :\n" + this.ennemyField.toString() + "\n----------------";
    }
}