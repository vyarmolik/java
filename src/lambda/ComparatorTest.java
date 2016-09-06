package lambda;

import static java.util.Comparator.comparing;

import java.util.Arrays;
import java.util.List;

public class ComparatorTest {
	public static void main(String[] args) {
		List<Fruit> fruits = Arrays.asList(
				new Orange(200),
				new Apple(190),
				new Orange(100),
				new Apple(150));
		
		System.out.println("Unsorted list: ");
		System.out.println(fruits);
		
		fruits.sort(comparing(Fruit::getName).thenComparing(Fruit::getWeight));
		
		System.out.println("Sorted list: ");
		System.out.println(fruits);
	}
}
