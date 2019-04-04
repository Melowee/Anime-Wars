package game.fight.effects;

import game.fight.BattleField;
import game.fight.character.Character;

public class Heal extends Effect {
	private int amount;
	
	public Heal(int amount, Skill skill) {
		super(skill);
		this.amount = amount;
	}
	
	public void use(Character caster, BattleField battleField, Character firstTarget) {
		this.getSkill().use(caster, battleField, firstTarget);
		firstTarget.getHealed(this.amount);
	}
}
