import java.util.HashMap;

public class Player
{
  public HashMap<Integer, hand> hands = new HashMap<>();
  {
	  hand hand1;
	  hand hand2;
	  hand hand3;
	  hand hand4;
	  hands.put(0, hand1);
	  hands.put(1, hand2);
	  hands.put(2, hand3);
	  hands.put(3, hand4);
	  
  }
}