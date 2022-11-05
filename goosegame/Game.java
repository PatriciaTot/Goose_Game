package goosegame;
import java.util.LinkedList;
import goosegame.board.*;
import goosegame.board.cell.*;

/** A class characterized by a board and a list of players and allows to play a part of the goose game */

public class Game {
	
	protected LinkedList<Player> thePlayers ;
	protected Board board ;
	protected Player currentPlayer ;
	
	public Game(Board board) {
		this.board = board ;
		this.currentPlayer = null ;
		this.thePlayers = new LinkedList<Player>() ;
	}
	
	/** Get the board
	 * @return the board
	 */
	public Board getBoard() {
		return this.board ;
	}
	
	/** adds a new player at the starting cell
	 * @param the player to add
	 */
	public void addPlayer(Player newPlayer) {
		this.thePlayers.add(newPlayer) ;
	    newPlayer.setCell(this.board.getCell(0)) ;
	}
	
	/** 
	 * run a game until its end
	 */
	public void play() {
		boolean won = false ;
		Player player = null ;
		int diceThrow = 0 ;
		
		while (!won) {
			player = this.nextPlayer() ;
			diceThrow = player.twoDiceThrow() ;
			this.displayGame(player, diceThrow) ;
			won = this.round(player, diceThrow) ;
		}
		this.winner(player) ;
	}
	
	/** returns the player's reached cell
	 * @param the player
	 * @param the number on the dices
	 * @return the player's reached cell
	 */

	private CellInterface reached(Player player, int diceThrow) {
		int lastCellIndex = player.getCell().getIndex() ;
	    int newCellNumber ;
	    int newCellIndex ;
	    if ((lastCellIndex + diceThrow) > 63) {
	    	newCellNumber = 2*63 - (lastCellIndex + diceThrow) ;
	    }
	    else {
	    	newCellNumber = lastCellIndex + diceThrow ;
	     }
	    if ((newCellNumber + this.board.getCell(newCellNumber).bounce(diceThrow)) > 63) {
	    	newCellIndex = 2*63 - (newCellNumber + this.board.getCell(newCellNumber).bounce(diceThrow)) ;
	     }
	    else{
	    	newCellIndex = newCellNumber + this.board.getCell(newCellNumber).bounce(diceThrow) ;
	     }
	     CellInterface reachedCell = this.board.getCell(newCellIndex);
	     return reachedCell;
	}
	
	/**
	 * gives the next player
	 * @return the next player
	 */
	public Player nextPlayer() {
		if (this.currentPlayer == null) {
			this.currentPlayer = this.thePlayers.getFirst();
		    return this.currentPlayer ;
		}
		else {
			int nextPlayer = this.thePlayers.indexOf(this.currentPlayer) + 1 ;
		    if (nextPlayer == this.thePlayers.size()) {
		         this.currentPlayer = this.thePlayers.getFirst();
		    }
		    else {
		         this.currentPlayer = this.thePlayers.get(nextPlayer);
		    }
		    return this.currentPlayer ;
		}
	}
	
	/**
	 * moves the player to another cell
	 */
	public void movePlayer(Player player, CellInterface cell) {
		cell.welcomePlayer(player) ;
	}
	
	/**
	 * tells whether the player can play or not
	 * @param the player
	 * @return <code>true</code> if the player can play, <code>false</code> otherwise
	 */
	public boolean canPlay(Player player) {
	     if (!(player.getCell() instanceof TrapCell) || !(player.getCell() instanceof WaitingCell)) {
	       return true;
	     }
	     return player.getCell().canBeLeft();
	}
	
	/** announces the winner
	 * @param player who is potentially the winner
	 */
	public void winner(Player player) {
		if (player.getCell().getIndex() == 63) {
			System.out.println(player.toString() + " has won.");
	    }
	}
	
	/** continues the rounds until there is a winner
	 * @param the player who is playing
	 * @param the number of his dice throw
	 * @return <code>true</code> if the player reaches the last cell, <code>false</code> otherwise
	 */
	private boolean round(Player player, int diceThrow) {
		boolean won = false ;
	    if (this.canPlay(player)) {
	    	CellInterface reachedCell = this.reached(player, diceThrow) ;
	        this.movePlayer(player, reachedCell) ;
	        won = (reachedCell.getIndex() == board.getNbOfCells() - 1);
	    }
	    else {
	        this.displayGame(player, diceThrow);
	     }
	    return won;
	}
	
	/**
	 * organizes a round
	 * @param the player
	 * @param diceThrow
	 */
	public void displayGame(Player player, int diceThrow) {
	     String lastCell = player.getCell().toString() ;
	     int lastCellIndex = player.getCell().getIndex() ;
	     int newCellNumber ;
	     int newCellIndex ;
	     
	     if ((lastCellIndex + diceThrow) > 63) {
	       newCellNumber = 2*63 - (lastCellIndex + diceThrow) ;
	     }
	     else {
	       newCellNumber = lastCellIndex + diceThrow ;
	     }
	     
	     if ((newCellNumber + this.board.getCell(newCellNumber).bounce(diceThrow)) > 63) {
	       newCellIndex = 2*63 - (newCellNumber + this.board.getCell(newCellNumber).bounce(diceThrow)) ;
	     }
	     else{
	       newCellIndex = newCellNumber + this.board.getCell(newCellNumber).bounce(diceThrow);
	     }
	     
	     if (this.canPlay(player)) {
	    	 if ( !(this.board.getCell(newCellIndex).isBusy()) ) {
	    		 if (this.board.getCell(newCellNumber) instanceof GooseCell) {
	    			 System.out.println(player.toString() + " is in " + lastCell + ", " + player.toString() + " throws " + diceThrow + " and reaches " + this.board.getCell(newCellNumber).toString() + newCellIndex);
	    		 }
	    		 else {
	    			 System.out.println(player.toString() + " is in " + lastCell + ", " + player.toString() + " throws " + diceThrow + " and reaches " + this.board.getCell(newCellNumber).toString());
	    		 }
	    	 }
	    	 else {
	    		 if (this.board.getCell(newCellNumber) instanceof GooseCell) {
	    			 System.out.println(player.toString() + " is in " + lastCell + ", " + player.toString() + " throws " + diceThrow + " and reaches " + this.board.getCell(newCellNumber).toString() + newCellIndex + "... this cell is busy, " + this.board.getCell(newCellIndex).getPlayer().toString() + " is sent to " + lastCell);
	    		 }
	    		 else {
	    			 System.out.println(player.toString() + " is in " + lastCell + ", " + player.toString() + " throws " + diceThrow + " and reaches " + this.board.getCell(newCellNumber).toString() + "... this cell is busy, " + this.board.getCell(newCellIndex).getPlayer().toString() + " is sent to " + lastCell);
	    		 }
	    	 }
	     }
	     else {
	    	 System.out.println(player.toString() + " is in " + lastCell + ", " + player.toString() + " cannot play.");
	     }
	  }

}
