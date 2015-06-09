import java.util.*;

import javafx.scene.image.*;
import cardAssignment.*;
import cardImages.ImageStorage;

public class Card extends ImageView{
	
	//Initialisieren der ben�tigten Strings
	private String rank;
	private String suit;
	private String TRUMP;
	
	//gr��e der karten
	public static final int  card_width   =  150 ;
	public static final int  card_height  =  215 ;
	
	Image card_faceup_image ;
	
	//Konstruktor f�r eine Zufallskarte
	public Card()
	{
		Random random = new Random();
		this.rank = Assignment.ranks[random.nextInt(Assignment.ranks.length-1)];
		this.suit = Assignment.suits[random.nextInt(Assignment.suits.length-1)];
		
		// Damit andere klassen ohne gui getestet werden k�nnen
		/*if ( suit == "Hearts" )
		{
			card_faceup_image = ImageStorage.getInstance().get( "hearts" + Assignment.cardValues.get(rank) ) ;
		}
		else if ( suit == "Diamonds" )
		{
			card_faceup_image = ImageStorage.getInstance().get( "diamonds" + Assignment.cardValues.get(rank) ) ;
		}
		else if ( suit == "Spades" )
		{
			card_faceup_image = ImageStorage.getInstance().get( "spades" + Assignment.cardValues.get(rank) ) ;
		}
		else if ( suit == "Clubs" )
		{
			card_faceup_image = ImageStorage.getInstance().get( "clubs" + Assignment.cardValues.get(rank) ) ;
		}

		setImage( ImageStorage.card_back_image ) ; // Initially the card is face-down
		*/
	}
	// Konstruktor f�r eine bestimmte Karte
	// Imageview evtl einf�gen
	public Card(String r, String s)
	{
		if(Arrays.asList(Assignment.ranks).contains(r) && Arrays.asList(Assignment.suits).contains(s))
		{
			this.rank = r;
			this.suit = s;
			//System.out.println(Assignment.cardValues.get(rank));
		/*
			//zuordnen des passenden Bildes
			if ( suit == "Hearts" )
			{
				card_faceup_image = ImageStorage.getInstance().get( "hearts" + Assignment.cardValues.get(rank) ) ;
			}
			else if ( suit == "Diamonds" )
			{
				card_faceup_image = ImageStorage.getInstance().get( "diamonds" + Assignment.cardValues.get(rank) ) ;
			}
			else if ( suit == "Spades" )
			{
				card_faceup_image = ImageStorage.getInstance().get( "spades" + Assignment.cardValues.get(rank) ) ;
			}
			else if ( suit == "Clubs" )
			{
				card_faceup_image = ImageStorage.getInstance().get( "clubs" + Assignment.cardValues.get(rank) ) ;
			}

			setImage(ImageStorage.card_back_image ) ; // Initially the card is face-down
	*/
		}
		else 
		{
			System.out.println("Invalid Card.");
		}
		}
	
	//Funktion zum umdrehen der Karte
	public void turn_card()
	{
		if(getImage() == card_faceup_image)
		{
			setImage(ImageStorage.card_back_image);
		}
		else if(getImage() == ImageStorage.card_back_image)
		{
			setImage(card_faceup_image);
		}
	}
	
	//Methode f�r den Vergleich
	// Return ( 1) = Verteidiger hat einen h�heren Wert (Somit ung�ltiger Zug)
	// 		  ( 0) = Karten sind nciht vergleichbar
	//		  (-1) = Angreifer hat einen h�heren Wert
	public int comparing(Card defCard)
	{
		if(Assignment.cardValues.get(defCard.getRank()) > Assignment.cardValues.get(this.getRank()))
		{
			//System.out.println("(Verteidiger)(" + defCard.rank + " "+ defCard.suit + ") has more value than (" + this.rank + " " + this.suit + ")(Angreifer)");
			
			return 1;
		}
		else if(Assignment.cardValues.get(defCard.getRank()) < Assignment.cardValues.get(this.getRank()))
		{
			//System.out.println("(Verteidiger)(" + defCard.rank + " "+ defCard.suit + ") has less value than (" + this.rank + " " + this.suit + ")(Angreifer)");
			//System.out.println("You can't attack with this card (" + this.rank + " / " + this.suit + ").");
			return -1;
		}
		else
		{
			//System.out.println("Cards not comparable.");
			//System.out.println("Angreifer Suit: " +this.suit+ " " + "Verteidiger Suit: " +defCard.suit);
			return 0;
		}
	}
	
	//Methode um auf den Trumpf zu �berpr�fen durch Vergleich des Trumpf-Strings mit dem Suit-String
	// Return ( 2) = Nur der Verteidiger ist Trumpf
	// 		  ( 0) = Keine Karte ist Trumpf
	//		  ( 1) = Beide Karten sind Trumpf
	//	 	  (-1) = Nur der Angreifer ist Trumpf
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
				return 2;
			}
			else if(this.getSuit().equalsIgnoreCase(TRUMP))
			{
				System.out.println("Angreifer ist Trumpf");
				System.out.println("Zug nicht m�glich");
				return -1;
			}
		}
		return 0;
	}
	
	//Angreifende Karte ist "this" verteidigende Karte wird �bergeben
	//Vergleich zweier Karten
	//Erste if-Abfrage f�r den Fall ob beide Trumpf sind (R�ckgabewert = geschlagen oder nicht m�glich)
	//Zweite if-Abfrage ob der Angreifer Trumpf ist wenn ja 1(geschlagen) return
	//Ansonsten 0 f�r nicht m�glich
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

	
	//Getter und Setter f�r Rank und Suit
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

		System.out.println("----" + TRUMP + "----");
		
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
		System.out.println("Angreifer h�her als Verteidiger");
		herzAce.compareTo(herz7);
		System.out.println("---------------");
		System.out.println("Angreifer = Verteidiger");
		herz7.compareTo(herz7);
		System.out.println("---------------");
		System.out.println("Verteidiger h�her als Angreifer");
		herz7.compareTo(herzAce);
		System.out.println("Angreifer Trumpf verteidiger nicht");
		spade7.compareTo(herzAce);
		
	}

}
