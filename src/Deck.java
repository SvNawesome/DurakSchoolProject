import java.io.*;
import java.util.*;

import cardAssignment.*;

public class Deck {
	Deck deck;
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
	
	public Card getCard() {
		//!
		return null;
	}
	
	public Card topCardDraw()
	{
		Card a = new Card("King", "Hearts");
		a = this.getCard();
		this.remove(0);
		return a;
	}

	private void remove(int i) {
		// TODO Auto-generated method stub
		this.remove(i);
	}

	public String getTrump()
	{
		return Trump;
	}
	
	public void setTrump(String Trump)
	{
		this.Trump = Trump;
	}
	
	public void setDeck(Deck setDeck){
		deck = setDeck;
	}
	
	public Deck getDeck(){
			return deck;
	}
	
	public void addCard(ArrayList<Card> deck, Card card){
		deck.add(card);
	}
	
	public void removeCard(ArrayList<Card> deck, Card card){
		deck.remove(card);
	}
	
	public static void main(String[] args){
		//h
	}
}

	
