package lambda;

import java.util.HashMap;
import java.util.Map;
import java.util.function.IntFunction;

public final class FruitFactory {
	
	private static final Map<String, IntFunction<Fruit>> FACTORY_METHODS = new HashMap<>();
	
	static {
		FACTORY_METHODS.put("Apple", Apple::new);
		FACTORY_METHODS.put("Orange", Orange::new);
	}
	
	public static final Fruit createFruit(String name, int weight) {
		return FACTORY_METHODS.get(name).apply(weight);
	}
}
