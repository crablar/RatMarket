package ratmarket;

public class RatBucket {
	
	public int price;
	public int turnsInPlay;
	public int numRatsInside;
	
	public RatBucket(int rats, int price){
		turnsInPlay = 0;
		numRatsInside = rats;
		this.price = price;
	}
	
	public void advance(){
		turnsInPlay++;
		numRatsInside++;
		price++;
	}
	
	public String getInfo(){
		return "The rat bucket has been in play for " + turnsInPlay + " turns.\nCurrent rat bucket price: $" + price;
	}

	
}
