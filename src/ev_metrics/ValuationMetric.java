package ev_metrics;

import java.util.ArrayList;

import ratmarket.Decision;
import ratmarket.Player;

/**
 * ExpectedValueMetrics are expressions of how "good" a Decision is.
 * 
 * A single ExpectedValueMetric is found in every strategy, but
 * ExpectedValueMetric can be subclassed to create hybrids between metric
 * systems.
 * 
 * @author jeffreymeyerson
 * 
 */

public abstract class ValuationMetric {

	public abstract double getExpectedValue(Player player, Decision decision);
	public ArrayList<Integer> history;
	
	public int getMostRecentEV() {
		return history.get(history.size() - 1);
	}
	public abstract int getEffectiveProfit(Player player, Decision decision);

}
