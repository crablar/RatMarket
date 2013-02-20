package ratmarket;

public class RatBucket {

	public int price;
	public int turnsInPlay;
	public int numRatsInside;
	public int turnsTilExpiration;

	public RatBucket(int rats, int price, int turnsTilExpiration) {
		turnsInPlay = 0;
		this.turnsTilExpiration = turnsTilExpiration;
		numRatsInside = rats;
		this.price = price;
	}

	public void advance() {
		turnsInPlay++;
		numRatsInside++;
		turnsTilExpiration--;
	}

	public String getInfo() {
		String result = "The rat bucket has accrued " + turnsInPlay
				+ " extra rats.";
		result += "\nCurrent rat bucket price: $" + price;
		if (turnsTilExpiration != 0)
			result += "\nThe rat bucket will expire in " + turnsTilExpiration
					+ " turns";
		else
			result += "\nThe rat bucket will expire this turn if not purchased!";
		return result;
	}

}
