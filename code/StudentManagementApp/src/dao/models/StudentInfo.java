package dao.models;

public class StudentInfo {
	private String name;
	private String identityCardNumber;
	private String numericalCode;
	private String address;
	
	public StudentInfo(String n, String i, String nc, String a) {
		this.name = n;
		this.identityCardNumber = i;
		this.numericalCode = nc;
		this.address = a; 
	}

	public String getName() {
		return name;
	}

	public String getIdentityCardNumber() {
		return identityCardNumber;
	}

	public String getNumericalCode() {
		return numericalCode;
	}

	public String getAddress() {
		return address;
	}
	
	
}
