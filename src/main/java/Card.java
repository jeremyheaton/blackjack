package main.java;

public class Card {

	private Suit suit;
	private Value value;

	//card constructor
	public Card(Suit suit, Value value) {
		this.suit = suit;
		this.value = value;
	}
	//suit getter
	public Suit getSuit() {
		return suit;
	}
	//value getter
	public Value getValue() {
		return value;
	}
	//over ride toString method
	@Override
	public String toString() {
		return value + " of " + suit;
	}
	//override equls since two cards are equal if they have the same suit and value
	public boolean equals(Object o) {
		//cards are equal if suit and value are both equal
		if (o instanceof Card) {
			Card toCompare = (Card) o;
			return this.suit.equals(toCompare.suit) && this.value.equals(toCompare.value);
		}
		return false;
	}
	//override hashCode because equals requires it
	@Override
	public int hashCode() {
	    return hashCode();
	}
}