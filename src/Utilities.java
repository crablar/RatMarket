

import java.util.Random;

public class Utilities {

	static Random rand = new Random();
	
	static void printIntro() {
		System.out
				.println("The future is an apocalyptic wasteland.  The main source of meat humans find to consume is that of rats.  Your goal is to play the market and buy and sell rats. You and your opponent compete by buying and selling rat holdings.  Every turn there will be market prices to buy and sell rats, as well as a \"rat bucket\" that players bid on.  The rat bucket is initialized as a number between 1 and 10.  A rat is added to it after every turn.\n\nFirst player to $1000 wins.");
	}

	// The RatBucket is initialized with r rats, where r is in int from 1 to 100.  The price of the ratbucket price is initialized to x, where x = 1/4 * ((random int between 1 and 8) * (market price of a rat) * r
	static RatBucket generateRatBucket(){
		int r = rand.nextInt(101);
		int mktPrice = Market.ratPrice;
		int multiple = rand.nextInt(9);
		int x = (r * mktPrice * multiple) / 4;
		return new RatBucket(r, x);
	}

	public static void characterize(Player player, String string) {
		player.strategy = StrategyMap.get(string);
		
	}
	
}
