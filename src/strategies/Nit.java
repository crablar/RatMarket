package strategies;

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

	final static String[] observedPredicates = {"30% invested", "35% invested", "37% invested", "70% invested", "50% invested"};
	
	public Decision generateDecision(int rats, int dollars,
			PersonalPredicateMap predicates) {
		
		boolean thirty_percent_invested = predicates.get("thirty percent invested");
		
		return null;
	}
	
	
}
