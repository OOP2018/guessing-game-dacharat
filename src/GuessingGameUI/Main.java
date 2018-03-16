package GuessingGameUI;

import java.net.URL;

import game.DacharatGame;
import game.GameConsole;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

	private static DacharatGame game = new DacharatGame(100);
	private static GameController control;
	
	@Override
	public void start(Stage stage) {

//		DacharatGame game = new DacharatGame(100);
//		GameController control;
		
		try {
			URL url = getClass().getResource("GameUI.fxml");
			if (url == null) {
				System.out.println("Couldn't find file: GameUI.fxml");
				Platform.exit();
			}
			FXMLLoader loader = new FXMLLoader(url);
			Parent root = loader.load();

			control = loader.getController();
			control.setGame(game);
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.sizeToScene();
			stage.setTitle("Click Counter");
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
			return;
		}

		GameConsole console = new GameConsole(game);
		game.addObserver(console);

		CountHintView count = new CountHintView(game);
		game.addObserver(count);
		count.run();

		GuessNumberView guess = new GuessNumberView();
		game.addObserver(guess);
		guess.run();

	}

	public static void main(String[] args) {
		launch(args);
	}	

}
