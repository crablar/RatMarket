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
		negativeMagnitude = 0;
		positiveMagnitude = 0;
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
		calculateDirectionalMagnitude();
		Market.movingAverage = Utilities.getAverage(priceHistory);
		changePriceByMagnitude();
		return Market.ratPrice;
	}

	private void changePriceByMagnitude() {
		int price = Market.ratPrice;
		int distFromAverage = Math.abs(price - Market.movingAverage);
		distFromAverage = distFromAverage == 0 ? 1 : distFromAverage;
		// A price far from the average is difficult to push further
		int scaledMagnitude = priceDirectionalMagnitude / distFromAverage;
		Market.ratPrice += scaledMagnitude;
	}

	public void calculateDirectionalMagnitude() {
		positiveMagnitude = Market.turnsSinceLastSell * Market.lastBuyOrder;
		negativeMagnitude = Market.turnsSinceLastBuy * Market.lastSellOrder;
		priceDirectionalMagnitude += positiveMagnitude - negativeMagnitude;
		priceDirectionalMagnitude = Math.min(100, priceDirectionalMagnitude);
		priceDirectionalMagnitude = Math.max(-100, priceDirectionalMagnitude);
		// If price has no momentum, create momentum of rand{-2..2}
		while (priceDirectionalMagnitude == 0)
			priceDirectionalMagnitude = Utilities.rand.nextInt(5) - 2;
	}

}
