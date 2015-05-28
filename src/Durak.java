import java.util.ArrayList;

import cardAssignment.Assignment;

public class Durak {
	private int currentPlayerId, playerCount;
	private int firstCard;
	private String Trump;
	private ArrayList<Player> players;
	private ArrayList<Card> currentTable;
	private ArrayList<Card> discardPile;
	//Table currentTable = new Table();
	private Card removeCard;
	
	void setFirstAttacker(String trmpSuit)
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
				
				if(Assignment.cardValues.get(actlCard.getRank()) < Assignment.cardValues.get(prvCard.getRank()) && actualHand.get(crdCount).getSuit().equalsIgnoreCase(trmpSuit))
				{
					prvCard = actualHand.get(crdCount);
					int firstPlayer = plsCount;
				}
			}
		}
		
			
		
		//	firstPlayer = ((Math.random()*playerCount)+1);
		//setAttacker(firstPlayer);
		//setDefender((firstPlayer+1) % 4);
	}
	
	void setAttacker(Player player)
	{
		player.setStatusId(1);
	}
	
	int getAttacker()
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
		player.setStatusId(2);;
	}
	int getDefender()
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
	   for(int i = 0; i > currentTable.size(); i++)
	   {
		   players.get(playerID).addCard(currentTable.get(i));
		   removeCard = currentTable.get(i);
		   currentTable.remove(removeCard);
	   }
	   
   }
   
   void discardPile()
   {
	   for(int i = 0; i > currentTable.size(); i++)
	   {
		   discardPile.add(currentTable.get(i));
		   removeCard = currentTable.get(i);
		   currentTable.remove(removeCard);
	   }
   }
   
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
				   //setLooser();
			   }
		   }
	   }
   }
   
   
   
}
// Angreifer bestimmen


// Verteidiger bestimmen
// Verteidigung durchfÃƒÂ¼hren (vergleich je 2er paare)s
