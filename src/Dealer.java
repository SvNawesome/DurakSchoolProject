import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.*;

public class Dealer {

	Deck dealerDeck;
	
	public Dealer(){
		dealerDeck.getDeck();
		//Deck dealerDeck = new Deck();
	}
	
	public void dealCards(ArrayList<Player> Players){
		for(int i = 0; i < Players.size(); i++){
			Players.get(i).fillHand();
		}
		trumpDraw();
	}
	
	public void trumpDraw(){
		dealerDeck.setTrump(dealerDeck.topCardDraw().suit);
		dealerDeck.addCard(dealerDeck.getDeck(), dealerDeck.topCardDraw());
		dealerDeck.removeCard(dealerDeck.getDeck(), dealerDeck.topCardDraw());
	}

	public static void main(String[] args)
	{
		Deck deck = new Deck();
		Dealer dealer = new Dealer();
	}
}
