package GuessingGameUI;

import game.DacharatGame;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class GameController {

	@FXML
	Label startLebel;
	@FXML
	Label hintLabel;
	@FXML
	TextField guessText;
	@FXML
	Button guessButton;
	
	public DacharatGame game;
	private static int guess;
	
	public void setGame(DacharatGame game) {
		this.game = game;
	}
	
	public void guessNumberHandler(ActionEvent event) {
		String guess = guessText.getText().trim();
		try {
			int guessNum = Integer.parseInt(guess);
			game.guess(guessNum);
			hintLabel.setText(game.getMessage());
			hintLabel.setStyle("-fx-text-fill: black");
		}catch(NumberFormatException e) {
			hintLabel.setText("Please enter number!!");
			hintLabel.setStyle("-fx-text-fill: red");
		}

	}
	
	public static int getGuess() {
		return guess;
	}
}
