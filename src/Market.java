import java.util.ArrayList;
import java.util.LinkedList;


public class Market {
	
	public static int price = 1;
	private static LinkedList<Integer> priceHistory = new LinkedList<Integer>();
	
	public static String getPriceHistory(){
		if(priceHistory.size() == 0)
			return "There is no price history.";
		int temp1 = priceHistory.get(0);
		String result = "Price History: " + temp1;
		for(int i = 1; i < priceHistory.size(); i++){
			int temp2 = priceHistory.get(i);
			char marketDirection = ' ';
			if(temp2 > temp1)
				marketDirection = '^';
			if(temp2 < temp1)
				marketDirection = 'v';
			if(temp2 == temp1)
				marketDirection = '=';
			temp1 = temp2;
			result += marketDirection + " " + temp2 + " ";
		}
		return result;
	}
	
	public static void addPrice(int price){
		priceHistory.add(price);
		if(priceHistory.size() > 5)
			priceHistory.remove(0);
	}
	
}
