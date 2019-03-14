package fight;

public class BattleField{
    private Field allyField;
    private Field ennemyField;

    public BattleField(Field allyField, Field ennemyField){
        this.allyField = allyField;
        this.ennemyField = ennemyField;
    }

    public String toString(){
        return "Ally field :\n" + this.allyField.toString() + "\nEnnemy Field :\n" + this.ennemyField.toString();
    }
}