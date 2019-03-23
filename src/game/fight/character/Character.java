package game.fight.character;

import game.fight.effects.Skill;

import java.util.ArrayList;

import game.fight.BattleField;
import game.fight.character.Character;

public class Character{
    private String name;
    
    private Owner owner;
    
    private static final int MAX_ATB = 100;
    private int atb;
    
    private int hpMAX;
    private int atk;
    private int hp;

    private Skill skill1;
    private Skill skill2;
    private Skill skill3;

    public Character(String name, Owner owner, int atk, int hpMAX, Skill skill1, Skill skill2, Skill skill3){
        this.name = name;
        
        this.owner = owner;
        
        this.atb = 0;
        
        this.atk = atk;
        this.hpMAX = hpMAX;
        this.hp = hpMAX;

        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
    }

    public boolean useSkill(int number, BattleField battleField, Character firstTarget){
        switch (number) {
            case 1:
                this.skill1.use(battleField, firstTarget);
                break;
            case 2:
                this.skill2.use(battleField, firstTarget);
                break;
            case 3:
                this.skill3.use(battleField, firstTarget);
                break;
            default:
                return false;
        }
        return true;
    }
    
    public void increaseAtb() {
    	this.atb += 10;
    	if (this.atb > MAX_ATB) {
    		this.atb = MAX_ATB;
    	}
    }

    public void getDamaged(int amount){
        if (this.hp - amount < 0){
            this.hp = 0;
        }else {
            this.hp -= amount;
        }
    }

    public void getHealed(int amount){
        if (this.hp + amount > this.hpMAX){
            this.hp = hpMAX;
        }else {
            this.hp += amount;
        }
    }

    public boolean isDead(){
        return this.hp == 0;
    }
    
    public boolean isFullAtb() {
    	return this.atb == MAX_ATB;
    }
    
    public void resetAtb() {
    	this.atb = 0;
    }
    
    public ArrayList<Skill> getAllSkills() {
    	ArrayList<Skill> skills = new ArrayList<Skill>();
    	
    	skills.add(this.skill1);
    	skills.add(this.skill2);
    	skills.add(this.skill3);
    	
    	return skills;
    }

    public String getName() { return this.name; }
    public int getAtb() { return this.atb; }
    public Owner getOwner() { return this.owner; }

    public String toString(){
        return this.name + " " + this.hp + "/" + this.hpMAX + " HP " + this.atb;
    }
}