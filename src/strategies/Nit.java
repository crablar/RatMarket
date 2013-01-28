package strategies;

import predicate_maps.PersonalPredicateMap;
import ratmarket.*;

/**
 * The nit fills up 20% of his portfolio with rats whenever the market has
 * trended up for three consecutive turns. If the market trends up another
 * consecutive turn, he buys until 30% of his capital has been turned into rats.
 * If the market trends up again, he buys until he is 35% invested. During each
 * price increase, the amount he adds is halved.
 * 
 * @author jeffreymeyerson
 * 
 */

public class Nit extends Strategy{

	public String[] observedPredicates = {"30% invested", "35% invested", "37% invested", "70% invested", "50% invested"};
	
	public Decision generateDecision(int rats, int dollars,
			PersonalPredicateMap predicates) {
		
			int valueAtFullLiquidity = dollars + rats * Market.ratPrice;
			double pcnt_cash = 1.0 * dollars / valueAtFullLiquidity;
			double pcnt_rat = 1 - pcnt_cash;
		
			boolean thirty_percent_invested = predicates.get(observedPredicates[0]);
			boolean thirtyfive_percent_invested = predicates.get(observedPredicates[1]);
			boolean thirtyseven_percent_invested = predicates.get(observedPredicates[2]);
			boolean fifty_percent_invested = predicates.get(observedPredicates[3]);
			boolean seventy_percent_invested = predicates.get(observedPredicates[4]);
			
		return null;
	}
	
	public static void seedPredicateMap(){
		
	}
	
	
}
