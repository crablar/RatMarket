
import java.util.Random;

import predicates.GlobalPredicateMap;

import ratmarket.Market;
import ratmarket.Player;
import ratmarket.Utilities;
import strategies.StrategyMap;


/**
 * Runs a 2-player game of RatMarket. 
 * 		@param args[0] = the name of alice's strategy
 * 		@param args[1] = the name of bob's strategy
 * 
 * 		example: java TwoPlayerGame nit nit
 * 
 * @author jeffreymeyerson
 *
 */

public class RatMarket {

	public final static int GOAL = 1000;
	
	public static void main(String[] args) {
		StrategyMap.initialize();
		Player alice = new Player("Alice");
		Player bob = new Player("Bob");
		alice.strategy = StrategyMap.get("nit");
		bob.strategy = StrategyMap.get("nit");
		printIntro();
		int turn = 0;
		Player currentPlayer;
		boolean A_TURN = Utilities.rand.nextBoolean();
		currentPlayer = A_TURN ? alice : bob;
		System.out
				.println("Alice and Bob flip a coin.  It is randomly decided that "
						+ currentPlayer.name + " will take the first turn.\n");
		// Main game loop
		while (alice.dollars < GOAL && bob.dollars < GOAL && turn < 10) {
			turn++;
			
			//TODO: this update should be moved to Market
			if(Market.ratBucket != null){
				Market.ratBucket.advance();
			}
			else
				Market.ratBucket = Utilities.generateRatBucket();
			
			Market.updatePrice();
			GlobalPredicateMap.updateAllPredicates();
			printTurnDetails(alice, bob, currentPlayer, turn);
			currentPlayer.takeTurn();
			A_TURN = !A_TURN;
			currentPlayer = A_TURN ? alice : bob;
		}
		System.out.println("The game is over.  " + currentPlayer.name + "  is the winner.");
	}
	
	static void printTurnDetails(Player alice, Player bob, Player currentPlayer, int turn){
		System.out.println("**********Turn " + turn + ": "+ currentPlayer.name +" begins***********");
		System.out.println("----------------------------");
		System.out.println("Alice: $" + alice.dollars + " and " + alice.rats + " rats.");
		System.out.println("Bob $" + bob.dollars + " and " + bob.rats + " rats.");
		System.out.println("Price of a rat: $" + Market.ratPrice + ".");
		System.out.println(Market.simplePriceHistory());
		System.out.println(Market.ratBucket.getInfo());
		System.out.println("----------------------------\n");
	}
	
	static void printIntro() {
		System.out
				.println("The future is an apocalyptic wasteland.  The main source of meat humans find to consume is that of rats.  Your goal is to play the market and buy and sell rats. You and your opponent compete by buying and selling rat holdings.  Every turn there will be market prices to buy and sell rats, as well as a \"rat bucket\" that players bid on.  The rat bucket is initialized as a number between 1 and 10.  A rat is added to it after every turn.\n\nFirst player to $1000 wins.");
	}
	
}
