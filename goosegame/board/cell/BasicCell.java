package goosegame.board.cell;
import goosegame.Player;

public class BasicCell implements CellInterface {
	
	protected final int index ;
	protected Player player ;
	
	public BasicCell(int index) {
	     this.index = index;
	     this.player = null;		
	}
	
	public int getIndex() {
		return this.index ;
	}
	
	public Player getPlayer() {
		return this.player ;
	}
	
	public void welcomePlayer(Player player) {
		if (this.player != null) {
		       this.player.setCell(player.getCell()) ;
		}
		this.player = player ;
		if (player != null) {
		       this.player.setCell(this);
		}	
	}
	
	public boolean canBeLeft() {
		return true ;
	}
	
	public boolean isBusy() {
		return this.player != null ;
	}
	
	public int bounce(int diceThrow) {
		return 0 ;
	}
	
	public String toString() {
		return "cell " + this.index ;
	}
}
