package strategies;

import ratmarket.Decision;
import ratmarket.Player;
import ev_metrics.ValuationMetric;

/**
 * The Strategy class. A strategy takes predicates from the PersonalPredicateMap
 * and GlobalPredicateMap, which describe the game state.
 * 
 * Built to scale so that a Player can implement hybrid strategies eventually.
 * 
 * @author jeffreymeyerson
 * 
 */

public abstract class Strategy {

	/**
	 * The Strategy uses a single ExpectedValueMetric.
	 */
	public ValuationMetric expectedValueMetric;

	/**
	 * Generates a decision for a given player.
	 * 
	 * @param player
	 * @return
	 */
	public abstract Decision generateDecision(Player player);

}
