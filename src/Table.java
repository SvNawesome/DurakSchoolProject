import java.util.ArrayList;

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
