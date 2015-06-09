import java.util.ArrayList;

import cardAssignment.Assignment;

public class Durak {
	private int currentPlayerId, roundStatus, playerNumber,firstPlayer;
	private int firstCard = 0;
	private String Trump;
	private ArrayList<Player> players;
	//private ArrayList<Card> currentTable;
	Table currentTable = new Table();
	private ArrayList<Card> discardPile;
	private Card removeCard, aiPrevCard,attackcard,defendcard;
	private boolean loser,attackcardset,defendcardset;
	
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
	
	
	//Den ersten Angreifer setzen
	void setFirstAttacker(String trmpSuit, ArrayList<Player> players)
	{	
		Card prvCard = null;
		
		//raussuchen wer den niedrigsten Trump hat
		for (int plsCount = 0; plsCount < players.size(); plsCount++) {
			System.out.println(players.get(plsCount).getHand());
			ArrayList<Card> actualHand = players.get(plsCount).getHand();
			for (int crdCount = 0; crdCount < actualHand.size(); crdCount++) {
				String actlRank = actualHand.get(crdCount).getRank();
				String actlSuit = actualHand.get(crdCount).getSuit();
				Card actlCard = new Card(actlRank, actlSuit);
				
				if(prvCard==null)
				{
					prvCard = new Card(actlRank, actlSuit);
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
		setDefender(players.get((this.firstPlayer+1)%3));
		
			
		
		//	firstPlayer = ((Math.random()*playerCount)+1);
		//setAttacker(firstPlayer);
		//setDefender((firstPlayer+1) % 4);
	}
	
	//Setter und Getter für Angreifer und Verteidiger
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
				return player.getId();
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
				return player.getId();
			}
		}
		return 0;
	}
	
	//muss Ã¼berarbeitet werden wegen den neuen Set/Get Methoden
	
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
		int currentCard = 0;
		if(firstCard == 0)
		{
		currentTable.addCard(currentTable, card);
		int player = getAttacker(players);
				
				//card.move(x,y);
				players.get(player).removeCard(card);
				if(players.get(player).getHand().size() == 0){players.get(player).emptyHand = true;}
				firstCard=+1;
				

		}
		else if(card.getRank().equalsIgnoreCase(currentTable.get(currentCard).getRank()))
		{
			currentTable.add(card);
			int player = getAttacker(players);
			
			
			//card.move(x,y);
			players.get(player).removeCard(card);
			if(players.get(player).getHand().size() == 0){players.get(player).emptyHand = true;}
			currentCard =+2;
		}
		else 
		{
			System.out.println("Karte kann nicht gelegt werden ");
		}
		
	}
	
	//setzen der verteidigendenn Karte
	void placeCardDefender(Card card)
	{
		
		int player = 0;
		{
			Card card2 = currentTable.get(currentTable.size()-1);
			if(card.compareTo(card2) == 1) //compareTo benutzen!
			{
				
				currentTable.add(card);
				//card.move(x,y);
				player = getDefender(players);
				players.get(player).removeCard(card);
				if(players.get(player).getHand().size() == 0){players.get(player).emptyHand = true;}


			}
			else if(card.compareTo(card2) == -1)
			{
				System.out.println("You can't defend with this card " + card2);
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
	   firstCard = 0;
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
	   firstCard = 0;
	   playerChange(players);
	   }
	   firstCard = 0;
	   playerChange(players);
   }
   
   /*void placeCardAttackerKI()
	{
		int currentCard = 0;
		int firstCard = 0;
		if(firstCard == 0)
		{
			if()
		currentTable.add(card);
		int player = 0;
				for (int plsCount = 0; plsCount < players.size(); plsCount++)
				{
					ArrayList<Card> actualHand = players.get(plsCount).getHand();
					for (int crdCount = 0; crdCount < actualHand.size(); crdCount++)
					{
						if(card == actualHand.get(crdCount))
						{
							player = plsCount;
						}

					}
				}
				//card.move(x,y);
				players.get(player).removeCard(card);
				currentCard = 0;

		}
		else if(card.getSuit().equalsIgnoreCase(currentTable.get(currentCard).getSuit()) || card.getRank().equalsIgnoreCase(currentTable.get(currentCard).getRank()))
		{
			currentTable.add(card);
			int player = 0;
			for (int plsCount = 0; plsCount < players.size(); plsCount++)
			{
				ArrayList<Card> actualHand = players.get(plsCount).getHand();
				for (int crdCount = 0; crdCount < actualHand.size(); crdCount++)
				{
					if(card == actualHand.get(crdCount))
					{
						player = plsCount;
					}

				}
			}
			//card.move(x,y);
			players.get(player).removeCard(card);
			currentCard =+2;
		}
		else 
		{
			System.out.println("Karte kann nicht gelegt werden ");
		}
	}*/
   
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
			   while(players.get(getAttacker(players)).winner == true){
			   	setAttacker(players.get((attacker+1)%4));
			   }
			   setDefender(players.get((defender+2)%4));
			   while(players.get(getDefender(players)).emptyHand == true){
			   	setDefender(players.get((defender+1)%4));
			   }
		   }
		   else if(roundStatus == 2)
		   {
			   setAttacker(players.get((attacker+1)%4));
			   while(players.get(getAttacker(players)).winner == true){
			   	setAttacker(players.get((attacker+1)%4));
			   }
			   setDefender(players.get((defender+1)%4));
			   while(players.get(getDefender(players)).emptyHand == true){
			   	setDefender(players.get((defender+1)%4));
			   }
		   }
	   }
	   else if(playerNumber == 3)
	   {
		   if(roundStatus == 1)
		   {
			   setAttacker(players.get((attacker+2)%3));
			   while(players.get(getAttacker(players)).winner == true){
			   	setAttacker(players.get((attacker+1)%4));
			   }
			   setDefender(players.get((defender+2)%3));
			   while(players.get(getDefender(players)).emptyHand == true){
			   	setDefender(players.get((defender+1)%4));
			   }
		   }
		   else if(roundStatus == 2)
		   {
			   setAttacker(players.get((attacker+1)%3));
			   while(players.get(getAttacker(players)).winner == true){
			   	setAttacker(players.get((attacker+1)%4));
			   }
			   setDefender(players.get((defender+1)%3));
			   while(players.get(getDefender(players)).emptyHand == true){
			   	setDefender(players.get((defender+1)%4));
			   }
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
   
	//Ai greift immer mit der stärksten Karte an
	//Gibt die Karte zurück mit der die Ai angreift
	Card AiAttackCard(Player AiPlayer, int Id){
		
		
		//Card card = AiPlayer.getHand(AiPlayer.getFirstCard());
		//Card card = AiPlayer.getHand(0);
		System.out.println("--------------SPIELER GREIFT AN MIT--------------");
		System.out.println(this.players.get(Id) + " -> Id: " + Id + " ---- " + this.players.get(Id).getHand());
		System.out.println("-------------------------------------------------");
		Card card = this.players.get(getAttacker(players)).getHand(0);
		//Card card = this.players.get(Id).getHand(0);
		
		for(int i = 0; i < AiPlayer.getHand().size(); i++){
			if(aiPrevCard == null){
			    if(card.compareTo(AiPlayer.getHand(i)) == 1){
			    card = AiPlayer.getHand(i);
			    aiPrevCard = card;
				}		   
			}
			else{
				if(aiPrevCard.getSuit().equalsIgnoreCase(AiPlayer.getHand(i).getSuit())){
					card = AiPlayer.getHand(i);
					aiPrevCard = card;
				    }
			}
		}
		return card;
	 }
	
	 //Ai verteidigt immer mit der st�rksten Karte
	 //Gibt die Karte zur�ck mit der die Ai verteidigt
	   Card AiDefendCard(Player AiPlayer, int Id){

		   Card card = AiPlayer.getHand(0);
		   System.out.println("--------------SPIELER VERTEIDIGT MIT--------------");
		   System.out.println(this.players.get(Id) + " -> Id: " + Id + " ---- " + this.players.get(Id).getHand());
		   System.out.println("--------------------------------------------------");
		   for(int i = 0; i < AiPlayer.getHand().size(); i++){
			   
				   if(card.compareTo(AiPlayer.getHand(i)) == 1){
				   card = AiPlayer.getHand(i);
				
			   }
		   }
		   return card;
	   }
   
   //Ueberpruefen wer verliert
   void checkLooser(){
	   int j = 0;
	   
	   //Anzahl an Spielern ohne Karten ermitteln
	   for(int i = 0; i < playerNumber; i++){
		   System.out.println(i);
		   if(players.get(i).emptyHand == true){
			   j++;
			   System.out.println("Ausgabe J");
			   System.out.println(j);
		   }
	   }
	   
	   //Den einzigen Spieler ohne Karten finden und als Winner setzen
	   if(j == 1){
		   for(int i = 0; i < playerNumber; i++){
			   if(players.get(i).emptyHand == true && players.get(i).winner == false ){
				   setWinner(players.get(i));
			   }
		   }

	   }
	   else{System.out.println("Keinen Gewinner gefunden");}
	   
	   //Den einzigen Spieler mit Karten finden und als Looser setzen
	   if(j == playerNumber-1){
		   for(int i = 0; i < playerNumber; i++){
			   if(players.get(i).emptyHand == false){
				   setLooser(players.get(i));
				   loser = true;
			   }
		   }
	   }
	   else{System.out.println("Keinen Verlierer gefunden");}
   }
   
   //Ausgabe des Gewinners
   void setWinner(Player winner){
	   System.out.println("Gewonnen hat spieler nummer: " + winner.getId());
	   winner.winner = true;
   }
   
   //Ausgabe des Verlierers und neustarten des Spiels
   void setLooser(Player looser){
	   System.out.println("Verloren hat spieler nummer: " + looser.getId());
	   restart();
   }
   
   //neu starten des Spiels
   void restart(){
	   System.out.println("Spiel wird neu gestartet...");
	   //Spiel neu starten
   }
   
   //Funktion für die Runden
   void round(ArrayList<Player> players,Deck deck) 
   {
	   //players.get(0).fillHand(deck);
	   int cardCounter = 0;
	   Player Attacker = players.get(getAttacker(players));
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
				     cardCounter = cardCounter +1;
					  // System.out.println(AiAttackCard(Attacker));
				    
					   
					   Card card = defendcard;
					   placeCardDefender(card);
					   card = null;
					   cardCounter = cardCounter +1;
			   }
		   }
			   
	   System.out.println("Runde abgeschlossen");
	   playerChange(players);
	   discardPile();
	   for(int i =0; i > players.size(); i++){
		   players.get(i).fillHand(deck);
	   }
	   }
	   
	   
	   
   
   
   //Starten des Spiels
   void run(int playerCount){
	   
	   Deck deck = new Deck();
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
		   //Player player1 = new Player(deck);
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
	   
	   while(loser != true){
		   System.out.println("HAND: " + this.players.get(0).getHand());
		   System.out.println("HAND: " + this.players.get(1).getHand());
		   System.out.println("HAND: " + this.players.get(2).getHand());
		   this.round(this.players,deck);
		   this.checkLooser();
	   } 

   }
   
   //-------------------------MAIN-------------------------------------
   
	public static void main(String[] args) {
		
		Durak durak = new Durak(3);


		
		//ALTE MAIN!!!
		/*ArrayList<Player> playersTmp = new ArrayList<Player>();
		ArrayList<Card> discardPileTmp = new ArrayList<Card>();
		
		Deck deck = new Deck();
		Player player1 = new Player(deck);
		Player player2 = new Player(deck);
		Player player3 = new Player(deck);
		Dealer dealer = new Dealer(deck);
		//Table table = new Table();
		//currentTable = table;
		Durak durak = new Durak(3);
		
		Player Attacker, Defender;
		
		durak.playerNumber = 3;
		durak.roundStatus = 2;
		durak.players = playersTmp;
		durak.discardPile = discardPileTmp;
		
		System.out.println("SpielerIds:");
		System.out.println(player1.getId());
		System.out.println(player2.getId());
		System.out.println(player3.getId());
		
		durak.players.add(player1);
		durak.players.add(player2);
		durak.players.add(player3);
		
		
		durak.Trump = dealer.dealCards(durak.players, deck);
		
		System.out.println(durak.Trump);
		
		durak.setFirstAttacker(durak.Trump, durak.players);
		System.out.println("Angreifer ist: " + durak.getAttacker(durak.players));
		System.out.println("Verteidiger ist: " + durak.getDefender(durak.players));
		
		System.out.println("----player change-----");
		durak.playerChange(durak.players);

		System.out.println("Angreifer ist: " + durak.getAttacker(durak.players));
		System.out.println("Verteidiger ist: " + durak.getDefender(durak.players));
		
		
		
		
		Attacker = durak.players.get(durak.getAttacker(durak.players));
		Defender = durak.players.get(durak.getDefender(durak.players));
		System.out.println("Attacker und Defender zugewiesen");
		
		
		Card cardAt = new Card("6", "Spades");
		Card cardDe = new Card("8", "Spades");
		
		//durak.placeCardAttacker(Attacker.getHand(0));
		durak.placeCardAttacker(cardAt);
		System.out.println("Place Card Attacker!");
		
		//durak.placeCardDefender(Defender.getHand(0));
		durak.placeCardDefender(cardDe);
		System.out.println("Place Card Defender!");
		
		
		
		System.out.println("Defender hand size: " + Defender.getHand().size());
		durak.takeCards(Defender.getId());
		System.out.println("Defender hand size: " + Defender.getHand().size());

		for(int i = 0; i < durak.currentTable.size(); i++){
			System.out.println(durak.currentTable.get(i));
		}
		
		System.out.println("Table Size: " + durak.currentTable.size());
		durak.discardPile();
		System.out.println("Table Size: " + durak.currentTable.size());
		
		
		//Testen ob bei leeren händen der richtige verlierer bestimmt wird
		/*for(int i = 0; i < Attacker.getHand().size()+1; i++){
			Attacker.getHand().remove(0);
			Attacker.emptyHand = true;
		}*/
		
		/*for(int i = 0; i < Defender.getHand().size()+1; i++){
			Defender.getHand().remove(0);
			Defender.emptyHand = true;
		}
		
		//durak.checkLooser();
		
		AI Ai = new AI(deck);
		durak.players.add(Ai.player);
		durak.setAttacker(durak.players.get(3));
		AI Ai2 = new AI(deck);
		durak.players.add(Ai.player);
		durak.setDefender(durak.players.get(4));
		durak.Trump = dealer.dealCards(durak.players, deck);
		System.out.println("Id der KI: " + durak.players.get(3).getId());
		System.out.println("-------------------------------------");
		System.out.println(durak.players.get(3).getHand(1));
		System.out.println(durak.players.get(3).getHand(2));
		System.out.println("-------------------------------------");
		durak.round(durak.players);
		//angriffsaufruf der KI:
		//durak.placeCardAttacker(durak.AiAttackCard(Ai.player));*/
	}
   
}
// Angreifer bestimmen

//test
// Verteidiger bestimmen
// Verteidigung durchfÃÆÃÂ¼hren (vergleich je 2er paare)s
