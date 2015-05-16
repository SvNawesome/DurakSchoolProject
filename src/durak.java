import java.util.ArrayList;

public class durak {
	int currentPlayerId, playerCount;
	ArrayList<Player> Players;
	ArrayList<Table> currentTable;
	void setFirstAttacker(String trmpSuit)
	{
		int min = Integer.MAX_VALUE;
		int firstPlayer = 0;
		Card prvCard = null;
		
		for (int plsCount = 0; plsCount < Players.size(); plsCount++) {
			ArrayList<Card> actualHand = Players.get(plsCount).getHand();
			for (int crdCount = 0; crdCount < actualHand.size(); crdCount++) {
				Integer actlRank = actualHand.get(crdCount).getRank();
				String actlSuit = actualHand.get(crdCount).getSuit();
				
				if(prvCard==null)
				{
					prvCard = new Card(actlRank.toString(),actlSuit);
				}
				
				if(actualHand.get(crdCount).getRank() < prvCard.getRank() && actualHand.get(crdCount).getSuit().equalsIgnoreCase(trmpSuit))
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
	   int player;
	   Table.add(card);
	   if(checkcard())
	   {
	   for (int plsCount = 0; plsCount < Players.size(); plsCount++)
	   {
			ArrayList<Card> actualHand = Players.get(plsCount).getHand();
			for (int crdCount = 0; crdCount < actualHand.size(); crdCount++)
			{
				if(card == actualHand.get(crdCount))
				{
					player = plsCount;
				}
					
			}
	   }
	   card.move(x,y);
	   Players.get(player).removeCard(card);
	   
	   
	   }
	   else
	   {
		   Table.remove(Table.size());
	   }
   }
   
   void takeCards()
   {
	   
   }
   
   void checkCard()
   {
	   if(firstCard =! 1)
	   {
		   valueBeforeCard = Table.size()-1.getRank();
		   valueActualCard = Table.size().getRank();
		   if(valueBeforeCard < valueActualCard )
		   {
			   return(1);
		   }
		  /* else if(valueBeforeCard == valueActualCard)
		   {
			   switchPlayer();
		   } */
		   else
		   {
			   return(0);
		   }
	   }
   }
   
}

// Angreifer bestimmen


// Verteidiger bestimmen
// Verteidigung durchführen (vergleich je 2er paare)s
