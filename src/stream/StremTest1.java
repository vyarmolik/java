package stream;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.toList;

import java.util.Arrays;
import java.util.List;

import model.Apple;
import model.Fruit;
import model.Orange;

public class StremTest1 {

	public static void main(String[] args) {
		List<Fruit> fruits = Arrays.asList(
				new Orange(200),
				new Apple(190),
				new Orange(100),
				new Apple(150));
		
		System.out.println("Initial list: ");
		System.out.println(fruits);
		
		List<Fruit> processedFruits = fruits
				.stream()
				.filter((fruit) -> fruit.getWeight() >= 150)
				.sorted(comparing(Fruit::getName).thenComparing(Fruit::getWeight))
				.collect(toList());
		
		System.out.println("Processed list: ");
		System.out.println(processedFruits);
	}

}
