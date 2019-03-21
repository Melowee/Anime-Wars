package game;

import game.fight.effects.Skill;
import game.fight.effects.InflictDamage;
import game.fight.field.Field;
import game.fight.character.Character;
import game.fight.BattleField;
import game.fight.Fight;

public class Main {
    public static void main(String[] args){
        Skill skill = new InflictDamage(1, new Skill());

        Character ch = new Character("Dev", 5, 5, skill, null, null);
        Character ch2 = new Character("Vicos", 5, 5, skill, null, null);

        Field field1 = new Field(ch, ch, ch, ch);
        Field field2 = new Field(ch, ch2, ch, ch);

        BattleField bf = new BattleField(field1, field2);

        Fight fight = new Fight(bf);

        fight.run();
    }
}