import java.util.ArrayList;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
	
	@Override
	public void start(Stage primaryStage) {
		try {			
			//-----------------------------------------------------------
			//Hbox mit mehreren karten funzt //alle aufgedeckt
			Deck deck = new Deck();
			Dealer dealer = new Dealer(deck);
			Player player1 = new Player(deck);
			Player player2 = new Player(deck);
			ArrayList<Player> players = new ArrayList<Player>();
			players.add(player1);
			players.add(player2);
			dealer.dealCards(players, deck);
			
			
			//-----------------------------------------------------------
			
			
			//-----------------------------------------------------------
			//Test der turn-Funktion	
			BorderPane borderPane = new BorderPane();
			
			HBox hb0 = new HBox();
			hb0.setAlignment(Pos.TOP_CENTER);
			hb0.setPadding(new Insets(1));
			hb0.setSpacing(0);
			HBox hb1 = new HBox();
			hb1.setAlignment(Pos.CENTER);
			hb1.setPadding(new Insets(1));
			hb1.setSpacing(-66);
			HBox hb2 = new HBox();
			hb2.setAlignment(Pos.BOTTOM_CENTER);
			hb2.setPadding(new Insets(1));
			hb2.setSpacing(-66);
			
			Button turnhand1 = new Button("Turn Hand 1");
			Button turnhand2 = new Button("Turn Hand 2");
			Button button2 = new Button("Draw");
			
			// geht nicht -> ObservableList<Card> oCard = FXCollections.observableArrayList(player1.getHand());
			
			turnhand1.setOnAction (new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e){
					for(Card card : player1.getHand())
					{
						card.turn_card();
					}
				}
			});
			
			turnhand2.setOnAction (new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e){
					for(Card card : player2.getHand())
					{
						card.turn_card();
					}
				}
			});
			button2.setOnAction (new EventHandler<ActionEvent>() {
				@Override public void handle(ActionEvent e){
					if(deck.checkEmptyDeck() != 0)
					{
						hb1.getChildren().add(player1.addCard(deck.getCard()));
						hb2.getChildren().add(player2.addCard(deck.getCard()));
					}
					else System.out.println("error");
				}
			});
			
			hb0.getChildren().addAll(turnhand1, turnhand2, button2);
			
			for(Card handCard : player1.getHand())
			{
				hb1.getChildren().add(handCard);
			}
			
			for(Card handCard : player2.getHand())
			{
				hb2.getChildren().add(handCard);
			}
			
			borderPane.setCenter(hb1);
			borderPane.setBottom(hb2);
			borderPane.setTop(hb0);
			
		    //Hbox einzelne karte
		    Scene scene2 = new Scene(borderPane);
		    
		  //-----------------------------------------------------------

			Parent root = FXMLLoader.load(getClass().getResource("Game.fxml"));
			Scene scene = new Scene(root,800,600);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		    
			primaryStage.setScene(scene2);
			primaryStage.setResizable(true);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}

