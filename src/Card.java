import java.util.*;
import java.io.*;
import cardAssignment.*;

public class Card implements Comparable{
	
	int rank = 0;
	String suit = "";
	
	public Card(String r,String s)
	{
		this.rank = Assignment.cardValues.get(r);
		this.suit = Assignment.suitColors.get(s);
	}
	
	@Override
	public int compareTo(Object arg0) {
		// TODO Auto-generated method stub
		return 0;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	public String getSuit() {
		return suit;
	}

	public void setSuit(String suit) {
		this.suit = suit;
	}

}
