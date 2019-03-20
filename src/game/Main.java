package game;

import fight.*;
import fight.Character;
import fight.effects.InflictDamage;

public class Main{
    public static void main(String[] args){
        Skill skill = new InflictDamage(5, new InflictDamage(6, new Skill()));

        Character ch = new Character("Dev", 5, 5, skill, null, null);

        Field field = new Field(ch, ch, ch, ch);

        BattleField bf = new BattleField(field, field);

        Fight fight = new Fight(bf);

        fight.run();
    }
}