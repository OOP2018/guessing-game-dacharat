import java.util.Scanner;

/**
 * Play guessing game on the console.
 */
public class GameConsole {

	/** play the game. */
	/**
	 * The play method plays a game using input from a user.
	 * 
	 * @param game
	 * @return true when you win the game.
	 */
	public int play(NumberGame game) {
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

}
