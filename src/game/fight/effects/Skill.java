package game.fight.effects;

import game.fight.BattleField;
import game.fight.character.Character;

public class Skill {
	
	private String nom;
	//isActive
	
	public Skill(String nom){
		this.nom = nom;
	}
	
	public void use(BattleField battleField, Character firstTarget){
        System.out.println("Compétence lancée");
    }
	
	public String getNom() { return this.nom; }
	
	public String toString() {
		return this.nom;
	}

}
