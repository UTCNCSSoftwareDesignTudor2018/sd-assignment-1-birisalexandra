package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import dao.models.Student;
import dao.models.StudentInfo;

public class StudentDAO {
	protected final static Logger LOGGER = Logger.getLogger(StudentDAO.class.getName());
	private final static String findByUsername = "SELECT * FROM studentdb.student where username = ?";
	private static final String editInfo = "UPDATE studentdb.student SET name = ?, address = ?, cardNumber = ?, numericalCode = ? WHERE username = ?";
	private final static String findIdByUsername = "SELECT student.id FROM studentdb.student where username = ?";
	private static final String insertNewStudent = "INSERT INTO studentdb.student (name,cardNumber,numericalCode,address,username,password) VALUES (?,?,?,?,?,?)";
	private static final String selectAllNames = "SELECT student.name FROM studentdb.student";
	private static final String deleteStudent = "DELETE FROM studentdb.student WHERE name = ?";
	private final static String findIdByName = "SELECT student.id FROM studentdb.student where name = ?";
	private final static String checkLogin = "SELECT student.password FROM studentdb.student WHERE username = ?";
	
	public StudentInfo findByUsername(String username) {
		StudentInfo toReturn = null;

		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			statement = conn.prepareStatement(findByUsername);
			statement.setString(1, username);
			rs = statement.executeQuery();
			rs.next();

			String name = rs.getString("name");
			String cardNumber = rs.getString("cardNumber");
			String numericalCode = rs.getString("numericalCode");
			String address = rs.getString("address");
			toReturn = new StudentInfo(name, cardNumber, numericalCode, address);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"StudentDAO: findByUsername " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
		return toReturn;
	}

	public void editInfo(StudentInfo info, String username) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		try {
			statement = conn.prepareStatement(editInfo);
			statement.setString(1, info.getName());
			statement.setString(2, info.getAddress());
			statement.setString(3, info.getIdentityCardNumber());
			statement.setString(4, info.getNumericalCode());
			statement.setString(5,  username);
			statement.execute();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Student can not be updated!");
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
	}
	
	public int findIdByUsername(String username) {
		int toReturn = 0;

		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			statement = conn.prepareStatement(findIdByUsername);
			statement.setString(1, username);
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
	
	public int findIdByName(String name) {
		int toReturn = 0;

		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			statement = conn.prepareStatement(findIdByName);
			statement.setString(1, name);
			rs = statement.executeQuery();
			rs.next();

			toReturn = rs.getInt("id");
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"StudentDAO: findByName " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
		return toReturn;
	}
	
	public void insertNewStudent(Student stud) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = conn.prepareStatement(insertNewStudent);
			statement.setString(1, stud.getStudentInfo().getName());
			statement.setString(2, stud.getStudentInfo().getIdentityCardNumber());
			statement.setString(3, stud.getStudentInfo().getNumericalCode());
			statement.setString(4, stud.getStudentInfo().getAddress());
			statement.setString(5, stud.getUsername());
			statement.setString(6, stud.getPassword());
			statement.executeUpdate();
			
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Student can not be inserted!");
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
	}
	
	public ArrayList<String> selectAllNames() {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		ArrayList<String> list = new ArrayList<String>();
		
		try {
			statement = conn.prepareStatement(selectAllNames);
			rs = statement.executeQuery();
			
			while(rs.next()) {
				list.add(rs.getString(1));
			}
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"StudentDAO: selectAllNames " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
		return list;
	}
	
	public void delete(String name) {
		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		
		try {
			statement = conn.prepareStatement(deleteStudent);
			statement.setString(1, name);
			statement.executeUpdate();
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING, "Student cannot be deleted!");
		} finally {
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
	}
	
	public String checkLogin(String username) {
		String toReturn = null;

		Connection conn = ConnectionFactory.getConnection();
		PreparedStatement statement = null;
		ResultSet rs = null;
		try {
			statement = conn.prepareStatement(checkLogin);
			statement.setString(1, username);
			rs = statement.executeQuery();
			rs.next();

			return rs.getString(1);
		} catch (SQLException e) {
			LOGGER.log(Level.WARNING,"StudentDAO: checkLogin " + e.getMessage());
		} finally {
			ConnectionFactory.close(rs);
			ConnectionFactory.close(statement);
			ConnectionFactory.close(conn);
		}
		return toReturn;
	}
}
