package goosegame.board.cell;

public class GooseCell extends BasicCell {
	
	public GooseCell(int index) {
		super(index) ;
	}
	
	public int bounce(int diceThrow) {
		return diceThrow ;
	}
	
	public String toString() {
		return "cell " + super.index + " and jumps to cell " ;
	}
}
