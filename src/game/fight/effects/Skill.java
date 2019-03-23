package game.fight.effects;

import game.fight.BattleField;
import game.fight.character.Character;

public abstract class Skill {
	
	private String nom;
	
	public Skill(String nom) {
		this.nom = nom;
	}
	
    public abstract void use(BattleField battleField, Character firstTarget);
    
    public String getNom() { return this.nom; }
    
    public String toString() {
    	return this.nom;
    }
}