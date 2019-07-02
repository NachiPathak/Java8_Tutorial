package streamstutorial;

import java.util.ArrayList;
import java.util.stream.Stream;

public class StramVsCollection {
	public static void main(String[] args) {
		ArrayList<String> names = new ArrayList<>();
		names.add("Nachi");
		names.add("Aditya");
		names.add("Nandini");

		for (String name : names) {
			System.out.println("Name is " + name);
		}

		for (String name : names) {
			System.out.println("Repeated Name is " + name);
		}

		Stream<String> streamName = names.stream();
		streamName.forEach((name) -> System.out.println("Stream name is " + name));
		streamName.forEach((name) -> System.out.println("Repeated Stream name is " + name));
	}
}
