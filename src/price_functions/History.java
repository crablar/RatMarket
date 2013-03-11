package price_functions;

import java.util.ArrayList;

/**
 * Maintains a global history for price and volume.
 * 
 * @author jeffreymeyerson
 *
 */

public class History {
	
	public static ArrayList<Integer> priceHistory = new ArrayList<Integer>();
	public static ArrayList<Integer> volumeHistory = new ArrayList<Integer>();

	public static int getPrice(int time){
		return priceHistory.get(time).intValue();
	}
	
	public static int getVolume(int time){
		return volumeHistory.get(time).intValue();
	}
	
}
