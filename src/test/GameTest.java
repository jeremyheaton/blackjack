

import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import main.java.BlackJackGame;
import main.java.Card;
import main.java.Dealer;
import main.java.Deck;
import main.java.Player;
import main.java.Suit;
import main.java.Value;

import org.junit.Test;

public class GameTest {

	@Test
	public void test() {
		Dealer dealer = new Dealer();
		Player player = new Player();
		Deck deck = new Deck();
		dealer.addCard(deck.drawCard());
		player.addCard(deck.drawCard());
		BlackJackGame game = new BlackJackGame(dealer, player, deck);
		assertTrue(game.getDealer() == dealer);
		assertTrue(game.getPlayer() == player);
		assertTrue(game.getDeck() == deck);
	}

	@Test
	public void testDealHands() {
		Dealer dealer = new Dealer();
		Player player = new Player();
		Deck deck = new Deck();
		BlackJackGame game = new BlackJackGame(dealer, player, deck);
		game.dealHands();
		assertTrue(deck.getDeck().size() == 48);
		assertTrue(game.getPlayer().getHand().size() == 2);
		assertTrue(game.getDealer().getHand().size() == 2);
	}

	@Test
	public void testPlayerWin() {
		Dealer dealer = new Dealer();
		Player player = new Player();
		player.addCard(new Card(Suit.CLUBS, Value.ACE));
		player.addCard(new Card(Suit.CLUBS, Value.KING));
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		Deck deck = new Deck();
		BlackJackGame game = new BlackJackGame(dealer, player, deck);
		game.declareWinner();
		assertTrue(outContent.toString().equals("You Win!\r\n"));
	}

	@Test
	public void testPlayerLoss() {
		Dealer dealer = new Dealer();
		Player player = new Player();
		player.addCard(new Card(Suit.SPADES, Value.KING));
		player.addCard(new Card(Suit.CLUBS, Value.KING));
		player.addCard(new Card(Suit.DIAMONDS, Value.KING));
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		Deck deck = new Deck();
		BlackJackGame game = new BlackJackGame(dealer, player, deck);
		game.declareWinner();
		assertTrue(outContent.toString().equals("You Lose!\r\n"));
	}
	@Test
	public void testPlayerTie() {
		Dealer dealer = new Dealer();
		Player player = new Player();
		ByteArrayOutputStream outContent = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outContent));
		Deck deck = new Deck();
		BlackJackGame game = new BlackJackGame(dealer, player, deck);
		game.declareWinner();
		assertTrue(outContent.toString().equals("Tie!\r\n"));
	}
}
