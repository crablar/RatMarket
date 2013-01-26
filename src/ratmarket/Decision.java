package ratmarket;

public class Decision {

	public String decisionType;
	public int ratsToSell;
	public int ratsToBuy;
	public boolean buyRatBucket;
	
	public Decision(String decisionType){
		ratsToBuy = 0;
		ratsToSell = 0;
		this.decisionType = decisionType;
		if(decisionType.equals("buy rat bucket"))
				buyRatBucket = true;
		else
				buyRatBucket = false;
	}
	
	public Decision(String decisionType, int rats){
		ratsToBuy = 0;
		buyRatBucket = false;
		if(decisionType.equals("sell")){
			this.decisionType = decisionType;
			this.ratsToSell = ratsToSell;
		}
			this.decisionType = "buy";
			this.ratsToBuy = ratsToBuy;
		}
	
}
