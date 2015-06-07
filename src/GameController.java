

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

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
	private Button optionButton;
	private HBox player1Hand;
	
	@FXML
	protected void buttonPressed(){
		Parent root;
        try {
            root = FXMLLoader.load(getClass().getClassLoader().getResource("GameOptions.fxml"));
            Stage stage = new Stage();
            stage.setTitle("Options");
            stage.setScene(new Scene(root));
            stage.setResizable(false);
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
		System.out.println(player1Hand);
//		HBox player1Hand = new HBox();
//		System.out.println(player1Hand);
		
		
	}
	
	@FXML
	public void retrieveData(ArrayList<Player> players)
	{
		for(Player player : players)
		{
			System.out.println("playerid -- <" + player.getId() + ">");
			switch(player.getId()) 
			{
			case 0:
				for(Card handCard : player.getHand())
				{
					System.out.println(handCard);
//					player1Hand.getChildren().add(handCard);


				}
				break;
			case 1:
				for(Card handCard : player.getHand())
				{
					System.out.println(handCard);
					//HBoxPlayer2Hand.getChildren().add(handCard);
				}
				break;
			/*case 2:
				for(Card handCard : player.getHand())
				{
						System.out.println(handCard);
						//VBoxPlayer3Hand.getChildren().add(handCard);
					}
					break;
			case 3:	
				for(Card handCard : player.getHand())
				{
						System.out.println(handCard);
						//VBoxPlayer4Hand.getChildren().add(handCard);
					}
					break;*/
			}
		}
	}
}