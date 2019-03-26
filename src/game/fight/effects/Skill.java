package game.fight.effects;

import game.fight.BattleField;
import game.fight.character.Character;

public class Skill {
	
	private String nom;
	//isActive
	
	private SkillType skillType;
	
	public Skill(String nom, SkillType skillType){
		this.nom = nom;
		
		this.skillType = skillType;
	}
	
	public void use(BattleField battleField, Character firstTarget){
        System.out.println("Competence lancee");
    }
	
	public String getNom() { return this.nom; }
	public SkillType getSkillType() { return this.skillType; }
	
	public String toString() {
		return this.nom;
	}

}
