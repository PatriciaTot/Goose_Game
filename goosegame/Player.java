package goosegame ;
import java.util.Random ;
import goosegame.board.cell.*;

/** A player in the goose game */

public class Player {
	
	private static final Random ALEA = new Random();
	
    /** current cell of the player */
    protected CellInterface cell ;
    
    /** name of the player*/
    protected String name ;
    
    /** 
     * @param name the name of this player
     * @param cell the starting cell of this player
    */
    public Player (String name, CellInterface cell) {
        this.name = name;
        this.cell = cell;
    }
    
    /**  A player with no current cell (== null)
     * @param name the name of this player
     * 
    */
    public Player (String name) {
        this(name, null);
    }
    
    public String toString() {
    	return name;
    }
    
    /** returns the current cell of the player 
      *  @return the current cell of the player 
      */
    public CellInterface getCell() { 
       return this.cell ; 
    }
    
    /** changes the cell of the player 
     * @param newCell the new cell
    */
    public void setCell(CellInterface newCell) { 
       this.cell = newCell; 
    }
    
    /** result of a 1d6 throw
     * @return random result of a 1d6 throw 
    */
    private int oneDieThrow() {	
       return ALEA.nextInt(6)+ 1; 
    }
    
    /** result of a 2d6 throw 
      * @return random result of a 2d6 throw
    */ 	
    public int twoDiceThrow() {
        int result = oneDieThrow() + oneDieThrow();
        return result;
    }
}
