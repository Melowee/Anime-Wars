package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
				String[] charData = line.split("=");
				CHARACTERS_RULES.put(charData[0], charData[1]);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static Skill buildSkill(ArrayList<String> skillData) throws Exception {
		int listSize = skillData.size();
		if (listSize == 2) {
			SkillType skillType;
			
			switch (skillData.get(1)) {
				case "offensive" :
					skillType = SkillType.OFFENSIVE;
					break;
				case "defensive" :
					skillType = SkillType.DEFENSIVE;
					break;
				default:
					throw new Exception("Can't find the skill type " + skillData.get(1));
			}
			
			return new Skill(skillData.get(0), skillType);
			
		} else if ( listSize > 2){
			String[] effectData = skillData.get(skillData.size() -1).split(":");
			switch (effectData[0]) {
				case "damage" :
					skillData.remove(skillData.size() - 1);
					return new InflictDamage(Integer.parseInt(effectData[1]), buildSkill(skillData));
				default:
					throw new Exception("Undefined effect " + effectData[0]);
			}
			
		} else {
			throw new Exception("Unexpected length for skillData");
		}
	}
	
	private static Character buildCharacter(String datas, Owner owner) throws Exception {
		String[] data = datas.split("\\|");
		String[] stats = data[1].split("_");

		return new Character(
				data[0],
				owner, 
				Integer.parseInt(stats[0]),
				Integer.parseInt(stats[1]),
				buildSkill(new ArrayList<String>(Arrays.asList(data[2].split("_")))),
				buildSkill(new ArrayList<String>(Arrays.asList(data[3].split("_")))),
				buildSkill(new ArrayList<String>(Arrays.asList(data[4].split("_"))))
				);
	}
	
	public static Character getCharacterByName(String name, Owner owner) throws Exception {
		/*
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
		*/
		
		if (CHARACTERS_RULES.containsKey(name)) {
			return buildCharacter(CHARACTERS_RULES.get(name), owner);
		} else {
			throw new Exception("Can't find the Character " + name);
		}
	}
}
