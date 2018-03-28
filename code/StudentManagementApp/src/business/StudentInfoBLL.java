package business;

import java.util.ArrayList;

import business.validators.Validator;
import dao.StudentDAO;
import dao.models.Student;
import dao.models.StudentInfo;

public class StudentInfoBLL implements Validator<StudentInfo>{
	
	public StudentInfo viewInfo(String username) {
		StudentDAO con = new StudentDAO();
		return con.findByUsername(username);
	}
	
	public int findId(String username) {
		StudentDAO con = new StudentDAO();
		return con.findIdByUsername(username);
	}
	
	public int findByName(String name) {
		StudentDAO con = new StudentDAO();
		return con.findIdByName(name);
	}
	
	public boolean insertNew(Student stud) {
		if (stud.getStudentInfo().getNumericalCode().length() != 13)
			return false;
		if (stud.getStudentInfo().getIdentityCardNumber().length() != 8)
			return false;
		
		StudentDAO con = new StudentDAO();
		con.insertNewStudent(stud);
		return true;
	}
	
	public void deleteStud(String name) {
		StudentDAO con = new StudentDAO();
		con.delete(name);
	}

	@Override
	public boolean validate(StudentInfo t, String username) {
		StudentDAO con = new StudentDAO();
		if (t.getNumericalCode().length() != 13)
			return false;
		if (t.getIdentityCardNumber().length() != 8)
			return false;
		con.editInfo(t, username);
		return true;
	}
	
	public ArrayList<String> setInComboBoxNames() {
		StudentDAO con = new StudentDAO();
		return con.selectAllNames();
	}
	
	public boolean checkLogin(String username, String password) {
		StudentDAO con = new StudentDAO();
		if (con.checkLogin(username).equals(password))
			return true;
		return false;
	}
	
}