package game.fight;

import game.fight.character.Character;
import game.fight.character.Owner;
import game.fight.player.AbstractPlayer;

public class Fight{
    private BattleField battleField;
    
    private AbstractPlayer allyPlayer;
    private AbstractPlayer ennemyPlayer;
    
    private Character activeCharacter;

    public Fight(BattleField battleField, AbstractPlayer player1, AbstractPlayer player2){
        this.battleField = battleField;
        this.allyPlayer = player1;
        this.ennemyPlayer = player2;
    }

    public void run(){
    	while (this.battleField.getBattleStatus() == BattleStatus.PROCESSING) {    		
    		this.activeCharacter = this.battleField.getNextActiveCharacter();
    		
    		System.out.println(this.battleField);
    		
    		Owner characterOwner = this.activeCharacter.getOwner();
    		
    		switch (characterOwner) {
    			case ALLY:
    				System.out.println("Tour de " + this.activeCharacter.getName() + " allie !");
    				this.allyPlayer.play(this.battleField, this.activeCharacter);
    				break;
    			case ENNEMY:
    				System.out.println("Tour de " + this.activeCharacter.getName() + " ennemi !");
    				this.ennemyPlayer.play(this.battleField, this.activeCharacter);
    				break;
    		}
    		
    		this.activeCharacter.endTurn();
    		
    		try {
    			Thread.sleep(3000);
    		} catch (InterruptedException e) {
    			e.printStackTrace();
    		}
    	}
    	
    	System.out.println(this.battleField.getBattleStatus());
    }

}