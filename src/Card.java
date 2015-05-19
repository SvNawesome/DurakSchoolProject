import java.util.*;
import java.io.*;

import cardAssignment.*;

public class Card{
	
	String rank = "";
	String suit = "";
	String color = "";
	
	String TRUMP = "";
	
	public Card(String r, String s)
	{
		if(Arrays.asList(Assignment.ranks).contains(r) && Arrays.asList(Assignment.suits).contains(s))
		{
			this.rank = r;
			this.suit = s;
			this.color = Assignment.suitColors.get(suit);
		}
		else 
		{
			System.out.println("Invalid Card.");
		}
	}
	
	public int comparing(Card defCard)
	{
		if(Assignment.cardValues.get(defCard.rank) > Assignment.cardValues.get(this.rank))
		{
			System.out.println("(" + defCard.rank + ") has more value than (" + this.rank + ")");
			System.out.println("You can't attack with this card (" + this.rank + " / " + this.suit + ").");
			return -1;
		}
		else if(Assignment.cardValues.get(defCard.rank) < Assignment.cardValues.get(this.rank))
		{
			System.out.println("(" + defCard.rank + ") has less value than (" + this.rank + ")");
			return 1;
		}
		else
		{
			System.out.println("Cards not comparable.");
			return 0;
		}
	}
	public int checkTrump(String TRUMP, Card defCard)
	{
		if(defCard.getSuit().equalsIgnoreCase(TRUMP) && this.getSuit().equalsIgnoreCase(TRUMP))
		{
			System.out.println("Beide Karten sind Trumpf");
			return 1;
		}
		else if(defCard.getSuit().equalsIgnoreCase(TRUMP) || this.getSuit().equalsIgnoreCase(TRUMP))
		{
			if(defCard.getSuit().equalsIgnoreCase(TRUMP))
			{
				System.out.println("Verteidiger ist Trumpf");
				return -1;
			}
			else if(this.getSuit().equalsIgnoreCase(TRUMP))
			{
				System.out.println("Angreifer ist Trumpf");
				return 2;
			}
		}
		return 0;
	}
	
	//Angreifende Karte ist "this" verteidigende Karte wird übergeben
	public int compareTo(Card defCard) {

		if(this.checkTrump(TRUMP, defCard) == 1 || this.checkTrump(TRUMP, defCard) == 0)
		{
			return this.comparing(defCard);
		}
		else if(this.checkTrump(TRUMP, defCard) == 2)
		{
			return 1;
		}
		else return 0;
	}

	public String getRank() {
		return rank;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	public static void main(String[] args)
	{
		Deck deck = new Deck();
		deck.setTrump("Hearts");
		
		String TRUMP = deck.getTrump();
		
		Card herzAce = new Card("Ace", "Hearts");
		Card herz7 = new Card("7", "Hearts");
		Card spade7 = new Card("7", "Spades");
//		System.out.println(herzAce.getRank());
//		System.out.println(herzAce.getSuit());
		
		System.out.println(Assignment.cardValues.get(herzAce.rank));
		System.out.println(Assignment.cardValues.get(herz7.rank));
		
		System.out.println("-------------------");
		
		System.out.println("Trumpfcheck");
		System.out.println(spade7.checkTrump(TRUMP, herz7));
		
		System.out.println("-----------");
		System.out.println("Kartenvergleich");
		System.out.println("---------------");
		System.out.println("Angreifer höher als Verteidiger");
		herzAce.compareTo(herz7);
		System.out.println("---------------");
		System.out.println("Angreifer = Verteidiger");
		herz7.compareTo(herz7);
		System.out.println("---------------");
		System.out.println("Verteidiger höher als Angreifer");
		herz7.compareTo(herzAce);
	}

}
