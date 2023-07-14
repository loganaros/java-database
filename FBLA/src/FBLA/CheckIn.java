package FBLA;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class CheckIn extends JFrame {
	
	private JPanel contentPane;
	private JLabel enter;
	private JTextField enterText;
	private JTextField timeText;
	
	private JCheckBox simCheck;
	private JButton checkButton;
	private JButton homeButton;
	
	CustomerList cusList = new CustomerList();
	
	public CheckIn() {
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(6, 2, 5, 5));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setBounds(100, 100, 300, 200);
		setLocationRelativeTo(null);
		setTitle("Check In");
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		setContentPane(contentPane);
		
		enter = new JLabel("Enter name of customer:");
		enter.setFont(new Font("Serif", Font.PLAIN, 14));
		enter.setSize(300, 30);
		contentPane.add(enter);
		
		enterText = new JTextField();
		enterText.setSize(50, 20);
		enterText.setColumns(15);
		contentPane.add(enterText);
		
		timeText = new JTextField("Enter hours(ex. 17)");
		timeText.setSize(50, 20);
		timeText.setColumns(15);
		
		simCheck = new JCheckBox("Uncheck for real time - otherwise input will be provided", true);
		contentPane.add(simCheck);
		if (simCheck.isSelected()) {
			contentPane.add(timeText);
			revalidate();
			repaint();
		} else {
			contentPane.remove(timeText);
			revalidate();
			repaint();
		}
		
		checkButton = new JButton("Check In");
		contentPane.add(checkButton);
		checkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name = enterText.getText();
				String[] name2 = name.split("\\s+");
				if (simCheck.isSelected()) {
					Date date = new Date();
					date.setHours(Integer.parseInt(timeText.getText()));
					cusList.insert(new Customer(name2[0], name2[1], date));
				} else {
					cusList.insert(new Customer(name2[0], name2[1], new Date()));
				}
				Customer cus = (Customer) cusList.get(0);
				System.out.println(cus.getFirstName() + cus.getLastName() + cus.getTime().getHours());
			}
		});
		
		homeButton = new JButton("Go Home");
		contentPane.add(homeButton);
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}
