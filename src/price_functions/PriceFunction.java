package price_functions;

import java.util.ArrayList;

/**
 * A PriceFunction describes the way the market moves.
 * 
 * @author jeffreymeyerson
 * 
 */

public abstract class PriceFunction {

	/**
	 * The current directional magnitude, a signed integer that indicates the
	 * direction and velocity of the market
	 */
	public int priceDirectionalMagnitude;
	public ArrayList<Integer> magnitudeHistory;

	public abstract int updatePrice();
	public abstract int getDirectionalMagnitude();

}
