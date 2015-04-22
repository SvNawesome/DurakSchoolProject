package cardAssignment;
import java.io.*;
import java.util.*;

public class Assignment {
	
	// Kartenname in ein Array speichern
	
	public static final String[] ranks =
		{
		"6",
		"7",
		"8",
		"9",
		"10",
		"Jack",
		"Queen",
		"King",
		"Ace"
		};

	
	// Kartenwerte
	// Hashmap Erstellen (Key + Value) mit der For-Schleife das Array mit den Namen durchgehen und es als Key setzen
	// und jedem Key einen Wert zu weisen um Damit später einfachere vergleiche durchzuführen
	
	public static void cardValues()
	{
		Map<String, Integer> cardMap = new HashMap<String, Integer>();
		for(int i = 6;i < 15;i++)
		{
			cardMap.put(ranks[i-6], i);
		}
		
		//zum Testen wird die Map durchgegangen für jeden gesetzen Key
		for(String key: cardMap.keySet())
		{
			System.out.print("Key: " + key + " - ");
			System.out.println("Value: " + cardMap.get(key) + "\n");
		}

	}
	
	// Karten Symbole Herz, Karo, Pik, Kreuz in Array speichern
	public static final String[] suits =
		{
			"Spades",
			"Clubs",
			"Hearts",
			"Diamonds"
		};
		
	// Karten Farbe
	// Karten Symbole (als Key), den passenden Farben zuordnen
	public static void suitColors()
	{
		Map<String, String> colorMap = new HashMap<String, String>();
			colorMap.put("Spades", "black");
			colorMap.put("Clubs", "black");
			colorMap.put("Hearts", "red");
			colorMap.put("Diamonds", "red");
			
			
		// Zum Testen der Zuordnung
		for(String key: colorMap.keySet())
		{
			System.out.print("Key: " + key + " - ");
			System.out.println("Value: " + colorMap.get(key) + "\n");
		}
	}

	
	//zum Testen
	/*
	 
	public static void main(String[] argv)
	{
		Assignment.cardValues();
		Assignment.suitColors();
	}
	
	*/
}

