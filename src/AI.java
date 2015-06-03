
public class AI {
	private Deck deck;
	public Player player;

	public AI(Deck deck){
		this.player = new Player(deck);
		this.player.artificialIntelligence = true;
	}
}
