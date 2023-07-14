package FBLA;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.border.*;

public class Welcome extends JFrame {
	
	Home home = new Home();
	private JPanel contentPane;
	private JTextField userField;
	private JTextField passField;
	EmployeeList eList = new EmployeeList();
	
	public Welcome() {
		setTitle("Welcome");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setLocationRelativeTo(null);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblWelcome = new JLabel("Welcome");
		lblWelcome.setBounds(150, 50, 150, 50);
		lblWelcome.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblWelcome.setHorizontalAlignment(SwingConstants.CENTER);
		contentPane.add(lblWelcome);
		
		JLabel lblUsername = new JLabel("Username:");
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblUsername.setBounds(100, 115, 100, 16);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password:");
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblPassword.setBounds(100, 150, 100, 16);
		contentPane.add(lblPassword);
		
		userField = new JTextField();
		userField.setBounds(212, 114, 116, 22);
		contentPane.add(userField);
		userField.setColumns(10);
		
		passField = new JPasswordField();
		passField.setColumns(10);
		passField.setBounds(212, 149, 116, 22);
		contentPane.add(passField);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				char[] input = ((JPasswordField) passField).getPassword();
				System.out.println(input);
		        if (isPasswordCorrect(input)) {
		            System.out.println("Success! You typed the right password.");
		            dispose();
		            home.setVisible(true);
		        } else {
		            System.out.println("Wrong.");
		        }

		        //Zero out the possible password, for security.
		        Arrays.fill(input, '0');
			}
		});
		btnSubmit.setBounds(175, 200, 97, 25);
		contentPane.add(btnSubmit);
	}
	
	private boolean isPasswordCorrect(char[] input) {
	    boolean isCorrect = true;
//	    for (int i = 0; i <= eList.size(); i++) {
//	    	if (eList.indexOf(i) == ) {
//	    		
//	    	}
//	    }
	    char[] correctPassword = { 'e', 's', 'b', '1', '1', 'm', 'p', 'h', 'b', 's' };

	    if (input.length != correctPassword.length) {
	        isCorrect = false;
	    } else {
	        isCorrect = Arrays.equals(input, correctPassword);
	    }

	    //Zero out the password.
	    Arrays.fill(correctPassword,'0');

	    return isCorrect;
	}
}
