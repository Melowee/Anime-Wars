package game.fight.player;

import java.util.ArrayList;
import java.util.Scanner;

import game.fight.BattleField;
import game.fight.character.Character;
import game.fight.effects.Skill;

public class AllyPlayer extends AbstractPlayer {
	
	private int currentSkill;
	private int currentTarget;
	private ArrayList<Skill> skills;
	private ArrayList<Character> characters;
	
	public void play(BattleField battleField, Character activeCharacter) {
		this.skills = activeCharacter.getAllSkills();
		this.characters = battleField.getAllCharacters();
		
		Scanner sc;
		
		for (int i = 0; i < this.skills.size(); i++) {
			System.out.println(i+1 + " " + this.skills.get(i));
		}
		
		do {
			System.out.println("Choisissez un skill");
			sc = new Scanner(System.in);
			
			if (sc.hasNextInt()) {
				this.currentSkill = sc.nextInt();
			} else {
				this.currentSkill = -1;
			}
		} while (!this.skillIsValid());
		
		Character character;
		for (int i = 0; i < this.characters.size(); i++) {
			character = this.characters.get(i);
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
		} while (!this.targetIsValid());
		
		activeCharacter.decreaseCooldowns();
		activeCharacter.useSkill(this.currentSkill, battleField, this.characters.get(this.currentTarget-1));
		
	}
	
	public boolean skillIsValid() {
		if (this.currentSkill <= 0 || this.currentSkill > this.skills.size()) {
			System.out.println(this.currentSkill + " n'est pas un id de skill valide !");
			return false;
		} else if (this.skills.get(this.currentSkill-1).isOnCooldown()) {
			System.out.println("Cette compétence est en cooldown !");
			return false;
		}
		return true;
	}
	
	public boolean targetIsValid() {
		if (this.currentTarget <= 0 || this.currentTarget > characters.size()) {
			System.out.println(this.currentTarget + " n'est pas un id de cible valide !");
			return false;
		}
		return true;
	}
}
