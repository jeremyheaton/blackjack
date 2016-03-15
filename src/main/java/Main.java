package main.java;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		while (true) {
			BlackJackGame game = new BlackJackGame(new Dealer(), new Player(),
					new Deck());
			game.run();
			System.out.println("play again? y/n");
			Scanner scan = new Scanner(System.in);
			String option = scan.nextLine();
			if (option.equalsIgnoreCase("n")) {
				break;
			}
		}
	}
}
