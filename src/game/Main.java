package game;

import game.fight.effects.Skill;
import game.fight.effects.ActiveSkill;
import game.fight.effects.InflictDamage;
import game.fight.field.Field4;
import game.fight.character.Character;
import game.fight.character.Owner;
import Player.AllyPlayer;
import game.fight.BattleField;
import game.fight.Fight;

public class Main {
    public static void main(String[] args){
        Skill skill = new InflictDamage(1, new ActiveSkill("Skill incroyable"));
        
        Character ch = new Character("Dev", Owner.ALLY, 5, 5, skill, skill, skill);
        Character ch2 = new Character("DevE", Owner.ENNEMY, 5, 5, skill, skill, skill);
        Character chV = new Character("Vicos", Owner.ENNEMY, 5, 5, skill, skill, skill);

        Field4 field1 = new Field4(ch, ch, ch, ch);
        Field4 field2 = new Field4(ch2, chV, ch2, ch2);

        BattleField bf = new BattleField(field1, field2);
        
        AllyPlayer player1 = new AllyPlayer();
        
        Fight fight = new Fight(bf, player1, player1);

        fight.run();
    }
}