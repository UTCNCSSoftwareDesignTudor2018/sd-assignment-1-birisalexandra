package testing;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

import business.SubjectBLL;
import dao.SubjectDAO;

@RunWith(MockitoJUnitRunner.class)
public class TestSubject {
	private SubjectBLL subject;
	private SubjectDAO subjectQuery;
	
	@Before
	public void setUp(){
		subject = new SubjectBLL();
		subjectQuery = mock(SubjectDAO.class);
	}
	
	@Test
	public void testFunctionality1(){
		when(subjectQuery.checkSubject("Software design")).thenReturn(0);
		Assert.assertEquals(subject.addSubject("Software design"), false);
		
		when(subjectQuery.checkSubject("Assembly")).thenReturn(1);
		Assert.assertEquals(subject.addSubject("Assembly"), true);
	}
	
	@Test
	public void testFunctionality2() {	
		when(subjectQuery.getIdFromTitle("Software design")).thenReturn(3);
		Assert.assertEquals(subject.getId("Software design"), 3);
	}
}
