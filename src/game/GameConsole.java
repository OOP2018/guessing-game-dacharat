package game;
import java.util.Observable;
import java.util.Scanner;

/**
 * Play guessing game on the console.
 */
public class GameConsole implements java.util.Observer{
	
	DacharatGame game;
	
	public GameConsole(DacharatGame game) {
		this.game = game;
	}

	/** play the game. */
	/**
	 * The play method plays a game using input from a user.
	 * 
	 * @param game
	 * @return true when you win the game.
	 */
	public int play() {
		boolean correct = false;
		int guess = 0;
		Scanner console = new Scanner(System.in);

		// describe the game
		System.out.println(game.toString());

		// This is just an example.
		System.out.println(game.getMessage());
		while (correct == false) {
			System.out.print("Your answer? ");
			guess = console.nextInt();
			correct = game.guess(guess);
			System.out.println(game.getMessage());
		}
		return guess;
	}

	@Override
	public void update(Observable o, Object arg) {
		System.out.println("You guess " + game.getCount() + " times.");
	}

}
