package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class EnrollDAO {
	protected static final Logger LOGGER = Logger.getLogger(EnrollDAO.class.getName());
	private static final String insertNewEnroll = "INSERT INTO studentdb.enroll (student_id, subjects_id) VALUES (?,?)";
	private static final String checkEnroll = "SELECT * FROM studentdb.enroll WHERE student_id = ? AND subjects_id = ?";
	private static final String  getEnrollments = "SELECT subjects.title FROM studentdb.enroll JOIN studentdb.subjects ON enroll.subjects_id = subjects.id WHERE student_id = ?";
	
	public void insert(int student_id, int subjects_id) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = conn.prepareStatement(insertNewEnroll);
			statement.setInt(1, student_id);
			statement.setInt(2, subjects_id);
			statement.executeUpdate();
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Enrollment can not be inserted!");
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
	}
	
	public int checkEnroll(int student_id, int subjects_id) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		int toReturn = 0;
		
		try {
			statement = conn.prepareStatement(checkEnroll);
			statement.setInt(1, student_id);
			statement.setInt(2, subjects_id);
			rs = statement.executeQuery();
			
			if(rs.next())
				toReturn = 0;
			else
				toReturn = 1;
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Enrollment can not be inserted 2!");
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
		
		return toReturn;
	}
	
	public StringBuilder getEnrollments(int student_id) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		StringBuilder response = new StringBuilder();
		
		try {
			statement = conn.prepareStatement(getEnrollments);
			statement.setInt(1, student_id);
			rs = statement.executeQuery();
			
			while(rs.next()) {
				response.append(rs.getString(1));
				response.append("\n");
			}
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Enrollment can not be get!");
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
		
		return response;
	}
	
}
