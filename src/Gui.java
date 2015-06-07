import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;


public class Gui extends Application{
	
	HBox hboxhand = new HBox();

	public Gui()
	{
	}
	public void hboxfill(Card card)
	{
		hboxhand.getChildren().add(card);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try{
			AnchorPane ap = new AnchorPane();
			System.out.println("HBOX");
			System.out.println("HBOX ENDE");
			ap.getChildren().add(hboxhand);
			Scene scene = new Scene(ap);
			primaryStage.setScene(scene);
			primaryStage.show();
		}
		catch(Exception e){
			e.printStackTrace();
		}

		
	}

}
