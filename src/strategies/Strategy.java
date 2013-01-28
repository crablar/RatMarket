package strategies;

import predicate_maps.GlobalPredicateMap;
import predicate_maps.PersonalPredicateMap;
import ratmarket.Decision;

/**
 * The Strategy class. A strategy takes predicates from the PersonalPredicateMap
 * and GlobalPredicateMap, which describe the game state.
 * 
 * Built to scale so that a Player can implement hybrid strategies eventually.
 * 
 * @author jeffreymeyerson
 * 
 */

public abstract class Strategy {

	public abstract Decision generateDecision(int rats, int dollars,
			PersonalPredicateMap personalPredicateMap,
			GlobalPredicateMap globalPredicateMap);

}
