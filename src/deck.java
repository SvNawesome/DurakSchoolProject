import java.io.*;
import java.util.*;

import cardAssignment.*;

public class Deck {
	String Trump;
	
	public Deck()
	{
		ArrayList<Card> deck = new ArrayList<Card>();
		for (String rank : Assignment.ranks) {
			for (String suit : Assignment.suits) {
				deck.add(new Card(rank, suit));
				Collections.shuffle(deck);
			}
		}
	}
	
	// Deck neu aufsetzen
	public static Card topCardDraw()
	{
		Card a = new Card("King", "Hearts");
		return a;
	}
	
	public String getTrump()
	{
		return Trump;
	}
	
	public void setTrump(String Trump)
	{
		this.Trump = Trump;
	}
}
