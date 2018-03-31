package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import business.GradeBLL;
import business.StudentInfoBLL;
import business.SubjectBLL;
import dao.models.Student;
import dao.models.StudentInfo;

public class ControllerTeacher {
	private GUI g;
	
	public ControllerTeacher(GUI g) {
		this.g = g;
		this.g.studentListener(new AddStudent());
		this.g.deleteListener(new Delete());
		
		this.g.addSubjectListener(new AddSubject());
		this.g.addAddGradeListener(new AddGrade());
		this.g.addComboListener(new CheckBox());
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
	
	@SuppressWarnings("unchecked")
	public void setComboBoxGrade(int id) {
		SubjectBLL businessLayer = new SubjectBLL();
		ArrayList<String> list = businessLayer.setInComboBoxPreference(id);
		for(int i = 0; i < list.size(); i++) {
			g.getComboBoxAddGrade_Subject().addItem(list.get(i));
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
