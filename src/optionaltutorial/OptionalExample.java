package optionaltutorial;

import java.util.Optional;

import entity.Bike;
import entity.Student;
import entity.StudentDataBase;

public class OptionalExample {

	public static Optional<String> ofNullableType() {
		Optional<String> stringOptional = Optional.ofNullable(null);
		return stringOptional;
	}

	public static Optional<String> ofType() {
		Optional<String> stringOptional = Optional.of("Hello");
		return stringOptional;
	}

	public static Optional<String> emptyType() {
		return Optional.empty();
	}

	public static String optionalOrElse() {
		Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
		// Optional<Student> studentOptional = Optional.ofNullable(null);

		String name = studentOptional.map(Student::getName).orElse("Default");

		return name;
	}

	public static String optionalOrElseGet() {
		Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
		// Optional<Student> studentOptional = Optional.ofNullable(null);

		String name = studentOptional.map(Student::getName).orElseGet(() -> "Default");

		return name;
	}

	public static String optionalOrElseThrow() {
		Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());
		// Optional<Student> studentOptional = Optional.ofNullable(null);

		String name = studentOptional.map(Student::getName).orElseThrow(() -> new NullPointerException());

		return name;
	}

	public static void main(String[] args) {
		System.out.println("Output of ofNullableType = " + ofNullableType());
		System.out.println("Output of ofType = " + ofType());
		System.out.println("Output of emptyType = " + emptyType());
		System.out.println("\n------------------------------------------------------------------------------\n");
		System.out.println("Output of optionalOrElse = " + optionalOrElse());
		System.out.println("Output of optionalOrElseGet = " + optionalOrElseGet());
		System.out.println("Output of optionalOrElseThrow = " + optionalOrElseThrow());

		System.out.println("\n------------------------------------------------------------------------------\n");

		Optional<String> stringOptional = Optional.ofNullable("Hello");

		System.out.println("String Present = " + stringOptional.isPresent());

		if (stringOptional.isPresent()) {
			System.out.println("Optional String is " + stringOptional.get());
		}

		stringOptional.ifPresent((s) -> System.out.println("If Present Returns " + s));

		System.out.println(
				"\n---------------------------------------Optional Filter---------------------------------------\n");

		Optional<Student> studentOptional = Optional.ofNullable(StudentDataBase.studentSupplier.get());

		studentOptional.filter((student) -> student.getGpa() >= 3.5).ifPresent(student -> System.out.println(student));

		System.out.println(
				"\n---------------------------------------Optional Map---------------------------------------\n");

		if (studentOptional.isPresent()) {
			Optional<String> studentName = studentOptional.filter((student) -> student.getGpa() >= 3.5)
					.map(Student::getName);
			System.out.println("Student Name " + studentName.get());
		}

		System.out.println(
				"\n---------------------------------------Optional FlatMap---------------------------------------\n");

		Optional<String> bikeName = studentOptional.filter((student) -> student.getGpa() >= 3.5)
				.flatMap(Student::getBike).map(Bike::getName);
		System.out.println("Bike Name is " + bikeName.get());
	}
}
