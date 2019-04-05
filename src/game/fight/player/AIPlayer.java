package game.fight.player;

import java.util.ArrayList;

import game.fight.BattleField;
import game.fight.character.Character;
import game.fight.character.Owner;
import game.fight.effects.Skill;

public class AIPlayer extends AbstractPlayer {
	public void play(BattleField battleField, Character activeCharacter) {
		ArrayList<Skill> skills = activeCharacter.getAllSkills();
		ArrayList<Character> characters = battleField.getAllCharacters();
		
		Character target;
		int i = 0;
		
		do {
			target = characters.get(i);
			i++;
		} while (target.getOwner() == Owner.ENNEMY);
		
		activeCharacter.decreaseCooldowns();
		activeCharacter.useSkill(1, battleField, target);
	}
}
