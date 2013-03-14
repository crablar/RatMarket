package ratmarket;
import java.util.ArrayList;

import price_functions.DemandDrivenPriceFunction;
import price_functions.PriceFunction;
;


public class Market {
	
	public final static int STARTING_PRICE = 1 + Utilities.rand.nextInt(9);	
	public static PriceFunction priceFunction = new DemandDrivenPriceFunction();
	public static int ratPrice = STARTING_PRICE;
	public static int lastBuyOrder = STARTING_PRICE;
	public static int lastSellOrder = STARTING_PRICE;
	public static int turnsSinceLastBuy = 0;
	public static int turnsSinceLastSell = 0;
	public static int consecutiveExpiredRatBuckets = 0;
	public static RatBucket ratBucket = null;
	public static int movingAverage = STARTING_PRICE;

	//  A list of up to 100 of the previous prices
	public static ArrayList<Integer> priceHistoryLong = new ArrayList<Integer>();
	public static int marketLiquidity = 100;
	
	/**
	 * Returns a simple String representation of the price history.
	 * 
	 * @return
	 */
	public static String simplePriceHistory(){
		if(priceHistoryLong.isEmpty())
			return "There is no price history.";
		int startingIndex = Math.max(0, priceHistoryLong.size() - 5);
		int temp1 = priceHistoryLong.get(startingIndex++);
		String result = "Price History: " + temp1;
		for(int i = startingIndex; i < priceHistoryLong.size() && i < startingIndex + 4; i++){
			int temp2 = priceHistoryLong.get(i);
			char marketDirection = 'v';
			if(temp2 > temp1)
				marketDirection = '^';
			else if(temp2 == temp1)
				marketDirection = '=';
			temp1 = temp2;
			result += " " + marketDirection + " " + temp2;
		}
		return result;
	}
	
	public static void updatePrice(){
		priceHistoryLong.add(priceFunction.updatePrice());
		if(priceHistoryLong.size() > 100)
			priceHistoryLong.remove(0);
	}
	
	public static boolean hasUpwardMomentum(){
		return priceFunction.calculateDirectionalMagnitude() > 0;
	}
	
	public static boolean hasDownwardMomentum(){
		return priceFunction.calculateDirectionalMagnitude() < 0;
	}
	
	public static void wipeHistory(){
		priceHistoryLong = new ArrayList<Integer>();
		priceHistoryLong.add(1);
		priceHistoryLong.add(3);
		priceHistoryLong.add(2);
		priceHistoryLong.add(3);
		priceHistoryLong.add(2);
	}

	
}
