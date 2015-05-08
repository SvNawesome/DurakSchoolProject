import java.io.*;
import java.util.*;
import cardAssignment.*;

public class deck {
	public deck()
	{
		ArrayList<cards> deck = new ArrayList<cards>();
		for (String rank : Assignment.ranks) {
			for (String suit : Assignment.suits) {
				deck.add(new cards(rank, suit));
				Collections.shuffle(deck);
			}
		}
	}
	
	// Deck neu aufsetzen
	public static cards topCardDraw()
	{
		cards a = new cards(null, null);
		return a;
	}
}
