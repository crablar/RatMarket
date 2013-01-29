package ev_metrics;

import ratmarket.Decision;
import ratmarket.Player;

/**
 * ExpectedValueMetrics are simple expressions of how "good" a play is to that player.
 * 
 * A single ExpectedValueMetric is found in every strategy, but
 * ExpectedValueMetric can be subclassed to create hybrids between metric
 * systems.
 * 
 * @author jeffreymeyerson
 * 
 */

public interface ExpectedValueMetric {

	public double getExpectedValue(Player player, Decision decision);

}
