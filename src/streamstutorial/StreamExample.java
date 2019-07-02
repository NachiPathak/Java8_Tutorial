package streamstutorial;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

	public static int multiplication(List<Integer> intList) {
		return intList.stream().reduce(1, (a, b) -> a * b);
	}

	public static Optional<Integer> multiplicationWithoutIdentity(List<Integer> intList) {
		return intList.stream().reduce((a, b) -> a * b);
	}

	public static int findMaxValue(List<Integer> intList) {
		return intList.stream().reduce(0, (x, y) -> x > y ? x : y);

	}

	public static Optional<Integer> findMaxValueWithoutIdentity(List<Integer> intList) {
		return intList.stream().reduce((x, y) -> x > y ? x : y);

	}

	public static int findMinValue(List<Integer> intList) {
		return intList.stream().reduce(Integer.MAX_VALUE, (x, y) -> x < y ? x : y);

	}

	public static Optional<Integer> findMinValueWithoutIdentity(List<Integer> intList) {
		return intList.stream().reduce((x, y) -> x < y ? x : y);

	}

	public static Optional<Integer> findLimitSum(List<Integer> intList) {
		return intList.stream().limit(3).reduce(Integer::sum);
	}

	public static Optional<Integer> findSkipSum(List<Integer> intList) {
		return intList.stream().skip(3).reduce(Integer::sum);
	}

	public static void main(String[] args) {
		List<Integer> intList = Arrays.asList(1, 3, 5, 7);
		List<Integer> intList1 = new ArrayList<>();

		System.out.println("Multiplication of Integers = " + multiplication(intList));

		System.out.println(
				"Is multiplication Without Identity Present: " + multiplicationWithoutIdentity(intList).isPresent());

		if (multiplicationWithoutIdentity(intList).isPresent()) {
			System.out.println("Is multiplication Without Identity = " + multiplicationWithoutIdentity(intList).get());
		}

		System.out.println("Max of the List values = " + findMaxValue(intList));

		if (findMaxValueWithoutIdentity(intList).isPresent()) {
			System.out
					.println("Max of the List values Without Identity = " + findMaxValueWithoutIdentity(intList).get());
		}

		if (findMaxValueWithoutIdentity(intList1).isPresent()) {
			System.out.println(
					"Max of the List values Without Identity = " + findMaxValueWithoutIdentity(intList1).get());
		} else {
			System.out.println("Value Does not Exists!!");

		}

		System.out.println("Min of the List values = " + findMinValue(intList));

		if (findMinValueWithoutIdentity(intList).isPresent()) {
			System.out
					.println("Min of the List values Without Identity = " + findMinValueWithoutIdentity(intList).get());
		}

		if (findMinValueWithoutIdentity(intList1).isPresent()) {
			System.out.println(
					"Min of the List values Without Identity = " + findMinValueWithoutIdentity(intList1).get());
		} else {
			System.out.println("Value Does not Exists!!");

		}

		if (findLimitSum(intList).isPresent()) {
			System.out.println("Sum of Limit int = " + findLimitSum(intList).get());
		}

		if (findSkipSum(intList).isPresent()) {
			System.out.println("Sum of Skip int = " + findSkipSum(intList).get());
		}

		System.out
				.println("\n---------------------------------------Stream Of---------------------------------------\n");
		Stream.of("Nachi", "Aditya", "Nandini").forEach(System.out::println);

		System.out.println(
				"\n---------------------------------------Stream Iterate---------------------------------------\n");
		Stream.iterate(1, x -> x * 2).limit(10).forEach(System.out::println);

		System.out.println(
				"\n---------------------------------------Stream Generate---------------------------------------\n");
		Stream.generate(new Random()::nextInt).limit(10).forEach(System.out::println);

		System.out.println(
				"\n---------------------------------------Numeric Streams---------------------------------------\n");

		System.out.println(
				"\n---------------------------------------Int Streams Sum---------------------------------------\n");

		System.out.println("Sum of Integers using IntStream.rangeClosed(1, 6) = " + IntStream.rangeClosed(1, 6).sum());

		System.out.println(
				"\n---------------------------------------Int Streams Average---------------------------------------\n");

		System.out.println("Average of Integers using IntStream.rangeClosed(1, 50) = "
				+ (IntStream.rangeClosed(1, 50).average()).getAsDouble());

		System.out.println(
				"\n---------------------------------------Int Streams Max---------------------------------------\n");

		System.out.println("Max of Integers using IntStream.rangeClosed(1, 50) = "
				+ (IntStream.rangeClosed(1, 50).max()).getAsInt());

		System.out.println(
				"\n---------------------------------------Int Streams Min---------------------------------------\n");

		System.out.println("Min of Integers using IntStream.rangeClosed(1, 50) = "
				+ (IntStream.rangeClosed(1, 50).min()).getAsInt());

		System.out.println(
				"\n---------------------------------------Int Streams Boxed---------------------------------------\n");

		List<Integer> integerList = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toList());
		System.out.println("Boxed of Integers using IntStream.rangeClosed(1, 10) = " + integerList);

		System.out.println(
				"\n---------------------------------------Int Streams UnBoxed---------------------------------------\n");

		System.out.println("UnBoxed Sum of Integers using IntStream.rangeClosed(1, 10) = "
				+ integerList.stream().mapToInt(Integer::intValue).sum());

		System.out.println(
				"\n---------------------------------------Int Streams Mapping---------------------------------------\n");

		System.out.println(
				"\n---------------------------------------Map To Object---------------------------------------\n");

		List<Integer> mapObj = IntStream.rangeClosed(1, 10).mapToObj((i) -> {
			return new Integer(i);
		}).collect(Collectors.toList());

		System.out.println("mapToObj of Integers using IntStream.rangeClosed(1, 10) = " + mapObj);

		System.out.println(
				"\n---------------------------------------Map To Object---------------------------------------\n");

		System.out.println("mapToLong of Integers using IntStream.rangeClosed(1, 10) = "
				+ IntStream.rangeClosed(1, 10).mapToLong((i) -> i).sum());

		System.out.println(
				"\n---------------------------------------Map To Double---------------------------------------\n");
		System.out.println("mapToDouble of Integers using IntStream.rangeClosed(1, 10) = "
				+ IntStream.rangeClosed(1, 10).mapToDouble((i) -> i).sum());

	}

}
