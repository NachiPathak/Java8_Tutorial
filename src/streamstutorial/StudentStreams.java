package streamstutorial;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import entity.Student;
import entity.StudentDataBase;

public class StudentStreams {
	public static void main(String[] args) {

		Predicate<Student> studentGradePredicate = (Student -> Student.getGradeLevel() >= 3);
		Predicate<Student> studentGPAPredicate = (Student -> Student.getGpa() >= 3.9);

		Predicate<Student> studentGenderPredicate = (Student -> "female".equals(Student.getGender()));

		Consumer<Student> studentConsumer = (student -> System.out.println(student));

		Map<String, List<String>> studentMap = StudentDataBase.getAllStudents().stream()
				.filter(studentGradePredicate.and(studentGPAPredicate))
				.collect(Collectors.toMap(Student::getName, Student::getActivities));

		System.out.println(studentMap);

		System.out
				.println("\n---------------------------------------------------------------------------------------\n");

		Map<String, List<String>> studentMap1 = StudentDataBase.getAllStudents().stream().peek(studentConsumer)
				.filter(studentGradePredicate).peek(studentConsumer).filter(studentGPAPredicate).peek(studentConsumer)
				.collect(Collectors.toMap(Student::getName, Student::getActivities));

		System.out.println(studentMap1);

		System.out
				.println("\n---------------------------------------------------------------------------------------\n");

		List<String> studentNamesList = StudentDataBase.getAllStudents().stream().map(Student::getName)
				.collect(Collectors.toList());

		System.out.println("Student Names List = " + studentNamesList);

		System.out
				.println("\n---------------------------------------------------------------------------------------\n");

		Set<String> studentNamesSet = StudentDataBase.getAllStudents().stream().map(Student::getName)
				.map(String::toUpperCase).collect(Collectors.toSet());

		System.out.println("Student Names Set = " + studentNamesSet);

		System.out
				.println("\n---------------------------------------------------------------------------------------\n");

		List<String> studentActivitiesList = StudentDataBase.getAllStudents().stream().map(Student::getActivities)
				.flatMap(List::stream).collect(Collectors.toList());

		System.out.println("Student Activities List = " + studentActivitiesList);

		System.out
				.println("\n---------------------------------------------------------------------------------------\n");

		Set<String> studentActivitiesSet = StudentDataBase.getAllStudents().stream().map(Student::getActivities)
				.flatMap(List::stream).collect(Collectors.toSet());

		System.out.println("Student Activities Set = " + studentActivitiesSet);

		System.out
				.println("\n---------------------------------------------------------------------------------------\n");

		List<String> distinctStudentActivitiesList = StudentDataBase.getAllStudents().stream()
				.map(Student::getActivities).flatMap(List::stream).distinct().collect(Collectors.toList());

		System.out.println("Distinct Student Activities List = " + distinctStudentActivitiesList);

		System.out.println(
				"\n---------------------------------------Count Distinct Activities---------------------------------------\n");

		long distinctStudentActivitiesCount = StudentDataBase.getAllStudents().stream().map(Student::getActivities)
				.flatMap(List::stream).distinct().count();

		System.out.println("Distinct Student Activities Count = " + distinctStudentActivitiesCount);

		System.out.println(
				"\n---------------------------------------List Of Distinct Activities---------------------------------------\n");

		List<String> distinctStudentActivitiesSortedList = StudentDataBase.getAllStudents().stream()
				.map(Student::getActivities).flatMap(List::stream).distinct().sorted().collect(Collectors.toList());

		System.out.println("Distinct Student Activities Sorted List = " + distinctStudentActivitiesSortedList);

		System.out.println(
				"\n---------------------------------------Sort Students By Name and GPA---------------------------------------\n");

		List<Student> sortedStudentNamesList = StudentDataBase.getAllStudents().stream()
				.sorted(Comparator.comparing(Student::getGpa)).sorted(Comparator.comparing(Student::getName))
				.collect(Collectors.toList());

		System.out.println("Sorted Student List = " + sortedStudentNamesList);

		System.out.println(
				"\n---------------------------------------Filter Students By Gender---------------------------------------\n");

		List<Student> filterStudentsByGender = StudentDataBase.getAllStudents().stream()
				.filter(studentGenderPredicate.and(studentGPAPredicate)).collect(Collectors.toList());

		System.out.println("Sorted Student List = " + filterStudentsByGender);

		System.out.println(
				"\n---------------------------------------Number of Notebooks Studets Have(Using Reduce)---------------------------------------\n");

		int numberofNotebooks = StudentDataBase.getAllStudents().stream()
				.filter(studentGradePredicate.and(studentGenderPredicate)).map(Student::getNotebooks)
				.reduce(0, (a, b) -> a + b);

		System.out.println("Total number of Notebooks = " + numberofNotebooks);

		System.out.println(
				"\n---------------------------------------Number of Notebooks Studets Have(Using INT SUM)---------------------------------------\n");

		int numberofNotebooksIS = StudentDataBase.getAllStudents().stream().map(Student::getNotebooks).reduce(0,
				Integer::sum);

		System.out.println("Total number of Notebooks = " + numberofNotebooksIS);

		System.out
				.println("\n---------------------------------------All Match---------------------------------------\n");

		Boolean gpaAllMatch = StudentDataBase.getAllStudents().stream().allMatch(studentGPAPredicate);

		System.out.println("All Match for GPA is " + gpaAllMatch);

		System.out
				.println("\n---------------------------------------Any Match---------------------------------------\n");

		Boolean gpaAnyMatch = StudentDataBase.getAllStudents().stream().anyMatch(studentGPAPredicate);

		System.out.println("All Match for GPA is " + gpaAnyMatch);

		System.out.println(
				"\n---------------------------------------None Match---------------------------------------\n");

		Boolean gpaNoneMatch = StudentDataBase.getAllStudents().stream().noneMatch(studentGPAPredicate);

		System.out.println("All Match for GPA is " + gpaNoneMatch);
		
		System.out.println(
				"\n---------------------------------------Find Any---------------------------------------\n");

		Optional<Student> anyStudent = StudentDataBase.getAllStudents().stream().filter(studentGPAPredicate).findAny();
		
		if(anyStudent.isPresent()) {
			System.out.println("Student with Given GPA is " + anyStudent.get());
		} else {
			System.out.println("No Student Has Given GPA!!!");
		}
		
		System.out.println(
				"\n---------------------------------------Find First---------------------------------------\n");

		Optional<Student> firstStudent = StudentDataBase.getAllStudents().stream().filter(studentGPAPredicate).findFirst();
		
		if(firstStudent.isPresent()) {
			System.out.println("Student with Given GPA is " + firstStudent.get());
		} else {
			System.out.println("No Student Has Given GPA!!!");
		}
		
	} 
}
