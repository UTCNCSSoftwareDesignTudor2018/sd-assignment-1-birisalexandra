package business;

import dao.EnrollDAO;
import dao.StudentDAO;
import dao.SubjectDAO;
import dao.models.Enroll;

public class EnrollBLL {

	public boolean enrollToSubject(Enroll data) {
		EnrollDAO con = new EnrollDAO();
		StudentDAO stud = new StudentDAO();
		SubjectDAO sub = new SubjectDAO();
		
		if (con.checkEnroll(stud.findIdByUsername(data.getUsername()), sub.getIdFromTitle(data.getSubject())) == 0)
			return false;
		else {
			con.insert(stud.findIdByUsername(data.getUsername()), sub.getIdFromTitle(data.getSubject()));
			return true;
		}
	}
	
	public StringBuilder getEnrollments(String username) {
		StudentDAO stud = new StudentDAO();
		EnrollDAO enr = new EnrollDAO();
		return enr.getEnrollments(stud.findIdByUsername(username));
	}
}
