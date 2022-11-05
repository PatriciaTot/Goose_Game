package goosegame.board.cell;

public class TrapCell extends BasicCell {
	
	public TrapCell(int index) {
		super(index) ;
	}
	
	public boolean canBeLeft() {
	     return false;
	}
	
	public String toString() {
	     return "cell " + super.index ;
	}
}
