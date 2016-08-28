import java.io.*;
import java.util.*;
public class Game {

	public static void main(String[] args) {
		System.out.println("Poker Game started..\n");
		int numPlayers = 0;
		Player[] players = null; //players in the game (at the table)
		int stackSize = 0;
		boolean noGoodValue = true;
		boolean cont = true;
		Deck deck = new Deck();
		Scanner scan = new Scanner(System.in);
		/*
		 * Get the number of players make sure its more than 1 and less than 6
		 */
		while(noGoodValue) {
			System.out.println("Enter the number of players(<=5)");
			numPlayers = scan.nextInt();
			if(numPlayers <= 0 || numPlayers >5) {
				System.out.println("Please enter a valid number of players");
			}
			else {
				noGoodValue = false;
			}
		}
		System.out.println("Enter number of chips per player"); //currently no error checking
		stackSize = scan.nextInt();
		scan.nextLine();
		players = new Player[numPlayers]; // make a "table" the size of players
		for(int i=0;i<numPlayers;i++) {
			System.out.println("Please enter player's " + (i+1) + " name");
			String name = scan.nextLine();
			players[i] = new Player(name, 5, stackSize);
		}
		/*
		 * Make a pot and put nothing in it
		 * Loop over playing a hand
		 * 
		 */
		int pot =0;
		while (cont) {
			deck.betterShuffle();
			int winner = 0;
			int highValue = 0;
			for(int i=0;i<numPlayers;i++){
				players[i].Deal(deck);
			}
			for(int i=0;i<numPlayers;i++) {
				players[i].DisplayHand();
				int thisValue = PokerHand.handValue( players[i].getHand() );
				System.out.println("With hand value " + thisValue);
				if(thisValue > highValue) {
					highValue = thisValue;
					winner = i;
				}
				System.out.println("Place player " + (i+1) + "'s bet");
				int bet = scan.nextInt();
				scan.nextLine();
				players[i].bet(bet);
				pot += bet;
			}
			System.out.println("Winner is " + players[winner].name + ", they win " + pot + " chips");
			players[winner].adjustStack(pot);
			pot = 0;
			System.out.println("Cont? Y/N");
			String more = scan.nextLine();
			System.out.println(more);
			if(more.equals("N")) {
				cont = false;
			}
		}
		scan.close();
	}
}
