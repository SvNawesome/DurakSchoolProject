import java.util.*;
import java.io.*;

import cardAssignment.*;

public class Card{
	
	String rank = "";
	String suit = "";
	String color = "";
	
	String TRUMP = "";
	
	public Card(int r,int s)
	{
		this.rank = Assignment.ranks[r];
		this.suit = Assignment.suits[s];
		this.color = Assignment.suitColors.get(suit);
	}
	
	public int checkTrump(String TRUMP, Card card)
	{
		System.out.println("drin");
		if(card.getSuit().equalsIgnoreCase(TRUMP))
		{
			System.out.println("Beide Karten sind Trumpf");
			return 1;
		}
		else return 0;
	}
	
	/*public int compareTo(Card card) {
		if(this.getRank() > card.getRank())
		{
		return -1;
		}
		else if(this.getRank() < card.getRank())
		{
		return 1;
		}
		else
		{
			System.out.println("Cards not comparable.");
			return 0;
		}
		
	}*/

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
		String TRUMP = "Hearts";
		Card herz6 = new Card(0, 0);
		Card herz7 = new Card(1, 0);
		System.out.println(herz6.getRank());
		System.out.println(herz6.getSuit());
		
		System.out.println("");
		//System.out.println(herz6.compareTo(herz7));
		//System.out.println(herz7.compareTo(herz7));
		//System.out.println(herz7.compareTo(herz6));
		
		System.out.println(herz6.checkTrump(TRUMP, herz7));
	}

}
