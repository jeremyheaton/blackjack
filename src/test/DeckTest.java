

import static org.junit.Assert.assertTrue;
import main.java.Card;
import main.java.Deck;
import main.java.Suit;
import main.java.Value;

import org.junit.Test;

public class DeckTest {

	@Test
	public void test() {
		// test to make sure a deck contains all cards.
		Deck deck = new Deck();
		for (Suit suit : Suit.values()) {
			for (Value val : Value.values()) {
				Card card = new Card(suit, val);
				assertTrue(deck.getDeck().contains(card));
			}
		}
	}

	@Test
	public void testDraw() {
		Deck deck = new Deck();
		deck.drawCard();
		assertTrue(deck.getDeck().size() == 51);
		
	}
}
