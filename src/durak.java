public class durak {
	int currentPlayerId, playerCount;
	void setFirstAttacker(Player AllPlayer)
	{
		int min = Integer.MAX_VALUE;
		int firstPlayer = 0;
		AllPlayer.hands.get(0, hand);
		for(int i = 0; i < AllPlayer.id.length; i++)
		{
			for(int j = 0; j < AllPlayer.id[i].hand.size(); j++)
			{
				if(AllPlayer.id[i].hand[j].suit == trump)
				{
					if (AllPlayer.id[i].hand[j]<min)
					{
						min = AllPlayer.id[i].hand[j];
						firstPlayer = Integer.valueOf(AllPlayer.id[i]);
					}
				}
				else
				{
				//	firstPlayer = ((Math.random()*playerCount)+1);
				}
			}
		}
		setAttacker(firstPlayer);
		setDefender((firstPlayer+1) % 4);
	}
	
	void setAttacker(int currentPlayerId)
	{
		currentPlayerId = 1;
	}
	Player getAttacker(Player AllPlayer)
	{
		for(int i = 0; i < AllPlayer.id.length;i++)
		{
			if (AllPlayer.id[i]==0)
			{
				System.out.println(AllPlayer.id[i]);
				System.out.println(i);
			}
		}
		return AllPlayer;
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

	}

// Angreifer bestimmen


// Verteidiger bestimmen
// Verteidigung durchführen (vergleich je 2er paare)s
