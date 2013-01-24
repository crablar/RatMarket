import java.util.Random;

public class Main {
	
	public static void main(String[] args) {

		Utilities.printIntro();
		
		int turn = 0;
		
		Player alice = new Player("Alice");
		Player bob = new Player("Bob");
		
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
			
			currentPlayer.takeTurn();
			


			A_TURN = !A_TURN;
			currentPlayer = A_TURN ? alice : bob;
		}
	}
	
}
