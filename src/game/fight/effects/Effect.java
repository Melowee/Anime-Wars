package game.fight.effects;

import game.fight.BattleField;
import game.fight.character.Character;
import game.fight.effects.Skill;

public abstract class Effect extends Skill{
    private Skill skill;

    public Effect(Skill skill){
    	super(skill.getNom(), skill.getSkillType());
        this.skill = skill;        
    }

    public abstract void use(Character caster, BattleField battleField, Character firstTarget);
    
    public Skill getSkill() {return this.skill; }
}