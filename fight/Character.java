package fight;

public class Character{
    private String name;

    private int atk;
    private int hp;

    private Skill skill1;
    private Skill skill2;
    private Skill skill3;

    public Character(String name, int atk, int hp, Skill skill1, Skill skill2, Skill skill3){
        this.name = name;
        this.atk = atk;
        this.hp = hp;
        this.skill1 = skill1;
        this.skill2 = skill2;
        this.skill3 = skill3;
    }

    public void useSkill1(BattleField battleField, Character firstTarget){
        skill1.use(battleField, firstTarget);
    }

    public void useSkill2(BattleField battleField, Character firstTarget){
        skill2.use(battleField, firstTarget);
    }

    public void useSkill3(BattleField battleField, Character firstTarget){
        skill3.use(battleField, firstTarget);
    }

    public String toString(){
        return this.name;
    }
}