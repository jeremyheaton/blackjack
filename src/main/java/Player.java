package main.java;

public class Player extends BlackJackHand{
	//method for when a player hits
	public void hit(Deck deck){
		Card card = deck.drawCard();
		super.addCard(card);
		System.out.println("You drew a " + card.toString());
	}
	//method to return hand
	public StringBuilder hand(){
		StringBuilder sb = new StringBuilder();
		sb.append("Your hand is: ");
		for (Card c : super.hand) {
			sb.append(c.toString() + " ");
		}
		return sb;
	}
}
