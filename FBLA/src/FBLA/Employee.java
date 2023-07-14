package FBLA;

import java.io.Serializable;

public class Employee implements Serializable {

  private static final long serialVersionUID = -2979767481876150729L;

  private String fName;

  private String lName;

  private int age;

  private String shift;
  
  private String email;

  public Employee(String fName, String lName, int age, String shift, String email) {
    this.fName = fName;
    this.lName = lName;
    this.age = age;
    this.shift = shift;
    this.email = email;
  }
  
  public String getName() {
	  return fName + " " + lName;
  }
  
  public String getFirstName() {
	  return fName;
  }
  
  public void setFirstName(String fName) {
	  this.fName = fName;
  }
  
  public String getLastName() {
	  return lName;
  }
  
  public void setLastName(String lName) {
	  this.lName = lName;
  }
  
  public int getAge() {
	  return age;
  }
  
  public void setAge(int age) {
	  this.age = age;
  }
  
  public String getShift() {
	  return shift;
  }
  
  public void setShift(String shift) {
	  this.shift = shift;
  }
  
  public String getEmail() {
	  return email;
  }
  
  public void setEmail(String email) {
	  this.email = email;
  }
  
  public Object[] getTableData() {
		return new Object[] {
			fName,
			lName,
			age,
			shift,
			email,
		};
	}
}
