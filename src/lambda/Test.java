package lambda;

public class Test {

	public static void main(String[] args) {
		final Formatter formatter1 = () -> "Variable formatter";
		final Formatter formatter2 = () -> {
			return "Blocked variable formatter";
		};
		
		callFormatter(formatter1);
		callFormatter(formatter2);
		callFormatter(() -> "Inlined formatter");
	}
	
	public static void callFormatter(Formatter formatter) {
		System.out.println(formatter.format());
	}

}
