package game;

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
	private long seed = System.nanoTime();
	private Random rand = new Random(seed);

	/**
	 * Initialize a new game.
	 * 
	 * @param upperBound
	 *            is the max value for the secret number (>1).
	 */
	public DacharatGame(int upperBound) {
		this.upperBound = upperBound;
//		long seed = System.nanoTime();
//		Random rand = new Random(seed);
		secret = rand.nextInt(upperBound) + 1;
//		System.out.println(secret);
	}

	/**
	 * This method use to check that your input number is correct or not.
	 * 
	 * @param number
	 * @return true if number is equal secret. false if number is not equal secret.
	 */
	@Override
	public boolean guess(int number) {
		count++;
		if (number == secret) {
			setMessage("Correct!!");
			this.setChanged();
			this.notifyObservers(number);
			return true;
		} else {
			if (number < secret) {
				setMessage("Too small!!");
			} else if (number > secret) {
				setMessage("Too large!!");
			}
			this.setChanged();
			this.notifyObservers(number);
			return false;
		}
	}

	/**
	 * Return upperbound
	 * 
	 * @return upperBound
	 */
	public int getUpperBound() {
		return upperBound;
	}

	/**
	 * Return count that is number of guess you use.
	 */
	@Override
	public int getCount() {
		return count;
	}
	
	/**
	 * Restart this game.
	 */
	public void restart() {
		secret = rand.nextInt(upperBound) + 1;
//		System.out.println(secret);
		count = 0;
		this.setChanged();
		this.notifyObservers();
	}
	
	/**
	 * Return secret number of this game.
	 * 
	 * @return secret number of this game.
	 */
	public int getSecret() {
		return secret;
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
