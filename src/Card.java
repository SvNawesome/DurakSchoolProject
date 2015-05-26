import java.util.*;
import cardAssignment.*;

public class Card{
	
	//Initialisieren der benötigten Strings
	private String rank;
	private String suit;
	private String color;
	
	private String TRUMP;
	
	//Konstruktor für eine Zufallskarte
	public Card()
	{
		Random random = new Random();
		this.rank = Assignment.ranks[random.nextInt(Assignment.ranks.length-1)];
		this.suit = Assignment.suits[random.nextInt(Assignment.suits.length-1)];
		this.color = Assignment.suitColors.get(suit);
		System.out.println(rank + " " + suit + " " + color);
		
	}
	// Konstruktor für eine bestimmte Karte
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
	
	//Methode für den Vergleich
	// Return (-1) = Verteidiger hat einen höheren Wert (Somit ungültiger Zug)
	// 		  ( 0) = Karten sind nciht vergleichbar
	//		  ( 1) = Angreifer hat einen höheren Wert
	public int comparing(Card defCard)
	{
		if(Assignment.cardValues.get(defCard.getRank()) > Assignment.cardValues.get(this.getRank()))
		{
			System.out.println("(" + defCard.rank + ") has more value than (" + this.rank + ")");
			System.out.println("You can't attack with this card (" + this.rank + " / " + this.suit + ").");
			return -1;
		}
		else if(Assignment.cardValues.get(defCard.getRank()) < Assignment.cardValues.get(this.getRank()))
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
	
	//Methode um auf den Trumpf zu überprüfen durch Vergleich des Trumpf-Strings mit dem Suit-String
	// Return (-1) = Nur der Verteidiger ist Trumpf
	// 		  ( 0) = Keine Karte ist Trumpf
	//		  ( 1) = Beide Karten sind Trumpf
	//	 	  ( 2) = Nur der Angreifer ist Trumpf
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
	//Vergleich zweier Karten
	//Erste if-Abfrage für den Fall ob beide Trumpf sind (Rückgabewert = geschlagen oder nicht möglich)
	//Zweite if-Abfrage ob der Angreifer Trumpf ist wenn ja 1(geschlagen) return
	//Ansonsten 0 für nicht möglich
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

	
	//Getter und Setter für Rank und Suit
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
	
	//Neue String Ausgabe der Karten
	public String toString()
	{
		String cardString = "[" + this.rank + "/" + this.suit + "]";
		return cardString;
	}
	
	// Main zum Testen
	public static void main(String[] args)
	{
		Deck deck = new Deck();
		deck.setTrump("Hearts");
		
		String TRUMP = deck.getTrump();
		
		Card randomCard = new Card();
		
		System.out.println(randomCard);
		
		Card herzAce = new Card("Ace", "Hearts");
		Card herz7 = new Card("7", "Hearts");
		Card spade7 = new Card("7", "Spades");
//		System.out.println(herzAce.getRank());
//		System.out.println(herzAce.getSuit());
		
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
		
		System.out.println(herz7);
	}

}
