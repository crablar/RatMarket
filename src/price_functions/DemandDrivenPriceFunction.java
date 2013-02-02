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

	/**
	 * Calculates and returns an updated price.
	 * 
	 * @return
	 */
	public int updatePrice() {
		if (Market.priceHistory.isEmpty())
			return Market.STARTING_PRICE;

		ArrayList<Integer> priceHistory = Utilities.trimPriceHistory(50);
		int movingAverage = Utilities.getAverage(priceHistory);
		int lastBuyTimestamp = Market.turnsSinceLastBuy;
		int lastSellTimestamp = Market.turnsSinceLastSell;
		int priceDirectionalMagnitude = lastSellTimestamp - lastBuyTimestamp;

		if (priceDirectionalMagnitude < 0) {
			if (Market.ratPrice > movingAverage)
				// Note that priceDirectionalMagnitude should be negative here
				return Market.ratPrice += priceDirectionalMagnitude;
			else
				return Market.ratPrice--;
		}
		if (priceDirectionalMagnitude > 0) {
			if (Market.ratPrice < movingAverage)
				return Market.ratPrice += priceDirectionalMagnitude;
			else
				return Market.ratPrice++;
		}
		// If the market is sideways, the price gets decremented
		return Market.ratPrice--;
	}

}
