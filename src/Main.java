import javafx.application.Application;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToolBar;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;


public class Main extends Application {
	 /*
	Deck deck = new Deck();
	Dealer dealer = new Dealer(deck);
	Player player1 = new Player();
	Player player2 = new Player();
	ArrayList<Player> players = new ArrayList<Player>();
	Table table = new Table();
	*/
	
	Durak durak = new Durak();
	
	static HBox player1Hand = new HBox();
	static HBox ai1Hand = new HBox();
	static VBox ai2Hand = new VBox();
	static VBox ai3Hand = new VBox();
	static HBox bottomCardTable = new HBox();
	static HBox topCardTable = new HBox();
	static Button takeFieldCards = new Button("Take Cards");
	static int clickCounter = 0;

	
	static HBox getPlayer1Hand()
	{
		return player1Hand;
	}
	public void setPlayer1Hand(HBox player1Hand) {
		Main.player1Hand = player1Hand;
	}

	public static HBox getAi1Hand() {
		return ai1Hand;
	}
	public static void setAi1Hand(HBox ai1Hand) {
		Main.ai1Hand = ai1Hand;
	}
	public static VBox getAi2Hand() {
		return ai2Hand;
	}
	public static void setAi2Hand(VBox ai2Hand) {
		Main.ai2Hand = ai2Hand;
	}
	public static VBox getAi3Hand() {
		return ai3Hand;
	}
	public static void setAi3Hand(VBox ai3Hand) {
		Main.ai3Hand = ai3Hand;
	}
	public static HBox getBottomCardTable() {
		return bottomCardTable;
	}
	public static void setBottomCardTable(HBox bottomCardTable) {
		Main.bottomCardTable = bottomCardTable;
	}
	public static HBox getTopCardTable() {
		return topCardTable;
	}
	public static void setTopCardTable(HBox topCardTable) {
		Main.topCardTable = topCardTable;
	}
	
	//VIELLEICHT LISTENER FÜR NEUE KARTEN // DENKE ABER NICHT ZWINGEND NOTWENDIG
	private Parent createGui()
	{
		Stage optionStage;
		
		//players.add(player1);
		//players.add(player2);
		
		
		//Instanziierungen
		AnchorPane root = new AnchorPane();
		BorderPane gameField = new BorderPane();
		ToolBar tBar = new ToolBar();
		ToolBar gameTBar = new ToolBar();
		System.out.println(player1Hand);
		Button startButton = new Button("Start");
		Button exitButton = new Button("Exit");
		
		//Instanziierung 2. Stage für die Abfrage der Spieler anzahl
		AnchorPane pane = new AnchorPane();
		pane.getStyleClass().add("pane");
		Button acceptButton = new Button("Akzeptieren");
		AnchorPane.setTopAnchor(acceptButton, 65.0);
		AnchorPane.setLeftAnchor(acceptButton, 50.0);
		AnchorPane.setRightAnchor(acceptButton, 0.0);
		TextField playerCount = new TextField();
		AnchorPane.setTopAnchor(playerCount, 25.0);
		AnchorPane.setLeftAnchor(playerCount, 0.0);
		AnchorPane.setRightAnchor(playerCount, 0.0);
		Label playerLabel = new Label("Spieleranzahl: (2-4 Spieler)");
		Scene scene2 = new Scene(pane, 200, 100);
		scene2.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		pane.getChildren().addAll(playerLabel, playerCount, acceptButton);
		optionStage = new Stage();
		optionStage.setScene(scene2);
		optionStage.setResizable(false);
		optionStage.initModality(Modality.APPLICATION_MODAL);
		
		
		//Root Fenster settings
		root.getStyleClass().add("background");
		root.getChildren().addAll(gameField, tBar, gameTBar, bottomCardTable, topCardTable);
		
		//BorderPane settingsa
		gameField.getStyleClass().add("background");
		gameField.setPrefSize(800, 600);
		gameField.setTop(ai1Hand);
		gameField.setBottom(player1Hand);
		gameField.setLeft(ai2Hand);
		gameField.setRight(ai3Hand);
		AnchorPane.setTopAnchor(gameField, 0.0);
		

		
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
		/*if(table.size() == 0)
		{
			takeFieldCards.setDisable(false);
		}
		else takeFieldCards.setDisable(false);
		*/
		
		//Player1Hand setting
		player1Hand.setPadding(new Insets(-50));
		player1Hand.setAlignment(Pos.CENTER);
		player1Hand.setSpacing(-66);

		
		//Ai1Hand setting
		ai1Hand.setPadding(new Insets(-50));
		ai1Hand.setAlignment(Pos.CENTER);
		ai1Hand.setSpacing(-66);

		
		//Ai2Hand setting
		ai2Hand.setPadding(new Insets(-50));
		ai2Hand.setAlignment(Pos.CENTER);
		ai2Hand.setSpacing(-110);

		
		//Ai3Hand setting
		ai3Hand.setPadding(new Insets(-50));
		ai3Hand.setAlignment(Pos.CENTER);
		ai3Hand.setSpacing(-110);

		
		// bottomCardTable
		//bottomCardTable.setPadding(new Insets(-50));
		bottomCardTable.setAlignment(Pos.CENTER_LEFT);
		bottomCardTable.setSpacing(30);
		AnchorPane.setTopAnchor(bottomCardTable, 200.0);
		AnchorPane.setLeftAnchor(bottomCardTable, 220.0);
		AnchorPane.setRightAnchor(bottomCardTable, 300.0);

		// topCardTable
		topCardTable.setAlignment(Pos.CENTER_LEFT);
		topCardTable.setSpacing(30);
		AnchorPane.setTopAnchor(topCardTable, 210.0);
		AnchorPane.setLeftAnchor(topCardTable, 240.0);
		AnchorPane.setRightAnchor(topCardTable, 300.0);

		
		
		//nur zur überprüfung ob karten angezeigt werden
		/*for(int i = 0; i < 6;i++)
		{
		player1.addCard(deck.getCard());
		}

		for(Card cards : player1.getHand())
		{
			cards.turn_card();
			player1Hand.getChildren().add(cards);
		}
		*/
		
		
		// BUTTON FUNKTION
		
		//Akzeptieren der Spieleranzahl und Durak starten
		acceptButton.setOnAction(new EventHandler<ActionEvent>()
				{
			@Override public void handle(ActionEvent e)
			{
				String text = playerCount.getText();
				if(text.matches("[2-4]"))
				{
					System.out.println(playerCount.getText());
					//Durak durak = new Durak(Integer.parseInt(playerCount.getText()));
					durak.run(Integer.parseInt(playerCount.getText()));
					optionStage.close();
					//Durak durak = new Durak(Integer.parseInt(playerCount.getText()));
					//durak.run(Integer.parseInt(playerCount.getText()));
				}
				else
				{
					Stage errorStage = new Stage();
					Label playerLabel = new Label("Ungültige Eingabe");
					Scene errorScene = new Scene(playerLabel);
					errorStage.initModality(Modality.WINDOW_MODAL);
					errorStage.setScene(errorScene);
					errorStage.show();
				}
			}
				});
		
		//Weiterleitung zu Abfrage der Spieleranzahl
		startButton.setOnAction (new EventHandler<ActionEvent>() {
			@Override public void handle(ActionEvent e){
				System.out.println("Spiel startet");
				optionStage.showAndWait();
				
//				Durak durak = new Durak();
//				durak.run();
			}
		});
		
		//Schließen der Anwendung
		exitButton.setOnAction(new EventHandler<ActionEvent>()
				{
			@Override public void handle(ActionEvent e)
			{
				Platform.exit();
			}
				});

		//nehmen der Karten vom Table // momentan umgeschrieben zum karten ziehen zum testen
		
		takeFieldCards.setOnAction(new EventHandler<ActionEvent>()
				{
			@Override public void handle(ActionEvent e)
			{
				durak.takeCards(0);
				durak.clearCardTable();
				durak.updateHand();
			}
				});
				

		
		return root;
		
	}

/*	private void createGame(Durak durak)
	{
		player1Hand.getChildren().add(durak.getDeck().getCard());
	}
	*/

	//starten des Fensters
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

