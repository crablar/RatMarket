package strategies;

import ratmarket.Decision;
import ratmarket.Player;
import ev_metrics.ExpectedValueMetric;

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

	public ExpectedValueMetric expectedValueMetric;

	public abstract Decision generateDecision(int rats, int dollars,
			Player player);

}
