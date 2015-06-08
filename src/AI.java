
public class AI {
	public Player player;

	public AI(){
		this.player = new Player();
		this.player.artificialIntelligence = true;
	}
	
	//Ai greift immer mit der stärksten Karte an
	//Gibt die Karte zurück mit der die Ai angreift
	/*Card AiAttackCard(Player AiPlayer){
		Card card = AiPlayer.getHand(AiPlayer.getFirstCard());
		for(int i = 0; i < AiPlayer.getHand().size(); i++){
			if(aiPrevCard == null){
			    if(card.compareTo(AiPlayer.getHand(i)) == 1){
			    card = AiPlayer.getHand(i);
			    aiPrevCard = card;
				}		   
			}
			else{
				if(aiPrevCard.getSuit().equalsIgnoreCase(AiPlayer.getHand(i).getSuit())){
					card = AiPlayer.getHand(i);
					aiPrevCard = card;
				    }
			}
		}
		return card;
	 }
	
	 //Ai verteidigt immer mit der stärksten Karte
	 //Gibt die Karte zurück mit der die Ai verteidigt
	   Card AiDefendCard(Player AiPlayer){
		   Card card = AiPlayer.getHand(0);
		   for(int i = 0; i < AiPlayer.getHand().size(); i++){
			   
				   if(card.compareTo(AiPlayer.getHand(i)) == 1){
				   card = AiPlayer.getHand(i);
				
			   }
		   }
		   return card;
	   }*/
}
