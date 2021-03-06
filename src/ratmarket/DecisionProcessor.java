package ratmarket;

/**
 * The DecisionProcessor processes Decisions and updates variables throughout
 * the program that are affected by the Decision. It also clears all Decision
 * requests to make sure they are valid (e.g. Alice's buy won't be processed if
 * she has no money).
 * 
 * @author jeffreymeyerson
 * 
 */

public class DecisionProcessor {

	/**
	 * Returns whether or not the Decision was deemed valid and was processed.
	 * 
	 * @param decision
	 * @param player
	 * @return
	 */
	public static boolean processDecision(Decision decision, Player player) {
		if (!getValidity(decision, player))
			return false;
		System.out.println(("--- " + player.name + ": " + decision + " ---")
				.toUpperCase());
		if (decision.isRatBucketDecision)
			System.out.println("*****" + player.name + " attained a "
					+ decision.profit + "$ increase in net worth*****");
		System.out.println();
		if (decision.isBuy()) {
			player.dollars -= decision.ratsToBuy * Market.ratPrice;
			player.rats += decision.ratsToBuy;
			Market.lastBuyOrder = decision.ratsToBuy;
			Market.turnsSinceLastBuy = 0;
			Market.turnsSinceLastSell++;
		} else if (decision.isSell()) {
			player.dollars += decision.ratsToSell * Market.ratPrice;
			player.rats -= decision.ratsToSell;
			Market.lastSellOrder = decision.ratsToSell;
			Market.turnsSinceLastSell = 0;
			Market.turnsSinceLastBuy++;
		} else if (decision.isRatBucketDecision) {
			player.dollars -= Market.ratBucket.price;
			player.rats += Market.ratBucket.numRatsInside;
			Market.ratBucket = null;
			Market.consecutiveExpiredRatBuckets = 0;
			Market.turnsSinceLastSell++;
			Market.turnsSinceLastBuy++;
		} else if (decision.decisionType.equals("do nothing")) {
			Market.turnsSinceLastSell++;
			Market.turnsSinceLastBuy++;
		}
		return true;
	}

	private static boolean getValidity(Decision decision, Player player) {
		if (decision.isRatBucketDecision)
			return Market.ratBucket.price <= player.dollars;
		if (decision.isSell())
			return player.rats >= decision.ratsToSell;
		return decision.ratsToBuy * Market.ratPrice <= player.dollars;
	}

}
