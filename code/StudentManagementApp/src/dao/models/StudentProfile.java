package dao.models;

import java.util.ArrayList;

public class StudentProfile {
	private ArrayList<String> enrollments;
	
	public StudentProfile() {
		enrollments = new ArrayList<String>();
	}

	public ArrayList<String> getEnrollments() {
		return this.enrollments;
	}

}
