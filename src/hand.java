import java.util.*;
import java.io.*;
import cardAssignment.*;

public class hand implements cards{

	List<cards> hand = new ArrayList<cards>();
	//cards[] hand = new cards[52];
	
	
	public static int getCardNumber(){
		return hand.size();
	}
	
	public static void fillHand(){
		if(hand.size() < 6){
			
			while(hand.size() < 6) do{
				hand.add(hand.size() + 1, cards);//von stapel nehmen!!!;
			}
		}
	}
	
	public static void add(int i, cards card){
		hand.add(i, card);
	}
	
	public static void remove(int i){
		hand.remove(i);
	}
	
	public static void playCard(cards card){
		//ToDo
	}
	
}
