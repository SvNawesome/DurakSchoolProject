
public class durak {
	
 //	private ;
	
	void setAttacker(Player PlayerID)
	{
		PlayerID = 1;
	}
	
    int getAttacker(Player PlayerID)
    {
    	for(int i = 0; i < PlayerID.length;i++)
		{
			if (PlayerID[i]==0)
			{
				System.out.println(PlayerID[i]);
				System.out.println(i);
			}
		}
    }
    
    void setDefender(int currentPlayer)
	{
		currentPlayer = 0;
	}
	
    int getDefender()
    {
       return currentPlayer;	
    }
    
    public static final void changeCurrentPlayer()
    {
    	if (currentPlayer = 1)
    	{
    		setDefender(currentPlayer);
    	}
    	
    }
	
		
	}
	
// Spiellogik
	
	// Karten vergleichen (aufrufen)
	
	// Angreifer bestimmen
	
	
	
	// Verteidiger bestimmen
	
	// Verteidigung durchführen (vergleich je 2er paare)

}
