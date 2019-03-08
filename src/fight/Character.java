package fight;

public class Character{
    private int atk;
    private int hp;

    private Skill skill1;
    private Skill skill2;
    private Skill skill3;

    public Character(int atk, int hp, Skill skill1, Skill skill2, Skill skill3){
        this.atk = atk;
        this.hp = hp;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
    }

    public void useSkill1(){
        skill1.use();
    }

    public void useSkill2(){
        skill2.use();
    }

    public void useSkill3(){
        skill3.use();
    }
}