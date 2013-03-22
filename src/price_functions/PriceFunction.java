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
	public int negativeMagnitude;
	public int positiveMagnitude;
	public ArrayList<Integer> magnitudeHistory;

	public abstract int updatePrice();
	public abstract void updateDirectionalMagnitude();
	public void print() {
		System.out.println("PriceDirectionalMagnitude = "
				+ priceDirectionalMagnitude);
		System.out.println("positiveMagnitude = " + positiveMagnitude);
		System.out.println("negativeMagnitude = " + negativeMagnitude + "\n");
	}
}
