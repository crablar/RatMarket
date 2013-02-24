import predicates.GlobalPredicateMap;
import ratmarket.Market;
import ratmarket.Player;
import ratmarket.Utilities;
import strategies.StrategyMap;

/**
 * Runs a 2-player game of RatMarket.
 * 
 * @param args
 *            [0] = the name of alice's strategy
 * @param args
 *            [1] = the name of bob's strategy
 * 
 *            example: java TwoPlayerGame nit nit
 * 
 * @author jeffreymeyerson
 * 
 */

public class RatMarket {

	public static void main(String[] args) {
		StrategyMap.initialize();
		Player alice = new Player("Alice");
		Player bob = new Player("Bob");
		alice.strategy = StrategyMap.get("nit");
		bob.strategy = StrategyMap.get("nit");
		int turn = 0;
		Utilities.manageRatBucket();
		Player currentPlayer;
		currentPlayer = Utilities.rand.nextBoolean() ? alice : bob;
		System.out.println("Alice and Bob flip a coin.\n" + currentPlayer.name
				+ " will take the first turn.\n");
		// Main game loop
		while (turn < 1000) {
			turn++;
			Market.updatePrice();
			GlobalPredicateMap.updateAllPredicates();
			if (!(Boolean) GlobalPredicateMap.get("functional market")) {
				System.out.println("Crash the market!!!!!!");
				Utilities.marketCrash();
			}
			Utilities.printTurnDetails(alice, bob, currentPlayer, turn);
			currentPlayer.takeTurn();
			Utilities.manageRatBucket();
			currentPlayer = currentPlayer == bob ? alice : bob;
		}
		int aliceNetWorth = alice.dollars + alice.rats * Market.ratPrice;
		int bobNetWorth = bob.dollars + bob.rats * Market.ratPrice;
		Player winner = aliceNetWorth > bobNetWorth ? alice : bob;
		System.out.println("The game is over.\nBob's net worth is $" + bobNetWorth + "\nAlice's net worth is $" + aliceNetWorth + "\n" + winner.name + " is the winner.");
	}

}
