package FBLA;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class AddEmployee extends JFrame {
	
	private JLabel fName;
	private JLabel lName;
	private JLabel age;
	private JLabel shift;
	private JLabel email;
	
	private JTextField fText;
	private JTextField lText;
	private JTextField ageText;
	private JRadioButton partButton;
	private JRadioButton fullButton;
	private JTextField emailText;
	
	private String shiftString;
	
	private JPanel contentPane;
	private JPanel buttonPanel;
	
	private JButton submit;
	private JButton home;
	
	private ButtonGroup bGroup;
	
	EmployeeList eList = new EmployeeList();
	FileOutputStream fos;
	ObjectOutputStream oos;
	File file;
	
	public AddEmployee() {
		file = new File("./save/save.txt");
		try {
			fos = new FileOutputStream(file, true);
			oos = new ObjectOutputStream(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
//		submitPanel = new JPanel();
//		submitPanel.setLayout(null);
//		submitPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setTitle("Add Employee");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setContentPane(contentPane);
		
		setLayout(new GridLayout(6, 2, 5, 5));
		setResizable(true);
		
		fName = new JLabel("First Name:");
		fName.setSize(50, 15);
		contentPane.add(fName);
		
		fText = new JTextField();
		fText.setSize(50, 20);
		fText.setColumns(10);
		contentPane.add(fText);
		
		lName = new JLabel("Last Name:");
		lName.setSize(50, 15);
		contentPane.add(lName);
		
		lText = new JTextField();
		lText.setSize(50, 20);
		lText.setColumns(10);
		contentPane.add(lText);
		
		age = new JLabel("Age:");
		age.setSize(50, 15);
		contentPane.add(age);
		
		ageText = new JTextField();
		ageText.setSize(50, 20);
		ageText.setColumns(10);
		contentPane.add(ageText);
		
		shift = new JLabel("Shift:");
		shift.setSize(50, 15);
		contentPane.add(shift);
		
		partButton = new JRadioButton("Part");
		partButton.setActionCommand("part");
		fullButton = new JRadioButton("Full");
		fullButton.setActionCommand("full");
		
		bGroup = new ButtonGroup();
		bGroup.add(partButton);
		bGroup.add(fullButton);
		
		buttonPanel = new JPanel();
		buttonPanel.add(fullButton);
		buttonPanel.add(partButton);
		contentPane.add(buttonPanel);
		
		partButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				shiftString = "part";
			}
		});
		fullButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				shiftString = "full";
			}
		});
		
		email = new JLabel("Email:");
		email.setSize(50, 15);
		contentPane.add(email);
		
		emailText = new JTextField();
		emailText.setSize(50, 20);
		emailText.setColumns(10);
		contentPane.add(emailText);
		
		submit = new JButton("Submit");
		submit.setSize(100, 20);
		contentPane.add(submit);
		submit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("Clicked");
				Employee eTemp = new Employee(fText.getText(),
						lText.getText(), 
						Integer.parseInt(ageText.getText()), 
						shiftString, 
						emailText.getText());
				eList.insert(eTemp);
				try {
					System.out.println(eList.get(0));
					oos.writeObject(eList);
					oos.writeUTF("\n");
					oos.flush();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				System.out.println(eList.get(0).getName());
				System.out.println(eList.get(0).getAge());
				System.out.println(eList.get(0).getShift());
				System.out.println(eList.get(0).getEmail());
			}
		});
		
		home = new JButton("Go Home");
		home.setSize(100, 20);
		contentPane.add(home);
		home.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new Home().revalidate();
				new Home().repaint();
			}
		});
		
		pack();
	}
}