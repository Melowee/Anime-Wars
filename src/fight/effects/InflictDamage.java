package fight.effects;

import fight.Skill;

public class InflictDamage extends Effect {
    int amount;

    public InflictDamage(int amount, Skill skill){
        super(skill);
        this.amount = amount;
    }

    public void use(){
        //Code pour infliger des dégats
        skill.use();
    }
}