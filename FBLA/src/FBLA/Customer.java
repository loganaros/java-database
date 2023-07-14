package FBLA;

import java.io.Serializable;
import java.util.Date;

public class Customer implements Serializable {

	  private static final long serialVersionUID = 2999627782207107531L;

	  private String fName;

	  private String lName;

	  private Date time;

	  public Customer(String fName, String lName, Date time) {
	    this.fName = fName;
	    this.lName = lName;
	    this.time = time;
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
	  
	  public Date getTime() {
		  return time;
	  }
	  
	  public Object[] printData() {
			return new Object[] {
				fName,
				lName,
				time
			};
		}

}
