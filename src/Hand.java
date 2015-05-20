import java.util.*;
import java.io.*;
import cardAssignment.*;

public class Hand{
	
	public Hand()
	{
		int i = 1;
	}
	
	static List<Card> hand = new ArrayList<Card>();
	
	public static int getCardNumber(){
		return hand.size();
	}
	
	public static void fillHand(){
		if(hand.size() < 6){
			while(hand.size() < 6){
				Deck a = new Deck();
				a.getDeck();
				hand.add(a.topCardDraw());//von stapel nehmen
			}
		}
	}
	
//	public static void playCard(Card card){
//		//ToDo
//		for(int i = 0; hand.size() != i; i++){
//			for(hand : ranks == card : ranks && hand : suits == card : suits){
//				//karte ausspielen
//				//karte löschen+
//				hand[i].remove(i);
//				//(array einrÃ¼cken)
//			}
//		}
	}
	
//}
