package fight;

public class Character{
    private String name;

    private int hpMAX;
    private int atk;
    private int hp;

    private Skill skill1;
    private Skill skill2;
    private Skill skill3;

    public Character(String name, int atk, int hpMAX, Skill skill1, Skill skill2, Skill skill3){
        this.name = name;
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

    public String toString(){
        return this.name + " " + this.hp + "/" + this.hpMAX + " HP";
    }
}