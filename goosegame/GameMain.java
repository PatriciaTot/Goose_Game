package goosegame;
import goosegame.board.ClassicalBoard;

public class GameMain {
	
	public static void main(String[] args) {
		
		Game game = new Game(new ClassicalBoard()) ;
		
		/* Either you can write the names of the players directly in the shell
		 
	    for (int i=0; i < args.length; i++) {
	       game.addPlayer(new Player(args[i])) ;
	     }
	     game.play();
	    */
		
		/* Or you create your player */
		
		Player firstPlayer = new Player("Patricia") ;
		Player secondPlayer = new Player("Elsa") ;
		Player thirdPlayer = new Player("Marc") ;
		
		game.addPlayer(firstPlayer) ;
		game.addPlayer(secondPlayer) ;
		game.addPlayer(thirdPlayer) ;
		game.play();
	}
}
