import java.util.*;
import java.io.*;
import cardAssignment.*;

public class hand{
	
	public hand()
	{
		int i = 1;
	}
	static List<cards> hand = new ArrayList<cards>();
	
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
	
//	public static void playCard(cards card){
//		//ToDo
//		for(int i = 0; hand.size() != i; i++){
//			for(hand : ranks == card : ranks && hand : suits == card : suits){
//				//karte ausspielen
//				//karte löschen+
//				hand[i].remove(i);
//				//(array einrücken)
//			}
//		}
	}
	
//}
