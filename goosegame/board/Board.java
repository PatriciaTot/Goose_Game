package goosegame.board;
import goosegame.board.cell.*;

/** abstract class representing the game board containing the different cells */

abstract public class Board {
	protected final int nbOfCells ;
	protected CellInterface[] theCells ;
	
	/** A board consists of an array of nbOfCells, plus the starting cell */
	public Board (int nbOfCells) {
		this.nbOfCells = nbOfCells + 1 ;
		this.theCells = new CellInterface[nbOfCells + 1] ;
		initBoard() ;
	}
	
	/** Initializes the board by creating the cells */
	abstract protected void initBoard() ;
	
	/**
	 * access the cell corresponding to the given index
	 * @param the index
	 * @return the cell
	 */
	public CellInterface getCell(int index) {
		return theCells[index] ;
	}
	
	/**
	 * access to the number of the cells of the board
	 * @return the number of cells
	 */
	public int getNbOfCells() {
		return this.nbOfCells ;
	}
	
}
