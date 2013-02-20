package ratmarket;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Utilities {

	public static Random rand = new Random();

	public static RatBucket generateRatBucket() {
		int numRats = 1 + rand.nextInt(10);
		int price = 5 * Market.ratPrice;
		int expiration = rand.nextInt(10);
		double eor = 1.0 * expiration / numRats;
		// If it expires quickly but has many rats, it is cheap
		int bucketPrice = (int) (price * eor);

		return new RatBucket(numRats, bucketPrice, expiration);
	}

	public static void manageRatBucket() {
		if (Market.ratBucket == null
				|| Market.ratBucket.turnsTilExpiration == 0){
			Market.ratBucket = Utilities.generateRatBucket();}
		else
			Market.ratBucket.advance();
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

	public static void printTurnDetails(Player alice, Player bob,
			Player currentPlayer, int turn) {
		System.out.println("**********Turn " + turn + ": " + currentPlayer.name
				+ " begins***********");
		System.out.println("Alice: $" + alice.dollars + " and " + alice.rats
				+ " rats.");
		System.out.println("Bob $" + bob.dollars + " and " + bob.rats
				+ " rats.");
		System.out.println("Price of a rat: $" + Market.ratPrice + ".");
		System.out.println(Market.simplePriceHistory());
		if (Market.ratBucket != null)
			System.out.println(Market.ratBucket.getInfo());
	}

	public static void marketCrash() {
		Market.ratPrice = 1;
	}

}
