package lambdatutorial;

import java.util.function.Consumer;

public class FirstLambda {
	public static void main(String[] args) {
		Consumer<String> consumer = (s) -> System.out.println(s); 
		consumer.accept("Java 8");
		
		
	}
}
