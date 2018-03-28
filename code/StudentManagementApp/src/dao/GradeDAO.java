package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.models.Grade;
import dao.models.Student;
import dao.models.StudentInfo;

public class GradeDAO {
	protected final static Logger LOGGER = Logger.getLogger(GradeDAO.class.getName());
	private final static String selectGrades = "SELECT subjects.title, student_subject.grade FROM studentdb.student_subject JOIN studentdb.subjects ON subjects.id = student_subject.subjects_id WHERE student_id = ?";
	private final static String updateGrade = "UPDATE studentdb.student_subject SET grade = ? WHERE student_id = ? AND subjects_id = ?";
	private final static String addGrade = "INSERT INTO studentdb.student_subject (subjects_id, student_id) VALUES (?,?)";
	
	public ArrayList<Grade> selectGrades(int studentId) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		ArrayList<Grade> list = new ArrayList<Grade>();
		
		try {
			statement = conn.prepareStatement(selectGrades);
			statement.setInt(1, studentId);
			rs = statement.executeQuery();
			
			while(rs.next()) {
				list.add(new Grade(rs.getString(1), rs.getInt(2)));
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"StudentDAO: findByUsername " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
		return list;
	}
	
	public void addGrade(int sub, int stud) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = conn.prepareStatement(addGrade);
			statement.setInt(1, sub);
			statement.setInt(2, stud);
			statement.executeUpdate();
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Student can not be inserted!");
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
	}
	
	public void updateGrade(int grade, int student_id, int subjects_id) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = conn.prepareStatement(updateGrade);
			statement.setInt(1, grade);
			statement.setInt(2, student_id);
			statement.setInt(3, subjects_id);
			statement.execute();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Grade can not be updated!");
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
	}
}
