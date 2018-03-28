package dao.models;

public class Student {
	private String username;
	private String password;
	private StudentInfo info;
	private StudentProfile profile;
	
	public Student(String username, String password, StudentInfo info) {
		this.username = username;
		this.password = password;
		this.info = info;
	}
	
	public String getUsername() {
		return username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public StudentInfo getStudentInfo() {
		return info;
	}
}
