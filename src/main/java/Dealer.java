package main.java;

public class Dealer extends BlackJackHand {
	//method that allows the dealer to hit
	public void hit(Deck deck) {
		if (mustHit()) {
			while (mustHit()) {
				Card card = deck.drawCard();
				super.addCard(card);
				System.out.println("Dealer drew a " + card.toString());
			}
		}
	}
	//checks to see if the dealer has to hit or stay
	public boolean mustHit() {
		if (super.checkValue() > 17) {
			return false;
		} else {
			return true;
		}
	}
	//returns the dealers hand
	public StringBuilder hand() {
		StringBuilder sb = new StringBuilder();
		sb.append("Dealer's hand is: ");
		for (Card c : super.hand) {
			sb.append(c.toString() + " ");
		}
		return sb;
	}
}
