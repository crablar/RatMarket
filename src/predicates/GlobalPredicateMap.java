package predicates;

import java.util.HashMap;
import java.util.Map.Entry;

import ratmarket.Market;

/**
 * The GlobalPredicateMap keeps track of predicates that describe the global
 * game state.
 * 
 * @author jeffreymeyerson
 * 
 */

public class GlobalPredicateMap {

	public static HashMap<String, Object> map = new HashMap<String, Object>();

	public static Object get(String predicate) {
		return map.get(predicate);
	}

	public static void updatePredicate(String predicateName, Object state) {
		map.put(predicateName, state);
	}

	public static void updateAllPredicates() {
		checkMarketFunctionality();
		updateDowntrendUptrend();
	}

	/**
	 * Checks to make sure there hasn't been an excessive amount of time without
	 * any decisions being made.
	 */
	private static void checkMarketFunctionality() {
		boolean functionalMarket = true;
		if(Market.turnsSinceLastBuy > 10 && Market.turnsSinceLastSell > 10)
			if(Market.consecutiveExpiredRatBuckets > 10)
				functionalMarket = true;
		map.put("functional market", functionalMarket);
	}

	public static void updateDowntrendUptrend() {
		if (Market.hasUpwardMomentum()) {
			Integer numConsecutiveUptrends = map
					.get("number of consecutive uptrends") == null ? 0
					: ((Integer) map.get("number of consecutive uptrends") + 1);
			updatePredicate("number of consecutive uptrends",
					numConsecutiveUptrends);
			updatePredicate("number of consecutive downtrends", 0);

		} else {
			Integer numConsecutiveDowntrends = map
					.get("number of consecutive downtrends") == null ? 0
					: ((Integer) map.get("number of consecutive downtrends") + 1);
			updatePredicate("number of consecutive downtrends",
					numConsecutiveDowntrends);
			updatePredicate("number of consecutive uptrends", 0);
		}
	}

	public static void printGlobalState() {
		for (Entry<String, Object> e : map.entrySet())
			System.out.println(e.getKey() + ": " + e.getValue());
	}

}
