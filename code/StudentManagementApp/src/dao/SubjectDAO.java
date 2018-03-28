package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SubjectDAO {
	protected final static Logger LOGGER = Logger.getLogger(SubjectDAO.class.getName());
	private final static String selectAll = "SELECT subjects.title FROM studentdb.subjects";
	private final static String getIdFromTitle = "SELECT subjects.id FROM studentdb.subjects WHERE title = ?";
	private static final String insertNewSubject = "INSERT INTO studentdb.subjects (title) VALUES (?)";
	private static final String checkSubject = "SELECT * FROM studentdb.subjects WHERE title = ?";
	private static final String selectAllById = "SELECT subjects.title FROM studentdb.subjects JOIN studentdb.student_subject ON student_subject.subjects_id = subjects.id WHERE student_id = ?"; 

	
	public ArrayList<String> selectAll() {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			statement = conn.prepareStatement(selectAll);
			rs = statement.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"SubjectDAO: selectAll " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
		return list;
	}
	
	public int getIdFromTitle(String title) {
		int toReturn = 0;

		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			statement = conn.prepareStatement(getIdFromTitle);
			statement.setString(1, title);
			rs = statement.executeQuery();
			rs.next();

			toReturn = rs.getInt("id");
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"StudentDAO: findByUsername " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
		return toReturn;
	}
	
	public void insertNewSubject(String sub) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = conn.prepareStatement(insertNewSubject);
			statement.setString(1, sub);
			statement.executeUpdate();
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Subject can not be inserted!");
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
	}
	
	public int checkSubject(String title) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		int toReturn = 0;
		
		try {
			statement = conn.prepareStatement(checkSubject);
			statement.setString(1, title);
			rs = statement.executeQuery();
			
			if(rs.next())
				toReturn = 0;
			else
				toReturn = 1;
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Subject can not be inserted!");
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
		return toReturn;
	}
	
	public ArrayList<String> selectAllById(int id) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			statement = conn.prepareStatement(selectAllById);
			statement.setInt(1, id);
			rs = statement.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"SubjectDAO: selectAllById " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
		return list;
	}
}
