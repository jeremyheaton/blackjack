package main.java;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
	private ArrayList<Card> deck = new ArrayList<Card>();
	 //deck constructor
	  public Deck ()
	  {
		  for (Suit suit : Suit.values()) {
			  for (Value val : Value.values()) {
				  Card card = new Card(suit, val);
			        this.deck.add(card);
			  }
			}
		  shuffleDeck();
	  }
	  //wrap interfaces default shuffle method
	  public void shuffleDeck(){
		  Collections.shuffle(deck);
	  }
	  // takes the first card out of the deck and returns it
	  public Card drawCard(){
		  Card card = deck.get(0);
		  deck.remove(0);
		return card;
		  
	  }
	  //deck getter
	  public ArrayList<Card> getDeck(){
		  return deck;
	  }
	  
	  
}
