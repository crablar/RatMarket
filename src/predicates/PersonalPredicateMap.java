package predicates;

import java.util.HashMap;

import ratmarket.Market;
import ratmarket.Player;

/**
 * Every Player has a PersonalPredicateMap, which tracks certain predicates
 * about that player.
 * 
 * For example: boolean fifty_percent_invested = Alice.map.get(15% invested);
 * 
 * @author jeffreymeyerson
 * 
 */

public class PersonalPredicateMap {

	public HashMap<String, Boolean> map;

	public PersonalPredicateMap() {
		map = new HashMap<String, Boolean>();
	}

	public boolean get(String key) {
		return map.get(key);
	}

	public void updateAllPredicates(Player player) {
		this.updateInvestmentPercentages(player);
	}

	/**
	 * Adds the percentage investment booleans to the player map. The map can
	 * now be queried as follows:
	 * 
	 * @boolean fifty_percent_invested = map.get(15% invested);
	 * 
	 *          Percentages are added to the map in increments of 5. The maximum
	 *          percentage that can be queried is 95%.
	 * 
	 * @param player
	 */
	public void updateInvestmentPercentages(Player player) {

		int fullLiquidity = player.dollars + player.rats * Market.ratPrice;
		double pcntDollars = 1.0 * player.dollars / fullLiquidity;
		double pcntRats = 1 - pcntDollars;

		// How could I automate this?
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

		map.put("15% invested", fifteen_percent_invested);
		map.put("20% invested", twenty_percent_invested);
		map.put("25% invested", twentyfive_percent_invested);
		map.put("30% invested", thirty_percent_invested);
		map.put("35% invested", thirtyfive_percent_invested);
		map.put("40% invested", forty_percent_invested);
		map.put("45% invested", fortyfive_percent_invested);
		map.put("50% invested", fifty_percent_invested);
		map.put("55% invested", fiftyfive_percent_invested);
		map.put("60% invested", sixty_percent_invested);
		map.put("65% invested", sixtyfive_percent_invested);
		map.put("70% invested", seventy_percent_invested);
		map.put("75% invested", seventyfive_percent_invested);
		map.put("80% invested", eighty_percent_invested);
		map.put("85% invested", eightyfive_percent_invested);
		map.put("90% invested", ninety_percent_invested);
		map.put("95% invested", ninetyfive_percent_invested);

	}

}
