package business;

import java.util.ArrayList;

import dao.GradeDAO;
import dao.models.Grade;


public class GradeBLL {

	public Object[][] gradeData(int studentId) {
		GradeDAO con = new GradeDAO();
		ArrayList<Grade> list = con.selectGrades(studentId);
		
		Object[][] data = new Object[list.size()][2];
		Grade c = null;
		for (int i = 0; i < list.size(); i++) {
			c = list.get(i);
			data[i][0] = c.getSubject();
			data[i][1] = c.getMark();
		}
		return data;
	}
	
	public void addGrade(int sub, int stud) {
		GradeDAO con = new GradeDAO();
		con.addGrade(sub, stud);
	}
	
	public boolean updateGrade(int grade, int student_id, int subjects_id) {
		GradeDAO con = new GradeDAO();
		if (grade < 0 || grade > 10)
			return false;
		else
			con.updateGrade(grade, student_id, subjects_id);
		return true;
	}
}
