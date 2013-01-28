package ratmarket;


import java.util.Random;

public class Utilities {

	static Random rand = new Random();

	// The RatBucket is initialized with r rats, where r is in int from 1 to 100.  The price of the ratbucket price is initialized to x, where x = 1/4 * ((random int between 1 and 8) * (market price of a rat) * r
	static RatBucket generateRatBucket(){
		int r = rand.nextInt(101);
		int mktPrice = Market.ratPrice;
		int multiple = rand.nextInt(9);
		int x = (r * mktPrice * multiple) / 4;
		return new RatBucket(r, x);
	}
	
}
