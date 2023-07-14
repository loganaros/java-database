package FBLA;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.io.Serializable;

public class EmployeeList extends ArrayList<Employee> implements Serializable {
	
	private static final long serialVersionUID = -7639186426523031684L;
	
	FileOutputStream fos;
	ObjectOutputStream oos;
	
	public EmployeeList() {
		
	}
	
	public void insert(Employee e) {
		add(e);
	}

	public void print() {
		
	}
	
	public Object[][] getTable() {
		Object[][] data = new Object[size()][];
		for (int i = 0; i < size(); i ++) {
			data[i] = get(i).getTableData();
		}
		return data;
	}
	
	public void save(String path, String name) {
		try {
			fos = new FileOutputStream(new File("./save/save.txt"));
			oos = new ObjectOutputStream(fos);
			try {
				oos.writeObject(this);
				oos.flush();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		File f = new File(path);
		if (!f.exists()) {
			f.mkdirs();
		}
	}
}

