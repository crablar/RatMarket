import java.util.HashMap;

import strategies.*;


public class StrategyMap {

	public static HashMap<String, Strategy> map = new HashMap<String, Strategy>();
	
	public static void initialize(){
		map.put("nit", new Nit());
	}
	
}