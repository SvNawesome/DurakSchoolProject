import java.util.*;

public class Hand{
	
	//Initialisieren der ben�tigten ArrayList
	ArrayList<Card> hand;
	
	//Konstruktor zum erstellen der Hand
	public Hand()
	{
		hand = new ArrayList<Card>();
	}
	
	//gibt Anzahl der Karten auf der Hand zur�ck
	public int getCardNumber(){
		return this.hand.size();
	}
	
}
	
