package game.fight.effects;

import game.fight.BattleField;
import game.fight.character.Character;

public class ActiveSkill extends Skill {
	
	public ActiveSkill(String nom){
		super(nom);
	}
	
	public void use(BattleField battleField, Character firstTarget){
        System.out.println("Compétence lancée");
    }

}
