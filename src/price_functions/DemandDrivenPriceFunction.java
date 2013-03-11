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

	public DemandDrivenPriceFunction() {
		priceDirectionalMagnitude = 0;
		magnitudeHistory = new ArrayList<Integer>();
	}

	/**
	 * Calculates and returns an updated price. Modifies the Market price.
	 * 
	 * @return
	 */
	public int updatePrice() {
		if (Market.priceHistoryLong.isEmpty())
			return Market.STARTING_PRICE;
		ArrayList<Integer> priceHistory = Utilities.trimPriceHistory(50);
		Market.movingAverage = Utilities.getAverage(priceHistory);
		priceDirectionalMagnitude = getDirectionalMagnitude();
		System.out.println("PriceDirectionalMagnitude = "
				+ priceDirectionalMagnitude + "\n");
		if (priceDirectionalMagnitude < 0) {
			if (Market.ratPrice > Market.movingAverage)
				Market.ratPrice = Math.max(1, Market.ratPrice + priceDirectionalMagnitude);
			else
				Market.ratPrice = Math.max(1, Market.ratPrice - 1);
		}
		if (priceDirectionalMagnitude > 0) {
			if (Market.ratPrice < Market.movingAverage)
				Market.ratPrice += priceDirectionalMagnitude;
			else
				Market.ratPrice++;
		}
		return Market.ratPrice;
	}

	public int getDirectionalMagnitude() {

		int positiveMomentum = Market.turnsSinceLastSell * Market.lastBuyOrder;
		int negativeMomentum = Market.turnsSinceLastBuy * Market.lastSellOrder ;
		priceDirectionalMagnitude += positiveMomentum - negativeMomentum;
		priceDirectionalMagnitude = Math.min(100, priceDirectionalMagnitude);
		priceDirectionalMagnitude = Math.max(-100, priceDirectionalMagnitude);
		// If price has no momentum, create momentum of rand{-2..2}
		while (priceDirectionalMagnitude == 0)
			priceDirectionalMagnitude = Utilities.rand.nextInt(5) - 2;
		return priceDirectionalMagnitude;
	}

}
