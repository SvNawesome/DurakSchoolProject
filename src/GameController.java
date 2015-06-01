

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import cardImages.ImageStorage;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class GameController implements Initializable{
	
	@FXML
	Button optionButton;
	Button exitButton;
	HBox HBoxPlayer1Hand;
	
	@FXML
	protected void buttonPressed(){
		Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("GameOptions.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Options");
            stage.setScene(new Scene(root, 450, 450));
            stage.show();
        } catch (IOException e) {
        	e.printStackTrace();
        }
	}
	@FXML
	protected void exitButtonPressed(){
		Platform.exit();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		System.out.println("GELADEN");
		
		
	}
}