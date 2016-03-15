

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import main.java.BlackJackHand;
import main.java.Card;
import main.java.Dealer;
import main.java.Deck;
import main.java.Player;
import main.java.Suit;
import main.java.Value;

import org.junit.Test;

public class HandTest {

	@Test
	public void test() {
		BlackJackHand hand = new BlackJackHand();
		hand.addCard(new Card(Suit.CLUBS, Value.FIVE));
		assertTrue(hand.getHand().get(0)
				.equals(new Card(Suit.CLUBS, Value.FIVE)));
	}

	@Test
	public void testHandleAces() {
		BlackJackHand hand = new BlackJackHand();
		hand.addCard(new Card(Suit.CLUBS, Value.ACE));
		hand.addCard(new Card(Suit.DIAMONDS, Value.ACE));
		hand.addCard(new Card(Suit.SPADES, Value.ACE));
		hand.addCard(new Card(Suit.SPADES, Value.TEN));
		assertTrue(hand.checkValue() == 13);
	}
	@Test
	public void testHandleAcesAgain() {
		BlackJackHand hand = new BlackJackHand();
		hand.addCard(new Card(Suit.CLUBS, Value.ACE));
		hand.addCard(new Card(Suit.DIAMONDS, Value.ACE));
		hand.addCard(new Card(Suit.SPADES, Value.TEN));
		hand.addCard(new Card(Suit.HEARTS, Value.ACE));
		assertTrue(hand.checkValue() == 13);
	}

	@Test
	public void testNoBust() {
		BlackJackHand hand = new BlackJackHand();
		hand.addCard(new Card(Suit.CLUBS, Value.ACE));
		hand.addCard(new Card(Suit.DIAMONDS, Value.JACK));
		hand.addCard(new Card(Suit.SPADES, Value.KING));
		assertTrue(!hand.bust());
	}

	@Test
	public void testBust() {
		BlackJackHand hand = new BlackJackHand();
		hand.addCard(new Card(Suit.CLUBS, Value.DEUCE));
		hand.addCard(new Card(Suit.DIAMONDS, Value.JACK));
		hand.addCard(new Card(Suit.SPADES, Value.KING));
		assertTrue(hand.bust());
	}

	@Test
	public void testDealerNoHit() {
		Dealer hand = new Dealer();
		hand.addCard(new Card(Suit.CLUBS, Value.DEUCE));
		hand.addCard(new Card(Suit.DIAMONDS, Value.JACK));
		hand.addCard(new Card(Suit.SPADES, Value.KING));
		assertFalse(hand.mustHit());
	}

	@Test
	public void testDealerMustHit() {
		Dealer hand = new Dealer();
		hand.addCard(new Card(Suit.CLUBS, Value.DEUCE));
		assertTrue(hand.mustHit());
	}

	@Test
	public void testDealerHit() {
		Deck deck = new Deck();
		Dealer hand = new Dealer();
		hand.addCard(new Card(Suit.CLUBS, Value.DEUCE));
		hand.hit(deck);
		assertTrue(deck.getDeck().size() < 52);
	}

	@Test
	public void testDealerHand() {
		Dealer hand = new Dealer();
		hand.addCard(new Card(Suit.CLUBS, Value.DEUCE));
		assertEquals(
				new StringBuilder("Dealer's hand is: DEUCE of CLUBS ")
						.toString(),
				hand.hand().toString());
	}

	@Test
	public void testPlayerHand() {
		Player hand = new Player();
		hand.addCard(new Card(Suit.CLUBS, Value.DEUCE));
		assertEquals(
				new StringBuilder("Your hand is: DEUCE of CLUBS ")
						.toString(),
				hand.hand().toString());
	}

	@Test
	public void testPlayerHit() {
		Deck deck = new Deck();
		Player hand = new Player();
		hand.addCard(new Card(Suit.CLUBS, Value.DEUCE));
		hand.hit(deck);
		assertTrue(deck.getDeck().size() < 52);
	}
}
