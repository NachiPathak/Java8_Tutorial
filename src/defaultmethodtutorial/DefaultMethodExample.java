package defaultmethodtutorial;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

import entity.Student;
import entity.StudentDataBase;

public class DefaultMethodExample {
	public static void main(String[] args) {
		List<String> names = Arrays.asList("Satish", "Seema", "Aditya", "Nandini", "Nachiket");

		System.out.println("Sorting Names in Prior Java 8 Way!!!");

		Collections.sort(names);

		System.out.println("Sorted Names in Prior Java 8 Way\n" + names);

		System.out.println("\nSorting Names in Java 8 Way!!!");

		names.sort(Comparator.naturalOrder());

		System.out.println("\nSorted Names in Java 8 Way\n" + names);

		names.sort(Comparator.reverseOrder());
		System.out.println("\nSorted Names in Java 8 Way Reversed\n" + names);

		System.out.println(
				"\n-------------------------------------------Sorting Student Examples-------------------------------------------\n");

		List<Student> studentList = StudentDataBase.getAllStudents();
		Consumer<Student> studentConsumer = (student) -> System.out.println(student);
		Comparator<Student> nameComparator = Comparator.comparing(Student::getName);
		Comparator<Student> gradeComparator = Comparator.comparing(Student::getGradeLevel);

		System.out.println("Before Sorting Student List\n");

		studentList.forEach(studentConsumer);

		studentList.sort(gradeComparator.thenComparing(nameComparator));

		System.out
				.println("\n--------------------------------------------------------------------------------------\n");

		System.out.println("After Sorting Student List\n");

		studentList.forEach(studentConsumer);

		System.out.println(
				"\n-------------------------------------------Sorting Student With null Values-------------------------------------------\n");


		Comparator<Student> nullComparator = Comparator.nullsFirst(nameComparator);
		studentList.sort(nullComparator);
		studentList.forEach(studentConsumer);

	}
}
