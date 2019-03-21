package fight;

public class Fight{
    private BattleField battleField;

    public Fight(BattleField battleField){
        this.battleField = battleField;
    }

    public void run(){
        /*while (this.battleField.getBattleStatus() == BattleStatus.PROCESSING){
            
        }*/
        System.out.println(this.battleField);
        this.battleField.getAllyField().getCharacter1().useSkill(1,
                                                            this.battleField,
                                                            this.battleField.getEnnemyField().getCharacter2()
                                                            );
        System.out.println(this.battleField);
    }

}