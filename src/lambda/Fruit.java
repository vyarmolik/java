package lambda;

public abstract class Fruit {
	
	private final String name;
	private final int weight;
	
	public Fruit(String name, int weight) {
		this.name = name;
		this.weight = weight;
	}

	public String getName() {
		return name;
	}

	public int getWeight() {
		return weight;
	}

	@Override
	public String toString() {
		return "Fruit [name=" + name + ", weight=" + weight + "]";
	}	
}
