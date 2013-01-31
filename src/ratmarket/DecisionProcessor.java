package ratmarket;

public class DecisionProcessor {

	public static void processDecision(Decision decision, Player player) {
		if(decision.ratsToBuy > 0){
			player.dollars -= decision.ratsToBuy * Market.ratPrice;
			Market.lastBuyOrder = decision.ratsToBuy;
			Market.turnsSinceLastBuy = 0;
		}
		else if(decision.ratsToSell > 0){
			player.dollars += decision.ratsToSell * Market.ratPrice;
			Market.lastSellOrder = decision.ratsToSell;
			Market.turnsSinceLastSell = 0;
		}
		else if(decision.buyRatBucket){
			player.dollars -= Market.ratBucket.price;
			player.rats += Market.ratBucket.numRatsInside;
			Market.ratBucket = null;
		}
	}
	
}
