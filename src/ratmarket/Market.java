package ratmarket;
import java.util.ArrayList;

import price_functions.DemandDrivenPriceFunction;
import price_functions.PriceFunction;
;


public class Market {
	
	public final static int STARTING_PRICE = 1 + Utilities.rand.nextInt(9);
	public static final boolean DEBUG = true;
	
	public static PriceFunction priceFunction = new DemandDrivenPriceFunction();
	public static int ratPrice = STARTING_PRICE;
	public static int lastBuyOrder = STARTING_PRICE;
	public static int lastSellOrder = STARTING_PRICE;
	public static int turnsSinceLastBuy = 0;
	public static int turnsSinceLastSell = 0;
	public static RatBucket ratBucket = null;
	
	//  A list of up to 100 of the previous prices
	public static ArrayList<Integer> priceHistory = new ArrayList<Integer>();
	
	/**
	 * Returns a simple String representation of the price history.
	 * 
	 * @return
	 */
	public static String simplePriceHistory(){
		if(priceHistory.isEmpty())
			return "There is no price history.";
		int temp1 = priceHistory.get(0);
		String result = "Price History: " + temp1;
		for(int i = 1; i < priceHistory.size() && i < 5; i++){
			int temp2 = priceHistory.get(i);
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
		priceHistory.add(priceFunction.updatePrice());
		if(priceHistory.size() > 100)
			priceHistory.remove(0);
	}
	
	public static boolean hasUpwardMomentum(){
		return priceFunction.getDirectionalMagnitude() > 0;
	}

	
}
