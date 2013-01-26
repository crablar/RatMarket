package ratmarket;
import java.util.HashMap;

import strategies.*;


public class StrategyMap {

	public static HashMap<String, Strategy> map = new HashMap<String, Strategy>();
	
	public static void initialize(){
		map.put("nit", new Nit());
	}

	public static Strategy get(String string) {
		return map.get(string);
	}
	
}
