package price_functions;

import java.util.ArrayList;

/**
 * A PriceFunction describes the way the market moves.
 * 
 * @author jeffreymeyerson
 * 
 */

public abstract class PriceFunction {

	// A history of price magnitudes
	public ArrayList<Integer> magnitudeHistory;

	// The current directional magnitude, a signed integer that indicates the
	// direction and velocity of the market
	public int priceDirectionalMagnitude;

	public abstract int updatePrice();

	public abstract int getDirectionalMagnitude();

}
