package testing;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import business.StudentInfoBLL;
import dao.StudentDAO;

@RunWith(MockitoJUnitRunner.class)
public class TestStudent {
	private StudentInfoBLL student;
	private StudentDAO studentQuery;
	
	@Before
	public void setUp(){
		student = new StudentInfoBLL();
		studentQuery = mock(StudentDAO.class);
	}
	
	@Test
	public void testFunctionalities(){
		when(studentQuery.checkLogin("alebiris")).thenReturn("1234");
		when(studentQuery.findIdByUsername("db")).thenReturn(3);
		when(studentQuery.findIdByName("Biris Alexandra")).thenReturn(2);
		
		Assert.assertEquals(student.checkLogin("alebiris", "1234"), true);
		Assert.assertEquals(student.findId("db"), 3);
		Assert.assertEquals(student.findByName("Biris Alexandra"), 2);
	}
}
