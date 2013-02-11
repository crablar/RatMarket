package ev_metrics;

import java.util.ArrayList;

import ratmarket.Decision;
import ratmarket.Market;
import ratmarket.Player;

/**
 * A short term outlook that allows comparison of a rat bucket purchase to a buy
 * or sell order.
 * 
 * @author jeffreymeyerson
 * 
 *         TODO: this class is just scalability right now; doesn't do anything
 *         relevant.
 * 
 */

public class ShortTermOutlook extends ValuationMetric {

	public ShortTermOutlook() {
		history = new ArrayList<Integer>();
	}

	@Override
	public double getExpectedValue(Player player, Decision decision) {
		if (decision.decisionType.equals("buy"))
			return getBuyEV(player, decision);
		if (decision.decisionType.equals("sell"))
			return getSellEV(player, decision);
		if (decision.decisionType.equals("buy rat bucket"))
			return getRatBucketEV(player, decision);

		// error
		else
			return 0;
	}

	private double getRatBucketEV(Player player, Decision decision) {
		if (Market.ratBucket.turnsInPlay > 3)
			return .5;
		return .33;
	}

	private double getSellEV(Player player, Decision decision) {
		return .33;
	}

	private double getBuyEV(Player player, Decision decision) {
		return .33;
	}

	@Override
	public int getEffectiveProfit(Player player, Decision decision) {
		if (decision.isRatBucketDecision) {
			return ratBucketValue();
		}
		return 0;
	}

	private int ratBucketValue() {
		return Market.ratBucket.numRatsInside * Market.ratPrice
				- Market.ratBucket.price;
	}

}
