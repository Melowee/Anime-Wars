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
import game.fight.effects.Heal;
import game.fight.effects.InflictAOEDamage;
import game.fight.effects.InflictDamage;
import game.fight.effects.InflictRandomDamage;
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
		if (listSize == 3) {
			SkillType skillType;
			
			switch (skillData.get(2)) {
				case "offensive" :
					skillType = SkillType.OFFENSIVE;
					break;
				case "defensive" :
					skillType = SkillType.DEFENSIVE;
					break;
				default:
					throw new Exception("Can't find the skill type " + skillData.get(1));
			}
			
			return new Skill(skillData.get(0), Integer.parseInt(skillData.get(1)), skillType);
			
		} else if ( listSize > 2){
			String[] effectData = skillData.get(skillData.size() -1).split(":");
			
			skillData.remove(skillData.size() - 1);
			switch (effectData[0]) {
				case "damage" :
					return new InflictDamage(Integer.parseInt(effectData[1]), buildSkill(skillData));
					
				case "heal":
					return new Heal(Integer.parseInt(effectData[1]), buildSkill(skillData));
					
				case "aoeDamage":
					return new InflictAOEDamage(Integer.parseInt(effectData[1]), buildSkill(skillData));
					
				case "randomDamage":
					return new InflictRandomDamage(Integer.parseInt(effectData[1]), Integer.parseInt(effectData[2]), buildSkill(skillData));
					
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
		if (CHARACTERS_RULES.containsKey(name)) {
			return buildCharacter(CHARACTERS_RULES.get(name), owner);
		} else {
			throw new Exception("Can't find the Character " + name);
		}
	}
}
