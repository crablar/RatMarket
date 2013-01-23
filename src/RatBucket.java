
public class RatBucket {
	
	public int turnsInPlay;
	public int numRatsInside;
	
	public RatBucket(){
		turnsInPlay = 0;
		numRatsInside = Main.rand.nextInt(10);
	}
	
	public void advance(){
		turnsInPlay++;
		numRatsInside++;
	}
	
	public String getInfo(){
		return "The rat bucket has been in play for " + turnsInPlay + " turns.";
	}

	
}
