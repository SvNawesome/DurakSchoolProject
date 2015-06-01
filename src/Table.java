import java.util.ArrayList;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import cardImages.ImageStorage;

public class Table {
	ArrayList<Card> table;
	
	public Table()
	{
		this.table = new ArrayList<Card>();	
	}
	
	//Add und Remove methoden für Table 
	public void addCard(Table table, Card card){
		table.add(card);
	}

	public void removeCard(Table table, Card card){
		table.remove(card);
	}
	
	public void add(Card card)
	{
		this.table.add(card);
		//Grob geschrieben
		Image card_Image = card.card_faceup_image;
		ImageView ivTable = new ImageView(card_Image);
	}
	
	public void remove(Card card)
	{
		this.table.remove(card);
	}
	
	public int size()
	{
		return this.table.size();
	}

	public Card get(int currentCard) {
		return table.get(currentCard);
	}

}
