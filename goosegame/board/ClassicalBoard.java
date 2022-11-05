package goosegame.board;
import goosegame.board.cell.*;

/** Board of 63 cells plus the starting cell */

public class ClassicalBoard extends Board {
	
	public static final int NB_OF_CELLS = 63 ;
	
	public ClassicalBoard() {
		super(ClassicalBoard.NB_OF_CELLS) ;
	}
	
	protected void initBoard() {
		
		// starting cell
		super.theCells[0] = new StartingCell() ;
		
		// basic cells
		for (int i = 1; i < 64; i++) {
			super.theCells [i] = new BasicCell(i) ;
		}
		
		// goose cells
		int[] gooseCells = {9, 18, 27, 36, 45, 54} ;
		for (int i : gooseCells) {
			super.theCells[i] = new GooseCell(i) ;
		}
		
		// waiting cells
		super.theCells[19] = new WaitingCell(19,2) ;
		
		// trap cells
		super.theCells[31] = new TrapCell(31) ;
		super.theCells[52] = new TrapCell(52) ;
		
		// teleport cells
		super.theCells[6] = new TeleportCell(6,12) ;
		super.theCells[42] = new TeleportCell(42,30) ;
		super.theCells[58] = new TeleportCell(58,1) ;
	}
}
