import java.util.ArrayList;

import javafx.scene.layout.HBox;
import cardAssignment.Assignment;

public class Durak {
	private int currentPlayerId, playerCount, roundStatus, playerNumber;
	private int firstCard, firstPlayer;
	private String Trump;
	private ArrayList<Player> players;
	//private ArrayList<Card> currentTable;
	Table currentTable = new Table();
	private ArrayList<Card> discardPile;
	private Card removeCard, aiPrevCard;
	private boolean loser;
	
	public Durak(){
		ArrayList<Player> players = new ArrayList<Player>();
	}
	
	void setFirstAttacker(String trmpSuit, ArrayList<Player> players)
	{	
		Card prvCard = null;
		
		for (int plsCount = 0; plsCount < players.size(); plsCount++) {
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

	

	void placeCardAttacker(Card card)
	{
		int currentCard = 0;
		int firstCard = 0;
		if(firstCard == 0)
		{
		currentTable.addCard(currentTable, card);
		int player = getAttacker(players);
				
				//card.move(x,y);
				players.get(player).removeCard(card);
				if(players.get(player).getHand().size() == 0){players.get(player).emptyHand = true;}
				firstCard=+1;
				

		}
		else if(card.getSuit().equalsIgnoreCase(currentTable.get(currentCard).getSuit()) || card.getRank().equalsIgnoreCase(currentTable.get(currentCard).getRank()))
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
	
	void placeCardDefender(Card card)
	{
		
		int player = 0;
		{
			Card card2 = currentTable.get(currentTable.size()-1);
			if(card.compareTo(card2) == 1) //compareTo benutzen!
			{
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
				currentTable.add(card);
				//card.move(x,y);
				players.get(player).removeCard(card);
				if(players.get(player).getHand().size() == 0){players.get(player).emptyHand = true;}


			}
			else if(card.compareTo(card2) == -1)
			{
				System.out.println("You can't defend with this card ");
			}
		}
	}
		
   
   void takeCards(int playerID)
   {
	   if(currentTable.size() != 0){
	   for(int i = -1; i < currentTable.size(); i++)
	   {
		   players.get(playerID).addCard(currentTable.get(0));
		   removeCard = currentTable.get(0);
		   currentTable.remove(removeCard);   
	   } 
	   roundStatus = 1;
	   playerChange(players);
	   }
   }
   
   void discardPile()
   {
	   if(currentTable.size() != 0){
	   for(int i = -1; i < currentTable.size(); i++)
	   {
		   discardPile.add(currentTable.get(0));
		   removeCard = currentTable.get(0);
		   currentTable.remove(removeCard);
	   }
	   roundStatus = 2;
	   playerChange(players);
	   }
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
   /*void checkClearHand()
   {
	   for (int plsCount = 0; plsCount < players.size(); plsCount++)
	   {
		   players.get(plsCount).getCardNumber();
		   
	   }
   }
}*/
   
   //Ai greift immer mit der stärksten Karte an
   //Gibt die Karte zurück mit der die Ai angreift
   Card AiAttackCard(Player AiPlayer){
	   Card card = AiPlayer.getHand(AiPlayer.getFirstCard());
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
   
 //Ai verteidigt immer mit der stärksten Karte
 //Gibt die Karte zurück mit der die Ai verteidigt
   Card AiDefendCard(Player AiPlayer){
	   Card card = AiPlayer.getHand(0);
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
		   if(players.get(i).emptyHand == true){
			   j++;
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
   
   void restart(){
	   System.out.println("Spiel wird neu gestartet...");
	   //Spiel neu starten
   }
   

   //void run(int playerCount, HBox hand1player){

   void round(ArrayList<Player> players)
   {
	   int cardCounter = 0;
	   Player Attacker = players.get(getAttacker(players));
	   Player Defender = players.get(getDefender(players));
	   if (Attacker.ai == true && Defender.ai == true)
	   {
		   while(roundStatus != 1 || roundStatus !=2 || cardCounter <= 12){
			   placeCardAttacker(AiAttackCard(Attacker));
			  // System.out.println(AiAttackCard(Attacker));
			   cardCounter = cardCounter +1;
			   placeCardDefender(AiDefendCard(Defender));
			  // System.out.println(AiDefendCard(Defender));
			   cardCounter = cardCounter +1;
			   if(cardCounter == 2){
				   roundStatus = 1;
			   }
		   }
		   playerChange(players);
	   }
   }
   
   
   void run(int playerCount){

	   
	   ArrayList<Player> playersTmp = new ArrayList<Player>();
	   ArrayList<Card> discardPileTmp = new ArrayList<Card>();
	   Deck deck = new Deck();
	   Durak durak = new Durak();
	   Dealer dealer = new Dealer(deck);

	   durak.players = playersTmp;
	   
	   if(playerCount == 4){
		   Player player1 = new Player(deck);
		   AI Ai1 = new AI(deck);
		   AI Ai2 = new AI(deck);
		   AI Ai3 = new AI(deck);
		   
		   durak.players.add(player1);
		   player1.ai = false;
		   durak.players.add(Ai1.player);
		   durak.players.add(Ai2.player);
		   durak.players.add(Ai3.player);
			
	   }else if(playerCount == 3){
		   Player player1 = new Player(deck);
		   AI Ai1 = new AI(deck);
		   AI Ai2 = new AI(deck);
		   
		   durak.players.add(player1);
		   player1.ai = false;
		   durak.players.add(Ai1.player);
		   durak.players.add(Ai2.player);
		   
	   }else if(playerCount == 2){
		   Player player1 = new Player(deck);
		   AI Ai1 = new AI(deck);
		   
		   durak.players.add(player1);
		   player1.ai = false;
		   durak.players.add(Ai1.player);
		   
	   }else{
		   System.out.println("Zu wenig oder zu viele Spieler!");
	   }
	   
	   playerNumber = playerCount;
	   
	   durak.discardPile = discardPileTmp;
	   durak.Trump = dealer.dealCards(durak.players, deck);
	   durak.setFirstAttacker(durak.Trump, durak.players);
	   
	   while(loser != true){
		   durak.round(durak.players);
		   //checkLooser();
	   }
   }
   
   //-------------------------MAIN-------------------------------------
   
	public static void main(String[] args) {
		
		Durak durak = new Durak();
		durak.run(3);
		
		
		
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
		Durak durak = new Durak();
		
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
// Verteidigung durchfÃƒÆ’Ã‚Â¼hren (vergleich je 2er paare)s
