import java.util.ArrayList;

public class Table {
	ArrayList<Card> table;
	
	public Table()
	{
		this.table = new ArrayList<Card>();	
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

}
