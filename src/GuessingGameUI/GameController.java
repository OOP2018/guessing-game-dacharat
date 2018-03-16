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
	private static int guess;
	private boolean isEnd = false;

	public void setGame(DacharatGame game) {
		this.game = game;
	}

	public boolean isEnd() {
		return isEnd;
	}

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
	
	public void giveUpHandler(ActionEvent event) {
		
		game.guess(game.getSecret());
		gameEndHandler(event);
	}

	public static int getGuess() {
		return guess;
	}
}
