package game.fight.field;

import java.util.ArrayList;

import game.fight.character.Character;

public class Field4 implements Field {
    private Character character1;
    private Character character2;
    private Character character3;
    private Character character4;

    public Field4(Character ch1, Character ch2, Character ch3, Character ch4){
        this.character1 = ch1;
        this.character2 = ch2;
        this.character3 = ch3;
        this.character4 = ch4;
    }

    public boolean areAllDead(){
        return (this.character1.isDead() &&
                this.character2.isDead() &&
                this.character3.isDead() &&
                this.character4.isDead());
    }
    
    public ArrayList<Character> getAllCharacters(){
    	ArrayList<Character> characters = new ArrayList<Character>();
    	
    	if (!this.character1.isDead()) characters.add(this.character1);
    	if (!this.character2.isDead()) characters.add(this.character2);
    	if (!this.character3.isDead()) characters.add(this.character3);
    	if (!this.character4.isDead()) characters.add(this.character4);
    	
    	return characters;
    }
    
    public Character getCharacter1(){ return this.character1; }
    public Character getCharacter2(){ return this.character2; }
    public Character getCharacter3(){ return this.character3; }
    public Character getCharacter4(){ return this.character4; }

    public String toString(){
        String ret = "1 : " + this.character1.toString();
        ret += "\n2 : " + this.character2.toString();
        ret += "\n3 : " + this.character3.toString();
        ret += "\n4 : " + this.character4.toString();

        return ret;
    }
}