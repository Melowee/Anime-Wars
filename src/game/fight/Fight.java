package fight;

public class Fight{
    private BattleField battleField;

    public Fight(BattleField battleField){
        this.battleField = battleField;
    }

    public void run(){
        System.out.println(this.battleField.getBattleStatus());
    }

}