package predicates;
import java.util.HashMap;

/**
 * The GlobalPredicateMap keeps track of predicates that describe the global game state.
 * 
 * @author jeffreymeyerson
 *
 */


public class GlobalPredicateMap{
	
	public static HashMap<String, Boolean> map = new HashMap<String, Boolean>();

	public static boolean get(String string) {
		return map.get(string);
	}
	
	public static void updateAllPredicates(){
		
	}
	
}
