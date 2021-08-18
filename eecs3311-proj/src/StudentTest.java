import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;

//import junit.framework.Assert;


public class StudentTest {
	
	customerLogins customer;
	adminLogins admin;
	officerLogins officer;
	
	@Before
    public void setUp() throws Exception {
		customer = new customerLogins("Jackie", "Jackie123", "Jackie@hotmail.com");
		admin = new adminLogins("Jackie", "Jackie123", "Jackie@hotmail.com");
		officer = new officerLogins("Jackie", "Jackie123", "Jackie@hotmail.com");
    }
	
	
	@Test
	public void fourPointOnePartOne() {
		//tests admin can add officer to system
		List<officerLogins> tempList = new ArrayList<officerLogins>();
		officerLogins tempOfficer = new officerLogins("Jordan", "Jordan123", "Jordan@hotmail.com");
		admin.adminParkingList.add(tempOfficer);
		
		List<officerLogins> testList = new ArrayList<officerLogins>();
		testList.add(tempOfficer);
		
		Assert.assertEquals(testList,admin.adminParkingList);
		    
	}
	
	@Test
	public void fourPointOnePartTwo() {
		//tests admin can remove officer from system
		List<officerLogins> tempList = new ArrayList<officerLogins>();
		officerLogins tempOfficer = new officerLogins("Jordan", "Jordan123", "Jordan@hotmail.com");
		admin.adminParkingList.add(tempOfficer);
		
		List<officerLogins> testList = new ArrayList<officerLogins>();
		admin.adminParkingList.remove(tempOfficer);
		
		Assert.assertEquals(0,admin.adminParkingList.size());
		    
	}
	
	

	@Test
	public void fourPointTwoReqPartOne() {
		//tests customer parkingSpot list is available to be added to
		List<parkingSpot> tempList = new ArrayList<parkingSpot>();
		parkingSpot A1 = new parkingSpot("A1");
		parkingSpot A2 = new parkingSpot("A2");
		parkingSpot A3 = new parkingSpot("A3");
		
		    customer.customerParkingList.add(A1);
		    customer.customerParkingList.add(A2);
		    customer.customerParkingList.add(A3);
		  
		tempList.add(A1);
		tempList.add(A2);
		tempList.add(A3);
		Assert.assertEquals(tempList.size(),customer.customerParkingList.size());
		assertEquals(tempList, customer.customerParkingList);
		    
	}
	
	@Test
	public void fourPointTwoReqPartTwo() {
		//tests that when customer object is made, it is initialized to be logged out
		Assert.assertEquals(false, customer.getLoggedInOrOut());
		    
	}
	
	@Test
	public void fourPointThreePartOne() {
		//tests that a user can log in/sign in
		
		customer.logIN();
		Assert.assertEquals(true, customer.getLoggedInOrOut());
    
	}
	
	@Test
	public void fourPointThreePartTwo() {
		//tests that a user can log out/sign out
		
		customer.logOUT();
		Assert.assertEquals(false, customer.getLoggedInOrOut());
    
	}
	
	@Test
	public void fourPointFourPartOne() {
		//tests that a customer can book a parking space, we assume the time limit is 10 minutes for all spots
		
		List<parkingSpot> tempList = new ArrayList<parkingSpot>();
		parkingSpot A1 = new parkingSpot("A1");
		customer.customerParkingList.add(A1);
	   
	  
	tempList.add(A1);
	
	Assert.assertEquals(tempList,customer.customerParkingList);
	
    
	}
	
	@Test
	public void fourPointFourPartTwo() {
		//tests that a counter keeps track of customer parkingSpot list size(3)
		
		
		parkingSpot A1 = new parkingSpot("A1");
		parkingSpot A2 = new parkingSpot("A2");
		parkingSpot A3 = new parkingSpot("A3");
		
		    customer.customerParkingList.add(A1);
		    customer.customerParkingList.add(A2);
		    customer.customerParkingList.add(A3);
	
		
		    Assert.assertEquals(3,customer.customerParkingList.size());
	
    
	}
	
	
	@Test
	public void fourPointFivePartOne() {
		//tests that a counter keeps track of customer parkingSpot list size(3)
		
		
		parkingSpot A1 = new parkingSpot("A1");
		
		
		    customer.customerParkingList.add(A1);
		    customer.customerParkingList.remove(A1);
		    
		
		    Assert.assertEquals(0,customer.customerParkingList.size());
	
    
	}
	
	@Test
	public void fourPointFivePartTwo() {
		//tests customer parkingSpot list is available to be added to
		List<parkingSpot> tempList = new ArrayList<parkingSpot>();
		parkingSpot A1 = new parkingSpot("A1");
		
		
		    customer.customerParkingList.add(A1);
		    customer.customerParkingList.remove(A1);
		  
		tempList.add(A1);
		tempList.remove(A1);
		
		assertEquals(tempList, customer.customerParkingList);
		    
	}
	
	@Test
	public void fourPointSevenPartOne() {
		//tests customer can return a list of their bookings
		List<parkingSpot> tempList = new ArrayList<parkingSpot>();
		parkingSpot A1 = new parkingSpot("A1");

		    customer.customerParkingList.add(A1);
	
		tempList.add(A1);
		assertEquals(tempList,  customer.getCustomerParkingList());
		    
	}
	
	@Test
	public void fourPointSevenPartTwo() {
		//tests customer can return name of their booking
		
		parkingSpot A1 = new parkingSpot("A1");

		    customer.customerParkingList.add(A1);
	
		
		assertEquals("A1",  customer.customerParkingList.get(0).getSpotName());
		    
	}
	
	@Test
	public void fourPointEightPartOne() {
		//tests officer can add parkingSpot to their list
		
		parkingSpot A1 = new parkingSpot("A1");

		    officer.officerParkingList.add(A1);
	
		
		assertEquals(1, officer.officerParkingList.size());
		    
	}
	
	@Test
	public void fourPointEightPartTwo() {
		//tests officer can remove parkingSpot to their list
		
		parkingSpot A1 = new parkingSpot("A1");

		    officer.officerParkingList.add(A1);
		    officer.officerParkingList.remove(A1);
		
		assertEquals(0, officer.officerParkingList.size());
		    
	}
	
	@Test
	public void extraOne() {
		
		List<parkingSpot> tempList = new ArrayList<parkingSpot>();
		parkingSpot A4 = new parkingSpot("A4");

		    officer.officerParkingList.add(A4);
		    tempList.add(A4);
		
		assertEquals(tempList, officer.officerParkingList);
		    
	}
	
	@Test
	public void extraTwo() {
		
		List<parkingSpot> tempList = new ArrayList<parkingSpot>();
		parkingSpot A4 = new parkingSpot("A4");
		parkingSpot A5 = new parkingSpot("A5");
		    officer.officerParkingList.add(A4);
		    officer.officerParkingList.add(A5);
		   
		
		assertEquals(2, officer.officerParkingList.size());
		    
	}
	
	@Test
	public void extraThree() {
		
		List<parkingSpot> tempList = new ArrayList<parkingSpot>();
		parkingSpot A4 = new parkingSpot("A4");
		parkingSpot A5 = new parkingSpot("A5");
		parkingSpot A6 = new parkingSpot("A6");
		    officer.officerParkingList.add(A4);
		    officer.officerParkingList.add(A5);
		    officer.officerParkingList.add(A6);
		
		assertEquals(3, officer.officerParkingList.size());
		    
	}
	
	
	
	
	
	
	

}
