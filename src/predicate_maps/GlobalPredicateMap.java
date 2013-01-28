package predicate_maps;
import java.util.HashMap;



public class GlobalPredicateMap{
	
	public static HashMap<String, Boolean> map = new HashMap<String, Boolean>();

	public static boolean get(String string) {
		return map.get(string);
	}
	
	public static void updateAllPredicates(){
		
	}
	
}
