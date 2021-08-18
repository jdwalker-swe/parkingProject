import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class parkingSpot {

	private int bookingID;
	public String spotName;
	private int cost;
	private String currentUserEmail;
	private boolean inUse;
	private String paymentStatus;
	private double timeRemaining;
	static int IdCounter =100;
	
	public parkingSpot(String name) {
		this.bookingID = IdCounter;
		this.spotName=name;
		this.cost = 10;
		this.currentUserEmail="";
		this.inUse = false;
		this.paymentStatus="";
		this.timeRemaining=20.00;
		
		
		IdCounter += 100;
	}

	public int getBookingID() {
		return bookingID;
	}

	public void setBookingID(int bookingID) {
		this.bookingID = bookingID;
	}

	public String getSpotName() {
		return spotName;
	}

	public void setSpotName(String spotName) {
		this.spotName = spotName;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public String getCurrentUserEmail() {
		return currentUserEmail;
	}

	public void setCurrentUserEmail(String currentUserEmail) {
		this.currentUserEmail = currentUserEmail;
	}

	public boolean isInUse() {
		return inUse;
	}

	public void setInUse(boolean inUse) {
		this.inUse = inUse;
	}

	public String getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public double getTimeRemaining() {
		return timeRemaining;
	}

	public void setTimeRemaining(double timeRemaining) {
		this.timeRemaining = timeRemaining;
	}

	public static int getIdCounter() {
		return IdCounter;
	}

	public static void setIdCounter(int idCounter) {
		IdCounter = idCounter;
	}
	
	
}
