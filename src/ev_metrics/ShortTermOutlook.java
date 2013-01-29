package ev_metrics;

import ratmarket.Decision;
import ratmarket.Market;
import ratmarket.Player;

/**
 * A simple short term outlook that allows comparison of a rat bucket purchase.
 * 
 * @author jeffreymeyerson
 *
 */

public class ShortTermOutlook implements ExpectedValueMetric{

	@Override
	public double getExpectedValue(Player player, Decision decision) {
		if(decision.decisionType.equals("buy"))
			return getBuyEV(player, decision);
		if(decision.decisionType.equals("sell"))
			return getSellEV(player, decision);
		if(decision.decisionType.equals("buy rat bucket"))
			return getRatBucketEV(player, decision);
		
		//error
		else return 0;
	}

	private double getRatBucketEV(Player player, Decision decision) {
		if(Market.ratBucket.turnsInPlay > 3)
			return .5;
		return .33;
	}

	private double getSellEV(Player player, Decision decision) {
		return .33;
	}

	private double getBuyEV(Player player, Decision decision) {
		return .33;
	}
	
	

}
