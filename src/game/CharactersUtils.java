package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import game.fight.character.Character;
import game.fight.character.Owner;
import game.fight.effects.InflictDamage;
import game.fight.effects.Skill;
import game.fight.effects.SkillType;

public class CharactersUtils {
	private static final Map<String, String> CHARACTERS_RULES = new HashMap<String, String>();
	private static final String CHARACTER_DATA_FILE = "./src/game/charactersData.txt";
	
	static {
		fillRules();
	}
	
	private static void fillRules() {
		try (BufferedReader reader = new BufferedReader(new FileReader(CHARACTER_DATA_FILE))) {
			String line;
			while ((line = reader.readLine()) != null) {
				String[] pieces = line.split("=");
				CHARACTERS_RULES.put(pieces[0], pieces[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static Character getCharacterByName(String name, Owner owner) {
		Skill skill1;
		Skill skill2;
		Skill skill3;
		
		switch (name) {
			case "dev":
				skill1 = new InflictDamage(1, new Skill("Skill exeptionnel", SkillType.OFFENSIVE));
				skill2 = new InflictDamage(1, new Skill("Skill incroyable", SkillType.OFFENSIVE));
				skill3 = new InflictDamage(1, new Skill("Skill incroyable", SkillType.OFFENSIVE));
				
				return new Character("Dev", owner, 5, 5, skill1, skill2, skill3);
			default:
				return new Character("Error", owner, 0, 0, null, null, null);
		}
	}
}
