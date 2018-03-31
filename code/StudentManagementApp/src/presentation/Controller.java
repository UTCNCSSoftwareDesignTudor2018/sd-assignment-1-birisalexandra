package presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import business.StudentInfoBLL;


public class Controller {
	private GUI g;
	
	public Controller(GUI g) {
		new ControllerStudent(g);
		new ControllerTeacher(g);
		this.g = g;
		this.g.loginListener(new Login());
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
}
