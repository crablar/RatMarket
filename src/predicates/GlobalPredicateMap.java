package predicates;

import java.util.HashMap;

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

	// TODO
	public static void updateAllPredicates() {
		updateDowntrendUptrend();
	}

	public static void updateDowntrendUptrend() {
		if (Market.hasUpwardMomentum()) {
			Integer numConsecutiveUptrends = map.get("number of uptrends") == null ? 0
					: ((Integer) map.get("number of uptrends") + 1);
			updatePredicate("number of consecutive uptrends",
					numConsecutiveUptrends);
			updatePredicate("number of consecutive downtrends", 0);

		} else {
			Integer numConsecutiveDowntrends = map.get("number of downtrends") == null ? 0
					: ((Integer) map.get("number of downtrends") - 1);
			updatePredicate("number of consecutive downtrends",
					numConsecutiveDowntrends);
			updatePredicate("number of consecutive uptrends", 0);
		}
	}

}
