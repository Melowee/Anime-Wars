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
        firstTarget.getDamaged(this.amount);
        System.out.println(firstTarget.getName() + " a subi " + this.amount + " dégats !");
    }
}