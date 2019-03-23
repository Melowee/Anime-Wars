package game.fight.effects;

import game.fight.BattleField;
import game.fight.character.Character;

public class InflictDamage extends Effect {
    int amount;

    public InflictDamage(int amount, Skill skill){
        super(skill);
        this.amount = amount;
    }

    public void use(BattleField battleField, Character firstTarget){
        this.getSkill().use(battleField, firstTarget);
        firstTarget.getDamaged(this.amount);
        System.out.println(firstTarget.getName() + " a subi " + this.amount + " d�gat(s) !");
    }
}