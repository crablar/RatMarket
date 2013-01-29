package strategies;

import predicate_maps.GlobalPredicateMap;
import predicate_maps.PersonalPredicateMap;
import ratmarket.Decision;
import ratmarket.Market;
import ratmarket.Player;

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

	public Decision generateDecision(int rats, int dollars,
			Player player) {
		
		PersonalPredicateMap personalPredicateMap = player.personalPredicateMap;
		int totalWorth = Market.ratPrice * rats + dollars;
		double pcntRats = 1.0 * rats * Market.ratPrice / totalWorth;
		
		//  Personal Predicates
		boolean twenty_percent_invested = personalPredicateMap.get("20% invested");
		boolean thirty_percent_invested = personalPredicateMap.get("30% invested");
		boolean thirtyfive_percent_invested = personalPredicateMap.get("35% invested");
		boolean forty_percent_invested = personalPredicateMap.get("40% invested");
		boolean fifty_percent_invested = personalPredicateMap.get("50% invested");
		boolean seventy_percent_invested = personalPredicateMap.get("70% invested");
		
		//  Global Predicates
		boolean three_consec_uptrends = GlobalPredicateMap.get("three_consecutive_uptrends");
		boolean three_consec_downtrends = GlobalPredicateMap.get("three_consecutive_downtrends");
 
		//  Expected values for each decision
		double buyEV = .33;
		double sellEV = .33;
		double ratBucketEV = .33;
		
		if(three_consec_uptrends){
			
			//  This turn will be a buy or a do-nothing.
			int buy_order = 0;		
			
			if(!twenty_percent_invested){
				// Calculate how many rats are needed to fill 20% of this player's portfolio
				double pcnt_invested = 1.0 * buy_order * Market.ratPrice / (dollars + 1);
				while(pcnt_invested > .2 && pcnt_invested < .3)
					buy_order++;
			}
			
			}
				
		}
	}

}
