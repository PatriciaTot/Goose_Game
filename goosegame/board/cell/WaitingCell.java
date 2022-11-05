package goosegame.board.cell;
import goosegame.Player;

public class WaitingCell extends BasicCell {
	
	protected final int waitTime ;
	protected int waitDuration ;
	
	public WaitingCell(int index, int waitTime) {
		super(index) ;
		this.waitTime = waitTime ;
	    this.waitDuration = 0 ;
	}
	
	public boolean canBeLeft() {
		if (this.waitDuration < this.waitTime) {
		       this.waitDuration += 1 ;
		}
		else {
			return true ;
		}
		return false;
	}
	
	public void welcomePlayer(Player player) {
		if (super.player == null) {
			super.welcomePlayer(player);
		}
	    else {
	    	super.player.setCell(player.getCell()) ;
	     }
	    if (player != null) {
	    	super.player = player ;
	        super.player.setCell(this) ;
	    }
	} 
	
	public String toString() {
		return "cell " + super.index + " (waiting for " + this.waitTime + " turns)" ;
	}
}
