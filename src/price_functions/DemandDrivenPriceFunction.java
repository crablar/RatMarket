package price_functions;

import java.util.ArrayList;

import ratmarket.TwoPlayerGame;

/**
 * A PriceFunction that moves according to the changes in the GlobalPredicateMap.
 * 
 * @author jeffreymeyerson
 *
 */

public class DemandDrivenPriceFunction extends PriceFunction{

	public DemandDrivenPriceFunction(){
		priceHistory = new ArrayList<Integer>();
	}
	
	public int calculatePrice() {
		if(priceHistory.get(1) == null)
			return TwoPlayerGame.STARTING_PRICE;
		
		return 0;
	}

}
