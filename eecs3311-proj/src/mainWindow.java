import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import javax.swing.DefaultListModel;

public class mainWindow {
	
	private JFrame frame;
	private JButton adminButton;
	private JButton CustomerButton;
	private final Action action = new SwingAction();

	//customer DBs
	static List<String> customerEmailDB = new ArrayList<String>();
	static List<customerLogins>  customerDB = new ArrayList<customerLogins>();
	static HashMap<String,String> customerLoginHash = new HashMap<String,String>();
	static boolean loggedInAndOut = false;
	
	//list of all parking spots
	static List<String> globalParkingList = new ArrayList<String>();
	static List<parkingSpot> globalParkingListReal = new ArrayList<parkingSpot>();
	
	//DefaultListModel DLM = new DefaultListModel();
	
	//officer Dbs
	static List<String> officerEmailDB = new ArrayList<String>();
	static List<officerLogins>  officerDB = new ArrayList<officerLogins>();
	static HashMap<String,String> officerLoginHash = new HashMap<String,String>();
	
	
	//static HashMap<String,String> officerDB = new HashMap<String,String>();
	
	static List<String> adminEmailDB = new ArrayList<String>();
	static List<adminLogins>  adminDB = new ArrayList<adminLogins>();
	static HashMap<String,String> adminLoginHash = new HashMap<String,String>();
	
	//just like our DB, we want to add a static "list" of all available parking spots
	//once a customer books that spot, we remove it from the global list
	//when an officer removes it, we add it back on to the global list
	//the hashmaps might be useless? for now just keep track of emails so we know theyre unique
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					mainWindow window = new mainWindow();
					window.frame.setResizable(false);
					window.frame.setVisible(true);
					
					ImageIcon img2 = new ImageIcon(this.getClass().getResource("carPic.png")); 
					window.frame.setIconImage(img2.getImage());
					
					welcomeWindow window17 = new welcomeWindow();
					window17.show();
					window17.setResizable(false);
			
					globalParkingList.add("A1");
					globalParkingList.add("A2");
					globalParkingList.add("A3");
					globalParkingList.add("B1");
					globalParkingList.add("B2");
					globalParkingList.add("B3");
					globalParkingList.add("C1");
					globalParkingList.add("C2");
					globalParkingList.add("C3");
					globalParkingList.add("D1");
					globalParkingList.add("D2");
					globalParkingList.add("D3");
					globalParkingList.add("E1");
					globalParkingList.add("E2");
					
					parkingSpot A1 = new parkingSpot("A1");
					parkingSpot A2 = new parkingSpot("A2");
					parkingSpot A3 = new parkingSpot("A3");
					parkingSpot B1 = new parkingSpot("B1");
					parkingSpot B2 = new parkingSpot("B2");
					parkingSpot B3 = new parkingSpot("B3");
					parkingSpot C1 = new parkingSpot("C1");
					parkingSpot C2 = new parkingSpot("C2");
					parkingSpot C3 = new parkingSpot("C3");
					parkingSpot D1 = new parkingSpot("D1");
					parkingSpot D2 = new parkingSpot("D2");
					parkingSpot D3 = new parkingSpot("D3");
					parkingSpot E1 = new parkingSpot("E1");
					parkingSpot E2 = new parkingSpot("E2");
					
					globalParkingListReal.add(A1);
					globalParkingListReal.add(A2);
					globalParkingListReal.add(A3);
					globalParkingListReal.add(B1);
					globalParkingListReal.add(B2);
					globalParkingListReal.add(B3);
					globalParkingListReal.add(C1);
					globalParkingListReal.add(C2);
					globalParkingListReal.add(C3);
					globalParkingListReal.add(D1);
					globalParkingListReal.add(D2);
					globalParkingListReal.add(D3);
					globalParkingListReal.add(E1);
					globalParkingListReal.add(E2);
					
				
					
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public mainWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 564, 367);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton officerButton = new JButton("Officer Login");
		officerButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				officerScreen window3 = new officerScreen();
				window3.show();
				window3.setResizable(false);
			}
		});
		officerButton.setBounds(220, 190, 136, 38);
		frame.getContentPane().add(officerButton);
		
		adminButton = new JButton("Admin Login");
		adminButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adminScreen window4 = new adminScreen();
				window4.show();
				window4.setResizable(false);
			}
		});
		adminButton.setBounds(380, 190, 136, 38);
		frame.getContentPane().add(adminButton);
		
		CustomerButton = new JButton("Customer Login");
		CustomerButton.setAction(action);
		CustomerButton.setBounds(60, 190, 136, 38);
		frame.getContentPane().add(CustomerButton);
		CustomerButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				customerScreen window2 = new customerScreen();
				window2.show();
				window2.setResizable(false);
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("Express Parking");
		lblNewLabel.setFont(new Font("Yu Gothic Light", Font.PLAIN, 32));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(169, 64, 281, 53);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon img = new ImageIcon(this.getClass().getResource("/greenPicTwo.png")); 
		lblNewLabel_1.setIcon(img);
		lblNewLabel_1.setBounds(35, 23, 136, 126);
		frame.getContentPane().add(lblNewLabel_1);
	
	}
	
	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "Customer Login");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
