import java.util.ArrayList;
import java.util.Scanner;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import cardAssignment.Assignment;

public class Durak {
	private int currentPlayerId, roundStatus, playerNumber;
	private int firstCard = 0;
	private int firstCard2 = 0;
	private int firstPlayer;
	private int j = 0;
	private String Trump;
	private ArrayList<Player> players;
	//private ArrayList<Card> currentTable;
	Table currentTable = new Table();
	private ArrayList<Card> discardPile;
	private Card removeCard, aiPrevCard,attackcard,defendcard;
	private boolean looser,attackcardset,defendcardset;
	private Deck deck;
	
	HBox player1Hand = Main.getPlayer1Hand();
	HBox ai1Hand = Main.getAi1Hand();
	VBox ai2Hand = Main.getAi2Hand();
	VBox ai3Hand = Main.getAi3Hand();
	
	HBox bottomCardTable = Main.getBottomCardTable();
	HBox topCardTable = Main.getTopCardTable();	

	
	Scanner scan = new Scanner(System.in);
	
	public Durak (int playerCount){
		ArrayList<Player> players = new ArrayList<Player>();
		System.out.println(players);
		run(playerCount);
		
		/*Deck deck = new Deck();
		for(int i = 0 ; i < playerCount; i++)
		{
			Player player = new Player(deck);
			System.out.println(player);
			players.add(player);
		}
		System.out.println(players);
		*/
	}
	
	void setDeck(Deck deck)
	{
		this.deck = deck.getDeck();
	}
	Deck getDeck()
	{
		return this.deck;
	}
	
	//Den ersten Angreifer setzen
	void setFirstAttacker(String trmpSuit, ArrayList<Player> players)
	{	
		Card prvCard = null;
		int firstTrump = 0;
		
		//raussuchen wer den niedrigsten Trumpf hat
		for (int plsCount = 0; plsCount < players.size(); plsCount++) {
			System.out.println("SpielerID "+ plsCount + " Hand: " +players.get(plsCount).getHand());
			ArrayList<Card> actualHand = players.get(plsCount).getHand();
			for (int crdCount = 0; crdCount < actualHand.size(); crdCount++) {
				String actlRank = actualHand.get(crdCount).getRank();
				String actlSuit = actualHand.get(crdCount).getSuit();
				Card actlCard = new Card(actlRank, actlSuit);
				
				
				
				if(prvCard==null)
				{
					prvCard = new Card(actlRank, actlSuit);
				}
				
				else if(actualHand.get(crdCount).getSuit().equalsIgnoreCase(trmpSuit) && firstTrump == 0)
				{
					prvCard = actualHand.get(crdCount);
					this.firstPlayer = plsCount;
					firstTrump = 1;
				}
				else if(Assignment.cardValues.get(actlCard.getRank()) < Assignment.cardValues.get(prvCard.getRank()) && actualHand.get(crdCount).getSuit().equalsIgnoreCase(trmpSuit))
				{
					prvCard = actualHand.get(crdCount);
					this.firstPlayer = plsCount;
				}
				
			}
		}
		
		//Testausgabe
		System.out.println(prvCard.getRank() +  "   " + prvCard.getSuit());
		System.out.println("Wert des Firstplayer:");
		System.out.println(firstPlayer);
		System.out.println("SPieler:");
		System.out.println(players.get(firstPlayer).getId());
		System.out.println("vorher:");
		System.out.println(players.get(firstPlayer).getStatusId());
		
		Player tmpPlayer = players.get(firstPlayer);
		
		setAttacker(tmpPlayer);
		System.out.println("nacher:");
		System.out.println(players.get(firstPlayer).getStatusId());
		
		System.out.println("playersize");
		System.out.println(players.size());
		switch(players.size()) {
		case 2:
			setDefender(players.get((this.firstPlayer+1)%2));
			break;
		case 3:
			setDefender(players.get((this.firstPlayer+1)%3));
			break;
		case 4:
			setDefender(players.get((this.firstPlayer+1)%4));
			break;
		}
			
		
			
		
		//	firstPlayer = ((Math.random()*playerCount)+1);
		//setAttacker(firstPlayer);
		//setDefender((firstPlayer+1) % 4);
	}
	

	//Setter und Getter fuer Angreifer und Verteidiger

	void setAttacker(Player player)
	{
		player.setStatusId(1);

	}
	
	int getAttacker(ArrayList<Player> players)
	{
		for (Player player : players)
		{
			if(player.getStatusId() == 1)
			{
				System.out.println(player.getId());
				int playerPosition = players.indexOf(player);
				System.out.println(players.indexOf(player.getId()));
				return playerPosition;
			}
		}
		return 0;
	}
	
	void setDefender(Player player)
	{
		player.setStatusId(2);
	}
	
	int getDefender(ArrayList<Player> players)
	{
		for (Player player : players)
		{
			if(player.getStatusId() == 2)
			{
				int playerPosition = players.indexOf(player);
				return playerPosition;
			}
		}
		return 0;
	}

	//muss ueberarbeitet werden wegen den neuen Set/Get Methoden
	
//	public final void changeCurrentPlayer(ArrayList<Player> players)
//	{
//		if (players. == 1)
//		{
//			setDefender(currentPlayerId);
//		}
//	}
	

// Spiellogik
// Karten vergleichen (aufrufen)

	
	//Setzen der angreifenden Karte
		void placeCardAttacker(Card card)
		{
			
			if(firstCard2 == 0)
			{
			currentTable.addCard(currentTable, card);
			int player = getAttacker(players);
					
					//card.move(x,y);
					players.get(player).removeCard(card);
					//if(players.get(player).getHand().size() == 0){players.get(player).emptyHand = true;}
					firstCard2=+1;
					

			}
			else if(card.getRank().equalsIgnoreCase(currentTable.get(currentTable.size()-1).getRank()) || card.getRank().equalsIgnoreCase(aiPrevCard.getRank()))
			{
				currentTable.add(card);
				int player = getAttacker(players);
				
				
				//card.move(x,y);
				players.get(player).removeCard(card);
				//if(players.get(player).getHand().size() == 0){players.get(player).emptyHand = true;}
				
			}
			else 
			{
				System.out.println("Karte kann nicht gelegt werden ");
				throw new RuntimeException();
			}
			
		}
	
	//setzen der verteidigendenn Karte
	void placeCardDefender(Card card)
	{
		
		int player = 0;
		{
			Card card2 = currentTable.get(currentTable.size()-1);
			if(card2.comparing(card) == 1) //compareTo benutzen!
			{
				
				currentTable.add(card);
				//card.move(x,y);
				player = getDefender(players);
				players.get(player).removeCard(card);
				//if(players.get(player).getHand().size() == 0){players.get(player).emptyHand = true;}


			}
			else if(card2.compareTo(card) == -1)
			{
				System.out.println("You can't defend with this card " + card);
				throw new RuntimeException(); 
			}
		}
	}
		
   //aufnehmen der Karten vom Feld
   void takeCards(int playerID)
   {
	   if(currentTable.size() != 0){
	   for(int i = 0; i < currentTable.size(); i++)
	   {
		   players.get(playerID).addCard(currentTable.get(0));
		   removeCard = currentTable.get(0);
		   currentTable.remove(removeCard);   
	   } 
	   roundStatus = 1;
	   playerChange(players);
	   }
   }
   
   //verwerfen der Karten vom Tisch
   void discardPile()
   {
	   if(currentTable.size() != 0){
	   for(int i = 0; i < currentTable.size(); i++)
	   {
		   discardPile.add(currentTable.get(0));
		   removeCard = currentTable.get(0);
		   currentTable.remove(removeCard);
	   }
	   roundStatus = 2;
	   playerChange(players);
	   }
	   roundStatus = 2;
	   playerChange(players);
   }
   
   //Durchwechseln der Spieler
   void playerChange(ArrayList<Player> players)
   {
	   int attacker, defender;
	   attacker = getAttacker(players);
	   defender = getDefender(players);
	   if(playerNumber == 4)
	   {
		   if(roundStatus == 1)
		   {
			   setAttacker(players.get((attacker+2)%4));
			   setDefender(players.get((defender+2)%4));
		   }
		   else if(roundStatus == 2)
		   {
			   setAttacker(players.get((attacker+1)%4));
			   setDefender(players.get((defender+1)%4));
		   }
	   }
	   else if(playerNumber == 3)
	   {
		   if(roundStatus == 1)
		   {
			   setAttacker(players.get((attacker+2)%3));
			   setDefender(players.get((defender+2)%3));
		   }
		   else if(roundStatus == 2)
		   {
			   setAttacker(players.get((attacker+1)%3));
			   setDefender(players.get((defender+1)%3));
		   }
	   }
	   else if(playerNumber == 2)
	   {
		   if(roundStatus == 1)
		   {
		
		   }
		   else if(roundStatus == 2)
		   {
			   setAttacker(players.get((attacker+1)%2));
			   setDefender(players.get((defender+1)%2));
		   }
	   }
   }
   
	//Ai greift zuerst immer mit der ersten Karte an danach je nach Karten auf dem Spielfeld
	//Gibt die Karte zurÃ¯Â¾Æ’ÃŽÂ´Ã¯Â½Â¼ck mit der die Ai angreift
	Card AiAttackCard(Player AiPlayer, int Id){
		
		
		//Card card = AiPlayer.getHand(AiPlayer.getFirstCard());
		//Card card = AiPlayer.getHand(0);
		//System.out.println("--------------SPIELER GREIFT AN MIT--------------");
		//System.out.println(this.players.get(Id) + " -> Id: " + Id + " ---- " + this.players.get(Id).getHand());
		//System.out.println("-------------------------------------------------");
		//Card card = this.players.get(Id).getHand(0);
		
		
		    // erste Karte wird geleget
			if(firstCard == 0){
			   Card card = this.players.get(getAttacker(players)).getHand(0);
			    aiPrevCard = card;
			    firstCard =+1;
			    System.out.println("--------------SPIELER GREIFT AN MIT--------------");
				System.out.println(this.players.get(Id) + " -> Id: " + Id + " ---- " + this.players.get(Id).getHand(0));
				System.out.println("-------------------------------------------------");
			   return card;
						   
			}
			// Restliche Karten werden gelegt
			else{
				
				for(int i = 0; i < AiPlayer.getHand().size(); i++){
					
				if(aiPrevCard.getRank().equalsIgnoreCase(AiPlayer.getHand(i).getRank()) || (aiPrevCard.getRank().equalsIgnoreCase(currentTable.get(currentTable.size() -1).getRank()))){
					Card card = AiPlayer.getHand(i);
					aiPrevCard = card;
					
					System.out.println("--------------SPIELER GREIFT AN MIT--------------");
					System.out.println(this.players.get(Id) + " -> Id: " + Id + " ---- " + this.players.get(Id).getHand(i));
					System.out.println("-------------------------------------------------");
					return card;
				    }
				else{
					System.out.println("Keine Karten zum Angreifen mehr!");
		
					if(i == AiPlayer.getHand().size()){
					throw new RuntimeException();
					}
				}
				
			}
		}
		return null;
		
		
	 }
	
	 //Ai verteidigt mit der ersten karte mit der es möglich ist 
	 //Gibt die Karte zurÃ¯Â¾Æ’Ã¯Â½Â¼ck mit der die Ai verteidigt
	   Card AiDefendCard(Player AiPlayer, int Id){
		  /// int crdcnt = 0;
		   //Card card = AiPlayer.getHand(0);
		  // System.out.println("--------------SPIELER VERTEIDIGT MIT--------------");
		   //System.out.println(this.players.get(Id) + " -> Id: " + Id + " ---- " + this.players.get(Id).getHand());
		   //System.out.println("--------------------------------------------------");
		   for(int i = 0; i < AiPlayer.getHand().size(); i++){
			       
			   
				   if((aiPrevCard.comparing(AiPlayer.getHand(i)) == 1 && aiPrevCard.getSuit().equalsIgnoreCase(AiPlayer.getHand(i).getSuit())) || (aiPrevCard.checkTrump(Trump, AiPlayer.getHand(i)) == 2) || ((aiPrevCard.checkTrump(Trump, AiPlayer.getHand(i)) == 1) && aiPrevCard.comparing(AiPlayer.getHand(i)) == 1 )){
				   Card  card = AiPlayer.getHand(i);
				   System.out.println("--------------SPIELER VERTEIDIGT MIT--------------");
				   System.out.println(this.players.get(Id) + " -> Id: " + Id + " ---- " + this.players.get(Id).getHand(i));
				   System.out.println("--------------------------------------------------");
				   return card;
				
			   }else{
				   
				  // if(crdcnt == 6){
				   throw new RuntimeException();
				   }
			   }
				   
		   
		   return null;
	   }
   
   //Ueberpruefen wer verliert
	   void checkLooser(){
		   System.out.println("-----Ausgabe J---------");
		   System.out.println("----------"+ j + "---------------");
		   System.out.println("---------------------");
		   
		   System.out.println("---- aktuelle Spielerzahl-------");
		   System.out.println("----------"+ playerNumber+"--------------");
		   System.out.println("---------------------");
		   
		   //Anzahl an Spielern ohne Karten ermitteln
		   for(int i = 0; i < playerNumber; i++){
			   System.out.println(i);
			   if(players.get(i).emptyHand == true){
				   
				   System.out.println("Ausgabe J");
				   System.out.println(j);
				   j = j + 1;
			   }
		   }
		   if(playerNumber >= 3){
		   //Den einzigen Spieler ohne Karten finden und als Winner setzen
		   if(j == 1 || j== 2 ){
			   for(int i = 0; i < playerNumber; i++){
				   if(players.get(i).emptyHand == true && players.get(i).winner == false ){
					   if(players.get(i).getStatusId() == 1){
						  setAttacker(players.get((i+1)%3));
						  setDefender(players.get((i+2)%3));
					   }else if(players.get(i).getStatusId() == 2){
						   setDefender(players.get((i+1)%3));
						   setAttacker(players.get((i+2)%3));
					   }
					   setWinner(players.get(i));
					   players.remove(i);
					   playerNumber =playerNumber-1;
					   break;
				   }
			   }

		   }
		   else{System.out.println("Keinen Gewinner gefunden");}
		   }
		   
		   if(playerNumber <3){
		   //Den einzigen Spieler mit Karten finden und als Looser setzen
		   if(j == playerNumber-1 || j == 2 || j == 1){
			   for(int i = 0; i < playerNumber; i++){
				  if(players.get(i).emptyHand == false){
					   System.out.println(players.get(i).getHand());
					   if(players.get((i+1)%2).emptyHand == false){
						   System.out.println("Beide haben noch Karten");
						   System.out.println("PLAYERSIZE");
						   System.out.println(players.size());
						  // setLooser(players.get(i+1));
						   System.out.println("Hand Spieler");
						   System.out.println(players.get(i+1).getHand());
						   System.out.println("SpielerAnzahl");
						   System.out.println(playerNumber);
						   //looser = true;
						   break;
					   }else{
					   setLooser(players.get(i));
					   looser = true;
					   break;
					   } 
				   }
			   }
		   }
		   else{System.out.println("Keinen Verlierer gefunden");}
		   }
		   
		   //Spieler ohne Karten aus Array Loeschen
		/*   if(playerNumber >= 3){
		   for(int i = 0; i < playerNumber; i++){
			   if(players.get(i).emptyHand == true){
				  if(playerNumber >=3){
				   players.remove(i);
				   playerNumber = playerNumber - 1;
				   break;
			   }
			   }
		   }
		   }*/
		   }
	   
   
   //Ausgabe des Gewinners
   void setWinner(Player winner){
	   System.out.println("Gewonnen hat spieler nummer: " + winner.getId());
	   winner.winner = true;
	   //this.looser = true;
   }
   
   //Ausgabe des Verlierers und neustarten des Spiels
   void setLooser(Player looser){
	   System.out.println("Verloren hat spieler nummer: " + looser.getId());
	   //players.clear();
	   restart();
   }
   
   //neu starten des Spiels
   void restart(){
	   System.out.println("Spiel wird neu gestartet...");
	   //Durak durak = new Durak(3);
	   //Spiel neu starten
   }
   

   //Funktion fuer die Runden
   void round(ArrayList<Player> players,Deck deck) 
   {
	   //players.get(0).fillHand(deck);
	   int cardCounter = 0;
	   System.out.println("Spieler");
	   System.out.println(players);
	   System.out.println(players.get(0));
	   System.out.println(players.get(1));
	   
	   System.out.println("ID Angreifer");
	   System.out.println(getAttacker(players));
	   System.out.println("Angreifer Id");
	   System.out.println(players.get(getAttacker(players)).getId());
	   
	   Player Attacker = players.get(getAttacker(players));
	   
	   System.out.println("ID Verteidiger");
	   System.out.println(getDefender(players));
	   System.out.println("Verteidiger Id");
	   System.out.println(players.get(getDefender(players)).getId());
	   
	   Player Defender = players.get(getDefender(players));
	   if (Attacker.ai == true && Defender.ai == true)
	   {
		   while(roundStatus != 1 || roundStatus !=2 || cardCounter <= 12){
			   try{
					  placeCardAttacker(AiAttackCard(Attacker, Attacker.getId()));
					
				     }
				  catch(RuntimeException e){
					discardPile();
					
					System.out.println("Karten werden abgelegt!");
					break;
				  }
				  // System.out.println(AiAttackCard(Attacker));
				   cardCounter = cardCounter +1;
				  try {
					  placeCardDefender(AiDefendCard(Defender, Defender.getId()));
				  }
				  catch(RuntimeException e){
					  takeCards(getDefender(players));
					  System.out.println("Karten werden aufgenommen!");
					break;
				  }
				  cardCounter = cardCounter +1;
		  // playerChange(players);
		   }
	   }
		   else if(Attacker.ai == false && Defender.ai == true){
			   while(roundStatus != 1 || roundStatus != 2 || cardCounter <=12){
				   Card card = attackcard;
				   placeCardAttacker(card);
				   card = null;
				   cardCounter = cardCounter +1;
				
				   
				   try{
					   	  Scanner scan = new Scanner(System.in);
					   	  int cardPos = scan.nextInt();
						  placeCardAttacker(Attacker.getHand(cardPos));
					     }
					  catch(RuntimeException e){
						discardPile();
						System.out.println("Karten werden abgelegt!");
						break;
					  }
				   
				   
				   try {
						  placeCardDefender(AiDefendCard(Defender,Defender.getId()));
					  }
					  catch(RuntimeException e){
						  takeCards(getDefender(players));
						  System.out.println("Karten werden aufgenommen!");
						break;
					  }
			   }
		   }else if(Attacker.ai == true && Defender.ai == false){
			   while(roundStatus != 1 || roundStatus != 2 || cardCounter <=12){
				   try{
						  placeCardAttacker(AiAttackCard(Attacker, Attacker.getId()));
					     }
					  catch(RuntimeException e){
						discardPile();
						System.out.println("Karten werden abgelegt!");
						break;
					  }
				   
				   try{
					   	  Scanner scan = new Scanner(System.in);
					   	  int cardPos = scan.nextInt();
						  placeCardAttacker(Defender.getHand(cardPos));
					     }
					  catch(RuntimeException e){
						takeCards(getDefender(players));
						System.out.println("Karten werden aufgenommen!");
						break;
					  }
				   
				     cardCounter = cardCounter +1;
					  // System.out.println(AiAttackCard(Attacker));
				    
					   
					   Card card = defendcard;
					   placeCardDefender(card);
					   card = null;
					   cardCounter = cardCounter +1;
			   }
		   }
			   
	   System.out.println("Runde abgeschlossen");
	  
	  
	for(int i =0; i < players.size(); i++){
		if(deck.checkEmptyDeck() == 1){
		 //  System.out.println("------------Hand vorher: ---------------");
		//   System.out.println(players.get(i).getHand());
		   players.get(i).fillHand(deck);
		 //  System.out.println("------------Spieler :---------------");
		  // System.out.println(players.get(i));
		 //  System.out.println("------------Hand nacher:---------------");
		 //  System.out.println(players.get(i).getHand());
		 //  System.out.println("--------------------------------------");
		}
	   }
	   for(int j = 0; j < players.size(); j++){
		   if(players.get(j).getHand().size() == 0){
			   players.get(j).emptyHand = true;
			   
		   }
	   }
	   firstCard  = 0;
	   firstCard2 = 0;
	   }
	   
   
   
   //Starten des Spiels
   void run(int playerCount){
	   
	   Deck deck = new Deck();
	   this.setDeck(deck);
	   Dealer dealer = new Dealer(deck);
	   this.players = new ArrayList<Player>();
	   
	   //evtl statt den If-Abfragen
	   //int firsttime = 1;
	   /*------------------------------------
	    * for(int i = 1; i < playerCount;i++)
	    * { 
	    * 	if(firsttime)
	    * {
	    * 	Player player1 = new Player(deck);
	    * 	firsttime = 0;
	    * }
	    * 	AI Ai = new AI(deck);
	    * }
	    * 
	    */
	   
	   if(playerCount == 4){
		   Player player1 = new Player();
		   AI Ai1 = new AI();
		   AI Ai2 = new AI();
		   AI Ai3 = new AI();
		   
		   this.players.add(player1);
		   player1.ai = false;
		   this.players.add(Ai1.player);
		   this.players.add(Ai2.player);
		   this.players.add(Ai3.player);
			
	   }else if(playerCount == 3){
		   //Player player1 = new Player();
		   //player1.ai = false;
		   AI Ai1 = new AI();
		   AI Ai2 = new AI();
		   AI Ai3 = new AI();
		   

		   //this.players.add(player1);
		   //player1.ai = false;
		   this.players.add(Ai1.player);
		   this.players.add(Ai2.player);
		   this.players.add(Ai3.player);
		   
	   }else if(playerCount == 2){
		   Player player1 = new Player();
		   AI Ai1 = new AI();
		   
		   this.players.add(player1);
		   player1.ai = false;
		   this.players.add(Ai1.player);
		   
	   }else{
		   System.out.println("Zu wenig oder zu viele Spieler!");
	   }
	   
	   playerNumber = playerCount;

	   this.discardPile = new ArrayList<Card>();
	   this.Trump = dealer.dealCards(this.players, deck);
	   this.setFirstAttacker(this.Trump, this.players);

	   
	   System.out.println(this.players);
	   //System.out.println("karten auf hand: " + this.players.get(1).getHand());
	  /* 
	   Card rndmCard = new Card();
	   rndmCard.turn_card();
	   player1Hand.getChildren().add(rndmCard);
	   Card rndmCard2 = new Card();
	   rndmCard2.turn_card();
	   bottomCardTable.getChildren().add(rndmCard2);
	   Card rndmCard3 = new Card();
	   rndmCard3.turn_card();
	   topCardTable.getChildren().add(rndmCard3);
	   */

	   
	   while(looser != true){
		   //System.out.println("HAND: " + this.players.get(0).getHand());
		   //System.out.println("HAND: " + this.players.get(1).getHand());
		   //System.out.println("HAND: " + this.players.get(2).getHand());

		   this.round(this.players,deck);
		   this.checkLooser();
	   } 

   }
   
   //-------------------------MAIN-------------------------------------
   
	public static void main(String[] args) {
		
		Durak durak = new Durak(3);
		/* Notizen Sven
		 * Evtl getter/setter für deck spieler karten usw.
		 */
	}
}