package strategies;
import characteristics.Characteristic;



public abstract class Strategy {

	public Characteristic[] characteristics;

	public abstract Decision generatePlay(int rats, int dollars,
			PersonalPredicateMap predicates);
	
}
