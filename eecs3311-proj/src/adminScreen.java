import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class adminScreen extends JFrame {

	private JPanel contentPane;
	private JTextField adminUserName;
	private JTextField adminPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminScreen frame = new adminScreen();
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
	public adminScreen() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 532, 366);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Admin Login");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.PLAIN, 30));
		lblNewLabel.setBounds(138, 33, 248, 59);
		contentPane.add(lblNewLabel);
		
		adminUserName = new JTextField();
		adminUserName.setBounds(163, 127, 194, 32);
		contentPane.add(adminUserName);
		adminUserName.setColumns(10);
		
		adminPassword = new JTextField();
		adminPassword.setBounds(163, 191, 194, 32);
		contentPane.add(adminPassword);
		adminPassword.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("User name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(40, 124, 100, 32);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Password");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(40, 191, 100, 31);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Dont have an account?");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(258, 284, 138, 23);
		contentPane.add(lblNewLabel_3);
		
		JButton CustomerRegisterButton = new JButton("Register");
		CustomerRegisterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminRegisterScreen window5 = new adminRegisterScreen();
				window5.show();
				window5.setResizable(false);
				
				
			}
		});
		CustomerRegisterButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		CustomerRegisterButton.setBounds(396, 278, 112, 34);
		contentPane.add(CustomerRegisterButton);
		
		JButton customerLoginButton = new JButton("Login");
		customerLoginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
					String userID = adminUserName.getText();
					String userPW =adminPassword.getText();
					
					if(mainWindow.adminLoginHash.containsKey(userID)) {
						if(mainWindow.adminLoginHash.get(userID).equals(userPW)) {
							//you logged in
							
							for(adminLogins c : mainWindow.adminDB) {
								if(c.getUserName().equals(userID) && c.getPassword().equals(userPW)) {
									c.logIN();
									//System.out.println("ADMIN LOGGED IN");
								}
							}
							
							
							dispose();
							//MAKE NEW OFFICERBOOKINGSCREEN WHICH IS THEIR VERSION
							adminBookingScreen window8 = new adminBookingScreen();
							window8.show();
							window8.setResizable(false);
							
							
							
						}
						
						else {//rest of these screens are error screens 
							loginFailErrorScreen window8 = new loginFailErrorScreen();
							window8.show();
							window8.setResizable(false);
							
							adminPassword.setText("");
						}
					}
					
					else if(adminUserName.getText().isBlank() || adminPassword.getText().isBlank()) {
						errorScreen window7 = new errorScreen();
						window7.show();
						window7.setResizable(false);
					}
					else {
						loginFailErrorScreen window9 = new loginFailErrorScreen();
						window9.show();
						window9.setResizable(false);
					}
			}
		});
		customerLoginButton.setFont(new Font("Tahoma", Font.PLAIN, 12));
		customerLoginButton.setBounds(163, 233, 100, 32);
		contentPane.add(customerLoginButton);
		
		JLabel lblNewLabel_4 = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/loginPicTwo.png")); 
		lblNewLabel_4.setIcon(img);
		lblNewLabel_4.setBounds(377, 79, 131, 144);
		contentPane.add(lblNewLabel_4);
	}

}