package game.fight.effects;

import java.util.List;
import java.util.Random;

import game.fight.BattleField;
import game.fight.character.Character;
import game.fight.character.Owner;

public class InflictRandomDamage extends Effect {
	private int amount;
	private int nbHits;
	
	public InflictRandomDamage(int amount, int nbHits, Skill skill) {
		super(skill);
		this.amount = amount;
		this.nbHits = nbHits;
	}

	public void use(Character caster, BattleField battleField, Character firstTarget) {
		this.getSkill()	.use(caster, battleField, firstTarget);
		List<Character> characters;
		
		if (firstTarget.getOwner() == Owner.ENNEMY) {
			characters = battleField.getEnnemyField().getAllCharacters();
		} else {
			characters = battleField.getAllyField().getAllCharacters();
		}
		
		int nbCharacters = characters.size();
		
		Random random = new Random();
		
		for (int i = 0; i < this.nbHits; i++) {
			characters.get(random.nextInt(nbCharacters)).getDamaged(this.amount);
		}
	}
	
	
}
