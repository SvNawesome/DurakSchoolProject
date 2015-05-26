import java.util.*;

import cardAssignment.*;

public class Deck {
	private Deck deck;
	private String Trump;
	private ArrayList<Card> cardDeck;
	
	public Deck()
	{
		this.cardDeck = new ArrayList<Card>();
		for (String rank : Assignment.ranks) {
			for (String suit : Assignment.suits) {
				cardDeck.add(new Card(rank, suit));
				Collections.shuffle(cardDeck);
			}
		}
	}
	
	public static Deck createNewDeck(){
		Deck newDeck = new Deck();
		return(newDeck);
	}
	
	public Card getCard() {
		if(this.cardDeck.size()!=0)
		{
			Card tmpCard = this.cardDeck.get(0);
			System.out.println("Gezogene Karte:" + tmpCard);
			this.cardDeck.remove(0);
			return tmpCard;
		}
		else
		{
			System.out.println("Keine Karten mehr.");
			return null;
		}
	}

	public String getTrump()
	{
		return Trump;
	}
	
	public void setTrump(String Trump)
	{
		this.Trump = Trump;
	}
	
	public void setDeck(Deck deck){
		this.deck = deck;
	}
	
	public Deck getDeck(){
			return deck;
	}
	
	public void addCard(Deck deck, Card card){
		deck.add(card);
	}

	public void removeCard(Deck deck, Card card){
		deck.remove(card);
	}
	
	private void add(Card card) {
		cardDeck.add(card);
	}
	
	private void remove(Card card) {
		cardDeck.remove(card);
	}

	public static void main(String[] args){
		new Deck();
		
	}
	
	public String toString()
	{
		String deckString = new String("[Top]\n");
		for (Card card: this.cardDeck)
		{
			deckString += card + "\n";
		}
		deckString += "[Bottom]\n";
		return deckString;
	}
}

	
