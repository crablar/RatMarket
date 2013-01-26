package ratmarket;
import java.util.HashMap;

/**
 * A map for each player, which tracks certain predicates about tha player.
 * 
 * @author jeffreymeyerson
 *
 */

public class PersonalPredicateMap {

	public HashMap<String, Boolean> map = new HashMap<String, Boolean>();
	
	public PersonalPredicateMap(){
		map = new HashMap<String, Boolean>();
	}

	public boolean get(String string) {
		return map.get(string);
	}
	
}
