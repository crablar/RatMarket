package ratmarket;

/**
 * A Decision is a message passed from a Player to the Market.
 * 
 * @author jeffreymeyerson
 * 
 */

public class Decision {

	public String decisionType;
	public int ratsToSell;
	public int ratsToBuy;
	public boolean buyRatBucket;

	/**
	 * Constructs a ratbucket buy Decision if given the @param "buy rat bucket"
	 * Constructs a null Decision if given anything else.
	 * 
	 * @param decisionType
	 */
	public Decision(String decisionType) {
		ratsToBuy = 0;
		ratsToSell = 0;
		this.decisionType = decisionType;
		if (decisionType.equals("buy rat bucket"))
			buyRatBucket = true;
		else
			buyRatBucket = false;
	}

	/**
	 * Constructs a sell or buy decision depending on parameters.
	 * 
	 * buy 15 --> Decision to buy 15
	 * sell 1 --> Decision to sell 1
	 * 
	 * @param decisionType
	 * @param rats
	 */
	public Decision(String decisionType, int rats) {
		ratsToBuy = 0;
		buyRatBucket = false;
		if (decisionType.equals("sell")) {
			this.decisionType = decisionType;
			this.ratsToSell = rats;
		}
		this.decisionType = "buy";
		this.ratsToBuy = rats;
	}
	
	public boolean isBuy(){
		return ratsToBuy > 0;
	}

	public boolean isSell(){
		return ratsToSell < 0;
	}
	
}
