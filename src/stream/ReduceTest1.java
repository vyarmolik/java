package stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import model.Apple;
import model.Fruit;
import model.Orange;

public class ReduceTest1 {

	public static void main(String[] args) {
		List<Fruit> fruits = Arrays.asList(
				new Orange(200),
				new Apple(190),
				new Orange(100),
				new Apple(150));
		
		Optional<Integer> sum = fruits.stream().map(Fruit::getWeight).reduce(Integer::sum);
		
		sum.ifPresent(System.out::println);
	}

}
