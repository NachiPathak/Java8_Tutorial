package streamstutorial;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import entity.Student;
import entity.StudentDataBase;

public class StreamsTerminalOperations {
	public static void main(String[] args) {

		List<Student> studentList = StudentDataBase.getAllStudents();
		Predicate<Student> studentGPAPredicate = (Student -> Student.getGpa() >= 3.8);

		System.out.println(
				"\n---------------------------------------Streams Joining---------------------------------------\n");

		String joiningWitoutDelimiter = studentList.stream().map(Student::getName).collect(Collectors.joining());

		System.out.println("Joining Without Delimiter = " + joiningWitoutDelimiter);

		String joiningWitDelimiter = studentList.stream().map(Student::getName).collect(Collectors.joining(" "));

		System.out.println("Joining WithDelimiter = " + joiningWitDelimiter);

		String joiningWitPrefixandSuffix = studentList.stream().map(Student::getName)
				.collect(Collectors.joining(", ", "[", "]"));

		System.out.println("Joining With Prefix and Suffix = " + joiningWitPrefixandSuffix);

		System.out.println(
				"\n---------------------------------------Streams Counting---------------------------------------\n");

		Long numberOfStudents = studentList.stream().collect(Collectors.counting());

		System.out.println("Total Number of Students are " + numberOfStudents);

		System.out.println(
				"\n---------------------------------------Streams Mapping---------------------------------------\n");

		List<String> nameList = studentList.stream().collect(Collectors.mapping(Student::getName, Collectors.toList()));
		System.out.println("Name List of Students = " + nameList);

		Set<String> nameSet = studentList.stream().collect(Collectors.mapping(Student::getName, Collectors.toSet()));
		System.out.println("Name Set of Students = " + nameSet);

		System.out.println(
				"\n---------------------------------------Streams MinBy and MaxBy---------------------------------------\n");

		Optional<Student> minByGPA = studentList.stream()
				.collect(Collectors.minBy(Comparator.comparing(Student::getGpa)));

		System.out.println("Student With least GPA is " + minByGPA.get());

		Optional<Student> maxByGPA = studentList.stream()
				.collect(Collectors.maxBy(Comparator.comparing(Student::getGpa)));

		System.out.println("Student With least GPA is " + maxByGPA.get());

		System.out.println(
				"\n---------------------------------------Streams SummingInt---------------------------------------\n");

		int totalNotebooks = studentList.stream().collect(Collectors.summingInt(Student::getNotebooks));
		System.out.println("Total Number of Notebooks are " + totalNotebooks);

		System.out.println(
				"\n---------------------------------------Streams AveragingInt---------------------------------------\n");

		double averageNotebooks = studentList.stream().collect(Collectors.averagingInt(Student::getNotebooks));
		System.out.println("Total Number of Notebooks are " + averageNotebooks);

		System.out.println(
				"\n---------------------------------------Streams GroupingBy Version-1---------------------------------------\n");

		Map<String, List<Student>> groupByGender = studentList.stream()
				.collect(Collectors.groupingBy(student -> student.getGender()));

		System.out.println("Students Grouped By Gender\n" + groupByGender);

		System.out.println("\n------------------------------------------------------------------------------\n");

		Map<String, List<Student>> groupByGPA = studentList.stream()
				.collect(Collectors.groupingBy((student -> student.getGpa() >= 3.8 ? "Outstanding" : "Average")));

		System.out.println("Students Grouped By Customized GPA\n" + groupByGPA);

		System.out.println(
				"\n---------------------------------------Streams GroupingBy Version-2---------------------------------------\n");

		Map<Integer, Map<String, List<Student>>> studentMap = studentList.stream()
				.collect(Collectors.groupingBy((student -> student.getGradeLevel()),
						Collectors.groupingBy(student -> student.getGpa() >= 3.8 ? "Outstanding" : "Average")));

		System.out.println("Printing Students by Grade and GPA\n" + studentMap);

		System.out.println("\n------------------------------------------------------------------------------\n");

		Map<Integer, Integer> studentNotebookMap = studentList.stream().collect(Collectors
				.groupingBy((student -> student.getGradeLevel()), Collectors.summingInt(Student::getNotebooks)));

		System.out.println("Printing Students by Grade and Number of Notebooks\n" + studentNotebookMap);

		System.out.println(
				"\n---------------------------------------Streams GroupingBy Version-3---------------------------------------\n");

		LinkedHashMap<String, Set<Student>> studentMapByNames = studentList.stream()
				.collect(Collectors.groupingBy(Student::getName, LinkedHashMap::new, Collectors.toSet()));
		System.out.println("Student Map By Names\n" + studentMapByNames);

		System.out.println(
				"\n---------------------------------------Streams GroupingBy MaxBy and MinBy---------------------------------------\n");

		Map<Integer, Student> studentGradeandGPAMax = studentList.stream().collect(Collectors.groupingBy(
				Student::getGradeLevel,
				Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(Student::getGpa)), Optional::get)));

		System.out.println("Student Grade and GPA Map\n" + studentGradeandGPAMax);

		System.out.println("\n------------------------------------------------------------------------------\n");

		Map<Integer, Student> studentGradeandGPAMin = studentList.stream().collect(Collectors.groupingBy(
				Student::getGradeLevel,
				Collectors.collectingAndThen(Collectors.minBy(Comparator.comparing(Student::getGpa)), Optional::get)));

		System.out.println("Student Grade and GPA Map\n" + studentGradeandGPAMin);

		System.out.println(
				"\n---------------------------------------Streams PartitioningBy Version-1---------------------------------------\n");

		Map<Boolean, List<Student>> gpaPartitioningList = studentList.stream()
				.collect(Collectors.partitioningBy(studentGPAPredicate));

		System.out.println("Partitioning Students Based on GPA List\n" + gpaPartitioningList);
		
		System.out.println(
				"\n---------------------------------------Streams PartitioningBy Version-2---------------------------------------\n");

		Map<Boolean, Set<Student>> gpaPartitioningSet = studentList.stream()
				.collect(Collectors.partitioningBy(studentGPAPredicate, Collectors.toSet()));

		System.out.println("Partitioning Students Based on GPA Set\n" + gpaPartitioningSet);
		
	}
}
