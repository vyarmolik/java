package stream;

import static java.util.stream.Collectors.maxBy;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.counting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import model.Apple;
import model.Fruit;
import model.Orange;

public class CollectorsTest {

	private static final List<Apple> apples = Arrays.asList(new Apple(234), new Apple(100), new Apple(150));
	
	private static final List<Orange> oranges = Arrays.asList(new Orange(70), new Orange(120));
	
	private static final List<Fruit> fruits = new ArrayList<>(5);
	
	static {
		fruits.addAll(apples);
		fruits.addAll(oranges);
	}

	public static void main(String[] args) {
		testMaxBy();
		testGroupingBy();
	}

	private static void testMaxBy() {
		Comparator<Apple> weightComparator = Comparator.comparingInt(Apple::getWeight);
		Optional<Apple> heaviestApple = apples.stream().collect(maxBy(weightComparator));
		
		System.out.println("The heaviest apple weights: " + heaviestApple.get());
	}
	
	private static void testGroupingBy() {
		Map<String, Long> countPerName = fruits.stream().collect(groupingBy(Fruit::getName, counting()));
		System.out.println("Count per name: " + countPerName);
	}
}
