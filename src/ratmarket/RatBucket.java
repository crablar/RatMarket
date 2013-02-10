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
	}
	
	public String getInfo(){
		return "The rat bucket has accrued " + turnsInPlay + " extra rats.\nCurrent rat bucket price: $" + price;
	}

	
}
