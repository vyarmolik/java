package stream.chapter5_5;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

import static java.util.Comparator.comparing;

public class Test {

	private static Trader raoul = new Trader("Raoul", "Cambridge");
	private static Trader mario = new Trader("Mario", "Milan");
	private static Trader alan = new Trader("Alan", "Cambridge");
	private static Trader brian = new Trader("Brian", "Cambridge");
	
	private static List<Transaction> transactions = Arrays.asList(
		new Transaction(brian, 2011, 300),
		new Transaction(raoul, 2012, 1000), 
		new Transaction(raoul, 2011, 400),
		new Transaction(mario, 2012, 710), 
		new Transaction(mario, 2012, 700), 
		new Transaction(alan, 2012, 950)
	);
	
	private static List<Trader> traders = Arrays.asList(raoul, mario, alan, brian);
	
	public static void main(String[] args) {
		task1();	
		task2();
		task3();
		task4();
		task5();
		task6();
		task7();
		task8();
	}
	
	// Find all transactions in the year 2011 and sort them by value (small to high)
	private static final void task1() {
		System.out.println("*****Find all transactions in the year 2011 and sort them by value (small to high)*****");
		
		transactions.stream()
			.filter(t -> t.getYear() == 2011)
			.sorted(comparing(Transaction::getValue))
			.forEach(System.out::println);
		
		System.out.println("**********\n");
	}
	
	// What are all the unique cities where the traders work?
	private static final void task2() {
		System.out.println("*****What are all the unique cities where the traders work?*****");
		
		traders.stream()
			.map(Trader::getCity)
			.distinct()
			.forEach(System.out::println);
		
		System.out.println("**********\n");
	}
	
	// Find all traders from Cambridge and sort them by name.
	private static final void task3() {
		System.out.println("*****Find all traders from Cambridge and sort them by name.*****");
		
		traders.stream()
			.filter(t -> "Cambridge".equals(t.getCity()))
			.distinct()
			.sorted(comparing(Trader::getName))
			.forEach(System.out::println);
		
		System.out.println("**********\n");
	}
	
	// Return a string of all traders’ names sorted alphabetically.
	private static final void task4() {
		System.out.println("*****Return a string of all traders’ names sorted alphabetically.*****");
		
		System.out.println(traders.stream()
			.map(Trader::getName)
			.sorted()
			.reduce("", (name1, name2) -> name1 += " " + name2));
		
		System.out.println("**********\n");
	}
	
	// Are any traders based in Milan?
	private static final void task5() {
		System.out.println("*****Are any traders based in Milan?*****");
		
		System.out.println(traders.stream().anyMatch(t -> "Milan".equals(t.getCity())));
		
		System.out.println("**********\n");
	}
	
	// Print all transactions’ values from the traders living in Cambridge.
	private static final void task6() {
		System.out.println("*****Print all transactions’ values from the traders living in Cambridge.*****");
		
		transactions.stream()
			.filter(t -> "Cambridge".equals(t.getTrader().getCity()))
			.map(Transaction::getValue)
			.forEach(System.out::println);
		
		System.out.println("**********\n");
	}
	
	// What’s the highest value of all the transactions?
	private static final void task7() {
		System.out.println("*****What’s the highest value of all the transactions?*****");
		
		OptionalInt maxValue = transactions.stream().mapToInt(Transaction::getValue).max();
		System.out.println(maxValue.getAsInt());				
		
		System.out.println("**********\n");
	}
	
	// Find the transaction with the smallest value.
	private static final void task8() {
		System.out.println("*****Find the transaction with the smallest value.*****");
		
		Optional<Transaction> smallestTransaction = transactions.stream().reduce((t1, t2) -> t1.getValue() < t2.getValue() ? t1 : t2);
		System.out.println(smallestTransaction.get());
		
		System.out.println("**********\n");
	}
}
