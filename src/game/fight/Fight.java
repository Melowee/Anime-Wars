package fight;

public class Fight{
    private BattleField battleField;

    public Fight(BattleField battleField){
        this.battleField = battleField;
    }

    public void run(){
        while (this.battleField.getBattleStatus() == BattlsStatus.PROCESSING){
            
        }
    }

}