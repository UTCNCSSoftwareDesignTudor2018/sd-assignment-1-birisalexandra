package dao.models;

public class Enroll {
	private String subject;
	private String username;
	
	public Enroll(String subject, String username) {
		this.subject = subject;
		this.username = username;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	
}
