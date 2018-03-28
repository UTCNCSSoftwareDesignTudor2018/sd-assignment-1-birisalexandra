package business;

import java.util.ArrayList;

import dao.SubjectDAO;

public class SubjectBLL {
	
	public ArrayList<String> setInComboBox() {
		SubjectDAO con = new SubjectDAO();
		return con.selectAll();
	}
	
	public ArrayList<String> setInComboBoxPreference(int id) {
		SubjectDAO con = new SubjectDAO();
		return con.selectAllById(id);
	}
	
	public int getId(String title) {
		SubjectDAO con = new SubjectDAO();
		return con.getIdFromTitle(title);
	}
	
	public boolean addSubject(String name) {
		SubjectDAO con = new SubjectDAO();
		if (con.checkSubject(name) == 0)
			return false;
		else
			con.insertNewSubject(name);
		return true;
	}	
}
