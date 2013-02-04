package strategies;

import predicates.GlobalPredicateMap;
import predicates.PersonalPredicateMap;
import ratmarket.Decision;
import ratmarket.Market;
import ratmarket.Player;
import ev_metrics.ExpectedValueMetric;
import ev_metrics.ShortTermOutlook;

/**
 * The nit fills up 20% of his portfolio with rats whenever the market has
 * trended up for three consecutive turns. If the market trends up another
 * consecutive turn, he buys until 30% of his capital has been turned into rats.
 * If the market trends up again, he buys until he is 35% invested.
 * Alternatively, if the market has trended down for three consecutive turns, he
 * sells 50% of his rats. If the market trends down again, he sells another 50%.
 * And so on until the market stops trending down consecutively.
 * 
 * @author jeffreymeyerson
 * 
 */

public class Nit extends Strategy {

	public static ExpectedValueMetric expectedValueMetric = new ShortTermOutlook();

	/**
	 * TODO: Architecture needs a lot of work here.
	 */
	public Decision generateDecision(Player player) {

		Decision decision = Decision.doNothing();

		PersonalPredicateMap personalPredicateMap = player.personalPredicateMap;
		int totalWorth = Market.ratPrice * player.rats + player.dollars;
		double pcntRats = 1.0 * player.rats * Market.ratPrice / totalWorth;
		// Personal Predicates
		boolean twenty_percent_invested = personalPredicateMap
				.get("20% invested");
		boolean thirty_percent_invested = personalPredicateMap
				.get("30% invested");
		boolean thirtyfive_percent_invested = personalPredicateMap
				.get("35% invested");
		boolean forty_percent_invested = personalPredicateMap
				.get("40% invested");
		boolean fifty_percent_invested = personalPredicateMap
				.get("50% invested");
		boolean seventy_percent_invested = personalPredicateMap
				.get("70% invested");
		// Global Predicates
		int numConsecUptrends = (Integer) GlobalPredicateMap
				.get("number of consecutive uptrends");
		int numConsecDowntrends = (Integer) GlobalPredicateMap
				.get("number of consecutive downtrends");

		if (numConsecUptrends > 2 && !twenty_percent_invested) {
			// Calculate how many rats are needed to fill 20% of this player's
			// portfolio
			double pcntToInvest = .2 - pcntRats;
			int dollarsToAllocate = (int) (pcntToInvest * totalWorth);
			int ratsToBuy = dollarsToAllocate / Market.ratPrice;
			decision = new Decision("buy", ratsToBuy);
		}
		if (numConsecUptrends > 3 && !thirty_percent_invested) {
			// Calculate how many rats are needed to fill 20% of this player's
			// portfolio
			double pcntToInvest = .3 - pcntRats;
			int dollarsToAllocate = (int) (pcntToInvest * totalWorth);
			int ratsToBuy = dollarsToAllocate / Market.ratPrice;
			decision = new Decision("buy", ratsToBuy);
		}
		if (numConsecUptrends > 4 && !thirtyfive_percent_invested) {
			// Calculate how many rats are needed to fill 20% of this player's
			// portfolio
			double pcntToInvest = .35 - pcntRats;
			int dollarsToAllocate = (int) (pcntToInvest * totalWorth);
			int ratsToBuy = dollarsToAllocate / Market.ratPrice;
			decision = new Decision("buy", ratsToBuy);
		}

		if (numConsecDowntrends > 2) {
			int ratsToSell = totalWorth / Market.ratPrice / 2;
			decision = new Decision("sell", ratsToSell);
		}
		Decision ratBucketDecision = new Decision("buy rat bucket");
		if(expectedValueMetric.getExpectedValue(player, ratBucketDecision) > .33){
			ratBucketDecision.print();
			return ratBucketDecision;
		}
		return decision;
	}
}
