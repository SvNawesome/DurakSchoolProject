
public class durak {
	
	int currentPlayerId;

	
	void setFirstAttacker(Player AllPlayer)
	{
		AllPlayer.id[0] = 1;
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
	
		
	}
	
// Spiellogik
	
	// Karten vergleichen (aufrufen)
	
	// Angreifer bestimmen
	
	
	
	// Verteidiger bestimmen
	
	// Verteidigung durchführen (vergleich je 2er paare)s
