package price_functions;

import java.util.ArrayList;

import ratmarket.Market;
import ratmarket.TwoPlayerGame;
import ratmarket.Utilities;

/**
 * A PriceFunction that moves according to the changes in the
 * GlobalPredicateMap.
 * 
 * @author jeffreymeyerson
 * 
 */

public class DemandDrivenPriceFunction extends PriceFunction {

	public int calculatePrice() {
		if (Market.priceHistory.get(0) == null)
			return TwoPlayerGame.STARTING_PRICE;

		ArrayList<Integer> priceHistory = Utilities.trimPriceHistory(50);
		int movingAverage = Utilities.getAverage(priceHistory);
		int lastBuyTimestamp = Market.turnsSinceLastBuy;
		int lastSellTimestamp = Market.turnsSinceLastSell;
		int priceDirectionalMagnitude = lastSellTimestamp - lastBuyTimestamp;

		int result = 0;

		if (priceDirectionalMagnitude < 0) {
			if (Market.ratPrice > movingAverage)
				Market.ratPrice += priceDirectionalMagnitude;
			else
				Market.ratPrice--;

		}

		return result;
	}

}
