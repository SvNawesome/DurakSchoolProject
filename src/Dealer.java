import java.util.ArrayList;

public class Dealer {

	//Initialisieren des Trumpf Strings
	private static String Trump;
	
	//Konstruktor gibt dem Dealer ein neues Deck
	public Dealer(Deck deck){
		deck.getDeck();
	}
	
	//Karten an Spieler austeilen (6) und Trumpf ziehen aufrufen
	public void dealCards(ArrayList<Player> Players, Deck deck){
		for(int i = 0; i < Players.size(); i++){
			System.out.println("\nSpieler" + i + " zieht:");
			Players.get(i).fillHand(deck);
		}
		trumpDraw(deck);
	}
	
	//Trumpf ziehen und die gezogene Karte wieder an das Deck anfügen
	public void trumpDraw(Deck dealerDeck){
		System.out.println("\nTrumpf gezogen");
		Card tmpCard = dealerDeck.getCard();
		Trump = tmpCard.getSuit();
		dealerDeck.addCard(dealerDeck, tmpCard);
	}
	
	public static void main(String[] args){
		Deck deck = new Deck();
		
		//Spieler erstellen und in eine Arrayliste packen
		Player player1 = new Player(deck);
		Player player2 = new Player(deck);
		ArrayList<Player> players = new ArrayList<Player>();
		players.add(player1);
		players.add(player2);
		
		
		Dealer dealer = new Dealer(deck);
		dealer.trumpDraw(deck);
		System.out.println(Trump);
		
		//Karten verteilen + Trumpdraw
		dealer.dealCards(players, deck);
		
		System.out.println(player1.getHand(1));
		
		
//		for(int i = 0; i != 36;i++)
//		{
//			deck.getCard();
//		}
	}
}
