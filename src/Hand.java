import java.util.*;

public class Hand{
	
	//Initialisieren der benötigten ArrayList
	ArrayList<Card> hand;
	
	//Konstruktor zum erstellen der Hand
	public Hand()
	{
		hand = new ArrayList<Card>();
	}
	
	//gibt Anzahl der Karten auf der Hand zurück
	public int getCardNumber(){
		return this.hand.size();
	}
	
}
	
