package GuessingGameUI;

import java.util.Observable;

import game.DacharatGame;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class CountHintView implements java.util.Observer{

	private Stage stage;
	private DacharatGame game;
	private Label label;

	public CountHintView(DacharatGame game) {
		this.game = game;
		initComponents();
	}

	private void initComponents() {
		stage = new Stage();
		HBox root = new HBox();
		root.setPadding(new Insets(10));
		root.setAlignment(Pos.CENTER);
		label = new Label("   ");
		label.setPrefWidth(144);
		label.setFont(new Font("Arial", 80.0));
		label.setAlignment(Pos.CENTER);
		root.getChildren().add(label);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.setTitle("Count Guest");
		stage.sizeToScene();
	}
	
	public void run() {
		stage.show();
		displayCount();
	}

	private void displayCount() {
		label.setText( String.format("%2d", game.getCount()) );
	}

	@Override
	public void update(Observable o, Object arg) {
		displayCount();
	}
}
