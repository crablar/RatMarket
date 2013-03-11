package ratmarket;

import predicates.PersonalPredicateMap;
import strategies.Strategy;


public class Player{
	
	public int rats;
	public int dollars;
	public String name;
	public PersonalPredicateMap personalPredicateMap;
	public Strategy strategy;
	
	public Player(String name){
		rats = 0;
		dollars = 200;
		this.name = name;
		personalPredicateMap = new PersonalPredicateMap();
		personalPredicateMap.updateAllPredicates(this);
	}
	
	public boolean buyRatBucket(){
		if(dollars > Market.ratBucket.price)
			return false;
		dollars -= Market.ratBucket.price;
		rats += Market.ratBucket.numRatsInside;
		return true;
	}

	public void takeTurn() {
		Decision decision = strategy.generateDecision(this);
		boolean sensicalDecision = DecisionProcessor.processDecision(decision, this);
		if(!sensicalDecision){
			decision = Decision.doNothing();
			System.out.println((this.name + " submits an invalid decision.").toUpperCase());
		}
		if(!decision.isBuy())
			Market.turnsSinceLastBuy++;
		if(!decision.isSell())
			Market.turnsSinceLastSell++;
		personalPredicateMap.updateAllPredicates(this);
	}

	
}