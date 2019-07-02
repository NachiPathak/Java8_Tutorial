package entity;

import java.util.List;
import java.util.Optional;

public class Student {

	private String name;
	private int gradeLevel;
	private double gpa;
	private String gender;
	private List<String> activities;
	private int notebooks;
	private Optional<Bike> bike = Optional.empty();

	public Student() {

	}

	public Student(String name, int gradeLevel, double gpa, String gender, List<String> activities, int notebooks) {
		super();
		this.name = name;
		this.gradeLevel = gradeLevel;
		this.gpa = gpa;
		this.gender = gender;
		this.activities = activities;
		this.notebooks = notebooks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getGradeLevel() {
		return gradeLevel;
	}

	public void setGradeLevel(int gradeLevel) {
		this.gradeLevel = gradeLevel;
	}

	public double getGpa() {
		return gpa;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<String> getActivities() {
		return activities;
	}

	public void setActivities(List<String> activities) {
		this.activities = activities;
	}

	public int getNotebooks() {
		return notebooks;
	}

	public void setNotebooks(int notebooks) {
		this.notebooks = notebooks;
	}

	public Optional<Bike> getBike() {
		return bike;
	}

	public void setBike(Optional<Bike> bike) {
		this.bike = bike;
	}

	@Override
	public String toString() {
		return "\nStudent [name=" + name + ", gradeLevel=" + gradeLevel + ", gpa=" + gpa + ", gender=" + gender
				+ ", activities=" + activities + ", notebooks=" + notebooks + ", bike=" + bike + "]";
	}

}
