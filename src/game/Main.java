package game;

import game.fight.effects.Skill;
import game.fight.effects.SkillType;
import game.fight.effects.InflictDamage;
import game.fight.field.Field4;
import game.fight.player.AIPlayer;
import game.fight.player.AllyPlayer;
import game.fight.character.Character;
import game.fight.character.Owner;
import game.fight.BattleField;
import game.fight.Fight;
import game.fight.FightUtils;

public class Main {
    public static void main(String[] args){
        Character ch1 = FightUtils.getCharacterByName("dev", Owner.ALLY);
        Character ch2 = FightUtils.getCharacterByName("dev", Owner.ALLY);
        Character ch3 = FightUtils.getCharacterByName("dev", Owner.ALLY);
        Character ch4 = FightUtils.getCharacterByName("dev", Owner.ALLY);
        
        Character ch5 = FightUtils.getCharacterByName("dev", Owner.ENNEMY);
        Character ch6 = FightUtils.getCharacterByName("dev", Owner.ENNEMY);
        Character ch7 = FightUtils.getCharacterByName("dev", Owner.ENNEMY);
        Character ch8 = FightUtils.getCharacterByName("dev", Owner.ENNEMY);

        Field4 field1 = new Field4(ch1, ch2, ch3, ch4);
        Field4 field2 = new Field4(ch5, ch6, ch7, ch8);

        BattleField bf = new BattleField(field1, field2);
        
        AllyPlayer player1 = new AllyPlayer();
        AIPlayer player2 = new AIPlayer();
        
        Fight fight = new Fight(bf, player1, player2);

        fight.run();
    }
}