import java.util.ArrayList;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Player
{
	private ArrayList<Card> hand;
	private Deck deck;
	private static int idCounter;
	private int statusId;
	private int id;
	public boolean emptyHand, winner, artificialIntelligence;
	
	public Player(Deck deck) {
		this.deck = deck.getDeck();
		this.hand = new ArrayList<Card>();
		id = idCounter;
		idCounter = idCounter+1;
		statusId = 0;
		artificialIntelligence = false;
		emptyHand = false;
		winner = false;
	}

	
	public int getId()
	{
		return this.id;
	}
	
	public void setStatusId(int statusId)
	{
		/*if(statusId == 1 || statusId == 2)
		{
			this.statusId = statusId;
		}
		else System.out.println("No viable Status.");*/
		this.statusId = statusId;
	}
	
	public void createHand()
	{
		HBox handGUI = new HBox();
		for(Card card : hand)
		{
			ImageView iv = new ImageView(card.card_faceup_image);
			handGUI.getChildren().add(iv);	
		}
	}
	
	public int getStatusId()
	{
		return this.statusId;
	}
	public ArrayList<Card> getHand() {
		return hand;
	}
	public Card getHand(int i) {
		return hand.get(i);
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	
	public void fillHand(Deck deck){
		if(hand.size() < 6){
			while(hand.size() < 6){
				hand.add(deck.getCard());//von stapel nehmen
			}
		}
	}
	
	void addCard(Card card)
	{
		hand.add(card);
	}
	
	void removeCard(Card card)
	{
		hand.remove(card);
	}
}