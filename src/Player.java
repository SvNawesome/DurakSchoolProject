import java.util.ArrayList;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class Player
{
	//überlegen ob wir deck hier drin überhaupt brauchen
	private ArrayList<Card> hand;
	private static int idCounter;
	private int statusId;
	private int id;
	public boolean emptyHand, winner, artificialIntelligence,ai;
	
	public Player() {
		this.hand = new ArrayList<Card>();
		id = idCounter;
		idCounter = idCounter+1;
		statusId = 0;
		artificialIntelligence = false;
		emptyHand = false;
		winner = false;
		ai = true;
	}

	//Getter der ID
	public int getId()
	{
		return this.id;
	}
	
	// setzen/bekommen des Statuses ( Angreifer oder Verteidiger)
	public void setStatusId(int statusId)
	{
		/*if(statusId == 1 || statusId == 2)
		{
			this.statusId = statusId;
		}
		else System.out.println("No viable Status.");*/
		this.statusId = statusId;
	}
	
	public int getStatusId()
	{
		return this.statusId;
	}
	public ArrayList<Card> getHand() {
		return hand;
	}
	
	//erstellen der Hand + Imageview, zurückgeben der Hand und setzen der Hand
	public void createHand()
	{
		HBox handGUI = new HBox();
		for(Card card : hand)
		{
			ImageView iv = new ImageView(card.card_faceup_image);
			handGUI.getChildren().add(iv);	
		}
	}
	
	public Card getHand(int i) {
		//System.out.println(hand);
		return hand.get(i);			

	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	
	//Methode um die Hand mit dem KArten vom Deck zu füllen
	public void fillHand(Deck deck){
		if(hand.size() < 6){
			while(hand.size() < 6){
				hand.add(deck.getCard());//von stapel nehmen
			}
			System.out.println(hand);
		}
	}
	
	//Karte der Hand hinzufügen oder entfernen
	
	Card addCard(Card card)
	{
		hand.add(card);
		return card;
	}
	
	void removeCard(Card card)
	{
		hand.remove(card);
	}
	
	//erste Karte der Hand ausgeben
	int getFirstCard(){
		int card = 0;
		for(int i = 0; i >= hand.size(); i++){
			if(getHand(i) != null){
				card = i;
			}
		}
		return card;
	}

}