import java.util.Collections;
import java.io.*;
import java.util.*;

public class Dealer {

	Deck dealerDeck;
	
	public Dealer(){
		Deck dealerDeck = new Deck();
	}
	
	public void shuffleCards(){
		dealerDeck.shuffleCards();
	}
	
	public void throwCards(int playerCount){
		for(int i = 0; i < playerCount; i++){
			//code zum austeilen
		}
	}

}
