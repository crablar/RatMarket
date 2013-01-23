import java.util.Random;

public class Main {

	static Random rand = new Random();

	public static void main(String[] args) {

		int turn = 1;
		
		Player alice = new Player("Alice");
		Player bob = new Player("Bob");
		
		Player currentPlayer;
		boolean A_TURN = rand.nextBoolean();
		currentPlayer = A_TURN ? alice : bob;

		System.out
				.println("Alice and Bob flip a coin.  It is randomly decided that "
						+ currentPlayer.name + " will take the first turn.");

		RatBucket ratBucket = new RatBucket();
		
		// Main game loop
		while (alice.dollars < 1000 && bob.dollars < 1000) {

			System.out.println("**********Turn " + turn + ": Alice begins***********\n");
			System.out.println("----------------------------\n");
			System.out.println("Alice has " + alice.dollars + " dollars and " + alice.rats + " rats.");
			System.out.println("Bob has " + bob.dollars + " dollars and " + bob.rats + " rats.");
			System.out.println("ииииииииииииииииииииииииииии\n");
			System.out.println("The market price of a rat is $" + Market.price + ".");
			System.out.println(Market.getPriceHistory());
			System.out.println(ratBucket.getInfo());
			System.out.println("----------------------------\n");


			A_TURN = !A_TURN;
			currentPlayer = A_TURN ? alice : bob;
			if(ratBucket != null){
				ratBucket.advance();
			}
			else
				ratBucket = new RatBucket();
			turn++;
		}
	}
}
