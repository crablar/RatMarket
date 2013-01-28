package predicate_maps;
import java.util.HashMap;

import ratmarket.Market;
import ratmarket.Player;


/**
 * A map for each player, which tracks certain predicates about tha player.
 * 
 * @author jeffreymeyerson
 *
 */

public class PersonalPredicateMap{
	
	public HashMap<String, Boolean> map;
	
	public PersonalPredicateMap(){
		map = new HashMap<String, Boolean>();
	}
	
	public void updateAllPredicates(){
		
	}
	
	public void updateInvestmentPercentages(Player player){
		
		int fullLiquidity = player.dollars + player.rats * Market.ratPrice;
		double pcntDollars = 1.0 * player.dollars / fullLiquidity;
		double pcntRats = 1 - pcntDollars;
		
		boolean fifteen_percent_invested = pcntRats >= .15 ? true : false;
		boolean twenty_percent_invested = pcntRats >= .2 ? true : false;
		boolean twentyfive_percent_invested = pcntRats >= .25 ? true : false;
		boolean thirty_percent_invested = pcntRats >= .3 ? true : false;
		boolean thirtyfive_percent_invested = pcntRats >= .35 ? true : false;
		boolean forty_percent_invested = pcntRats >= .4 ? true : false;
		boolean fortyfive_percent_invested = pcntRats >= .45 ? true : false;
		boolean fifty_percent_invested = pcntRats >= .5 ? true : false;
		boolean fiftyfive_percent_invested = pcntRats >= .55 ? true : false;
		boolean sixty_percent_invested = pcntRats >= .6 ? true : false;
		boolean sixtyfive_percent_invested = pcntRats >= .65 ? true : false;
		boolean seventy_percent_invested = pcntRats >= .7 ? true : false;
		boolean seventyfive_percent_invested = pcntRats >= .75 ? true : false;
		boolean eighty_percent_invested = pcntRats >= .8 ? true : false;
		boolean eightyfive_percent_invested = pcntRats >= .85 ? true : false;
		boolean ninety_percent_invested = pcntRats >= .9 ? true : false;
		boolean ninetyfive_percent_invested = pcntRats >= .95 ? true : false;

		

	}
	
}
