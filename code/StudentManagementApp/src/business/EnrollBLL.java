package business;

import java.util.ArrayList;

import dao.EnrollDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import dao.models.Enroll;

public class EnrollBLL {

	public boolean enrollToSubject(Enroll data) {
		EnrollDAO con = new EnrollDAO();
		StudentDAO stud = new StudentDAO();
		SubjectDAO sub = new SubjectDAO();
		
		if (con.checkEnroll(stud.findIdByUsername(data.getUsername().getUsername()), sub.getIdFromTitle(data.getGrade().getSubject())) == 0)
			return false;
		else {
			con.insert(stud.findIdByUsername(data.getUsername().getUsername()), sub.getIdFromTitle(data.getGrade().getSubject()));
			return true;
		}
	}
	
	public ArrayList<String> getEnrollments(String username) {
		StudentDAO stud = new StudentDAO();
		EnrollDAO enr = new EnrollDAO();
		
		return enr.getEnrollments(stud.findIdByUsername(username));
	}
}
