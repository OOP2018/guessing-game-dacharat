/**
 * A main class for the GuessingGame.
 * It is responsible for creating objects, 
 * connecting objects, and running the game UI.
 */
public class Main {
	public static void main(String[] args) {
		// upper limit for secret number in guessing game
		int upperBound = 100;
		DacharatGame game = new DacharatGame(upperBound);
//		GameConsole ui = new GameConsole( );
		GameSolver g = new GameSolver();
//		int solution = ui.play( game );
		g.play(game);
		//TODO display the answer returned by play
//		System.out.println("play() returned "+solution);
		System.out.println("You use "+game.getCount()+" times");
		//TODO display how many guesses the user made
	}
}
