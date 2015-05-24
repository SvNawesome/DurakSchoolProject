import java.util.ArrayList;

import cardAssignment.Assignment;

public class Durak {
	int currentPlayerId, playerCount;
	Card firstCard;
	ArrayList<Player> Players;
	ArrayList<Table> currentTable;
	ArrayList<Table> discardPile;
	void setFirstAttacker(String trmpSuit)
	{
		int min = Integer.MAX_VALUE;
		int firstPlayer = 0;
		Card prvCard = null;
		
		for (int plsCount = 0; plsCount < Players.size(); plsCount++) {
			ArrayList<Card> actualHand = Players.get(plsCount).getHand();
			for (int crdCount = 0; crdCount < actualHand.size(); crdCount++) {
				String actlRank = actualHand.get(crdCount).getRank();
				String actlSuit = actualHand.get(crdCount).getSuit();
				Card actlCard = new Card(actlRank, actlSuit);
				
				if(prvCard==null)
				{
					prvCard = new Card(actlRank, actlSuit);
				}
				
				if(Assignment.cardValues.get(actlCard.rank) < Assignment.cardValues.get(prvCard.rank) && actualHand.get(crdCount).getSuit().equalsIgnoreCase(trmpSuit))
				{
					prvCard = actualHand.get(crdCount);
					firstPlayer = plsCount;
				}
			}
		}
		
			
		
		//	firstPlayer = ((Math.random()*playerCount)+1);
		//setAttacker(firstPlayer);
		//setDefender((firstPlayer+1) % 4);
	}
	
	void setAttacker(int currentPlayerId)
	{
		currentPlayerId = 1;
	}
	
	Player getAttacker()
	{
		return null;
	}
	void setDefender(int currentPlayerId)
	{
		currentPlayerId = 0;
	}
	int getDefender()
	{
		return currentPlayerId;
	}
	public final void changeCurrentPlayer()
	{
		if (currentPlayerId == 1)
		{
			setDefender(currentPlayerId);
		}
	}
	

// Spiellogik
// Karten vergleichen (aufrufen)

	

	void placeCard(Card card)
	{
		Card card2;
		currentTable.add(card);
		int player = 0;
		if(firstCard != 0)
		{
			card2 = currentTable.get(currentTable.legnth-1)
			if(card.compareTo(card2) == 1) //compareTo benutzen!
			{
				for (int plsCount = 0; plsCount < Players.size(); plsCount++)
				{
					ArrayList<Card> actualHand = Players.get(plsCount).getHand();
					for (int crdCount = 0; crdCount < actualHand.size(); crdCount++)
					{
						if(card == actualHand.get(crdCount))
						{
							player = plsCount2;
						}

					}
				}
				//card.move(x,y);
				Players.get(player).removeCard(card);


			}
			else if(card.compareTo(card2) == -1)
			{
				System.out.println("You can't attack with this card ");
			}
		}
		firstCard = 1;
	}
   
   void takeCards(int playerID)
   {
	   for(i = 0; i > currentTable.lenght; i++)
	   {
		   Players.get(playerID).addCard(currentTable.get(i));
		   removeCard = currentTable.get(i);
		   currentTable.remove(removeCard);
	   }
	   
   }
   
   void discardPile()
   {
	   for(i = 0; i > currentTable.lenght; i++)
	   {
		   discardPile.add(currentTable.get(i));
		   removeCard = currentTable.get(i);
		   currentTable.remove(removeCard);
	   }
   }
   
   
   
   
}

// Angreifer bestimmen


// Verteidiger bestimmen
// Verteidigung durchführen (vergleich je 2er paare)s
