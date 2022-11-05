package goosegame.board.cell;

public class TeleportCell extends BasicCell {
	
	protected final int jumIndex;
	
	public TeleportCell(int index, int jumIndex) {
		super(index) ;
		this.jumIndex = jumIndex ;
	}
	
	public int bounce(int diceThrow) {
		return this.jumIndex - super.index ;
	}
	
	public String toString() {
	     return "cell " + super.index + " and jumps to cell " + this.jumIndex ;
	}
}
