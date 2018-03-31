package dao.models;

public class Enroll {
	private Grade grade;
	private Student username;
	
	public Enroll(Grade grade, Student username) {
		this.grade = grade;
		this.username = username;
	}

	public Grade getGrade() {
		return this.grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public Student getUsername() {
		return this.username;
	}

	public void setUsername(Student username) {
		this.username = username;
	}
	
	
}
