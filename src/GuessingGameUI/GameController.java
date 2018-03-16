package GuessingGameUI;

import java.util.Optional;

import game.DacharatGame;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

/**
 * The Guessing Game GUI.
 * 
 * @author Dacharat Pankong
 *
 */
public class GameController {

	@FXML
	Label startLebel;
	@FXML
	Label hintLabel;
	@FXML
	TextField guessText;
	@FXML
	Button guessButton;
	@FXML
	Button giveUpButton;

	public DacharatGame game;
	private boolean isEnd = false;

	/**
	 * Set a reference to game.
	 * 
	 * @param game
	 *            the game to display.
	 */
	public void setGame(DacharatGame game) {
		this.game = game;
	}

	/**
	 * Check that game is end or not.
	 * 
	 * @return true if game is end(guess = secret). false if otherwise.
	 */
	public boolean isEnd() {
		return isEnd;
	}

	/**
	 * Guess number from input and return if with hint that it equal secret or not.
	 * Special : if it end game you can choose to exit program or play again.
	 * 
	 * @param event
	 */
	public void guessNumberHandler(ActionEvent event) {
		String guess = guessText.getText().trim();
		try {
			int guessNum = Integer.parseInt(guess);
			isEnd = game.guess(guessNum);
			hintLabel.setText(game.getMessage());
			hintLabel.setStyle("-fx-text-fill: black");
			if (isEnd) {
				gameEndHandler(event);
			}
		} catch (NumberFormatException e) {
			hintLabel.setText("Please enter number!!");
			hintLabel.setStyle("-fx-text-fill: red");

		}
		guessText.clear();
	}

	/**
	 * Alert window will ask you to close this program or play again.
	 * 
	 * @param event
	 */
	public void gameEndHandler(ActionEvent event) {

		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Confirmation Dialog");
		alert.setHeaderText("Secret number is : " + game.getSecret());
		alert.setContentText("Do you want to play again?");

		ButtonType play = new ButtonType("Play again");
		ButtonType exit = new ButtonType("Exit", ButtonData.CANCEL_CLOSE);

		alert.getButtonTypes().setAll(play, exit);

		Optional<ButtonType> result = alert.showAndWait();
		if (result.get() == play) {
			game.restart();
		} else {
			Platform.exit();
		}
	}

	/**
	 * Give up this game it will show you the secret and ask you to play again.
	 * 
	 * @param event
	 */
	public void giveUpHandler(ActionEvent event) {

		game.guess(game.getSecret());
		gameEndHandler(event);
	}

}
