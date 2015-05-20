import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.*;

public class Dealer {

	Deck dealerDeck;
	
	public Dealer(){
		Deck dealerDeck = new Deck();
	}
	
	public void createNewDeck(){
		dealerDeck.createNewDeck();
	}
	
	public void dealCards(ArrayList<Player> Players){
		for(int i = 0; i < Players.size(); i++){
			//code zum austeilen
			
			
			
		}
	//trumpDraw();
	}

}
