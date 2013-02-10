package ratmarket;

/**
 * The DecisionProcessor processes Decisions. Currently, it also clears all
 * Decision requests to make sure they are valid (eg Alice's buy won't be
 * processed if she has no money). This shouldn't be the domain of the
 * DecisionProcessor but it is a quick fix for now.
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
			System.out.println("*****" + player.name + " has an ev gain of " + decision.profit + "*****");
		System.out.println();
		if (decision.ratsToBuy > 0) {
			player.dollars -= decision.ratsToBuy * Market.ratPrice;
			Market.lastBuyOrder = decision.ratsToBuy;
			Market.turnsSinceLastBuy = 0;
		} else if (decision.ratsToSell > 0) {
			player.dollars += decision.ratsToSell * Market.ratPrice;
			Market.lastSellOrder = decision.ratsToSell;
			Market.turnsSinceLastSell = 0;
		} else if (decision.isRatBucketDecision) {
			player.dollars -= Market.ratBucket.price;
			player.rats += Market.ratBucket.numRatsInside;
			Market.ratBucket = null;
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
