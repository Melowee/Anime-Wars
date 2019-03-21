package fight;

import game.fight.BattleStatus;

public class BattleField{
    private Field allyField;
    private Field ennemyField;

    public BattleField(Field allyField, Field ennemyField){
        this.allyField = allyField;
        this.ennemyField = ennemyField;
    }

    public BattleStatus getBattleStatus(){
        if (this.allyField.areAllDead()){
            return BattleStatus.ALLY_DEAD;
        }else if (this.ennemyField.areAllDead()){
            return BattleStatus.ENNEMY_DEAD;
        }
        return BattleStatus.PROCESSING;
    }

    public Field getAllyField() { return this.allyField; }
    public Field getEnnemyField() { return this.ennemyField; }

    public String toString(){
        return "Ally field :\n" + this.allyField.toString() + "\nEnnemy Field :\n" + this.ennemyField.toString();
    }
}