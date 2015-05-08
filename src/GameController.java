import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameController {
	
	@FXML
	Button buttonOptions;
	
	@FXML
	protected void buttonPressed(){
		Stage stage = new Stage();
		stage.setScene(new Scene(new Group(new Text(10,10, "my second window"))));
		stage.show();

	}
}
