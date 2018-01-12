//import java.util.Scanner;

/**
 * Autometically find the secret to any NumberGame.
 * 
 * @author Dacharat Pankong
 *
 */
public class GameSolver {

	/**
	 * Play a NumberGame and return the solution. The NumberGame object must
	 * provide message (getMessage) containing the phrase "too small" if a guess
	 * is too small and "too large" if a guess is too large, for efficient
	 * solution.
	 * 
	 * @param game
	 *            is the NumberGame to solve
	 * @return
	 */
	public int play(NumberGame game) {
		boolean correct = false;
		int guess = game.getUpperBound() / 2;
		int time = 2;
		String answer = "";
		// describe the game
		System.out.println(game.toString());
		// This is just an example.
		System.out.println(game.getMessage());

		while (correct == false) {
			System.out.print("Your answer? ");
			System.out.println(guess);
			correct = game.guess(guess);
			answer = game.getMessage();
			System.out.println(answer);
			if (answer == "Too small!!") {
				guess = guess + (50 / time);
			} else if (answer == "Too large!!") {
				guess = guess - (50 / time);
			}
			if (50 / time > 1) {
				time *= 2;
			}
		}

		return guess;
	}
}
