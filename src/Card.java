import java.util.*;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.image.*;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import cardAssignment.*;
import cardImages.ImageStorage;

public class Card extends ImageView{
	
	//Initialisieren der ben�tigten Strings
	private String rank;
	private String suit;
	private boolean faceUp;
	private boolean rotated90;
	HBox player1Hand = Main.player1Hand;
	HBox bottomCardTable = Main.bottomCardTable;
	
	//gr��e der karten
	public static final int  card_width   =  150 ;
	public static final int  card_height  =  215 ;
	
	Image card_faceup_image ;
	
	//Konstruktor f�r eine Zufallskarte
	public Card()
	{
		Card thisCard = this;
		
		//Eventhandler um Feedback zu bekommen wenn eine Karte geklickt wird 
		//Eventhandler zum verteidigen (2 klicks erst die eigene Karte dann die angreifer Karte
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent m) {
				Main.clickCounter = Main.clickCounter%2;
				System.out.println(Main.clickCounter);
				// 0 = erster Klick 1 = zweiter Klick
				if(Main.clickCounter == 0)
				{
					//Um zu schauen ob die Karte in der Spielerhand ist
					for(Node cardInHand: player1Hand.getChildren())
					{
						Card card = (Card) cardInHand;
						if(card == thisCard)
						{
							Durak.playerTurn(card);
							Main.clickCounter +=1;
							break;
						}
						else Main.clickCounter = 0;
					}
				}
				else if(Main.clickCounter == 1)
				{
					//zum �berpr�fen ob die Karte auf dem Feld liegt
					for(Node cardInHand: bottomCardTable.getChildren())
					{
						Card card = (Card) cardInHand;
						if(card == thisCard)
						{
							Durak.playerTurn(card);
							Main.clickCounter +=1;
							break;
						}
						else Main.clickCounter = 1;
					}
					
				}
				m.consume();
			}
		});
		
		Random random = new Random();
		this.rank = Assignment.ranks[random.nextInt(Assignment.ranks.length-1)];
		this.suit = Assignment.suits[random.nextInt(Assignment.suits.length-1)];
		
		//Zuweisen der Bilder zu den Karten
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
		
		//Standar den Kartenr�cken als Bild setzen
		setImage( ImageStorage.card_back_image ) ; // Initially the card is face-down
		faceUp = false;
		
	}
	
	// Konstruktor f�r eine bestimmte Karte
	public Card(String r, String s)
	{
		Card thisCard = this;
		//selbe wie beim Random Konstruktor
		this.setOnMouseClicked(new EventHandler<MouseEvent>() {

			@Override
			public void handle(MouseEvent m) {
				Main.clickCounter = Main.clickCounter%2;
				System.out.println(Main.clickCounter);

				if(Main.clickCounter == 0)
				{
					for(Node cardInHand: player1Hand.getChildren())
					{
						Card card = (Card) cardInHand;
						if(card == thisCard)
						{
							Durak.playerTurn(card);
							Main.clickCounter +=1;
							break;
						}
						else Main.clickCounter = 0;
					}
				}
				else if(Main.clickCounter == 1)
				{
					for(Node cardInHand: bottomCardTable.getChildren())
					{
						Card card = (Card) cardInHand;
						if(card == thisCard)
						{
							Durak.playerTurn(card);
							Main.clickCounter +=1;
							break;
						}
						else Main.clickCounter = 1;
					}
					
				}
				m.consume();
			}
		});
		
		if(Arrays.asList(Assignment.ranks).contains(r) && Arrays.asList(Assignment.suits).contains(s))
		{
			this.rank = r;
			this.suit = s;
			//System.out.println(Assignment.cardValues.get(rank));
		
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
			faceUp = false;
	
		}
		else 
		{
			System.out.println("Invalid Card.");
		}
		}
	
	//Funktion zum umdrehen der Karte + setzen der faceUp variable
	public void turn_card()
	{
		if(getImage() == card_faceup_image)
		{
			setImage(ImageStorage.card_back_image);
			faceUp = false;
		}
		else if(getImage() == ImageStorage.card_back_image)
		{
			setImage(card_faceup_image);
			faceUp = true;
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
			//System.out.println("You can't defend with this card (" + defCard.rank + " / " + defCard.suit + ").");
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
				System.out.println("Nur Verteidiger ist Trumpf");
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
	public int compareTo(String TRUMP, Card defCard) {
		System.out.println("AttCard: " + this + "defCard: " + defCard + "Trump: " + TRUMP);
		if(defCard == null)
		{
			return 0;
		}
		else
		{
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
	}

	
	//Getter und Setter f�r Rank und Suit
	//+ FaceUp und Rotated90
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
	
	public boolean isFaceUp() {
		return faceUp;
	}

	public void setFaceUp(boolean faceUp) {
		this.faceUp = faceUp;
	}

	public boolean isRotated90() {
		return rotated90;
	}

	public void setRotated90(boolean rotated90) {
		this.rotated90 = rotated90;
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
		
		/*
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
		*/
	}

}
