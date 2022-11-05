package goosegame.board.cell;
import goosegame.Player;

public class StartingCell implements CellInterface {
	
	private int index ;
	
	public StartingCell() {
		this.index = 0 ;
	}
	
	public int getIndex() {
		return this.index ;
	}
	
	public Player getPlayer() {
		return null ;
	}
	
	public void welcomePlayer(Player player){}
	
	public boolean isBusy() {
		return false ;
	}
	
	public boolean canBeLeft() {
		return true ;
	}
	
	public int bounce(int diceThrow) {
	     return 0 ;
	}
	
	public String toString() {
		return "cell 0" ;
	}
}
