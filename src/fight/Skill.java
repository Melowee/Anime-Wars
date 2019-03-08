package fight;

public abstract class Skill{
    private BattleField battleField;
    private Character firstTarget;

    public Skill(BattleField battleField, Character firstTarget){
        this.battleField = battleField;
        this.firstTarget = firstTarget;
    }

    public Skill(Skill skill){
        this.battleField = skill.battleField;
        this.firstTarget = skill.firstTarget;
    }

    public void use(){
        System.out.println("Compétence lancée");
    }

    public BattleField getBattleField(){return this.battleField;}
    public Character getFirstTarget(){return this.firstTarget;}
}