import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Component;

import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JScrollBar;
import java.awt.ScrollPane;
import javax.swing.SwingConstants;

public class customerBookingScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customerBookingScreen frame = new customerBookingScreen();
					frame.setResizable(false);
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public customerBookingScreen() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 697, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Express Parking Booking system");
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 27));
		lblNewLabel.setBounds(76, 10, 521, 68);
		contentPane.add(lblNewLabel);
		
	
		
		JLabel lblNewLabel_1 = new JLabel("Your bookings");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(76, 99, 103, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Available Bookings");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(479, 99, 134, 31);
		contentPane.add(lblNewLabel_2);
		
		JList customerYourBookingList = new JList();
		customerYourBookingList.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		customerYourBookingList.setBackground(Color.WHITE);
		customerYourBookingList.setBounds(35, 128, 199, 222);
		contentPane.add(customerYourBookingList);
		  //sdad
		JList customerAvailBookingList = new JList();
		customerAvailBookingList.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		customerAvailBookingList.setBounds(448, 128, 199, 222);
		contentPane.add(customerAvailBookingList);
	
		DefaultListModel DLM = new DefaultListModel();
		DefaultListModel DLMNew = new DefaultListModel();
		DefaultListModel DLMUser = new DefaultListModel();
		
		
		if(mainWindow.customerDB.size()>1 || mainWindow.loggedInAndOut ==true) {
			
			
			
			for(customerLogins c: mainWindow.customerDB) {
				if (c.getLoggedInOrOut() == true) {
					
					for(int i =0; i<c.customerParkingList.size(); i++) {
						
						if(c.customerParkingList.get(i)!=null) {
							
							DLMUser.addElement(c.customerParkingList.get(i).spotName);
						}
				
					}
					customerYourBookingList.setModel(DLMUser);
					//DLMUser.addElement(mainWindow.customerDB.get(i).customerParkingList.get(i).spotName);
			}
			}
			
			
			
			for(int i=0;i<mainWindow.globalParkingList.size();i++) {
				if(mainWindow.globalParkingList.get(i)==null) {
				
				
				}
				else {
					
					DLMNew.addElement(mainWindow.globalParkingList.get(i));
				}
			}
			
			customerAvailBookingList.setModel(DLMNew);
			
		}
		
		
	
		
		
		
		
	
		
		//
		if(mainWindow.customerDB.size()==1) {
			
			DLM.addAll(mainWindow.globalParkingList);
			customerAvailBookingList.setModel(DLM);
			
		}
		
		
	
		
		JButton customerCancelBookingButton = new JButton("Cancel Booking");
		customerCancelBookingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//remove from customer bookings and add that to available
				// also set that parking isInUse=false since its no longer being used
				
				
				
				String added = (String) customerYourBookingList.getSelectedValue();
				parkingSpot curSpotCancel = null;
				customerAvailBookingList.clearSelection();
				
				if(customerAvailBookingList.isSelectionEmpty() && !customerYourBookingList.isSelectionEmpty()) {
					//System.out.println("we good");
					
				
				//checks for who is logged in so we can remove from their list
				for(customerLogins c: mainWindow.customerDB) {
					if(c.getLoggedInOrOut()==true && c.totalNumberOfSpots>=1) {
						
						
						for(parkingSpot s: c.customerParkingList) {
							if(s.getSpotName().equals(added)) {
								s.setInUse(false);
								curSpotCancel = s;
							}
						}
						
						
						c.customerParkingList.remove(curSpotCancel);
						c.totalNumberOfSpots--;
						DLMUser.removeElement(added);
				
						mainWindow.globalParkingListReal.add(curSpotCancel);
						mainWindow.globalParkingList.add(added);
						
						if(mainWindow.customerDB.size()==1) {
							DLM.addElement(added);
						}
						else {
							DLMNew.addElement(added);
						}
						
						
						//System.out.println(c.customerParkingList);
						//System.out.println(c.totalNumberOfSpots);
						
					}
					
					
				}
				}
				
				
			}
		});
		customerCancelBookingButton.setBounds(284, 246, 103, 31);
		contentPane.add(customerCancelBookingButton);
		
		ScrollPane scrollPane = new ScrollPane();
		scrollPane.setBounds(35, 128, 199, 222);
		contentPane.add(scrollPane);
		
		
		JButton btnNewButton = new JButton("Book Space");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String added = (String) customerAvailBookingList.getSelectedValue();
				//DefaultListModel DLMine = new DefaultListModel();
				parkingSpot curSpot = null;
				customerYourBookingList.clearSelection();
				
				//checks for customers totalnumber of spots
				
				for(customerLogins c: mainWindow.customerDB) {
					if(c.getLoggedInOrOut() == true && c.totalNumberOfSpots==3) {
						fullOnParkingSpotsErrorScreen window11 = new fullOnParkingSpotsErrorScreen();
						window11.show();
						window11.setResizable(false);
					}
				}
				
				
				
				
				
			
				
				//checks if spot is available from global list
				for(parkingSpot spot: mainWindow.globalParkingListReal) {
					if(spot.getSpotName().equals(added)) {
						spot.setInUse(true);
						curSpot = spot;
					}
				}
				
				//when we find spot is available, we check whos using the system
				//we then add that spot to the list of whoever is using system
				
				if(!customerAvailBookingList.isSelectionEmpty() && customerYourBookingList.isSelectionEmpty()) {
					
				
				
				for(customerLogins c: mainWindow.customerDB) {
					if (c.getLoggedInOrOut() == true && c.totalNumberOfSpots<3) {
						c.customerParkingList.add(curSpot);
						c.totalNumberOfSpots++;
						
						DLMUser.addElement(added);
						//customerYourBookingList.setModel(DLMUser);
						
						
						mainWindow.globalParkingListReal.remove(curSpot);
						mainWindow.globalParkingList.remove(added);
						
						if(mainWindow.customerDB.size()==1) {
							DLM.removeElement(added);
						}
						else {
							DLMNew.removeElement(added);
						}
						
						//System.out.println(c.customerParkingList);
						//System.out.println(c.totalNumberOfSpots);
						
						break;
					}
					
					
						
					
				}
			}
				
				customerYourBookingList.setModel(DLMUser);
				
				//DefaultListModel DLM = new DefaultListModel();
				//DLM.addAll(mainWindow.globalParkingListReal);
				//customerAvailBookingList.setModel(DLM);
				
				
				
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(256, 174, 171, 40);
		contentPane.add(btnNewButton);
		
		JButton customerLogOutButton = new JButton("Log Out");
		customerLogOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainWindow.loggedInAndOut =true;
				for(customerLogins c: mainWindow.customerDB) {
					if(c.getLoggedInOrOut()==true) {
						c.logOUT();
						dispose();
					}
				}
			}
		});
		customerLogOutButton.setBounds(284, 334, 109, 34);
		contentPane.add(customerLogOutButton);
	}
}
