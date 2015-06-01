import java.util.ArrayList;

import cardImages.ImageStorage;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Group row_of_cards = new Group();
			Card card = new Card();
			row_of_cards.getChildren().add(card);
			
			Deck deck = new Deck();
			Dealer dealer = new Dealer(deck);
			Player player1 = new Player(deck);
			ArrayList<Player> players = new ArrayList<Player>();
			players.add(player1);
			dealer.dealCards(players, deck);
			
			HBox handGUI = new HBox();
			for(Card cards : player1.getHand())
			{
				System.out.println("-------------");
				System.out.println(cards);
				ImageView iv = new ImageView(cards.card_faceup_image);
				handGUI.getChildren().add(iv);	
			}
			
			Image card_image ;

			Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			
			HBox sp = new HBox();
			
			//Test der turn-Funktion
			//Speichert am anfang die Karte setzt danach null
			/*
			Button button = new Button("Turn");
			button.setOnAction (new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e){
					card.turn_card();
				}
			});
			
			sp.getChildren().add(button);
			*/
			
			card_image = ImageStorage.getInstance().get("hearts" + 8);
		    ImageView imgView = new ImageView(card_image);
		    sp.getChildren().add(row_of_cards);
		    Scene scene2 = new Scene(sp);
		    Scene scene3 = new Scene(handGUI);
		    
			primaryStage.setScene(scene2);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

