package game.fight.player;

import game.fight.BattleField;
import game.fight.character.Character;

public abstract class AbstractPlayer {
	public abstract void play(BattleField battleField, Character activeCharacter);
}
