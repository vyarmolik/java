package lambda;

public class FruitFactoryTest {

	public static void main(String[] args) {
		Fruit apple = FruitFactory.createFruit("Apple", 100);
		Fruit orange = FruitFactory.createFruit("Orange", 150);
		
		System.out.println(apple);
		System.out.println(orange);
	}

}
