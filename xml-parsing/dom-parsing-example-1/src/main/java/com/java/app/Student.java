package com.java.app;

public class Student {
	String studentId;
	String firstName;
	String lastName;
	String courseName;

	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", courseName=" + courseName + "]";
	}

}
