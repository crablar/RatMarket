package ratmarket;
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

public class TwoPlayerGame {

	public final static int GOAL = 1000;
	public final static int STARTING_PRICE = 1 + Utilities.rand.nextInt(9);
	
	public static void main(String[] args) {

		StrategyMap.initialize();
		
		Player alice = new Player("Alice");
		Player bob = new Player("Bob");
		
		alice.strategy = StrategyMap.get(args[0]);
		bob.strategy = StrategyMap.get(args[1]);
		
		printIntro();
		
		int turn = 0;
		
		Player currentPlayer;
		boolean A_TURN = Utilities.rand.nextBoolean();
		currentPlayer = A_TURN ? alice : bob;

		System.out
				.println("Alice and Bob flip a coin.  It is randomly decided that "
						+ currentPlayer.name + " will take the first turn.");
		
		
		// Main game loop
		while (alice.dollars < GOAL && bob.dollars < GOAL) {
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
			
			currentPlayer.takeTurn();
			
			A_TURN = !A_TURN;
			currentPlayer = A_TURN ? alice : bob;
		}
		
		System.out.println("The game is over.  " + currentPlayer + "  is the winner.");
		
	}
	
	static void printIntro() {
		System.out
				.println("The future is an apocalyptic wasteland.  The main source of meat humans find to consume is that of rats.  Your goal is to play the market and buy and sell rats. You and your opponent compete by buying and selling rat holdings.  Every turn there will be market prices to buy and sell rats, as well as a \"rat bucket\" that players bid on.  The rat bucket is initialized as a number between 1 and 10.  A rat is added to it after every turn.\n\nFirst player to $1000 wins.");
	}
	
}
