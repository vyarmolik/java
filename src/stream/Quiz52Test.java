package stream;

import java.util.Arrays;
import java.util.List;

public class Quiz52Test {

	public static void main(String[] args) {
		List<Integer> list1 = Arrays.asList(1, 2, 3);
		List<Integer> list2 = Arrays.asList(3, 4);
		
		list1.stream()
			.flatMap(e1 -> list2
					.stream()
					.filter(e2 -> (e1 + e2) % 3 == 0)
					.map(e2 -> new int[]{e1, e2}))
			.map(Arrays::toString)
			.forEach(System.out::println);
	}
}
