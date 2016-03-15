



import static org.junit.Assert.assertTrue;
import main.java.Card;
import main.java.Suit;
import main.java.Value;

import org.junit.Test;

public class CardTest {

	@Test
	public void test() {
		Card card = new Card(Suit.CLUBS, Value.ACE);
		assertTrue(card.getValue().getValue() == 11);
		assertTrue(card.getSuit().name().equals("CLUBS"));
	}

}
