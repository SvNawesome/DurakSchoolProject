import java.util.ArrayList;

import cardAssignment.Assignment;

public class Durak {
	private int currentPlayerId, playerCount, roundStatus, playerNumber;
	private int firstCard, firstPlayer;
	private String Trump;
	private ArrayList<Player> players;
	//private ArrayList<Card> currentTable;
	Table currentTable = new Table();
	private ArrayList<Card> discardPile;
	private Card removeCard;
	
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
	
	//muss überarbeitet werden wegen den neuen Set/Get Methoden
	
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
   
   //Überprüfen wer verliert
   void checkLooser(int playerCount, int playerID){
	   int j = 0;
	   
	   //Anzahl an Spielern ohne Karten ermitteln
	   for(int i = 0; i < playerCount; i++){
		   if(players.get(i).emptyHand == true){
			   j++;
		   }
	   }
	   
	   //Den einzigen Spieler mit Karten finden und als Looser setzen
	   if(j == playerCount-1){
		   for(int i = 0; i < playerCount; i++){
			   if(players.get(i).emptyHand == false){
				   setLooser(players.get(i));
			   }
		   }
	   }
   }
   
   void setLooser(Player looser){
	   System.out.println("Verloren hat spieler nummer: " + looser.getId());
	   //Spiel stoppen
	   //Meldung wer gewonnen, verloren hat
	   //Spiel neustarten (+ grafik)
   }
   
	public static void main(String[] args) {
		ArrayList<Player> playersTmp = new ArrayList<Player>();
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
	}
   
}
// Angreifer bestimmen


// Verteidiger bestimmen
// Verteidigung durchfÃƒÂ¼hren (vergleich je 2er paare)s
