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
				hand.add(Deck.topCardDraw());//von stapel nehmen
			}
		}
	}
	
//	public static void playCard(Card card){
//		//ToDo
//		for(int i = 0; hand.size() != i; i++){
//			for(hand : ranks == card : ranks && hand : suits == card : suits){
//				//karte ausspielen
//				//karte l�schen+
//				hand[i].remove(i);
//				//(array einrücken)
//			}
//		}
	}
	
//}
