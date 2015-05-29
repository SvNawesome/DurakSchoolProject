import java.util.ArrayList;

public class Player
{
	private ArrayList<Card> hand;
	private Deck deck;
	private int idCounter = 0;
	private int statusId;
	private int id;
	public boolean emptyHand, artificialIntelligence;
	
	public Player(Deck deck) {
		idCounter++;
		this.deck = deck.getDeck();
		this.hand = new ArrayList<Card>();
		int id = idCounter;
		int statusId = 0;
		artificialIntelligence = false;
	}

	
	public int getId()
	{
		return this.id;
	}
	
	public void setStatusId(int statusId)
	{
		if(statusId == 1 || statusId == 2)
		{
			this.statusId = statusId;
		}
		else System.out.println("No viable Status.");
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