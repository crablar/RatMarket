package ratmarket;
import java.util.ArrayList;
import java.util.LinkedList;


public class Market {
	
	public static PriceFunction priceFuntion = new SinPriceFunction();
	public static int ratPrice = ;
	
	public int lastBuyOrder = 0;
	public int lastSellOrder = 0;
	
	public static RatBucket ratBucket = null;
	private static LinkedList<Integer> priceHistory = new LinkedList<Integer>();
	
	public static String getPriceHistory(){
		if(priceHistory.size() == 0)
			return "There is no price history.";
		int temp1 = priceHistory.get(0);
		String result = "Price History: " + temp1;
		for(int i = 1; i < priceHistory.size(); i++){
			int temp2 = priceHistory.get(i);
			char marketDirection = 'v';
			if(temp2 > temp1)
				marketDirection = '^';
			else if(temp2 == temp1)
				marketDirection = '=';
			temp1 = temp2;
			result += " " + marketDirection + " " + temp2;
		}
		return result;
	}
	
	public static int

	
	public static void updatePrice(int newPrice){
		priceHistory.add(ratPrice);
		ratPrice = newPrice;
		if(priceHistory.size() > 5)
			priceHistory.remove(0);
	}
	
}
