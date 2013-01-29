package ratmarket;

/**
 * The DecisionFactory helps with the interface between a Player and his
 * Strategy. A player should be able to execute every Decision that is provided
 * to him by his strategy.
 * 
 * @author jeffreymeyerson
 * 
 */

public class DecisionFactory {

	public static Decision buy(int num_rats) {
		return new Decision("buy", num_rats);
	}

	public static Decision sell(int num_rats) {
		return new Decision("sell", num_rats);
	}
	
	public static Decision buyRatBucket(){
		return new Decision("buy rat bucket");
	}

}
