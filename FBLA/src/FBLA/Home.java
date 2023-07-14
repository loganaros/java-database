package FBLA;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

import javax.swing.BoxLayout;
import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;

public class Home extends JFrame implements Serializable {
	
	private static final long serialVersionUID = -7639186426523031684L;
	
	private JTable table;
	private JPanel contentPane;
	private JScrollPane ePane;
	private JPanel navPanel;
	
	private JButton addButton;
	private JButton schButton;
	private JButton cusButton;
	private JButton repButton;
	
	private JList empList;
	private DefaultListModel model;
	
	private String temp;
	
	//OutputStream os = new FileOutputStream(file);
	//InputStream is = new FileInputStream(file);;
	
	private static String savePath = ("./save");
	private static String saveName = ("save.dat");
	
	EmployeeList eList;
	File file;
	FileInputStream fis;
	ObjectInputStream ois;
	Object object;
	
	private static final Object[] columns = {
//		"Name",
//		"Sunday",
//		"Monday",
//		"Tuesday",
//		"Wednesday",
//		"Thursday",
//		"Friday",
//		"Saturday"
		"First Name",
		"Last Name",
		"Age",
		"Shift",
		"Email"
	};
	
	public Home() {
		file = new File("./save/save.txt");
		try {
			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);
			try {
				object = (EmployeeList) ois.readObject();
				System.out.println(object);
				while (ois.readObject() != null) {
					ois.readObject();
					ois.close();
				}
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		eList = new EmployeeList();
		System.out.println(new File(".").getAbsolutePath());
		load(savePath, saveName);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setTitle("Home");
		setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		addWindowListener(new WindowListener() {

			@Override
			public void windowActivated(WindowEvent arg0) {}

			@Override
			public void windowClosed(WindowEvent arg0) {}

			@Override
			public void windowClosing(WindowEvent arg0) {
				eList.save(savePath, saveName);
				System.exit(0);
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {}

			@Override
			public void windowDeiconified(WindowEvent arg0) {}

			@Override
			public void windowIconified(WindowEvent arg0) {}

			@Override
			public void windowOpened(WindowEvent arg0) {}
			
		});
		setBounds(100, 100, 800, 600);
		setLocationRelativeTo(null);
		
		//for (int i = 0; i <= eList.size(); i++) {
			//System.out.println(eList.get(i).getName());
		//}
		tableUpdate();
		table.setBounds(0, getHeight()/2, getWidth(), getHeight()/2);
		
		model = new DefaultListModel<Employee>();
		
		empList = new JList(model);
		empList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		empList.setLayoutOrientation(JList.HORIZONTAL_WRAP);
		empList.setVisibleRowCount(-1);
		empList.setCellRenderer(new DefaultListCellRenderer());
		empList.setVisible(false);
		empList.setVisible(true);
		
		ePane = new JScrollPane(empList);
		ePane.setBounds(0, 0, getWidth()/2, getHeight()/2);
		ePane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	    ePane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		contentPane.add(ePane);
		
		//eList.insert(new Employee("logan", "aros", 25, "full", "part"));
		
		for (int i = 0; i < model.getSize(); i++) {
			model.addElement(eList.get(0));
			System.out.println(eList.get(i));
			System.out.println(empList.getModel().getElementAt(i));
//		      model.addElement("Element " + i);
//		      System.out.println(model.getElementAt(i));
//			  ePane.add(new JLabel(Integer.toString(i)));
		}
		
		navPanel = new JPanel();
		navPanel.setBounds(getWidth()/2, 0, getWidth()/2, getHeight()/2);
		navPanel.setLayout(new BoxLayout(navPanel, BoxLayout.Y_AXIS));
		navPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.add(navPanel);
		
		addButton = new JButton("Add an Employee");
		addButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		addButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new AddEmployee().setVisible(true);
			}
		});
		navPanel.add(addButton);
		
		schButton = new JButton("Weekly Schedule Report");
		schButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		schButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		navPanel.add(schButton);
		
		cusButton = new JButton("Customer Check In");
		cusButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		cusButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new CheckIn().setVisible(true);
				System.out.println("Checked in");
			}
		});
		navPanel.add(cusButton);
		
		repButton = new JButton("Customer Report");
		repButton.setAlignmentX(Component.CENTER_ALIGNMENT);
		repButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//new Report().setVisible(true);
			}
		});
		navPanel.add(repButton);
		
		System.out.println("Generated");
	}
	
	public void tableUpdate() {
		eList = new EmployeeList();
		System.out.println("Table called");
		table = new JTable(eList.getTable(), columns);
		contentPane.add(table);
	}
	
	private void load(String path, String name) {
		File f = new File(path);
		if (!f.exists()) {
			eList = new EmployeeList();
			f.mkdir();
			return;
		}
	}

}
