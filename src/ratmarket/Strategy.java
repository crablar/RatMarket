package ratmarket;


import characteristics.Characteristic;

public abstract class Strategy {

	public Characteristic[] characteristics;

	public abstract Decision generateDecision(int rats, int dollars,
			PersonalPredicateMap predicates);

}
