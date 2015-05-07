import java.util.*;
import java.io.*;
import cardAssignment.*;

public class hand implements cards{

	List<cards> hand = new ArrayList<cards>();
	
	public static int getCardNumber(){
		return hand.size();
	}
	
	public static void fillHand(){
		if(hand.size() < 6){
			while(hand.size() < 6){
				hand.add(deck.topCardDraw());//von stapel nehmen
			}
		}
	}
	
	public static void playCard(cards card){
		//ToDo
		for(int i = 0; hand.size() != i; i++){
			if(hand[i].ranks == card.ranks && hand[i].suits == card.suits){
				//karte ausspielen
				//karte löschen+
				hand[i].remove(i);
				//(array einrücken)
			}
		}
	}
	
}
