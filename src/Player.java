import java.util.Scanner;

public class Player{
	
	public int rats;
	public int dollars;
	public String name;
	
	public Player(String name){
		rats = 0;
		dollars = 200;
		this.name = name;
	}
	
	public boolean buyRatBucket(){
		if(dollars > ratbucket.price)
			return false;
		dollars -= ratbucket.price;
		rats += ratbucket.numRatsInside;
		return true;
	}

	public void takeTurn() {
		Scanner scan = new Scanner(System.in);
		boolean done = false;
		System.out.println("Bob, would you like to buy the rat bucket, buy rats, sell rats, or end your turn?  Example: \"buy 5\" or \"Sell 2\" or \"done\" or \"buy rat bucket\"");
		String command = scan.nextLine();
		command = command.toLowerCase();
		if(command.equals("buy rat bucket"))
			
	}
	
}