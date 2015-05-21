import java.util.ArrayList;
import java.util.HashMap;

public class Player
{
	ArrayList<Card> hand;
	
	public Player() {
		this.hand = new ArrayList<Card>();
	}

	public ArrayList<Card> getHand() {
		return hand;
	}

	public void setHand(ArrayList<Card> hand) {
		this.hand = hand;
	}
	
	public void fillHand(){
		if(hand.size() < 6){
			while(hand.size() < 6){
				Deck a = new Deck();
				a.getDeck();
				hand.add(a.topCardDraw());//von stapel nehmen
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