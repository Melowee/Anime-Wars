package game.fight.effects;

import game.fight.BattleField;
import game.fight.character.Character;

public class Skill {

    public Skill(){
    }

    public Skill(Skill skill){
    }

    public void use(BattleField battleField, Character firstTarget){
        System.out.println("Compétence lancée");
    }
}