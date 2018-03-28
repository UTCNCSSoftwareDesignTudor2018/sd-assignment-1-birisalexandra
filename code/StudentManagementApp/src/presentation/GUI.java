package presentation;

import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import java.awt.CardLayout;
import javax.swing.JTable;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldUser;
	private JPanel studentPanel = new JPanel();
	private JPanel teacherPanel = new JPanel();
	private JPanel mainPanel = new JPanel();
	private JPanel enrollPanel = new JPanel();
	private JTextField textFieldName;
	private JTextField textFieldCard;
	private JTextField textFieldCode;
	private JTextField textFieldAddress;
	private JButton btnLogIn = new JButton("Log in ");
	private JButton btnViewInfo = new JButton("View");
	private JButton btnUpdateInfo = new JButton("Update");
	private JButton btnGrades = new JButton("Grades");
	private JButton btnEnroll_1 = new JButton("Enroll");
	private JButton btnEnrollments = new JButton("Enrollments");
	private JButton btnAddStudent = new JButton("Add student");
	private JButton btnDelete = new JButton("Delete");
	private JButton btnSubject = new JButton("Add subject");
	private JButton btnAddGrades = new JButton("Add grades");
	private JButton btnAddGrade = new JButton("Add");
	private JButton btnAdd = new JButton("Add");
	private JLabel labelWarning = new JLabel("");
	private JLabel lblEnrollWarning = new JLabel("");
	private JLabel lblTeacherWarning = new JLabel("");
	private JLabel lblSubjectWarning = new JLabel("");
	private JLabel labelAddGradeWarning = new JLabel("");
	private JLabel label = new JLabel("");
	private JLabel deleteWarning = new JLabel("");
	private JPanel gradesPanel = new JPanel();
	private JPanel enrollmentsPanel = new JPanel();
	private JPanel deletePanel = new JPanel();
	private JPanel subjectPanel = new JPanel();
	private JPanel addGradePanel = new JPanel();
	private JTable gradeTable;
	private JScrollPane scrollPaneGrade = new JScrollPane();
	private JComboBox comboBoxSubject = new JComboBox();
	private JComboBox comboBox = new JComboBox();
	private JComboBox comboBoxAddGrade_Student = new JComboBox();
	private JComboBox comboBoxAddGrade_Subject = new JComboBox();
	private JTextArea textArea = new JTextArea();
	private JTextField textFieldUser2;
	private JTextField textFieldPass2;
	private JTextField textFieldName2;
	private JTextField textFieldCard2;
	private JTextField textFieldCode2;
	private JTextField textFieldAddress2;
	private JTextField textFieldSubject;
	private JTextField textFieldAddGrade;
	private JPasswordField textFieldPass;
	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		contentPane.add(mainPanel, "name_459422405291626");
		mainPanel.setLayout(null);
		
		JLabel lblLogin = new JLabel("LOGIN");
		lblLogin.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblLogin.setBounds(177, 28, 62, 27);
		mainPanel.add(lblLogin);
		
		textFieldUser = new JTextField();
		textFieldUser.setBounds(187, 66, 142, 20);
		mainPanel.add(textFieldUser);
		textFieldUser.setColumns(10);
		
		JLabel testLabel = new JLabel("");
		testLabel.setBounds(114, 201, 215, 20);
		mainPanel.add(testLabel);
		
		btnLogIn.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		btnLogIn.setBounds(153, 156, 101, 34);
		mainPanel.add(btnLogIn);
		
		JLabel lblNewLabel = new JLabel("Username:");
		lblNewLabel.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblNewLabel.setBounds(99, 68, 111, 17);
		mainPanel.add(lblNewLabel);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblPassword.setBounds(99, 115, 111, 17);
		mainPanel.add(lblPassword);
		
		label.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		label.setBounds(114, 207, 222, 20);
		mainPanel.add(label);
		
		textFieldPass = new JPasswordField();
		textFieldPass.setBounds(187, 113, 142, 20);
		mainPanel.add(textFieldPass);
		
		contentPane.add(studentPanel, "name_459432056275915");
		studentPanel.setLayout(null);
		
		JLabel lblInformation = new JLabel("Information");
		lblInformation.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblInformation.setBounds(76, 13, 98, 25);
		studentPanel.add(lblInformation);
		
		JLabel lblProfile = new JLabel("Profile");
		lblProfile.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblProfile.setBounds(296, 15, 82, 21);
		studentPanel.add(lblProfile);
		
		textFieldName = new JTextField();
		textFieldName.setBounds(86, 49, 88, 20);
		studentPanel.add(textFieldName);
		textFieldName.setColumns(10);
		
		textFieldCard = new JTextField();
		textFieldCard.setBounds(86, 79, 88, 20);
		studentPanel.add(textFieldCard);
		textFieldCard.setColumns(10);
		
		textFieldCode = new JTextField();
		textFieldCode.setBounds(86, 110, 88, 20);
		studentPanel.add(textFieldCode);
		textFieldCode.setColumns(10);
		
		textFieldAddress = new JTextField();
		textFieldAddress.setBounds(86, 141, 88, 21);
		studentPanel.add(textFieldAddress);
		textFieldAddress.setColumns(10);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblName.setBounds(44, 48, 56, 25);
		studentPanel.add(lblName);
		
		JLabel lblAddress = new JLabel("Address:");
		lblAddress.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblAddress.setBounds(32, 144, 46, 17);
		studentPanel.add(lblAddress);
		
		JLabel lblNumericalCode = new JLabel("Numerical code:");
		lblNumericalCode.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblNumericalCode.setBounds(0, 111, 100, 20);
		studentPanel.add(lblNumericalCode);
		
		JLabel lblCardNumber = new JLabel("Card number:");
		lblCardNumber.setFont(new Font("Sylfaen", Font.PLAIN, 12));
		lblCardNumber.setBounds(10, 83, 76, 14);
		studentPanel.add(lblCardNumber);
		
		btnUpdateInfo.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		btnUpdateInfo.setBounds(122, 173, 89, 23);
		studentPanel.add(btnUpdateInfo);
		
		btnViewInfo.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		btnViewInfo.setBounds(23, 173, 89, 23);
		studentPanel.add(btnViewInfo);
		
		labelWarning.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		labelWarning.setBounds(22, 209, 213, 20);
		studentPanel.add(labelWarning);
		
		btnGrades.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		btnGrades.setBounds(257, 68, 121, 23);
		studentPanel.add(btnGrades);
		
		JButton btnEnroll = new JButton("Enroll");
		btnEnroll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentPanel.setVisible(false);
				enrollPanel.setVisible(true);
			}
		});
		btnEnroll.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		btnEnroll.setBounds(257, 110, 121, 23);
		studentPanel.add(btnEnroll);
		btnEnrollments.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enrollmentsPanel.setVisible(true);
				studentPanel.setVisible(false);
			}
		});
		
		btnEnrollments.setFont(new Font("Sylfaen", Font.PLAIN, 11));
		btnEnrollments.setBounds(257, 151, 121, 23);
		studentPanel.add(btnEnrollments);
		
		contentPane.add(teacherPanel, "name_459466863848480");
		teacherPanel.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblUsername.setBounds(20, 11, 71, 18);
		teacherPanel.add(lblUsername);
		
		JLabel lblPassword_1 = new JLabel("Password");
		lblPassword_1.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblPassword_1.setBounds(20, 42, 90, 18);
		teacherPanel.add(lblPassword_1);
		
		JLabel lblName_1 = new JLabel("Name");
		lblName_1.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblName_1.setBounds(29, 71, 71, 18);
		teacherPanel.add(lblName_1);
		
		JLabel lblCardNumber_1 = new JLabel("Card Number");
		lblCardNumber_1.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblCardNumber_1.setBounds(10, 100, 90, 18);
		teacherPanel.add(lblCardNumber_1);
		
		JLabel lblNumericalCode_1 = new JLabel("Numerical Code");
		lblNumericalCode_1.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblNumericalCode_1.setBounds(0, 131, 97, 18);
		teacherPanel.add(lblNumericalCode_1);
		
		textFieldUser2 = new JTextField();
		textFieldUser2.setBounds(97, 9, 107, 20);
		teacherPanel.add(textFieldUser2);
		textFieldUser2.setColumns(10);
		
		textFieldPass2 = new JTextField();
		textFieldPass2.setBounds(97, 40, 107, 20);
		teacherPanel.add(textFieldPass2);
		textFieldPass2.setColumns(10);
		
		textFieldName2 = new JTextField();
		textFieldName2.setBounds(97, 69, 107, 20);
		teacherPanel.add(textFieldName2);
		textFieldName2.setColumns(10);
		
		textFieldCard2 = new JTextField();
		textFieldCard2.setBounds(97, 98, 107, 20);
		teacherPanel.add(textFieldCard2);
		textFieldCard2.setColumns(10);
		
		textFieldCode2 = new JTextField();
		textFieldCode2.setBounds(97, 129, 107, 20);
		teacherPanel.add(textFieldCode2);
		textFieldCode2.setColumns(10);
		
		btnAddStudent.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		btnAddStudent.setBounds(55, 199, 119, 27);
		teacherPanel.add(btnAddStudent);
		
		JButton btnDeleteStudent = new JButton("Delete student");
		btnDeleteStudent.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		btnDeleteStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherPanel.setVisible(false);
				deletePanel.setVisible(true);
			}
		});
		btnDeleteStudent.setBounds(262, 54, 125, 27);
		teacherPanel.add(btnDeleteStudent);
		
		JLabel lblOtherFunctionalities = new JLabel("Other functionalities:");
		lblOtherFunctionalities.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblOtherFunctionalities.setBounds(262, 25, 132, 18);
		teacherPanel.add(lblOtherFunctionalities);
		
		JLabel lblAddress_1 = new JLabel("Address");
		lblAddress_1.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblAddress_1.setBounds(29, 162, 55, 18);
		teacherPanel.add(lblAddress_1);
		
		textFieldAddress2 = new JTextField();
		textFieldAddress2.setBounds(97, 160, 107, 20);
		teacherPanel.add(textFieldAddress2);
		textFieldAddress2.setColumns(10);
		
		lblTeacherWarning.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblTeacherWarning.setBounds(205, 204, 209, 22);
		teacherPanel.add(lblTeacherWarning);
		
		btnSubject.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		btnSubject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherPanel.setVisible(false);
				subjectPanel.setVisible(true);
			}
		});
		btnSubject.setBounds(262, 100, 125, 23);
		teacherPanel.add(btnSubject);
		btnAddGrades.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addGradePanel.setVisible(true);
				teacherPanel.setVisible(false);
			}
		});
		
		btnAddGrades.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		btnAddGrades.setBounds(262, 144, 125, 23);
		teacherPanel.add(btnAddGrades);
		
		contentPane.add(gradesPanel, "name_438687500067997");
		gradesPanel.setLayout(null);
		
		JLabel lblGradesTable = new JLabel("Grades table");
		lblGradesTable.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblGradesTable.setBounds(20, 11, 120, 24);
		gradesPanel.add(lblGradesTable);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentPanel.setVisible(true);
				gradesPanel.setVisible(false);
			}
		});
		btnBack.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		btnBack.setBounds(325, 124, 89, 23);
		gradesPanel.add(btnBack);
		
		gradeTable = new JTable();
		gradeTable.setBounds(30, 46, 288, 194);
		
		scrollPaneGrade.setBounds(30, 46, 285, 194);
		gradesPanel.add(scrollPaneGrade);
		scrollPaneGrade.setViewportView(gradeTable);
		
		contentPane.add(enrollPanel, "name_438703017276815");
		enrollPanel.setLayout(null);
		
		JLabel lblEnroll = new JLabel("Enroll");
		lblEnroll.setFont(new Font("Sylfaen", Font.PLAIN, 17));
		lblEnroll.setBounds(178, 26, 90, 26);
		enrollPanel.add(lblEnroll);
		
		JLabel lblChooseTheDesired = new JLabel(" Choose the desired course from the list below: ");
		lblChooseTheDesired.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblChooseTheDesired.setBounds(83, 63, 309, 26);
		enrollPanel.add(lblChooseTheDesired);
		
		btnEnroll_1.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		btnEnroll_1.setBounds(103, 151, 89, 23);
		enrollPanel.add(btnEnroll_1);
		
		JButton btnBack_1 = new JButton("Back");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				studentPanel.setVisible(true);
				enrollPanel.setVisible(false);
			}
		});
		btnBack_1.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		btnBack_1.setBounds(230, 151, 89, 23);
		enrollPanel.add(btnBack_1);
		
		comboBoxSubject.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		comboBoxSubject.setBounds(103, 100, 216, 23);
		enrollPanel.add(comboBoxSubject);
		
		lblEnrollWarning.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblEnrollWarning.setBounds(103, 201, 216, 26);
		enrollPanel.add(lblEnrollWarning);
		
		contentPane.add(enrollmentsPanel, "name_493526034063111");
		enrollmentsPanel.setLayout(null);
		
		JButton btnBack_2 = new JButton("Back");
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				enrollmentsPanel.setVisible(false);
				studentPanel.setVisible(true);
			}
		});
		btnBack_2.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		btnBack_2.setBounds(173, 204, 89, 23);
		enrollmentsPanel.add(btnBack_2);
		
		JLabel lblTheClassesYou = new JLabel("The classes you are attending are listed below:");
		lblTheClassesYou.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblTheClassesYou.setBounds(73, 24, 320, 23);
		enrollmentsPanel.add(lblTheClassesYou);
		
		textArea.setBounds(73, 58, 282, 128);
		enrollmentsPanel.add(textArea);
		
		contentPane.add(deletePanel, "name_523511284926546");
		deletePanel.setLayout(null);
		
		JLabel lblChooseTheStudent = new JLabel("Choose the student you want to delete:");
		lblChooseTheStudent.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblChooseTheStudent.setBounds(92, 34, 256, 24);
		deletePanel.add(lblChooseTheStudent);
		
		btnDelete.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		btnDelete.setBounds(178, 125, 89, 23);
		deletePanel.add(btnDelete);
		
		JButton btnBack_3 = new JButton("Back");
		btnBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherPanel.setVisible(true);
				deletePanel.setVisible(false);
			}
		});
		btnBack_3.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		btnBack_3.setBounds(178, 159, 89, 23);
		deletePanel.add(btnBack_3);
		
		comboBox.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		comboBox.setBounds(107, 80, 216, 24);
		deletePanel.add(comboBox);
		
		deleteWarning.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		deleteWarning.setBounds(126, 203, 197, 24);
		deletePanel.add(deleteWarning);
		
		contentPane.add(subjectPanel, "name_526178455365696");
		subjectPanel.setLayout(null);
		
		JLabel lblAddANew = new JLabel("Add a new subject in the database");
		lblAddANew.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblAddANew.setBounds(101, 30, 268, 24);
		subjectPanel.add(lblAddANew);
		
		JLabel lblSubjectTitle = new JLabel("Subject Title");
		lblSubjectTitle.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblSubjectTitle.setBounds(82, 81, 107, 24);
		subjectPanel.add(lblSubjectTitle);
		
		textFieldSubject = new JTextField();
		textFieldSubject.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		textFieldSubject.setBounds(170, 82, 157, 22);
		subjectPanel.add(textFieldSubject);
		textFieldSubject.setColumns(10);
		
		btnAdd.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		btnAdd.setBounds(174, 135, 89, 23);
		subjectPanel.add(btnAdd);
		
		JButton btnBack_4 = new JButton("Back");
		btnBack_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherPanel.setVisible(true);
				subjectPanel.setVisible(false);
			}
		});
		btnBack_4.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		btnBack_4.setBounds(174, 171, 89, 23);
		subjectPanel.add(btnBack_4);
		
		lblSubjectWarning.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblSubjectWarning.setBounds(111, 205, 216, 24);
		subjectPanel.add(lblSubjectWarning);
		
		contentPane.add(addGradePanel, "name_529866763858145");
		addGradePanel.setLayout(null);
		
		JLabel lblChooseStudentAnd = new JLabel("Choose student and subject to add a grade");
		lblChooseStudentAnd.setFont(new Font("Sylfaen", Font.PLAIN, 15));
		lblChooseStudentAnd.setBounds(70, 27, 315, 26);
		addGradePanel.add(lblChooseStudentAnd);
		
		JLabel lblPickStudent = new JLabel("Pick student");
		lblPickStudent.setFont(new Font("Sylfaen", Font.PLAIN, 14));
		lblPickStudent.setBounds(88, 79, 107, 18);
		addGradePanel.add(lblPickStudent);
		
		JLabel lblPickSubject = new JLabel("Pick subject");
		lblPickSubject.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		lblPickSubject.setBounds(88, 119, 82, 18);
		addGradePanel.add(lblPickSubject);
		
		comboBoxAddGrade_Student.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		comboBoxAddGrade_Student.setBounds(180, 76, 167, 26);
		addGradePanel.add(comboBoxAddGrade_Student);
		
		comboBoxAddGrade_Subject.setBounds(180, 114, 167, 26);
		addGradePanel.add(comboBoxAddGrade_Subject);
		
		btnAddGrade.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		btnAddGrade.setBounds(219, 161, 89, 23);
		addGradePanel.add(btnAddGrade);
		
		JButton btnBack_5 = new JButton("Back");
		btnBack_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addGradePanel.setVisible(false);
				teacherPanel.setVisible(true);
			}
		});
		btnBack_5.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		btnBack_5.setBounds(180, 217, 89, 23);
		addGradePanel.add(btnBack_5);
		
		textFieldAddGrade = new JTextField();
		textFieldAddGrade.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		textFieldAddGrade.setBounds(123, 162, 86, 20);
		addGradePanel.add(textFieldAddGrade);
		textFieldAddGrade.setColumns(10);
		
		labelAddGradeWarning.setFont(new Font("Sylfaen", Font.PLAIN, 13));
		labelAddGradeWarning.setBounds(123, 193, 208, 18);
		addGradePanel.add(labelAddGradeWarning);
	}
	
	public void loginListener(ActionListener a) {
		btnLogIn.addActionListener(a);}
	
	public void viewListener(ActionListener a) {
		btnViewInfo.addActionListener(a);}
	
	public void updateListener(ActionListener a) {
		btnUpdateInfo.addActionListener(a);}
	
	public void gradeListener(ActionListener a) {
		btnGrades.addActionListener(a);}
	
	public void enrollListener(ActionListener a) {
		btnEnroll_1.addActionListener(a);}
	
	public void enrollmentListener(ActionListener a) {
		btnEnrollments.addActionListener(a);}
	
	public void studentListener(ActionListener a) {
		btnAddStudent.addActionListener(a);}
	
	public void deleteListener(ActionListener a) {
		btnDelete.addActionListener(a);}
	
	public void addSubjectListener(ActionListener a) {
		btnAdd.addActionListener(a);}
	
	public void addAddGradeListener(ActionListener a) {
		btnAddGrade.addActionListener(a);}
	
	public void addComboListener(ActionListener a) {
		comboBoxAddGrade_Student.addActionListener(a);}
	
	public String getTextFieldUser () {
		return textFieldUser.getText().toString();
	}
	public String getTextFieldPass () {
		return textFieldPass.getText().toString();
	}
	
	public String getTextFieldSubject () {
		return textFieldSubject.getText().toString();
	}
	
	public String getTextFieldUser2() {
		return textFieldUser2.getText().toString();
	}

	public String getTextFieldPass2() {
		return textFieldPass2.getText().toString();
	}

	public String getTextFieldName2() {
		return textFieldName2.getText().toString();
	}
	
	public String getTextFieldAddress2() {
		return textFieldAddress2.getText().toString();
	}

	public String getTextFieldCard2() {
		return textFieldCard2.getText().toString();
	}

	public String getTextFieldCode2() {
		return textFieldCode2.getText().toString();
	}
	
	public int getTextFieldAddGrade() {
		return Integer.parseInt(textFieldAddGrade.getText().toString());
	}
	
	public JTextField getTextFieldName () {
		return textFieldName;
	}
	public JTextField getTextFieldCard () {
		return textFieldCard;
	}
	
	public JTextField getTextFieldCode () {
		return textFieldCode;
	}
	public JTextField getTextFieldAddress () {
		return textFieldAddress;
	}
	
	public void setTextFieldName(String text) {
		textFieldName.setText(text);
	}

	public void setTextFieldCard(String text) {
		textFieldCard.setText(text);
	}

	public void setTextFieldCode(String text) {
		textFieldCode.setText(text);
	}

	public void setTextFieldAddress(String text) {
		textFieldAddress.setText(text);
	}
	
	public void setLabelWarning(String text) {
		labelWarning.setText(text);
	}
	
	public void setDeleteWarning(String text) {
		deleteWarning.setText(text);
	}
	
	public void setTeacherWarning(String text) {
		lblTeacherWarning.setText(text);
	}
	
	public void setLabelEnroll(String text) {
		lblEnrollWarning.setText(text);
	}
	
	public void setLabelMain(String text) {
		label.setText(text);
	}
	
	public void setLblSubjectWarning(String text) {
		lblSubjectWarning.setText(text);
	}
	
	public void setLblAddGradeWarning(String text) {
		labelAddGradeWarning.setText(text);
	}

	public JPanel getMainPanel() {
		return mainPanel;
	}
	public JPanel getStudentPanel() {
		return studentPanel;
	}
	public JPanel getTeacherPanel() {
		return teacherPanel;
	}
	public JPanel getGradePanel() {
		return gradesPanel;
	}
	public void updateTable(Object[][] lista) {
		gradeTable = new JTable(lista, new Object[]{"Subject", "Grade"});
		scrollPaneGrade.setViewportView(gradeTable);
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboBoxSubject() {
		return comboBoxSubject;
	}
	
	@SuppressWarnings("rawtypes")
	public JComboBox getComboBoxStudent() {
		return comboBox;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboBoxAddGrade_Student() {
		return comboBoxAddGrade_Student;
	}

	@SuppressWarnings("rawtypes")
	public JComboBox getComboBoxAddGrade_Subject() {
		return comboBoxAddGrade_Subject;
	}

	public JTextArea getTextArea() {
		return textArea;
	}
}
