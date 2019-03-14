package fight.effects;

import fight.BattleField;
import fight.Character;
import fight.Skill;

public abstract class Effect extends Skill{
    protected Skill skill;

    public Effect(Skill skill){
        super(skill);
        this.skill = skill;        
    }

    public abstract void use(BattleField battleField, Character firstTarget);
}