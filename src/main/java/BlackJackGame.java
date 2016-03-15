package main.java;

import java.util.Scanner;

public class BlackJackGame {
	Dealer dealer;
	Player player;
	Deck deck;
	
	//constructor for the game
	public BlackJackGame(Dealer dealer, Player player, Deck deck) {
		this.dealer = dealer;
		this.player = player;
		this.deck = deck;
	}
	//method to run the game
	public void run() {
		dealHands();
		if (playersTurn()) {
			declareWinner();
		} else {
			dealersTurn();
			declareWinner();
			System.out.println("You had " + player.checkValue()
					+ " and the dealer had " + dealer.checkValue());
		}

	}
	//method that plays out the dealers turn
	public void dealersTurn() {
		dealer.hit(deck);
	}
	//method that encompasses the players turn
	public boolean playersTurn() {
		while (!player.bust()) {
			System.out.println("'hit' or 'stay'?");
			Scanner scan = new Scanner(System.in);
			String option = scan.nextLine();
			if (option.equalsIgnoreCase("hit")) {
				player.hit(deck);

			} else {
				break;
			}
		}
		return player.bust();

	}
	//deals the players hands
	public void dealHands() {
		player.addCard(deck.drawCard());
		dealer.addCard(deck.drawCard());
		player.addCard(deck.drawCard());
		dealer.addCard(deck.drawCard());
		System.out.println(dealer.hand());
		System.out.println(player.hand());
	}
	//method to determine the winner of the game
	public void declareWinner() {
		if ((player.checkValue() > dealer.checkValue() && !player.bust())
				|| (dealer.bust())) {
			System.out.println("You Win!");
		} else if (dealer.checkValue() == player.checkValue()) {
			System.out.println("Tie!");
		} else {
			System.out.println("You Lose!");
		}
	}

	

	// methods strictly used for testing the class
	public Dealer getDealer() {
		return dealer;
	}

	public Player getPlayer() {
		return player;
	}

	public Deck getDeck() {
		return deck;
	}
}
