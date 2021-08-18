import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class adminLogins {
	
	
	
	private String userName;
	private String password;
	private String email;
	private int totalSpots;
	public List<officerLogins> adminParkingList;
	private boolean loggedIn =false;
	public int totalNumberOfSpots=0;

	//we can do error handling with customerParkingList and make sure size()<=3
	
	
	public adminLogins(String user,String pass,String mail){
		this.userName=user;
		this.password = pass;
		this.email = mail;
		totalSpots = 0;
		
		this.loggedIn = false;
		 this.adminParkingList = new ArrayList<officerLogins>();
		
		
	}


	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public int getTotalSpots() {
		return totalSpots;
	}


	public void setTotalSpots(int totalSpots) {
		this.totalSpots = totalSpots;
	}


	public List<officerLogins> getCustomerParkingList() {
		return adminParkingList;
	}


	public void setCustomerParkingList(List<officerLogins> officerLogins) {
		this.adminParkingList = officerLogins;
	}
	
	
	public void logIN() {
		this.loggedIn = true;
	}
	
	public void logOUT() {
		this.loggedIn = false;
	}
	
	public boolean getLoggedInOrOut() {
		return this.loggedIn;
	}
	
	
}

