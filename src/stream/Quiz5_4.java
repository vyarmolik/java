package stream;

import java.util.stream.Stream;

public class Quiz5_4 {

	public static void main(String[] args) {
		// Fibonacci pairs stream
		Stream.iterate(new int[]{0, 1}, pair -> new int[]{pair[1], pair[0] + pair[1]})
		.limit(20)
		.forEach(t -> System.out.println("(" + t[0] + "," + t[1] +")"));
	}
}
