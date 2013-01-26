package ratmarket;
import java.util.Random;


/**
 * Runs a 2-player game of RatMarket. 
 * 		@param args[0] = the name of alice's strategy
 * 		@param args[1] = the name of bob's strategy
 * 
 * @author jeffreymeyerson
 *
 */

public class Main {

	public static void main(String[] args) {

		final int NUM_PLAYERS = 2;
		StrategyMap.initialize();
		
		Player alice = new Player("Alice");
		Player bob = new Player("Bob");
		
		Utilities.characterize(alice, args[0]);
		Utilities.characterize(bob, args[1]);
		
		Utilities.printIntro();
		
		int turn = 0;
		
		Player currentPlayer;
		boolean A_TURN = Utilities.rand.nextBoolean();
		currentPlayer = A_TURN ? alice : bob;

		System.out
				.println("Alice and Bob flip a coin.  It is randomly decided that "
						+ currentPlayer.name + " will take the first turn.");
		
		
		// Main game loop
		while (alice.dollars < 1000 && bob.dollars < 1000) {
			turn++;
			if(Market.ratBucket != null){
				Market.ratBucket.advance();
			}
			else
				Market.ratBucket = Utilities.generateRatBucket();
			
			System.out.println("**********Turn " + turn + ": "+ currentPlayer.name +"begins***********\n");
			System.out.println("----------------------------\n");
			System.out.println("Alice has " + alice.dollars + " dollars and " + alice.rats + " rats.");
			System.out.println("Bob has " + bob.dollars + " dollars and " + bob.rats + " rats.");
			System.out.println("ииииииииииииииииииииииииииии\n");
			System.out.println("The market price of a rat is $" + Market.ratPrice + ".");
			System.out.println(Market.getPriceHistory());
			System.out.println(Market.ratBucket.getInfo());
			System.out.println("----------------------------\n");
			
			currentPlayer.takeTurn(Strategy strategy);
			


			A_TURN = !A_TURN;
			currentPlayer = A_TURN ? alice : bob;
		}
	}
}
