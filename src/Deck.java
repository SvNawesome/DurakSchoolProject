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
	
	public static Deck createNewDeck(){
		Deck newDeck = new Deck();
		return(newDeck);
	}
	
	public Card topCardDraw(Deck deck)
	{
		Card a = new Card("King", "Hearts");
		//a = deck(0);
		deck.remove(0);
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
	
	public ArrayList<Card> getDeck(){
		return this.deck;
	}
	
	public void addCard(ArrayList<Card> deck, Card card){
		deck.add(card);
	}
	
	public void removeCard(ArrayList<Card> deck, Card card){
		deck.remove(card);
	}
}
