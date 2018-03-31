package presentation;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import business.EnrollBLL;
import business.GradeBLL;
import business.StudentInfoBLL;
import business.SubjectBLL;
import dao.models.Enroll;
import dao.models.Student;
import dao.models.StudentInfo;
import dao.models.Grade;

public class ControllerStudent {
	private GUI g;
	
	public ControllerStudent(GUI g) {
		this.g= g;
		this.g.viewListener(new View());
		this.g.updateListener(new Update());
		this.g.gradeListener(new Grade2());	
		setComboBoxGrade();
		this.g.enrollListener(new EnrollStud());
		this.g.enrollmentListener(new Enrollment());
		setComboBoxStudent();
	}
	
	public class View implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			StudentInfoBLL businessLayer= new StudentInfoBLL();
			StudentInfo info = businessLayer.viewInfo(g.getTextFieldUser());
			if (info.getAddress().isEmpty()) {
				g.setTextFieldAddress("Empty field!");
				g.getTextFieldAddress().setForeground(Color.RED);
			}
			else
				g.setTextFieldAddress(info.getAddress());
			
			if (info.getIdentityCardNumber().isEmpty()) {
				g.setTextFieldCard("Empty field!");
				g.getTextFieldCard().setForeground(Color.RED);
			}
			else
				g.setTextFieldCard(info.getIdentityCardNumber());
			
			if (info.getNumericalCode().isEmpty()) {
				g.setTextFieldCode("Empty field!");
				g.getTextFieldCode().setForeground(Color.RED);
			}
			else
				g.setTextFieldCode(info.getNumericalCode());	
			
			if (info.getName().isEmpty()) {
				g.setTextFieldName("Empty field!");
				g.getTextFieldName().setForeground(Color.RED);
			}
			else
				g.setTextFieldName(info.getName());
		}
	}
	
	public class Update implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			StudentInfoBLL businessLayer = new StudentInfoBLL();
			StudentInfo toBeChecked = new StudentInfo(g.getTextFieldName().getText().toString(), g.getTextFieldCard().getText().toString(), g.getTextFieldCode().getText().toString(), g.getTextFieldAddress().getText().toString());
			if (businessLayer.validate(toBeChecked, g.getTextFieldUser()) == false)
				g.setLabelWarning("Wrong information format!");
			else
				g.setLabelWarning("Successfully updated!");
		}
	}
	
	public class Grade2 implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			g.getStudentPanel().setVisible(false);
			g.getGradePanel().setVisible(true);
			
			StudentInfoBLL businessLayer1 = new StudentInfoBLL();
			GradeBLL businessLayer2 = new GradeBLL();
			g.updateTable(businessLayer2.gradeData(businessLayer1.findId(g.getTextFieldUser())));
		}
	}
	
	@SuppressWarnings("unchecked")
	public void setComboBoxGrade() {
		SubjectBLL businessLayer = new SubjectBLL();
		ArrayList<String> list = businessLayer.setInComboBox();
		for(int i = 0; i < list.size(); i++) {
			g.getComboBoxSubject().addItem(list.get(i));
		}
	}
	
	@SuppressWarnings("unchecked")
	public void setComboBoxStudent() {
		StudentInfoBLL businessLayer = new StudentInfoBLL();
		ArrayList<String> list = businessLayer.setInComboBoxNames();
		for(int i = 0; i < list.size(); i++) {
			g.getComboBoxStudent().addItem(list.get(i));
			g.getComboBoxAddGrade_Student().addItem(list.get(i));
		}
	}
	
	public class EnrollStud implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			EnrollBLL businessLayer1 = new EnrollBLL();
			GradeBLL businessLayer2 = new GradeBLL();
			StudentInfoBLL businessLayer3 = new StudentInfoBLL();
			SubjectBLL businessLayer4 = new SubjectBLL();
			
			StudentInfo stud = businessLayer3.viewInfo(g.getTextFieldUser());
			
			if (businessLayer1.enrollToSubject(new Enroll(new Grade(g.getComboBoxSubject().getSelectedItem().toString()), new Student(g.getTextFieldUser(), g.getTextFieldPass(), stud))) == false)
				g.setLabelEnroll("You are already enrolled to this subject!");
			else {
				g.setLabelEnroll("Enrollment success!");
				businessLayer2.addGrade(businessLayer4.getId(g.getComboBoxSubject().getSelectedItem().toString()), businessLayer3.findId(g.getTextFieldUser()));
			}
		}
	}
	
	public class Enrollment implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			EnrollBLL enr = new EnrollBLL();
			ArrayList<String> list = enr.getEnrollments(g.getTextFieldUser());
			for(int i = 0; i < list.size(); i++) {
				g.getTextArea().append(list.get(i));
				g.getTextArea().append("\n");
			}
		}
	}
	
}
