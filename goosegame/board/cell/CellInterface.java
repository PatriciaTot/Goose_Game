package goosegame.board.cell;
import goosegame.Player;

public interface CellInterface {
	
	/**
	 * access to the index of the cell
	 * @return the index
	 */
	public int getIndex() ;
	
	/**
	 * access to the player who is in the cell
	 * @return the player
	 */
	public Player getPlayer() ;
	
	/** assigns a cell to a player who gets there
	 * @param the player
	 */
	public void welcomePlayer(Player player);

	/**
	 * tells whether a cell can be left or not
	 * @return <code>true</code> if the cell can be left, <code>false</code> otherwise
	 */
	public boolean canBeLeft() ;
	
	/**
	 * tells whether a cell is busy or not
	 * @return <code>true</code> if the cell is busy, <code>false</code> otherwise
	 */
	public boolean isBusy() ;
	
	/**
	 * the player bounces and moves as many cells as indicated by the dice or stays in place for the goose cells
	 */
	public int bounce(int diceThrow) ;
	
}
