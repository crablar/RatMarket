package ratmarket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utilities {

	public static Random rand = new Random();

	// The RatBucket is initialized with r rats, where r is in int from 1 to 10.
	// The price of the ratbucket price is initialized to x, where x = 1/4 *
	// ((random int between 1 and 8) * (market price of a rat) * r
	public static RatBucket generateRatBucket() {
		int r = 1 + rand.nextInt(10);
		int mktPrice = Market.ratPrice;
		int multiple = rand.nextInt(9);
		int x = r + ((r - 1) * mktPrice * multiple) / 4;
		return new RatBucket(r, x);
	}

	public static void manageRatBucket() {
		if (Market.ratBucket != null) {
			Market.ratBucket.advance();
		} else
			Market.ratBucket = Utilities.generateRatBucket();
	}

	public static ArrayList<Integer> trimPriceHistory(int maxSize) {
		ArrayList<Integer> priceHistory;
		if (Market.priceHistoryLong.size() < 51)
			priceHistory = Market.priceHistoryLong;
		else {
			List<Integer> sublist = Market.priceHistoryLong.subList(
					Market.priceHistoryLong.size() - maxSize,
					Market.priceHistoryLong.size());
			priceHistory = new ArrayList<Integer>(sublist);
		}
		return priceHistory;
	}

	public static int getAverage(ArrayList<Integer> priceHistory) {
		if (priceHistory == null)
			return 0;
		// Take average of last 50 points, or up to 50 depending on how many
		// turns have passed
		int total = 0;
		int count = 0;
		for (Integer i : priceHistory) {
			total += i;
			count++;
		}
		return total / count;
	}
	
	public static void printTurnDetails(Player alice, Player bob, Player currentPlayer, int turn){
		System.out.println("**********Turn " + turn + ": "+ currentPlayer.name +" begins***********");
		System.out.println("Alice: $" + alice.dollars + " and " + alice.rats + " rats.");
		System.out.println("Bob $" + bob.dollars + " and " + bob.rats + " rats.");
		System.out.println("Price of a rat: $" + Market.ratPrice + ".");
		System.out.println(Market.simplePriceHistory());
		System.out.println(Market.ratBucket.getInfo());
	}

}
