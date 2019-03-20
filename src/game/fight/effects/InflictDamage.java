package fight.effects;

import fight.BattleField;
import fight.Character;
import fight.Skill;

public class InflictDamage extends Effect {
    int amount;

    public InflictDamage(int amount, Skill skill){
        super(skill);
        this.amount = amount;
    }

    public void use(BattleField battleField, Character firstTarget){
        skill.use(battleField, firstTarget);
        System.out.println("Haha des dégats" + this.amount);
    }
}