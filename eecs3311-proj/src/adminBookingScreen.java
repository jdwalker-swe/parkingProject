import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
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
import javax.swing.JTextField;

public class adminBookingScreen extends JFrame {

	private JPanel contentPane;
	private JTextField officerUserName;
	private JTextField officerEmail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminBookingScreen frame = new adminBookingScreen();
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
	public adminBookingScreen() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 697, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Welcome to Admin Employee System");
		lblNewLabel.setFont(new Font("Yu Gothic UI Light", Font.PLAIN, 27));
		lblNewLabel.setBounds(126, 10, 521, 68);
		contentPane.add(lblNewLabel);
		
	
		
		JLabel lblNewLabel_1 = new JLabel("Enter Officer Information");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(35, 99, 199, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Officer List");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_2.setBounds(479, 99, 134, 31);
		contentPane.add(lblNewLabel_2);
		  //sdad
		JList customerAvailBookingList = new JList();
		customerAvailBookingList.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		customerAvailBookingList.setBounds(448, 128, 199, 222);
		contentPane.add(customerAvailBookingList);
	
		DefaultListModel DLM = new DefaultListModel();
		DefaultListModel DLMNew = new DefaultListModel();
		DefaultListModel DLMUser = new DefaultListModel();
		
		//enable this if, if stuff messes up
		//if(mainWindow.customerDB.size()>1 || mainWindow.loggedInAndOut ==true) {
			
			
			
			for(adminLogins c: mainWindow.adminDB) {
				if (c.getLoggedInOrOut() == true) {
					
					
					for(int i =0; i<mainWindow.officerDB.size(); i++) {
						
						if(mainWindow.officerDB.get(i)!=null) {
							
							DLM.addElement(mainWindow.officerDB.get(i).getEmail());
						}
				
					}
					//customerYourBookingList.setModel(DLMUser);
					//DLMUser.addElement(mainWindow.customerDB.get(i).customerParkingList.get(i).spotName);
			}
			}
			
			
			
			//for(int i=0;i<mainWindow.globalParkingList.size();i++) {
				//if(mainWindow.globalParkingList.get(i)==null) {
				
				
				//}
				//else {
					
					//DLMNew.addElement(mainWindow.globalParkingList.get(i));
				//}
			//}
			
			//customerAvailBookingList.setModel(DLMNew);
			
		//}
		
		
	
		
		
		
		
	
		
		//
		if(mainWindow.adminDB.size()==1 || mainWindow.officerDB.size()==1) {
		
			//DLM.addAll(mainWindow.globalParkingList);
			customerAvailBookingList.setModel(DLM);
			
		}
		
		
	
		
		JButton customerCancelBookingButton = new JButton("Add Officer");
		customerCancelBookingButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//remove from customer bookings and add that to available
				// also set that parking isInUse=false since its no longer being used
				
				 if((mainWindow.officerEmailDB.contains(officerEmail.getText())  &&!officerUserName.getText().isBlank() &&!officerEmail.getText().isBlank())) {
					 emailOrUsernameAlreadyInUseErrorScreen window9 = new emailOrUsernameAlreadyInUseErrorScreen();
					 officerUserName.setText("");
					 
					 officerEmail.setText("");
						window9.show();
						window9.setResizable(false);
				}
				 else if(!officerUserName.getText().isBlank() &&!officerEmail.getText().isBlank()) {
					 officerLogins login = new officerLogins(officerUserName.getText(),officerEmail.getText());
					 mainWindow.officerEmailDB.add(officerEmail.getText());
					 mainWindow.officerDB.add(login);
					 DLM.addElement(mainWindow.officerDB.get(mainWindow.officerDB.size()-1).getEmail());
					 officerUserName.setText("");
					 officerEmail.setText("");
					 
				 }
				 else {
						errorScreen window6 = new errorScreen();
						window6.show();
						window6.setResizable(false);
					}
				
				//String added = (String) customerYourBookingList.getSelectedValue();
				officerLogins curOfficer = null;
				customerAvailBookingList.clearSelection();
				
				if(customerAvailBookingList.isSelectionEmpty()) {
					
			
					}
					
					
				
				}
				
				
			}
		);
		customerCancelBookingButton.setBounds(279, 252, 125, 45);
		contentPane.add(customerCancelBookingButton);
		
		
		JButton btnNewButton = new JButton("Remove Officer");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String added = (String) customerAvailBookingList.getSelectedValue();
				String tempUsername =null;
				String tempPW = null;
				parkingSpot tempSpot = null;
				//DefaultListModel DLMine = new DefaultListModel();
				officerLogins curOfficer = null;
				
				
				if(!customerAvailBookingList.isSelectionEmpty()){
				
			//find officer to remove from global list
				for(officerLogins o: mainWindow.officerDB) {
					if(o.getEmail().equals(added)) {
						
						curOfficer = o;
						tempUsername = curOfficer.getUserName();
						tempPW = curOfficer.getPassword();
			           o.isActive=false;
			           
			           for(parkingSpot s: o.officerParkingList) {
			        	   
			        	   mainWindow.globalParkingListReal.add(s);
			        	   mainWindow.globalParkingList.add(s.getSpotName());
			        	   
			           }
			           
			           for(int i =0; i<curOfficer.officerParkingList.size();i++) {
			        	  curOfficer.officerParkingList.remove(i);
			           }
			           
					}
				}
				
				if(mainWindow.officerLoginHash.containsKey(tempUsername)) {
					mainWindow.officerLoginHash.remove(tempUsername);
				}
				
				mainWindow.officerEmailDB.remove(added);
				mainWindow.officerDB.remove(curOfficer);
				DLM.removeElement(added);
				DLM.removeElement(added);
				
				}
			
				
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
				for(adminLogins c: mainWindow.adminDB) {
					if(c.getLoggedInOrOut()==true) {
						c.logOUT();
						dispose();
					}
				}
			}
		});
		customerLogOutButton.setBounds(284, 334, 109, 34);
		contentPane.add(customerLogOutButton);
		
		officerUserName = new JTextField();
		officerUserName.setBounds(90, 176, 116, 27);
		contentPane.add(officerUserName);
		officerUserName.setColumns(10);
		
		officerEmail = new JTextField();
		officerEmail.setBounds(90, 220, 116, 27);
		contentPane.add(officerEmail);
		officerEmail.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("User Name");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 174, 84, 27);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(25, 217, 59, 29);
		contentPane.add(lblNewLabel_4);
	}
}
