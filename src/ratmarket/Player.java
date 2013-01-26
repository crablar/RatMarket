package ratmarket;


public class Player{
	
	public int rats;
	public int dollars;
	public String name;
	public PersonalPredicateMap predicates;
	public Strategy strategy;
	
	public Player(String name){
		rats = 0;
		dollars = 200;
		this.name = name;
	}
	
	public boolean buyRatBucket(){
		if(dollars > Market.ratBucket.price)
			return false;
		dollars -= Market.ratBucket.price;
		rats += Market.ratBucket.numRatsInside;
		return true;
	}

	public void takeTurn() {
		Decision decision = strategy.generatePlay(rats, dollars, predicates);
	}
	
}