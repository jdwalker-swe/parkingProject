import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.awt.event.ActionEvent;

public class officerRegisterScreen extends JFrame {

	private JPanel contentPane;
	private JTextField officerUserName;
	private JTextField officerPassword;
	private JTextField officerEmail;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					officerRegisterScreen frame = new officerRegisterScreen();
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
	public officerRegisterScreen() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 426, 454);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Create Account");
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.PLAIN, 31));
		lblNewLabel.setBounds(119, 32, 206, 57);
		contentPane.add(lblNewLabel);
		
		officerUserName = new JTextField();
		officerUserName.setBounds(136, 191, 179, 28);
		contentPane.add(officerUserName);
		officerUserName.setColumns(10);
		
		officerPassword = new JTextField();
		officerPassword.setBounds(136, 247, 179, 28);
		contentPane.add(officerPassword);
		officerPassword.setColumns(10);
		
		
		officerEmail = new JTextField();
		officerEmail.setBounds(136, 299, 179, 28);
		contentPane.add(officerEmail);
		officerEmail.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("User Name");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(27, 194, 81, 21);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Password");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(27, 254, 85, 21);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Email");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(27, 306, 85, 21);
		contentPane.add(lblNewLabel_4);
		
		JButton createCustomerAccButton = new JButton("Create Account");
		createCustomerAccButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				{
					
					//checks if email is already registered in emailDB
					 if(mainWindow.officerEmailDB.size()>=1 && (mainWindow.officerEmailDB.contains(officerEmail.getText()) || mainWindow.officerLoginHash.containsKey(officerUserName.getText())) &&!officerUserName.getText().isBlank() && !officerPassword.getText().isBlank() && !officerEmail.getText().isBlank()) {
						 emailOrUsernameAlreadyInUseErrorScreen window9 = new emailOrUsernameAlreadyInUseErrorScreen();
						 officerUserName.setText("");
						 officerPassword.setText("");
						 officerEmail.setText("");
							window9.show();
							window9.setResizable(false);
					}
					 
					 else if(!officerUserName.getText().isBlank() && !officerPassword.getText().isBlank() && !officerEmail.getText().isBlank()) {
							//creating new customer object
							officerLogins login = new officerLogins(officerUserName.getText(),officerPassword.getText(),officerEmail.getText());
							//putting customer email into global DB
							mainWindow.officerEmailDB.add(officerEmail.getText());
							
							//putting customerLogin objects into global DB
							mainWindow.officerDB.add(login);
							
							//putting customer UserNames and PWs into global hashMap
							mainWindow.officerLoginHash.put(officerUserName.getText(), officerPassword.getText());
							
							//print stuff
							//System.out.println("size of DB:" + mainWindow.officerDB.size());
							//System.out.println(officerEmail.getText());
							//System.out.println(mainWindow.officerEmailDB.size());
							
							//resetting text fields
							officerUserName.setText("");
							officerPassword.setText("");
							officerEmail.setText("");
							
							dispose();
					 }
					
					else {
						errorScreen window6 = new errorScreen();
						window6.show();
						window6.setResizable(false);
					}
					
					
					//System.out.println(login.customerEmailsArr.get(1).toString());
					
					
					
					
					//System.out.println(login.password);
				}
				
				
	
				
			}
		});
		createCustomerAccButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		createCustomerAccButton.setBounds(146, 346, 133, 47);
		contentPane.add(createCustomerAccButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/registerPicTwo.png")); 
		lblNewLabel_1.setIcon(img);
		lblNewLabel_1.setBounds(151, 76, 133, 105);
		contentPane.add(lblNewLabel_1);
	}
}

