package ratmarket;


import predicate_maps.PersonalPredicateMap;
/**
 * The Strategy class.  Built to scale so that a Player can implement hybrid strategies eventually.
 * 
 * @author jeffreymeyerson
 *
 */

public abstract class Strategy {

	public abstract Decision generateDecision(int rats, int dollars,
			PersonalPredicateMap predicates);

}
