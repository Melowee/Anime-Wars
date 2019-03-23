package game.fight.player;

import java.util.ArrayList;
import java.util.Scanner;

import game.fight.BattleField;
import game.fight.character.Character;
import game.fight.effects.Skill;

public class AllyPlayer extends AbstractPlayer {
	
	private int currentSkill;
	private int currentTarget;
	
	public void play(BattleField battleField, Character activeCharacter) {
		ArrayList<Skill> skills = activeCharacter.getAllSkills();
		ArrayList<Character> characters = battleField.getAllCharacters();
		
		Scanner sc;
		
		for (int i = 0; i < skills.size(); i++) {
			System.out.println(i+1 + " " + skills.get(i).toString());
		}
		
		do {
			System.out.println("Choisissez un skill");
			sc = new Scanner(System.in);
			
			if (sc.hasNextInt()) {
				this.currentSkill = sc.nextInt();
			} else {
				this.currentSkill = -1;
			}
		} while (this.currentSkill <= 0 || this.currentSkill > skills.size());
		
		Character character;
		for (int i = 0; i < characters.size(); i++) {
			character = characters.get(i);
			System.out.println(i+1 + " " + character.getOwner().toString() + character.toString());
		}
		
		do {
			System.out.println("Choisissez une cible");
			sc = new Scanner(System.in);
			
			if (sc.hasNextInt()) {
				this.currentTarget = sc.nextInt();
			} else {
				this.currentTarget = -1;
			}
		} while (this.currentTarget <= 0 || this.currentTarget > characters.size());
		
		activeCharacter.useSkill(this.currentSkill, battleField, characters.get(this.currentTarget-1));
		
	}
}
