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

	public final static int GOAL = 500;

	public static void main(String[] args) {
		StrategyMap.initialize();
		Player alice = new Player("Alice");
		Player bob = new Player("Bob");
		alice.strategy = StrategyMap.get("nit");
		bob.strategy = StrategyMap.get("nit");
		int turn = 0;
		Player currentPlayer;
		currentPlayer = Utilities.rand.nextBoolean() ? alice : bob;
		System.out
				.println("Alice and Bob flip a coin.  It is randomly decided that "
						+ currentPlayer.name + " will take the first turn.\n");
		// Main game loop
		while (alice.dollars < GOAL && bob.dollars < GOAL && turn < 100) {
			turn++;
			Market.updatePrice();
			Utilities.manageRatBucket();
			GlobalPredicateMap.updateAllPredicates();
			if(!(Boolean)GlobalPredicateMap.get("functional market")){
				System.out.println("Crash the market!!!!!!");
				Utilities.marketCrash();
			}
			// GlobalPredicateMap.printGlobalState();
			Utilities.printTurnDetails(alice, bob, currentPlayer, turn);
			currentPlayer.takeTurn();
			currentPlayer = currentPlayer == bob ? alice : bob;
		}
		System.out.println("The game is over.  " + currentPlayer.name
				+ "  is the winner.");
	}

}
