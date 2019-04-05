package game.fight.effects;

import java.util.List;

import game.fight.BattleField;
import game.fight.character.Character;
import game.fight.character.Owner;

public class InflictAOEDamage extends Effect {
	private int amount;
	
	public InflictAOEDamage(int amount, Skill skill) {
		super(skill);
		this.amount = amount;
	}
	
	public void use(Character caster, BattleField battleField, Character firstTarget) {
		this.getSkill().use(caster, battleField, firstTarget);
		List<Character> characters;
		
		if (firstTarget.getOwner() == Owner.ENNEMY) {
			characters = battleField.getEnnemyField().getAllCharacters();
		} else {
			characters = battleField.getAllyField().getAllCharacters();
		}
		
		for (Character character : characters) {
			character.getDamaged(this.amount);
		}
	}
}
