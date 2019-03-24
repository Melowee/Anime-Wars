package game.fight;

import game.fight.character.Character;
import game.fight.character.Owner;
import game.fight.effects.InflictDamage;
import game.fight.effects.Skill;
import game.fight.effects.SkillType;

public class FightUtils {
	public static Character getCharacterByName(String name, Owner owner) {
		Skill skill1;
		Skill skill2;
		Skill skill3;
		
		switch (name) {
			case "dev":
				skill1 = new InflictDamage(1, new Skill("Skill incroyable", SkillType.OFFENSIVE));
				skill2 = new InflictDamage(1, new Skill("Skill incroyable", SkillType.OFFENSIVE));
				skill3 = new InflictDamage(1, new Skill("Skill incroyable", SkillType.OFFENSIVE));
				
				return new Character("Dev", owner, 5, 5, skill1, skill2, skill3);
			default:
				return new Character("Error", owner, 0, 0, null, null, null);
		}
	}
}
