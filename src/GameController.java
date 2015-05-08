import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class GameController {
	
	@FXML
	Button optionButton;
	Button exitButton;
	
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
			Stage stage = (Stage) exitButton.getScene().getWindow();
			stage.close();
	}
}