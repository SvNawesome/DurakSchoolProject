import java.util.ArrayList;
import java.util.Collections;
import java.io.*;
import java.util.*;

public class Dealer {

	Deck dealerDeck;
	
	public Dealer(Deck deck){
		dealerDeck = deck.getDeck();
	}
	
	public void dealCards(ArrayList<Player> Players){
		for(int i = 0; i < Players.size(); i++){
			Players.get(i).fillHand();
		}
		trumpDraw();
	}
	
	public void trumpDraw(){
		dealerDeck.setTrump(dealerDeck.topCardDraw().suit);
	}
	
	public static void main(String[] args){
		Deck deck = new Deck();
		Dealer dealer = new Dealer(deck);
		dealer.trumpDraw();
	}
}
