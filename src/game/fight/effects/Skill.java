package game.fight.effects;

import game.fight.BattleField;
import game.fight.character.Character;

public class Skill {
	
	private String nom;
	private int maxCooldown;
	private int currentCooldown;
	
	private SkillType skillType;
	
	public Skill(String nom, int maxCooldown, SkillType skillType){
		this.nom = nom;
		this.maxCooldown = maxCooldown;
		
		this.currentCooldown = 0;
		this.skillType = skillType;
	}
	
	public Skill(Skill skill) {
		this.nom = skill.getNom();
		this.maxCooldown = skill.getMaxCooldown();
		this.skillType = skill.getSkillType();
		this.currentCooldown = skill.getCurrentCooldown();
	}
	
	public void use(Character caster, BattleField battleField, Character firstTarget){
		this.currentCooldown = this.maxCooldown;
        System.out.println("Competence lancee");
    }
	
	public boolean isOnCooldown() {
		return this.currentCooldown != 0;
	}
	
	public String getNom() { return this.nom; }
	public int getMaxCooldown() { return this.maxCooldown; }
	public int getCurrentCooldown() { return this.currentCooldown; }
	public SkillType getSkillType() { return this.skillType; }
	
	public String toString() {
		return this.nom + this.currentCooldown + this.maxCooldown;
	}

}
