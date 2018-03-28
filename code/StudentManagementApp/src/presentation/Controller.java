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

public class Controller {
	private GUI g;
	
	public Controller(GUI g) {
		this.g = g;
		this.g.loginListener(new Login());
		this.g.viewListener(new View());
		this.g.updateListener(new Update());
		this.g.gradeListener(new Grade());	
		setComboBoxGrade();
		this.g.enrollListener(new EnrollStud());
		this.g.enrollmentListener(new Enrollment());
		this.g.studentListener(new AddStudent());
		this.g.deleteListener(new Delete());
		setComboBoxStudent();
		this.g.addSubjectListener(new AddSubject());
		this.g.addAddGradeListener(new AddGrade());
		this.g.addComboListener(new CheckBox());
	}
	
	public class Login implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			StudentInfoBLL businessLayer= new StudentInfoBLL();
			if (g.getTextFieldPass().equals("admin")) {
				g.getMainPanel().setVisible(false);
				g.getTeacherPanel().setVisible(true);
			}
			else 
				if (businessLayer.checkLogin(g.getTextFieldUser().toString(), g.getTextFieldPass().toString()) == true) {
					g.getMainPanel().setVisible(false);
					g.getStudentPanel().setVisible(true);
				}
				else
					g.setLabelMain("Username or password are inccorect!");
		}
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
	
	public class Grade implements ActionListener {
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
	public void setComboBoxGrade(int id) {
		SubjectBLL businessLayer = new SubjectBLL();
		ArrayList<String> list = businessLayer.setInComboBoxPreference(id);
		for(int i = 0; i < list.size(); i++) {
			g.getComboBoxAddGrade_Subject().addItem(list.get(i));
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
			
			if (businessLayer1.enrollToSubject(new Enroll(g.getComboBoxSubject().getSelectedItem().toString(), g.getTextFieldUser())) == false)
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
			g.getTextArea().setText(enr.getEnrollments(g.getTextFieldUser()).toString());
		}
	}
	
	public class AddStudent implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			StudentInfoBLL stud = new StudentInfoBLL();
			Student toBeInserted = new Student(g.getTextFieldUser2(), g.getTextFieldPass2(), new StudentInfo(g.getTextFieldName2(), g.getTextFieldCard2(), g.getTextFieldCode2(), g.getTextFieldAddress2()));
			
			if (stud.insertNew(toBeInserted) == false)
				g.setTeacherWarning("Data format is inccorect!");
			else 
				g.setTeacherWarning("Student successfully inserted!");
		}
	}
	
	public class Delete implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			StudentInfoBLL stud = new StudentInfoBLL();
			String name = g.getComboBoxStudent().getSelectedItem().toString();
			stud.deleteStud(name);
			g.setDeleteWarning("Student was deleted!");
			g.getComboBoxStudent().removeItem(name);
		}
	}

	public class AddSubject implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			SubjectBLL businessLayer = new SubjectBLL();
			if (businessLayer.addSubject(g.getTextFieldSubject()) == false)
				g.setLblSubjectWarning("Subject already exists!");
			else
				g.setLblSubjectWarning("Subject successfully inserted!");
		}
	}
	
	public class AddGrade implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			GradeBLL businessLayer1 = new GradeBLL();
			StudentInfoBLL businessLayer2 = new StudentInfoBLL();
			SubjectBLL businessLayer3 = new SubjectBLL();

			if (businessLayer1.updateGrade(g.getTextFieldAddGrade(), businessLayer2.findByName(g.getComboBoxAddGrade_Student().getSelectedItem().toString()), businessLayer3.getId(g.getComboBoxAddGrade_Subject().getSelectedItem().toString())) == false)
				g.setLblAddGradeWarning("Grade should be between 1 and 10!");
			else
				g.setLblAddGradeWarning("Grade saved!");
		}
	}
	
	public class CheckBox implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			g.getComboBoxAddGrade_Subject().removeAllItems();
			StudentInfoBLL businessLayer2 = new StudentInfoBLL();
			setComboBoxGrade(businessLayer2.findByName(g.getComboBoxAddGrade_Student().getSelectedItem().toString()));
		}
	}
}
