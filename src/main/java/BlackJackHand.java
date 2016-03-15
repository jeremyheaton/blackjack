package main.java;

import java.util.ArrayList;

public  class BlackJackHand {

	protected int handValue;
	protected ArrayList<Card> hand = new ArrayList<Card>();
	private int badAce;
	//generic hand constructor 
	public BlackJackHand() {

	}
	//adds the card to the hand and accounts for it being an ace or not
	public void addCard(Card card) {
		handValue += card.getValue().getValue();
		if(card.getValue().equals(Value.ACE)){
			badAce++;
		}
		if(badAce > 0 && bust()){
			handValue = handValue - 10;
			badAce--;
		}
		hand.add(card);
	}
	//getter for handvalue
	public int checkValue() {
		return handValue;
	}
	
	//checks to see if hand busted
	public boolean bust() {
		if (handValue > 21) {
			return true;
		} else {
			return false;
		}
	}
	//getter for hand
	public ArrayList<Card> getHand(){
		return hand;
	}
}
