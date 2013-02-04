package price_functions;

import java.util.ArrayList;

import ratmarket.Market;
import ratmarket.Utilities;

/**
 * A PriceFunction that moves according to the changes in the Market and
 * GlobalPredicateMap.
 * 
 * @author jeffreymeyerson
 * 
 */

public class DemandDrivenPriceFunction extends PriceFunction {
	
	public DemandDrivenPriceFunction(){
		priceDirectionalMagnitude = 0;
		magnitudeHistory = new ArrayList<Integer>();
	}
	
	/**
	 * Calculates and returns an updated price.  Modifies the Market price.
	 * 
	 * @return
	 */
	public int updatePrice() {
		if (Market.priceHistoryLong.isEmpty())
			return Market.STARTING_PRICE;
		ArrayList<Integer> priceHistory = Utilities.trimPriceHistory(50);
		int movingAverage = Utilities.getAverage(priceHistory);
		int lastBuyTimestamp = Market.turnsSinceLastBuy;
		int lastSellTimestamp = Market.turnsSinceLastSell;
		priceDirectionalMagnitude = lastSellTimestamp - lastBuyTimestamp;
		
		priceDirectionalMagnitude = getDirectionalMagnitude();
		
		if (priceDirectionalMagnitude < 0 && priceDirectionalMagnitude + Market.ratPrice > 0) {
			if (Market.ratPrice > movingAverage)
				// Note that priceDirectionalMagnitude should be negative here
				Market.ratPrice += priceDirectionalMagnitude;
			else
				Market.ratPrice--;
		}
		if (priceDirectionalMagnitude > 0) {
			if (Market.ratPrice < movingAverage)
				Market.ratPrice += priceDirectionalMagnitude;
			else
				Market.ratPrice++;
		}
		// If the market is sideways, the price gets decremented
		return Market.ratPrice;
	}
	
	public int getDirectionalMagnitude(){
	//  If price has no momentum, create momentum of rand{0..10}
	if(priceDirectionalMagnitude == 0)
		priceDirectionalMagnitude = Utilities.rand.nextInt(10) - 5; 
	return priceDirectionalMagnitude;
	}

}
