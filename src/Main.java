import java.util.ArrayList;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToolBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;


public class Main extends Application {
	
	Deck deck = new Deck();
	Dealer dealer = new Dealer(deck);
	Player player1 = new Player(deck);
	Player player2 = new Player(deck);
	ArrayList<Player> players = new ArrayList<Player>();
	Table table = new Table();

	//VIELLEICHT LISTENER FÜR NEUE KARTEN // DENKE ABER NICHT ZWINGEND NOTWENDIG
	private Parent createGui()
	{
		players.add(player1);
		players.add(player2);
		
		
		//Instanziierungen
		AnchorPane root = new AnchorPane();
		ToolBar tBar = new ToolBar();
		ToolBar gameTBar = new ToolBar();
		HBox player1Hand = new HBox();
		Button startButton = new Button("Start");
		Button exitButton = new Button("Exit");
		Button takeFieldCards = new Button("Draw Cards");
		
		
		//Root Fenster settings
		root.getStyleClass().add("background");
		root.getChildren().addAll(tBar, gameTBar, player1Hand);
		
		//Toolbar settings
		tBar.getItems().addAll(startButton, exitButton);
		tBar.getStyleClass().add("toolbar");
		AnchorPane.setTopAnchor(tBar, 0.0);
		AnchorPane.setLeftAnchor(tBar, 0.0);
		AnchorPane.setRightAnchor(tBar, 0.0);
		
		//GameToolbar settings
		gameTBar.getItems().addAll(takeFieldCards);
		gameTBar.getStyleClass().add("toolbar");
		AnchorPane.setTopAnchor(gameTBar, 0.0);
		AnchorPane.setLeftAnchor(gameTBar, 650.0);
		AnchorPane.setRightAnchor(gameTBar, 0.0);

		//TakeCard button überarbeitet prüft nur einmal
		if(table.size() == 0)
		{
			takeFieldCards.setDisable(false);
		}
		else takeFieldCards.setDisable(false);
		
		//Player1Hand settings
		player1Hand.setPadding(new Insets(-50));
		player1Hand.setAlignment(Pos.CENTER);
		player1Hand.setSpacing(-66);
		AnchorPane.setBottomAnchor(player1Hand, 0.0);
		AnchorPane.setLeftAnchor(player1Hand, 100.0);
		AnchorPane.setRightAnchor(player1Hand, 100.0);
		for(int i = 0; i < 6;i++)
		{
		player1.addCard(deck.getCard());
		}

		for(Card cards : player1.getHand())
		{
			cards.turn_card();
			player1Hand.getChildren().add(cards);
		}
		
		// BUTTON FUNKTION
		
		startButton.setOnAction (new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e){
				System.out.println("Spiel startet");
//				Durak durak = new Durak();
//				durak.run();
			}
		});
		
		exitButton.setOnAction(new EventHandler<ActionEvent>()
				{
			@Override public void handle(ActionEvent e)
			{
				Platform.exit();
			}
				});

		takeFieldCards.setOnAction(new EventHandler<ActionEvent>()
				{
			@Override public void handle(ActionEvent e)
			{
				Card card = deck.getCard();
				card.turn_card();
				player1Hand.getChildren().add(card);
			}
				});

		
		return root;
		
	}


	@Override
	public void start(Stage primaryStage) {
		Scene scene = new Scene(createGui());
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.setWidth(800);
		primaryStage.setHeight(600);
		primaryStage.setResizable(false);
		primaryStage.setTitle("Durak");
		primaryStage.show();
	}
	
	public static void main(String[] args) {
		launch(args);
		
		

		
	}
}

