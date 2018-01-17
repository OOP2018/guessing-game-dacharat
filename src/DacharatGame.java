import java.util.Random;

/**
 * Game of guessing a secret number.
 * 
 * @author Dacharat Pankong
 *
 */
public class DacharatGame extends NumberGame {
	private int upperBound;
	private int secret;

	/**
	 * Initialize a new game.
	 * 
	 * @param upperBound
	 *            is the max value for the secret number (>1).
	 */
	public DacharatGame(int upperBound) {
		this.upperBound = upperBound;
		long seed = System.nanoTime();
		Random rand = new Random(seed);
		secret = rand.nextInt(upperBound) + 1;
//		System.out.println(secret);
	}

	/**
	 * This method use to check that your input number is correct or not.
	 * 
	 * @param number
	 * @return true if number is equal secret.
	 * 		 false if number is not equal
	 *         secret.
	 */
	@Override
	public boolean guess(int number) {
		count++;
		if (number == secret) {
			setMessage("Correct!!");
			return true;
		} else if (number < secret) {
			setMessage("Too small!!");
			return false;
		} else if (number > secret) {
			setMessage("Too large!!");
			return false;
		}
		return false;
	}

	/**
	 * Return upperbound
	 * 
	 * @return upperBound
	 */
	public int getUpperBound() {
		return upperBound;
	}

	@Override
	public int getCount() {
		return count;
	}
	
	/**
	 * return range of number that you can guess.
	 * 
	 * @return Range of number that you can guess.
	 */
	@Override
	public String toString() {
		return "Guess a secret number between 1 and " + upperBound;
	}

}
