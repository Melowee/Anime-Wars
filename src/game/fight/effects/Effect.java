package game.fight.effects;

import game.fight.BattleField;
import game.fight.character.Character;
import game.fight.effects.Skill;

public abstract class Effect extends Skill{
    private Skill skill;

    public Effect(Skill skill){
    	super(skill);
        this.skill = skill;
    }

    public abstract void use(Character caster, BattleField battleField, Character firstTarget);
    
    public int getCurrentCooldown() { return skill.getCurrentCooldown(); }
    public boolean isOnCooldown() { return skill.isOnCooldown(); }
    public String getNom() { return skill.getNom(); }
    public SkillType getSkillType() { return skill.getSkillType(); }
    
    public Skill getSkill() { return this.skill; }
    
    public String toString() {
    	return this.skill.toString();
    }
}